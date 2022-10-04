package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Manages project-level configuration and first-time file structure setup.
 */
public class Configuration {

    /**
     * The singleton instance of Configuration.
     */
    private static Configuration instance = null;

    /**
     * The name of the window for the application.
     */
    public final String WindowName = "Understanding the Kanji";

    /**
     * The width of the window for the application.
     */
    public final double WindowWidth = 800;

    /**
     * The height of the window for the application.
     */
    public final double WindowHeight = 600;

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
     * Ensures that the application-level storage directory and database exist.
     *
     * @throws IOException Thrown if the files failed to create.
     */
    private void firstTimeSetup() throws IOException {
        File appStorageDirectory = new File(this.AppStorageDir);
        if (!appStorageDirectory.exists()) {
            appStorageDirectory.mkdir();
        }

        File databaseFile = new File(this.DBFilePath);
        if (!databaseFile.exists()) {
            Files.copy(Paths.get(Main.class.getResource("kanji/default.db").toExternalForm()), Paths.get(this.DBFilePath));
        }
    }

    /**
     * Initializes a new instance of Configuration.
     *
     * @throws IOException Thrown if the first-time-setup process (creation of the configuration directory) failed to complete.
     */
    private Configuration() throws IOException {
        this.AppStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();
        this.LogFilePath = Paths.get(this.AppStorageDir, "log.txt").toAbsolutePath().toString();
        this.DBFilePath = Paths.get(this.AppStorageDir, "utk.db").toAbsolutePath().toString();

        this.firstTimeSetup();

        System.out.println(AppStorageDir);
    }

    /**
     * Retrieves the singleton instance of Configuration.
     *
     * @return The singleton instance of Configuration.
     * @throws IOException Thrown if the singleton instance failed to initialize.
     */
    public static Configuration GetInstance() throws IOException {
        if (Configuration.instance == null) Configuration.instance = new Configuration();

        return Configuration.instance;
    }
}
