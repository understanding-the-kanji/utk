package net.samuelcmace.utk.logic;

import java.io.IOException;
import java.sql.*;

/**
 * Defines an object wrapper for a SQLite database connection.
 */
public class DatabaseConnection {

    /**
     * Logger object for the DatabaseConnection class.
     */
    private Logger logger;

    /**
     * The JDBC connection string that corresponds to the database.
     */
    private String dbConnectionString;

    /**
     * The connection object associated with the instance of DatabaseConnection.
     */
    public Connection activeConnection;

    /**
     * The statement associated with the instance of DatabaseConnection.
     */
    public Statement activeStatement;

    /**
     * The active result set containing the query results.
     */
    public ResultSet activeResultSet;

    /**
     * Initializes a new instance of DatabaseConnection.
     *
     * @throws IOException  Thrown if either the Configuration or Logger singleton instances failed to instantiate.
     * @throws SQLException Thrown if the database connection failed.
     */
    public DatabaseConnection(String m_dbConnectionString) throws IOException {

        this.dbConnectionString = m_dbConnectionString;

        try {
            this.activeConnection = DriverManager.getConnection(this.dbConnectionString);
        } catch (SQLException e) {
            Logger.ConsoleError("There was an error in connecting to the database " + e.getLocalizedMessage());
        }

        this.logger.ConsoleInformation("Database Connection String Set: " + this.dbConnectionString);
    }

//    protected void finalize() {
//        try {
//            this.activeConnection.close();
//        } catch (SQLException e) {
//            Logger.ConsoleError("There was an error in closing the database connection in the object destructor: " + e.getLocalizedMessage());
//        }
//    }

    /**
     * Fetch a card object from the database by Kanji character and store it in a ResultSet.
     *
     * @param m_kanji The Kanji character in question.
     */
    public void getCardByKanji(char m_kanji) throws SQLException {
        try {
            this.activeStatement = this.activeConnection.createStatement();

            this.activeResultSet = this.activeStatement.executeQuery("SELECT CARD_ID, CARD_KANJI, HEISIG_INDEX_5_EDITION, HEISIG_INDEX_6_EDITION, KEYWORD_5_EDITION, KEYWORD_6_EDITION, ON_READING, KUN_READING, NOTE FROM CARD WHERE CARD.CARD_KANJI = '" + m_kanji + "';");
        } catch (SQLException e) {

            e.printStackTrace();
            this.logger.ConsoleInformation("The connection to the database failed. This is likely due to an invalid file path.");

        }
    }

    /**
     * Fetch a card object from the database by the 5th Edition Heisig Index.
     *
     * @param m_heisigIndex The Kanji character in question.
     */
    public void getCardBy5thEditionIndex(int m_heisigIndex) {
        throw new IllegalCallerException();
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Index.
     *
     * @param m_heisigIndex The Kanji character in question.
     */
    public void getCardBy6thEditionIndex(int m_heisigIndex) {
        throw new IllegalCallerException();
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Keyword.
     *
     * @param m_heisigIndex The Kanji character in question.
     */
    public void getCardBy5thEditionKeyword(int m_heisigIndex) {
        throw new IllegalCallerException();
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Keyword.
     *
     * @param m_heisigIndex The Kanji character in question.
     */
    public void getCardBy6thEditionKeyword(int m_heisigIndex) {
        throw new IllegalCallerException();
    }
}
