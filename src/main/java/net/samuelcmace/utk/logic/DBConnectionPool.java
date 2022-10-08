package net.samuelcmace.utk.logic;

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
    public DatabaseReadConnection KanjiSearchConnection;

    /**
     * The DatabaseConnection object that deals with writing data to the database.
     */
    public DatabaseWriteConnection KanjiEditorConnection;

    /**
     * Initializes a new instance of DBConnectionPool.
     */
    private DBConnectionPool() {
        this.KanjiSearchConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());
        this.KanjiEditorConnection = new DatabaseWriteConnection(AppStoragePaths.GetDBConnectionString());
    }

    /**
     * Retrieves the singleton instance of DBConnectionPool.
     *
     * @return The singleton instance of DBConnectionPool.
     */
    public static DBConnectionPool GetInstance() {
        if (DBConnectionPool.instance == null) DBConnectionPool.instance = new DBConnectionPool();

        return DBConnectionPool.instance;
    }
}
