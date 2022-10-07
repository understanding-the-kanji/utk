package net.samuelcmace.utk.logic;

import java.nio.file.Paths;

public abstract class AppStoragePaths {
    /**
     * Utility function to fetch the app storage directory
     *
     * @return The application storage directory.
     */
    public static String GetAppStorageDir() {
        return Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();
    }

    /**
     * Utility function to fetch the path for the application-level logging file.
     *
     * @return The application logging file path.
     */
    public static String GetLogFilePath()
    {
        return Paths.get(AppStoragePaths.GetAppStorageDir(), "log.txt").toAbsolutePath().toString();
    }

    /**
     * Utility function to fetch the path for the application-level database file.
     *
     * @return The application logging database path.
     */
    public static String GetDBFilePath()
    {
        return Paths.get(AppStoragePaths.GetAppStorageDir(), "utk.db").toAbsolutePath().toString();
    }

    /**
     * Utility function to fetch the JDBC connection string for the application-level database.
     *
     * @return The JDBC connection string associated with the database file.
     */
    public static String GetDBConnectionString()
    {
        return "jdbc:sqlite:" + AppStoragePaths.GetDBFilePath();
    }
}
