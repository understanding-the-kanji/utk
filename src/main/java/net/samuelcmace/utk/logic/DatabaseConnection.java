package net.samuelcmace.utk.logic;

import net.samuelcmace.utk.logic.model.CardEntity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Defines a direct connection to the SQLite project database.
 */
public class DatabaseConnection {

    /**
     * Singleton instance of DatabaseConnection.
     */
    private static DatabaseConnection instance = null;

    /**
     * Configuration object for the DatabaseConnection class.
     */
    private Configuration configuration;

    /**
     * Logger object for the DatabaseConnection class.
     */
    private Logger logger;

    /**
     * The JDBC connection string that corresponds to the database.
     */
    private String dbConnectionString;

    /**
     * Initializes a new instance of DatabaseConnection.
     *
     * @throws IOException  Thrown if either the Configuration or Logger singleton instances failed to instantiate.
     * @throws SQLException Thrown if the database connection failed.
     */
    private DatabaseConnection() throws IOException {
        this.configuration = Configuration.GetInstance();
        this.logger = Logger.GetInstance();

        this.dbConnectionString = "jdbc:sqlite:" + this.configuration.DBFilePath;



        this.logger.ConsoleInformation("Database Connection Succeeded");
    }

    /**
     * Retrieves the singleton instance of DatabaseConnection.
     *
     * @return The singleton instance of DatabaseConnection.
     * @throws IOException Thrown if the DatabaseConnection singleton instance was unable to instantiate.
     */
    public static DatabaseConnection getInstance() throws IOException {
        if (DatabaseConnection.instance == null) DatabaseConnection.instance = new DatabaseConnection();

        return DatabaseConnection.instance;
    }

    /**
     * Fetch a card object from the database by Kanji character.
     *
     * @param m_kanji The Kanji character in question.
     * @return The card entity.
     */
    public CardEntity getCardByKanji(char m_kanji) throws SQLException {
        CardEntity cardEntity = null;
        Connection connection;

        try {
            connection = DriverManager.getConnection(this.dbConnectionString);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            this.logger.ConsoleInformation("The connection to the database failed. This is possibly due to an invalid file path.");
        }

        return cardEntity;
    }

    /**
     * Fetch a card object from the database by the 5th Edition Heisig Index.
     * @param m_heisigIndex The Kanji character in question.
     * @return The card entity.
     */
    public CardEntity getCardBy5thEditionIndex(int m_heisigIndex)
    {
        throw new IllegalCallerException();
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Index.
     * @param m_heisigIndex The Kanji character in question.
     * @return The card entity.
     */
    public CardEntity getCardBy6thEditionIndex(int m_heisigIndex)
    {
        throw new IllegalCallerException();
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Keyword.
     * @param m_heisigIndex The Kanji character in question.
     * @return The card entity.
     */
    public CardEntity getCardBy5thEditionKeyword(int m_heisigIndex)
    {
        throw new IllegalCallerException();
    }

    /**
     * Fetch a card object from the database by the 6th Edition Heisig Keyword.
     * @param m_heisigIndex The Kanji character in question.
     * @return The card entity.
     */
    public CardEntity getCardBy6thEditionKeyword(int m_heisigIndex)
    {
        throw new IllegalCallerException();
    }
}
