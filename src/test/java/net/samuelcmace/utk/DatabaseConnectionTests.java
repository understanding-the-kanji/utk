package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.DatabaseConnection;
import org.junit.jupiter.api.Test;

/**
 * A class to store database-related tests.
 */
public class DatabaseConnectionTests {

    /**
     * Test to see if the connection to the user's database (usually located in the
     * .understanding-the-kanji directory nested in the user's home directory)
     * was a success.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void databaseConnectionTest() {
        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            databaseConnection.getCardByKanji('覚');
            assert true;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }

}
