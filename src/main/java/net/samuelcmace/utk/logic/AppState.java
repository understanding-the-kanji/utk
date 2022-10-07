package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.Main;
import net.samuelcmace.utk.logic.model.CardEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

/**
 * Manages project-level configuration and first-time file structure setup.
 */
public class AppState {

    /**
     * The singleton instance of Configuration.
     */
    private static AppState instance = null;

    /**
     * The string containing the application-level storage directory (usually the users home directory followed by '.understanding-the-kanji').
     */
    public String AppStorageDir;

    /**
     * The string containing the logging file path (usually a 'log.txt' file located in the application-level storage directory).
     */
    public String LogFilePath;

    /**
     * The string containing the database file path (usually a 'kanji.db' file located in the application-level storage directory).
     */
    public String DBFilePath;

    /**
     * The string containing the database file path (usually a 'kanji.db' file located in the application-level storage directory).
     */
    public String DBConnectionString;

    /**
     * The currently active database connection object.
     */
    private DatabaseConnection dbConnection;

    /**
     * Ensures that the application-level storage directory and database exist.
     *
     * @throws IOException Thrown if either the default directory failed to create or the template database file failed to copy.
     */
    public void FirstTimeSetup() throws IOException {
        File appStorageDirectory = new File(this.AppStorageDir);
        if (!appStorageDirectory.exists()) {
            appStorageDirectory.mkdir();
        }

        File databaseFile = new File(this.DBFilePath);
        if (!databaseFile.exists()) {
            Files.copy(Main.class.getResourceAsStream("kanji/default.db"), Paths.get(this.DBFilePath));
        }
    }

    /**
     * Initializes a new instance of AppState.
     */
    private AppState() {
        this.AppStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();
        this.LogFilePath = Paths.get(this.AppStorageDir, "log.txt").toAbsolutePath().toString();
        this.DBFilePath = Paths.get(this.AppStorageDir, "utk.db").toAbsolutePath().toString();
        this.DBConnectionString = "jdbc:sqlite:" + this.DBFilePath;
    }

    /**
     * Retrieves the singleton instance of AppState.
     *
     * @return The singleton instance of AppState.
     */
    public static AppState GetInstance() {
        if (AppState.instance == null) AppState.instance = new AppState();

        return AppState.instance;
    }
}
