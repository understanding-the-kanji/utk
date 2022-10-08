package net.samuelcmace.utk.logic;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseWriteConnection extends DatabaseConnection {

    /**
     * The statement object associated with writing data to the database.
     */
    public PreparedStatement ActivePreparedStatement;

    public DatabaseWriteConnection(String m_dbConnectionString) throws SQLException {
        super(m_dbConnectionString);
    }

    public void finalize()
    {
        try {
            this.ActiveResultSet.close();
            this.ActivePreparedStatement.close();
            this.ActiveConnection.close();
        } catch (SQLException e) {
            Logger.ConsoleError("The connections failed to close in the DatabaseReadConnection destructor: " + e.getLocalizedMessage());
        }
    }

    /**
     * Set the card's note information, given the primary key.
     *
     * @param m_cardID The primary key that corresponds to the Kanji character in question.
     * @throws SQLException Thrown if there was a database-related error.
     */
    public void setNote(int m_cardID, String m_data) throws SQLException {
        this.ActiveConnection = DriverManager.getConnection(this.dbConnectionString);
        this.ActivePreparedStatement = this.ActiveConnection.prepareStatement("UPDATE CARD SET NOTE = ? WHERE CARD_ID = ?;");

        this.ActivePreparedStatement.setString(1, m_data);
        this.ActivePreparedStatement.setInt(2, m_cardID);

        this.ActivePreparedStatement.executeUpdate();

        this.ActivePreparedStatement.close();
        this.ActiveConnection.close();
    }
}
