package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Test to see if the first-time setup procedure
 * (the creation of the .understanding-the-kanji directory
 * and the copying of the utk database was a success).
 */
public class FirstTimeSetupTest {

    /**
     * The test associated with the first-time setup.
     */
    @Test
    public void firstTimeSetupTest() {
        try {
            File appStorageDirectory = new File(AppStoragePaths.GetAppStorageDir());
            if (!appStorageDirectory.exists()) {
                appStorageDirectory.mkdir();
            }

            File databaseFile = new File(AppStoragePaths.GetDBFilePath());
            if (!databaseFile.exists()) {
                Files.copy(Main.class.getResourceAsStream("kanji/default.db"), Paths.get(AppStoragePaths.GetDBFilePath()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
