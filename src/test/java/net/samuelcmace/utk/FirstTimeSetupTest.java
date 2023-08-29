package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import org.junit.jupiter.api.Test;

/**
 * Test to see if the first-time setup procedure
 * (the creation of the .understanding-the-kanji directory
 * and the copying of the utk database was a success).
 */
public class FirstTimeSetupTest {

    /**
     * The test associated with the first-time setup process.
     * It asserts true if the operation was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void firstTimeSetupTest() {
        try {
            AppStoragePaths.FirstTimeSetup();
            assert true;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }
}
