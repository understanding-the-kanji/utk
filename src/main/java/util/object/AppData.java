package util.object;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppData {

    public final String WindowName = "Understanding the Kanji";
    public final double WindowWidth = 800;
    public final double WindowHeight = 600;

    public Path AppStorageDir;

    public AppData()
    {
        this.AppStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath();

        File appStorageDirectory = new File(String.valueOf(this.AppStorageDir));
        if(!appStorageDirectory.exists()) { appStorageDirectory.mkdir(); }

        System.out.println(AppStorageDir);
    }

}
