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
     * The active primary key shared between the two database connections.
     */
    public int ActivePrimaryKey;

    /**
     * The DatabaseConnection object that deals with reading data from the database.
     */
    public DatabaseConnection kanjiSearchConnection;

    /**
     * The DatabaseConnection object that deals with writing data to the database.
     */
    public DatabaseConnection kanjiEditorConnection;

    /**
     * Initializes a new instance of DBConnectionPool.
     */
    private DBConnectionPool() throws SQLException {
        this.kanjiSearchConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
        this.kanjiEditorConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
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
