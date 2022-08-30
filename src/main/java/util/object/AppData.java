package util.object;

import java.nio.file.Path;
import java.nio.file.Paths;

public class AppData {

    public final String WindowName = "Understanding the Kanji";
    public final double WindowWidth = 800;
    public final double WindowHeight = 600;

    private final Path appStorageDir;

    public AppData()
    {
        this.appStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath();
        System.out.println(appStorageDir);
    }

}
