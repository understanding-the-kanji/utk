package net.samuelcmace.utk.logic;

/**
 * Manages project-level configuration and first-time file structure setup.
 */
public class DBConnectionPool {

    /**
     * The singleton instance of Configuration.
     */
    private static DBConnectionPool instance = null;

    /**
     * The currently active database connection object.
     */
    private DatabaseConnection dbConnection;

    /**
     * Initializes a new instance of AppState.
     */
    private DBConnectionPool() {
        this.dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
    }

    /**
     * Retrieves the singleton instance of AppState.
     *
     * @return The singleton instance of AppState.
     */
    public static DBConnectionPool GetInstance() {
        if (DBConnectionPool.instance == null) DBConnectionPool.instance = new DBConnectionPool();

        return DBConnectionPool.instance;
    }
}
