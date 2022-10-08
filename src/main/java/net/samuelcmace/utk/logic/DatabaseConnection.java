package net.samuelcmace.utk.logic;

import java.sql.*;

/**
 * Defines an object wrapper for a SQLite database connection.
 */
public class DatabaseConnection {

    /**
     * The JDBC connection string that corresponds to the database.
     */
    private String dbConnectionString;

    /**
     * The connection object associated with the instance of DatabaseConnection.
     */
    public Connection ActiveConnection;

    /**
     * The statement object associated with reading data from the database.
     */
    public Statement ActiveStatement;

    /**
     * The statement object associated with writing data to the database.
     */
    public PreparedStatement ActivePreparedStatement;

    /**
     * The active result set associated with reading data from the database.
     */
    public ResultSet ActiveResultSet;

    /**
     * The currently active query string used to generate the ActiveResultSet.
     */
    private String activeQuery;

    /**
     * Initializes a new instance of DatabaseConnection.
     */
    public DatabaseConnection(String m_dbConnectionString) throws SQLException {
        this.dbConnectionString = m_dbConnectionString;
        Logger.ConsoleInformation("Database Connection String Set: " + this.dbConnectionString);

        this.ActiveConnection = DriverManager.getConnection(this.dbConnectionString);
    }

    /**
     * Destructor called by the garbage collector to close the database connection on program exit.
     * Although destructors are no longer needed in most java programming, this context requires that the database
     * connection will remain open for the entire lifespan of the object, but also closed when the object is destroyed.
     */
    protected void finalize() {
        try {
            this.ActiveResultSet.close();
            this.ActiveStatement.close();
            this.ActivePreparedStatement.close();
            this.ActiveConnection.close();
        } catch (SQLException e) {
            Logger.ConsoleError("There was an error in closing the database connection in the object destructor: " + e.getLocalizedMessage());
        }
    }

    /**
     * Runs the currently-stored query.
     *
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void RunActiveQuery() throws SQLException {
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

    /**
     * Set the card's note information, given the primary key.
     *
     * @param m_cardID The primary key that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database-related error.
     */
    public void setNote(int m_cardID, String m_data) throws SQLException {
        String query = "UPDATE CARD SET CARD.NOTE = '?' WHERE CARD.CARD_ID = '" + m_cardID + "';";
        this.ActivePreparedStatement = this.ActiveConnection.prepareStatement(this.activeQuery);
        this.ActivePreparedStatement.setString(1, m_data);
        this.ActivePreparedStatement.executeUpdate();
    }
}
