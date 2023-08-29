package net.samuelcmace.utk.logic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * The DatabaseConnection child class associated with writing data to the database.
 */
public class DatabaseWriteConnection extends DatabaseConnection {

    /**
     * The statement object associated with writing data to the database.
     */
    public PreparedStatement ActivePreparedStatement;

    /**
     * Initializes a new instance of DatabaseWriteConnection.
     *
     * @param m_dbConnectionString The JDBC connection string.
     */
    public DatabaseWriteConnection(String m_dbConnectionString) {
        super(m_dbConnectionString);
    }

    /**
     * Method called by the Java garbage collector before the object is destroyed.
     * Although this method is not needed in most java programming, it is needed here to ensure that the database
     * connections are closed before the program exists.
     */
    protected void finalize() {
        super.finalize();
        try {
            this.ActivePreparedStatement.close();
        } catch (SQLException e) {
            Logger.ConsoleError("The connections failed to close in the DatabaseReadConnection destructor: " + e.getLocalizedMessage());
        }
    }

    /**
     * Set the card's note information, given the primary key and the associated note data.
     *
     * @param m_cardID The primary key that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database-related connection error.
     */
    public void setNote(int m_cardID, String m_data) throws SQLException {
        this.ActiveConnection = DriverManager.getConnection(this.dbConnectionString);
        this.ActivePreparedStatement = this.ActiveConnection.prepareStatement("UPDATE CARD SET NOTE = ? WHERE CARD_ID = ?;");

        this.ActivePreparedStatement.setString(1, m_data);
        this.ActivePreparedStatement.setInt(2, m_cardID);

        this.ActivePreparedStatement.executeUpdate();
    }
}
