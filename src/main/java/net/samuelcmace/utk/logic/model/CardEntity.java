package net.samuelcmace.utk.logic.model;

import net.samuelcmace.utk.logic.AppState;
import net.samuelcmace.utk.logic.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 * Class that describes the CARD entity in the database.
 * Once the CardEntity object has been created, it cannot be modified, since all the Kanji characters in Heisig's works have already been added to the database.
 */
public class CardEntity {

    /**
     * The primary key of the CARD object.
     * The primary keys for the first 3,000 kanji characters map to the 6th edition Heisig index.
     * As for the additional characters contained in Heisig's previous works, they are incrementally indexed thereafter.
     */
    private int CARD_ID;

    /**
     * Represents the Kanji character of the card.
     * Since Java supports full-Unicode, this value can be stored in the char data type.
     */
    private char CARD_KANJI;

    /**
     * Represents the Heisig Index for the card (used in the 5th edition of Remembering the Kanji).
     */
    private int HEISIG_INDEX_5_EDITION;

    /**
     * Represents the Heisig Index for the card (used in the 6th edition of Remembering the Kanji).
     */
    private int HEISIG_INDEX_6_EDITION;

    /**
     * Represents the Keyword for the card (used in the 5th edition of Remembering the Kanji).
     */
    private String KEYWORD_5_EDITION;

    /**
     * Represents the Keyword for the card (used in the 6th edition of Remembering the Kanji).
     */
    private String KEYWORD_6_EDITION;

    /**
     * Represents the On-Reading of the Kanji character.
     * The On-Reading is the original, Chinese reading of the Kanji character.
     * Multiple entries for this may exist, all of which will be stored in this string object.
     */
    private String ON_READING;

    /**
     * Represents the Kun-Reading of the Kanji character.
     * The Kun-Reading is the modified, Japanese reading of the character.
     * Multiple entries for this may exist, all of which will be stored in this string object.
     */
    private String KUN_READING;

    /**
     * Represents the note that the user takes on the given card.
     */
    private String NOTE;

    /**
     * Represents all the tag entities that are associated with the given CARD instance.
     */
    private HashMap<Integer, TagEntity> CARD_TAG;

    /**
     * Represents all the primitives that are associated with the given CARD instance.
     * The user may add or subtract primitives, but may not modify the primitives themselves.
     */
    private HashMap<Integer, PrimitiveEntity> CARD_PRIMITIVE;

    /**
     * The application state associated with the CardEntity object.
     * This ensures that if the setters are called, the corresponding data in the database can be updated.
     */
    private AppState appState;

    /**
     * The database connection object associated with the entity (to allow for persistence).
     */
    private DatabaseConnection databaseConnection;

    /**
     * The SQLite JDBC connection object.
     */
    private Connection connection;

    /**
     * Database-related querying code shared between all the constructor overloads.
     */
    private void commonConstructor()
    {

    }

    /**
     * Initializes a new instance of CardEntity
     *
     * @param m_cardKanji             The kanji character for the card.
     */
    public CardEntity(char m_cardKanji) throws IOException {
        this.appState = AppState.GetInstance();
    }

    /**
     * Initializes a new instance of CardEntity
     *
     * @param m_heisigIndex The Heisig keyword to lookup by.
     * @param m_editionNumber The edition number associated with the Heisig index (5 or 6);
     */
    public CardEntity(int m_heisigIndex, int m_editionNumber)
    {

    }

    /**
     * Initializes a new instance of CardEntity
     *
     * @param m_keyword The Heisig keyword to lookup by.
     * @param m_editionNumber The edition number associated with the Heisig index (5 or 6);
     */
    public CardEntity(String m_keyword, int m_editionNumber)
    {

    }

    /**
     * Gets the value stored in CARD_ID.
     *
     * @return The CARD_ID stored in the object.
     */
    public int getCARD_ID() {
        return CARD_ID;
    }

    /**
     * Gets the value stored in CARD_KANJI.
     *
     * @return The CARD_KANJI stored in the object.
     */
    public char getCARD_KANJI() {
        return CARD_KANJI;
    }

    /**
     * Gets the value stored in HEISIG_INDEX_5_EDITION.
     *
     * @return The HEISIG_INDEX_5_EDITION stored in the object.
     */
    public int getHEISIG_INDEX_5_EDITION() {
        return HEISIG_INDEX_5_EDITION;
    }

    /**
     * Gets the value stored in HEISIG_INDEX_6_EDITION.
     *
     * @return The HEISIG_INDEX_6_EDITION stored in the object.
     */
    public int getHEISIG_INDEX_6_EDITION() {
        return HEISIG_INDEX_6_EDITION;
    }

    /**
     * Gets the value stored in KEYWORD_5_EDITION.
     *
     * @return The KEYWORD_5_EDITION stored in the object.
     */
    public String getKEYWORD_5_EDITION() {
        return KEYWORD_5_EDITION;
    }

    /**
     * Gets the value stored in KEYWORD_6_EDITION.
     *
     * @return The KEYWORD_6_EDITION stored in the object.
     */
    public String getKEYWORD_6_EDITION() {
        return KEYWORD_6_EDITION;
    }

    /**
     * Gets the value stored in ON_READING.
     *
     * @return The ON_READING stored in the object.
     */
    public String getON_READING() {
        return ON_READING;
    }

    /**
     * Gets the value stored in KUN_READING.
     *
     * @return The KUN_READING stored in the object.
     */
    public String getKUN_READING() {
        return KUN_READING;
    }
}
