package net.samuelcmace.utk.logic;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * The DatabaseConnection child class associated with reading data from the database.
 */
public class DatabaseReadConnection extends DatabaseConnection {

    /**
     * The statement object associated with reading data from the database.
     */
    public Statement ActiveStatement;

    /**
     * The active result set associated with reading data from the database.
     */
    public ResultSet ActiveResultSet;

    /**
     * Initializes a new instance of DatabaseReadConnection.
     * @param m_dbConnectionString The JDBC connection string.
     */
    public DatabaseReadConnection(String m_dbConnectionString) {
        super(m_dbConnectionString);
    }

    /**
     * Method called by the Java garbage collector before the object is destroyed.
     * Although this method is not needed in most java programming, it is needed here to ensure that the database
     * connections are closed before the program exists.
     */
    protected void finalize()
    {
        super.finalize();
        try {
            this.ActiveStatement.close();
            this.ActiveResultSet.close();
        } catch (SQLException e) {
            Logger.ConsoleError("The connections failed to close in the DatabaseReadConnection destructor: " + e.getLocalizedMessage());
        }
    }

    /**
     * Runs the currently-stored query which was set using the getCardBy* methods.
     *
     * @throws SQLException Thrown if there was a database query-related error.
     */
    public void RunActiveQuery() throws SQLException {
        this.ActiveConnection = DriverManager.getConnection(this.dbConnectionString);
        this.ActiveStatement = this.ActiveConnection.createStatement();
        this.ActiveResultSet = this.ActiveStatement.executeQuery(this.activeQuery);
    }

    /**
     * Sets the currently active query string based on the passed-in parameters.
     * The query still needs to be executed by calling the RunActiveQuery() method.
     *
     * @param m_kanji The Kanji character in question.
     */
    public void getCardByKanji(String m_kanji) {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.CARD_KANJI = '" + m_kanji + "';";
    }

    /**
     * Sets the currently active query string based on the passed-in parameters.
     * The query still needs to be executed by calling the RunActiveQuery() method.
     *
     * @param m_heisigIndex The Heisig Index that corresponds to the Kanji character in question.
     */
    public void getCardBy5thEditionIndex(int m_heisigIndex) {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.HEISIG_INDEX_5_EDITION = '" + m_heisigIndex + "';";
    }

    /**
     * Sets the currently active query string based on the passed-in parameters.
     * The query still needs to be executed by calling the RunActiveQuery() method.
     *
     * @param m_heisigIndex The Heisig Index that corresponds to the Kanji character in question.
     */
    public void getCardBy6thEditionIndex(int m_heisigIndex) {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.HEISIG_INDEX_6_EDITION = '" + m_heisigIndex + "';";
    }

    /**
     * Sets the currently active query string based on the passed-in parameters.
     * The query still needs to be executed by calling the RunActiveQuery() method.
     *
     * @param m_keyword The keyword that corresponds to the Kanji character in question.
     */
    public void getCardBy5thEditionKeyword(String m_keyword) {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.KEYWORD_5_EDITION = '" + m_keyword + "';";
    }

    /**
     * Sets the currently active query string based on the passed-in parameters.
     * The query still needs to be executed by calling the RunActiveQuery() method.
     *
     * @param m_keyword The keyword that corresponds to the Kanji character in question.
     */
    public void getCardBy6thEditionKeyword(String m_keyword) {
        this.activeQuery = "SELECT CARD.* FROM CARD WHERE CARD.KEYWORD_6_EDITION = '" + m_keyword + "';";
    }
}
