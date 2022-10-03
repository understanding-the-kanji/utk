package net.samuelcmace.utk.util;

import net.samuelcmace.utk.Main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AppData {

    public final String WindowName = "Understanding the Kanji";
    public final double WindowWidth = 800;
    public final double WindowHeight = 600;

    public String AppStorageDir;
    public String LogFilePath;
    public String DBFilePath;

    public AppData() throws IOException {
        this.AppStorageDir = Paths.get(System.getProperty("user.home") + "/.understanding-the-kanji/").toAbsolutePath().toString();

        File appStorageDirectory = new File(this.AppStorageDir);
        if (!appStorageDirectory.exists()) {
            appStorageDirectory.mkdir();
        }

        this.LogFilePath = Paths.get(this.AppStorageDir, "log.txt").toAbsolutePath().toString();

        this.DBFilePath = Paths.get(this.AppStorageDir, "utk.db").toAbsolutePath().toString();

        File databaseFile = new File(this.DBFilePath);
        if(!databaseFile.exists()) {
            Files.copy(Paths.get(Main.class.getResource("kanji/default.db").toExternalForm()), Paths.get(this.DBFilePath));
        }

        System.out.println(AppStorageDir);
    }
}
