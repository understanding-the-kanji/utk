package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.Main;
import net.samuelcmace.utk.logic.model.CardEntity;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     * The Database Connection associated with querying new objects.
     * When it comes to updating existing objects (persistence), the model setters will have their own connections.
     */
    private DatabaseConnection dbConnection;

    /**
     * The CardEntities currently displayed on the KanjiBrowserController at any given time.
     */
    private HashMap<Integer, CardEntity> kanjiBrowserWorkspace;

    /**
     * The CardEntity currently being edited by the KanjiEditorController.
     */
    private CardEntity editingCharacter;

    /**
     * Ensures that the application-level storage directory and database exist.
     *
     * @throws IOException Thrown if either the default directory failed to create or the template database file failed to copy.
     */
    private void firstTimeSetup() throws IOException {
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
     * Initializes a new instance of Configuration.
     */
    private AppState() {
        this.AppStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();
        this.LogFilePath = Paths.get(this.AppStorageDir, "log.txt").toAbsolutePath().toString();
        this.DBFilePath = Paths.get(this.AppStorageDir, "utk.db").toAbsolutePath().toString();

        try {
            this.firstTimeSetup();
        }
        catch (IOException e)
        {
            Logger.ConsoleError("The program was unable to complete the first-time setup process: " + e.getLocalizedMessage());
        }

        Logger.ConsoleInformation("Application Storage Directory: " + this.AppStorageDir);
        Logger.ConsoleInformation("Application Log File Path: " + this.LogFilePath);
        Logger.ConsoleInformation("Application Database Path: " + this.DBFilePath);
    }

    /**
     * Retrieves the singleton instance of Configuration.
     *
     * @return The singleton instance of Configuration.
     * @throws IOException Thrown if the singleton instance failed to initialize.
     */
    public static AppState GetInstance() throws IOException {
        if (AppState.instance == null) AppState.instance = new AppState();

        return AppState.instance;
    }
}
