package net.samuelcmace.utk.logic;

import java.sql.SQLException;

/**
 * Singleton to manage program-wide database connections.
 */
public class DBConnectionPool {

    /**
     * The singleton instance of DBConnectionPool.
     */
    private static DBConnectionPool instance = null;

    /**
     * The DatabaseConnection object associated with the DBConnectionPool.
     */
    public DatabaseConnection dbConnection;

    /**
     * Initializes a new instance of DBConnectionPool.
     */
    private DBConnectionPool() throws SQLException {
        this.dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
    }

    /**
     * Retrieves the singleton instance of DBConnectionPool.
     *
     * @return The singleton instance of DBConnectionPool.
     */
    public static DBConnectionPool GetInstance() throws SQLException {
        if (DBConnectionPool.instance == null) DBConnectionPool.instance = new DBConnectionPool();

        return DBConnectionPool.instance;
    }
}
