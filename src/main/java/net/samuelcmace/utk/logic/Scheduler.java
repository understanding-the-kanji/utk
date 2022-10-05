package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.logic.model.DatabaseConnection;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Responsible for managing the scheduling information of the spaced repetition flashcard system.
 */
public class Scheduler {

    /**
     * The database connection object associated with the Scheduler.
     */
    private DatabaseConnection databaseConnection;

    /**
     * The logger object associated with the Scheduler.
     */
    private Logger logger;

    /**
     * Initializes a new instance of Scheduler.
     *
     * @throws IOException  Thrown if either the Logger or DatabaseConnection singletons failed to initialize.
     * @throws SQLException Thrown if the DatabaseConnection object was unable to instantiate.
     */
    public Scheduler() throws IOException, SQLException {
        this.logger = Logger.GetInstance();
        this.databaseConnection = DatabaseConnection.getInstance();
    }
}
