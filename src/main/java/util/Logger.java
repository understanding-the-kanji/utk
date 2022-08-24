package util;

import java.io.FileWriter;

public class Logger
{
    private String filePath;
    private FileWriter fileWriter;

    private void logMessage(String message)
    {
        try {
            this.fileWriter = new FileWriter(this.filePath, true);
            this.fileWriter.write(message + "\n");
            this.fileWriter.close();
        }
        catch (Exception ex) {
            System.out.println("Error: Failed to Write Line to File!");
            System.out.println(ex.toString());
        }
    }

    public Logger(String m_filePath)
    {
        this.filePath = m_filePath;
    }

    public void Information(String m_message)
    {
        System.out.println("Information: " + m_message);
        MessageDialog.ShowInfoDialog(m_message);
        this.logMessage("Information: " + m_message);
    }

    public void ConsoleInformation(String m_message)
    {
        System.out.println("Information: " + m_message);
        this.logMessage("Information: " + m_message);
    }

    public void Warning(String m_message)
    {
        System.out.println("Warning: " + m_message);
        MessageDialog.ShowWarningDialog(m_message);
        this.logMessage("Warning: " + m_message);
    }

    public void ConsoleWarning(String m_message)
    {
        System.out.println("Warning: " + m_message);
        this.logMessage("Warning: " + m_message);
    }

    public void Error(String m_message)
    {
        System.out.println("Error: " + m_message);
        MessageDialog.ShowErrorDialog(m_message);
        this.logMessage("Error: " + m_message);
    }

    public void ConsoleError(String m_message)
    {
        System.out.println("Error: " + m_message);
        this.logMessage("Error: " + m_message);
    }
}