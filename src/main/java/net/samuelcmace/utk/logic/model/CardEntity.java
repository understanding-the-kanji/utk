package net.samuelcmace.utk.logic.model;

/**
 * Class that describes the CARD entity in the database.
 * Once the CardEntity object has been created, it cannot be modified, since all the Kanji characters in Heisig's works have already been added to the database.
 */
public class CardEntity {

    /**
     * Represents the card ID according to the schema.
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

    public CardEntity(int m_cardID, char m_cardKanji, int m_heisigIndex5thEdition, int m_heisigIndex6thEdition, String m_keyword5thEdition, String m_keyword6thEdition, String m_onReading, String m_kunReading) {

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
