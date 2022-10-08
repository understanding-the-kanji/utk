package net.samuelcmace.utk.logic;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseReadConnection extends DatabaseConnection {

    /**
     * The statement object associated with reading data from the database.
     */
    public Statement ActiveStatement;

    public DatabaseReadConnection(String m_dbConnectionString) throws SQLException {
        super(m_dbConnectionString);
    }

    public void finalize()
    {
        try {
            this.ActiveResultSet.close();
            this.ActiveStatement.close();
            this.ActiveConnection.close();
        } catch (SQLException e) {
            Logger.ConsoleError("The connections failed to close in the DatabaseReadConnection destructor: " + e.getLocalizedMessage());
        }
    }

    /**
     * Runs the currently-stored query.
     *
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void RunActiveQuery() throws SQLException {
        this.ActiveConnection = DriverManager.getConnection(this.dbConnectionString);
        this.ActiveStatement = this.ActiveConnection.createStatement();
        this.ActiveResultSet = this.ActiveStatement.executeQuery(this.activeQuery);
    }

    /**
     * Fetch a card object from the database by Kanji character and store it in a ResultSet.
     *
     * @param m_kanji The Kanji character in question.
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void getCardByKanji(String m_kanji) throws SQLException {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.CARD_KANJI = '" + m_kanji + "';";
    }

    /**
     * Fetch a card object from the database by the 5th Edition Heisig Index.
     *
     * @param m_heisigIndex The Heisig Index that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void getCardBy5thEditionIndex(int m_heisigIndex) throws SQLException {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.HEISIG_INDEX_5_EDITION = '" + m_heisigIndex + "';";
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Index.
     *
     * @param m_heisigIndex The Heisig Index that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void getCardBy6thEditionIndex(int m_heisigIndex) throws SQLException {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.HEISIG_INDEX_6_EDITION = '" + m_heisigIndex + "';";
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Keyword.
     *
     * @param m_keyword The keyword that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void getCardBy5thEditionKeyword(String m_keyword) throws SQLException {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.KEYWORD_5_EDITION = '" + m_keyword + "';";
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Keyword.
     *
     * @param m_keyword The keyword that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void getCardBy6thEditionKeyword(String m_keyword) throws SQLException {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.KEYWORD_6_EDITION = '" + m_keyword + "';";
    }
}
