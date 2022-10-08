package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Test to see if the first-time setup procedure
 * (the creation of the .understanding-the-kanji directory
 * and the copying of the utk database was a success).
 */
public class FirstTimeSetupTest {

    /**
     * The test associated with the first-time setup process.
     */
    @Test
    public void firstTimeSetupTest() {
        try {
            AppStoragePaths.FirstTimeSetup();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
