package util;

import util.object.AppData;

import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Logger
{
    public AppData applicationData;
    private Path filePath;
    private FileWriter fileWriter;

    private void logMessage(String message)
    {
        try {
            this.fileWriter = new FileWriter(this.filePath.toString(), true);
            this.fileWriter.write(message + "\n");
            this.fileWriter.close();
        }
        catch (Exception ex) {
            System.out.println("Error: Failed to Write Line to File!");
            System.out.println(ex.toString());
        }
    }

    public Logger()
    {
        this.applicationData = new AppData();
        this.filePath = Paths.get(String.valueOf(this.applicationData.AppStorageDir), "foo.txt");
        logMessage("Test");
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
