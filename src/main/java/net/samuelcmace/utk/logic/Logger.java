package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.gui.MessageBox;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Logs messages both to the program and to the console.
 */
public class Logger {

    /**
     * The singleton instance of Logger.
     */
    private static Logger instance = null;

    /**
     * References the singleton instance of Configuration for the purposes of fetching the file paths stored in the instance.
     */
    private Configuration configuration;

    /**
     * The FileWriter object to be used to log files on the disk.
     */
    private FileWriter fileWriter;

    /**
     * Utility function to fetch the local time in a preferred format.
     *
     * @return The time (including the date and time of day).
     */
    private String getLocalTime() {
        return java.time.LocalDate.now() + " " + java.time.LocalTime.now();
    }

    /**
     * Logs a message to the log file.
     *
     * @param message The message to be logged to the log file.
     */
    private void logMessage(String message) {
        try {
            this.fileWriter = new FileWriter(this.configuration.LogFilePath, true);
            this.fileWriter.write(message + "\n");
            this.fileWriter.close();
        } catch (Exception ex) {
            System.out.println("Error: Failed to Write Line to File!");
            System.out.println(ex.toString());
        }
    }

    /**
     * Initializes a new instance of Logger.
     *
     * @throws IOException Thrown if the configuration singleton instance was unable to load.
     */
    private Logger() throws IOException {
        this.configuration = Configuration.GetInstance();
        this.logMessage("Application Started at " + this.getLocalTime());
    }

    /**
     * Logs an informative message to the disk, as well as the console and GUI.
     *
     * @param m_message The message to be logged.
     */
    public void Information(String m_message) {
        System.out.println("Information: " + m_message);
        MessageBox.ShowInfoDialog(m_message);
        this.logMessage("Information: " + m_message);
    }

    /**
     * Logs an informative message to the disk, as well as the console.
     *
     * @param m_message The message to be logged.
     */
    public void ConsoleInformation(String m_message) {
        System.out.println("Information: " + m_message);
        this.logMessage("Information: " + m_message);
    }

    /**
     * Logs a warning message to the disk, as well as the console and GUI.
     *
     * @param m_message The message to be logged.
     */
    public void Warning(String m_message) {
        System.out.println("Warning: " + m_message);
        MessageBox.ShowWarningDialog(m_message);
        this.logMessage("Warning: " + m_message);
    }

    /**
     * Logs a warning message to the disk, as well as the console.
     *
     * @param m_message The message to be logged.
     */
    public void ConsoleWarning(String m_message) {
        System.out.println("Warning: " + m_message);
        this.logMessage("Warning: " + m_message);
    }

    /**
     * Logs an error message to the disk, as well as the console and GUI.
     *
     * @param m_message The message to be logged.
     */
    public void Error(String m_message) {
        System.out.println("Error: " + m_message);
        MessageBox.ShowErrorDialog(m_message);
        this.logMessage("Error: " + m_message);
    }

    /**
     * Logs an error message to the disk, as well as the console.
     *
     * @param m_message The message to be logged.
     */
    public void ConsoleError(String m_message) {
        System.out.println("Error: " + m_message);
        this.logMessage("Error: " + m_message);
    }

    /**
     * Retrieves the singleton instance of Logger.
     *
     * @return The singleton instance.
     * @throws IOException If the instance was null and was unable to be initialized, an exception will be thrown.
     */
    public static Logger GetInstance() throws IOException {
        if (Logger.instance == null) Logger.instance = new Logger();

        return Logger.instance;
    }
}
