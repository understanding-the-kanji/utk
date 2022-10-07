package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.DatabaseConnection;
import org.junit.jupiter.api.Test;

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
            DatabaseConnection databaseConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
            assert true;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }

    /**
     * Test to see if a specific Kanji Character and its associated details can be retrieved from the database.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void getCardByKanjiTest() {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
            dbConnection.getCardByKanji('何');

            while (dbConnection.activeResultSet.next()) {
                System.out.println(dbConnection.activeResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.activeResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.activeResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.activeResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.activeResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.activeResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.activeResultSet.getString("ON_READING"));
                System.out.println(dbConnection.activeResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.activeResultSet.getString("NOTE"));
            }

            dbConnection.activeConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
