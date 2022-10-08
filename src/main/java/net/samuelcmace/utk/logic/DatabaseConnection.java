package net.samuelcmace.utk.logic;

import java.sql.*;

/**
 * Defines an object wrapper for a SQLite database connection.
 */
public abstract class DatabaseConnection {

    /**
     * The JDBC connection string that corresponds to the database.
     */
    protected String dbConnectionString;

    /**
     * The connection object associated with the instance of DatabaseConnection.
     */
    public Connection ActiveConnection;

    /**
     * The active result set associated with reading data from the database.
     */
    public ResultSet ActiveResultSet;

    /**
     * The currently active query string used to generate the ActiveResultSet.
     */
    protected String activeQuery;

    /**
     * Initializes a new instance of DatabaseConnection.
     */
    public DatabaseConnection(String m_dbConnectionString) throws SQLException {
        this.dbConnectionString = m_dbConnectionString;
        Logger.ConsoleInformation("Database Connection String Set: " + this.dbConnectionString);
    }
}
