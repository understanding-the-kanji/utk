package util.object;

import java.io.File;
import java.nio.file.Paths;

public class AppData {

    public final String WindowName = "Understanding the Kanji";
    public final double WindowWidth = 800;
    public final double WindowHeight = 600;

    public String AppStorageDir;
    public String LogFilePath;

    public AppData()
    {
        this.AppStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();

        File appStorageDirectory = new File(this.AppStorageDir);
        if(!appStorageDirectory.exists()) { appStorageDirectory.mkdir(); }

        this.LogFilePath = Paths.get(this.AppStorageDir, "log.txt").toAbsolutePath().toString();

        System.out.println(AppStorageDir);
    }

}
