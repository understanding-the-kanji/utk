package net.samuelcmace.utk.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Defines a direct connection to the SQLite project database.
 */
public class DatabaseConnection {

    /**
     * Singleton instance of DatabaseConnection.
     */
    private static DatabaseConnection instance = null;

    /**
     * Configuration object for the DatabaseConnection class.
     */
    private Configuration configuration;

    /**
     * Logger object for the DatabaseConnection class.
     */
    private Logger logger;

    /**
     * The JDBC connection string that corresponds to the database.
     */
    private String dbConnectionString;

    /**
     * The JDBC connection object.
     */
    private Connection dbConnection;

    /**
     * Initializes a new instance of DatabaseConnection.
     *
     * @throws IOException  Thrown if either the Configuration or Logger singleton instances failed to instantiate.
     * @throws SQLException Thrown if the database connection failed.
     */
    private DatabaseConnection() throws IOException, SQLException {
        this.configuration = Configuration.GetInstance();
        this.logger = Logger.GetInstance();

        this.dbConnectionString = "jdbc:sqlite:" + this.configuration.DBFilePath;
        this.dbConnection = DriverManager.getConnection(this.dbConnectionString);
        this.logger.ConsoleInformation("Database Connection Succeeded");
    }

    /**
     * Retrieves the singleton instance of DatabaseConnection.
     *
     * @return The singleton instance of DatabaseConnection.
     * @throws IOException Thrown if the DatabaseConnection singleton instance was unable to instantiate.
     */
    public static DatabaseConnection getInstance() throws IOException, SQLException {
        if (DatabaseConnection.instance == null) DatabaseConnection.instance = new DatabaseConnection();

        return DatabaseConnection.instance;
    }
}
