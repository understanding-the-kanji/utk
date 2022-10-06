package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.gui.MessageBox;

import java.io.FileWriter;

/**
 * Abstract (static) class to log messages both to the program and to the console.
 */
public abstract class Logger {

    /**
     * Utility function to fetch the local time in a preferred format.
     *
     * @return The time (including the date and time of day).
     */
    private static String getLocalTime() {
        return java.time.LocalDate.now() + " " + java.time.LocalTime.now();
    }

    /**
     * Logs a message to the log file.
     *
     * @param message The message to be logged to the log file.
     */
    private static void logMessage(String message) {
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(AppState.GetInstance().LogFilePath, true);
            fileWriter.write("[ " + Logger.getLocalTime() + "] " + message + "\n");
            fileWriter.close();
        } catch (Exception ex) {
            System.out.println("Error: Failed to Write Line to File!");
            System.out.println(ex.getLocalizedMessage());
        }
    }

    /**
     * Logs an informative message to the disk, as well as the console.
     *
     * @param m_message The message to be logged.
     */
    public static void ConsoleInformation(String m_message) {
        System.out.println("Information: " + m_message);
        Logger.logMessage("Information: " + m_message);
    }

    /**
     * Logs an informative message to the disk, as well as the console and GUI.
     *
     * @param m_message The message to be logged.
     */
    public static void Information(String m_message) {
        System.out.println("Information: " + m_message);
        MessageBox.ShowInfoDialog(m_message);
        Logger.logMessage("Information: " + m_message);
    }

    /**
     * Logs a warning message to the disk, as well as the console and GUI.
     *
     * @param m_message The message to be logged.
     */
    public static void Warning(String m_message) {
        System.out.println("Warning: " + m_message);
        MessageBox.ShowWarningDialog(m_message);
        Logger.logMessage("Warning: " + m_message);
    }

    /**
     * Logs a warning message to the disk, as well as the console.
     *
     * @param m_message The message to be logged.
     */
    public static void ConsoleWarning(String m_message) {
        System.out.println("Warning: " + m_message);
        Logger.logMessage("Warning: " + m_message);
    }

    /**
     * Logs an error message to the disk, as well as the console and GUI.
     *
     * @param m_message The message to be logged.
     */
    public static void Error(String m_message) {
        System.out.println("Error: " + m_message);
        MessageBox.ShowErrorDialog(m_message);
        Logger.logMessage("Error: " + m_message);
    }

    /**
     * Logs an error message to the disk, as well as the console.
     *
     * @param m_message The message to be logged.
     */
    public static void ConsoleError(String m_message) {
        System.out.println("Error: " + m_message);
        Logger.logMessage("Error: " + m_message);
    }
}
