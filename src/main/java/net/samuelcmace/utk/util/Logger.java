package net.samuelcmace.utk.util;

import java.io.FileWriter;

public class Logger {
    public AppData ApplicationData;

    private FileWriter fileWriter;

    private String getLocalTime() {
        return java.time.LocalDate.now() + " " + java.time.LocalTime.now();
    }

    private void logMessage(String message) {
        try {
            this.fileWriter = new FileWriter(this.ApplicationData.LogFilePath, true);
            this.fileWriter.write(message + "\n");
            this.fileWriter.close();
        } catch (Exception ex) {
            System.out.println("Error: Failed to Write Line to File!");
            System.out.println(ex.toString());
        }
    }

    public Logger() {
        this.ApplicationData = new AppData();
        this.logMessage("Application Started at " + this.getLocalTime());
    }

    public void Information(String m_message) {
        System.out.println("Information: " + m_message);
        MessageBox.ShowInfoDialog(m_message);
        this.logMessage("Information: " + m_message);
    }

    public void ConsoleInformation(String m_message) {
        System.out.println("Information: " + m_message);
        this.logMessage("Information: " + m_message);
    }

    public void Warning(String m_message) {
        System.out.println("Warning: " + m_message);
        MessageBox.ShowWarningDialog(m_message);
        this.logMessage("Warning: " + m_message);
    }

    public void ConsoleWarning(String m_message) {
        System.out.println("Warning: " + m_message);
        this.logMessage("Warning: " + m_message);
    }

    public void Error(String m_message) {
        System.out.println("Error: " + m_message);
        MessageBox.ShowErrorDialog(m_message);
        this.logMessage("Error: " + m_message);
    }

    public void ConsoleError(String m_message) {
        System.out.println("Error: " + m_message);
        this.logMessage("Error: " + m_message);
    }
}
