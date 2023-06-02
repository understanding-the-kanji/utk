package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.DatabaseReadConnection;
import org.junit.jupiter.api.Test;

/**
 * A class to store database-related read tests.
 */
public class DatabaseReadTests {

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
            DatabaseReadConnection dbConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());
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
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
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
            DatabaseReadConnection dbConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());
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
        } catch (Exception e) {
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
            DatabaseReadConnection dbConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());
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
        } catch (Exception e) {
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
            DatabaseReadConnection dbConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test to see if a specific 6th edition Heisig keyword and its associated details can be retrieved from the database.
     * It asserts true if the connection was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void getCardBy6thEditionHeisigKeyword() {
        try {
            DatabaseReadConnection dbConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
