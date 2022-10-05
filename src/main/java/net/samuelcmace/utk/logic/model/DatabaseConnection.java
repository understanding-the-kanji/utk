package net.samuelcmace.utk.logic.model;

import jakarta.persistence.*;
import net.samuelcmace.utk.logic.Configuration;
import net.samuelcmace.utk.logic.Logger;
import net.samuelcmace.utk.logic.model.hibernate.CardEntity;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

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
     * Contains a map of properties to be sent to the EntityManagerFactory upon instantiation.
     * In this case, it only contains the connection string object, although more can be added if needed.
     */
    private HashMap<String, String> dbConnectionProperties;

    /**
     * The entity manager factory (persistence API) for the DatabaseConnection object.
     */
    private EntityManagerFactory entityManagerFactory;

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

        this.dbConnectionProperties = new HashMap<String, String>();
        this.dbConnectionProperties.put("jakarta.persistence.jdbc.url", this.dbConnectionString);

        this.logger.ConsoleInformation("Database Connection Succeeded");
    }

    /**
     * Retrieves the singleton instance of DatabaseConnection.
     *
     * @return The singleton instance of DatabaseConnection.
     * @throws IOException Thrown if the DatabaseConnection singleton instance was unable to instantiate.
     */
    public static DatabaseConnection getInstance() throws IOException, SQLException {
        if (DatabaseConnection.instance == null) DatabaseConnection.instance = new DatabaseConnection();

        return DatabaseConnection.instance;
    }

    /**
     * Fetch a card object from the database by Kanji character.
     * @param m_kanji The Kanji character in question.
     * @return The card entity.
     */
    public CardEntity getCardByKanji(char m_kanji)
    {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("utk", this.dbConnectionProperties);

        EntityManager entityManager = this.entityManagerFactory.createEntityManager();
        String query = "SELECT c FROM CARD c WHERE c.CARD_KANJI = :cardKanji";

        TypedQuery<CardEntity> typedQuery = entityManager.createQuery(query, CardEntity.class);
        typedQuery.setParameter("cardKanji", m_kanji);
        CardEntity card = null;

        try {
            card = typedQuery.getSingleResult();
            System.out.println(card.getKeyword6Edition());
        }
        catch (Exception ex)
        {
            System.out.println("There was an error in the query.");
        }

        this.entityManagerFactory.close();

        return card;
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
