package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppState;
import net.samuelcmace.utk.logic.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
            AppState appState = AppState.GetInstance();
            DatabaseConnection databaseConnection = new DatabaseConnection(appState.DBConnectionString);
            databaseConnection.getCardByKanji('覚');
            assert true;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }

    @Test
    public void anotherDatabaseConnectionTest()
    {
        try {
            AppState appState = AppState.GetInstance();
            assert true;
        } catch (Exception e)
        {
            e.printStackTrace();
            assert false;
        }
    }

}
