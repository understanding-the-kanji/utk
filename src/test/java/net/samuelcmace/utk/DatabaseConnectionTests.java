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
            DBConnectionPool dbConnectionPool = DBConnectionPool.GetInstance();
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
            dbConnection.getCardByKanji("何");
            dbConnection.RunActiveQuery();

            while (dbConnection.ActiveResultSet.next()) {
                System.out.println(dbConnection.ActiveResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.ActiveResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("ON_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("NOTE"));
            }

            dbConnection.ActiveResultSet.close();
            dbConnection.ActiveStatement.close();
            dbConnection.ActiveConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to see if a specific 5th edition Heisig index and its associated details can be retrieved from the database.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void getCardBy5thEditionHeisigIndex() {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
            dbConnection.getCardBy5thEditionIndex(345);
            dbConnection.RunActiveQuery();

            while (dbConnection.ActiveResultSet.next()) {
                System.out.println(dbConnection.ActiveResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.ActiveResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("ON_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("NOTE"));
            }

            dbConnection.ActiveResultSet.close();
            dbConnection.ActiveStatement.close();
            dbConnection.ActiveConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to see if a specific 6th edition Heisig index and its associated details can be retrieved from the database.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void getCardBy6thEditionHeisigIndex() {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
            dbConnection.getCardBy5thEditionIndex(234);
            dbConnection.RunActiveQuery();

            while (dbConnection.ActiveResultSet.next()) {
                System.out.println(dbConnection.ActiveResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.ActiveResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("ON_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("NOTE"));
            }

            dbConnection.ActiveResultSet.close();
            dbConnection.ActiveStatement.close();
            dbConnection.ActiveConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to see if a specific 5th edition Heisig keyword and its associated details can be retrieved from the database.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void getCardBy5thEditionHeisigKeyword() {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
            dbConnection.getCardBy5thEditionKeyword("peach tree");
            dbConnection.RunActiveQuery();

            while (dbConnection.ActiveResultSet.next()) {
                System.out.println(dbConnection.ActiveResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.ActiveResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("ON_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("NOTE"));
            }

            dbConnection.ActiveResultSet.close();
            dbConnection.ActiveStatement.close();
            dbConnection.ActiveConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to see if a specific 5th edition Heisig keyword and its associated details can be retrieved from the database.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void getCardBy6thEditionHeisigKeyword() {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
            dbConnection.getCardBy6thEditionKeyword("about that time");
            dbConnection.RunActiveQuery();

            while (dbConnection.ActiveResultSet.next()) {
                System.out.println(dbConnection.ActiveResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.ActiveResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.ActiveResultSet.getString("ON_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.ActiveResultSet.getString("NOTE"));
            }

            dbConnection.ActiveResultSet.close();
            dbConnection.ActiveStatement.close();
            dbConnection.ActiveConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setNote()
    {
        try {
            DatabaseConnection readConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());

            Integer sharedPrimaryKey = null;

            readConnection.getCardBy6thEditionKeyword("about that time");
            readConnection.RunActiveQuery();


            while (readConnection.ActiveResultSet.next()) {
                sharedPrimaryKey = readConnection.ActiveResultSet.getInt("CARD_ID");
                System.out.println(sharedPrimaryKey);
            }

            readConnection.ActiveResultSet.close();
            readConnection.ActiveStatement.close();
            readConnection.ActiveConnection.close();

            String testNote = "When your great uncle starts his usual dinner routine of sticking spoons to his forehead, you know it's about that time to come up with an excuse to excuse yourself.";

            if(sharedPrimaryKey != null)
            {
                DatabaseConnection writeConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
                writeConnection.setNote(sharedPrimaryKey, testNote);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
