package net.samuelcmace.utk.logic;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Defines an object wrapper for a SQLite database connection.
 */
public abstract class DatabaseConnection {

    /**
     * The connection object associated with the instance of DatabaseConnection.
     */
    public Connection ActiveConnection;
    /**
     * The JDBC connection string that corresponds to the database.
     */
    protected String dbConnectionString;
    /**
     * The currently active query string used to generate the ActiveResultSet.
     */
    protected String activeQuery;

    /**
     * Initializes a new instance of DatabaseConnection.
     */
    public DatabaseConnection(String m_dbConnectionString) {
        this.dbConnectionString = m_dbConnectionString;
        Logger.ConsoleInformation("Database Connection String Set: " + this.dbConnectionString);
    }

    /**
     * Method called by the Java garbage collector before the object is destroyed.
     * Although this method is not needed in most java programming, it is needed here to ensure that the database
     * connections are closed before the program exists.
     */
    protected void finalize() {
        try {
            this.ActiveConnection.close();
        } catch (SQLException e) {
            Logger.ConsoleError("The connections failed to close in the abstract DatabaseConnection destructor: " + e.getLocalizedMessage());
        }
    }
}
