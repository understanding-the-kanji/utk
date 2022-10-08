package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class associated with creating and retrieving the default file structure for the project.
 */
public abstract class AppStoragePaths {
    /**
     * Utility function to fetch the app storage directory.
     *
     * @return The application storage directory.
     */
    public static String GetAppStorageDir() {
        return Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();
    }

    /**
     * Utility function to set up the initial file structure for the program if it doesn't already exist.
     *
     * @throws IOException Thrown if either the default directory failed to create or the template database file failed to copy.
     */
    public static void FirstTimeSetup() throws IOException {
        File appStorageDirectory = new File(AppStoragePaths.GetAppStorageDir());
        if (!appStorageDirectory.exists()) {
            appStorageDirectory.mkdir();
        }

        File databaseFile = new File(AppStoragePaths.GetDBFilePath());
        if (!databaseFile.exists()) {
            Files.copy(Main.class.getResourceAsStream("kanji/default.db"), Paths.get(AppStoragePaths.GetDBFilePath()));
        }
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
