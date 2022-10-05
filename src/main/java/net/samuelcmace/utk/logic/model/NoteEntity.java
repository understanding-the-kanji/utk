package net.samuelcmace.utk.logic.model;

/**
 * Class that describes the NOTE entity in the database.
 * Unlike the CARD entity, the NOTE entity *may* be modified so that the user can add custom notes.
 */
public class NoteEntity {

    /**
     * Corresponds to the NOTE_ID in the database schema.
     */
    private int NOTE_ID;

    /**
     * Corresponds to the card that the note references.
     */
    private int CARD_ID;

    /**
     * Corresponds to the NOTE_CONTENTS in the database schema.
     */
    private String NOTE_CONTENTS;

    public NoteEntity(int m_noteID, String m_noteContents) {
        this.NOTE_ID = m_noteID;
        this.NOTE_CONTENTS = m_noteContents;
    }

    /**
     * Gets the value contained in NOTE_ID.
     *
     * @return The NOTE_ID.
     */
    public int getNOTE_ID() {
        return NOTE_ID;
    }

    /**
     * Sets the value contained in NOTE_ID.
     *
     * @return The NOTE_ID.
     */
    public void setNOTE_ID(int NOTE_ID) {
        this.NOTE_ID = NOTE_ID;
    }

    /**
     * Gets the value contained in CARD_ID.
     *
     * @return The CARD_ID.
     */
    public int getCARD_ID() {
        return CARD_ID;
    }

    /**
     * Sets the value contained in CARD_ID.
     *
     * @return The CARD_ID.
     */
    public void setCARD_ID(int CARD_ID) {
        this.CARD_ID = CARD_ID;
    }

    /**
     * Gets the value contained in NOTE_CONTENTS.
     *
     * @return The NOTE_CONTENTS.
     */
    public String getNOTE_CONTENTS() {
        return NOTE_CONTENTS;
    }

    /**
     * Sets the value contained in NOTE_CONTENTS.
     *
     * @return The NOTE_CONTENTS.
     */
    public void setNOTE_CONTENTS(String NOTE_CONTENTS) {
        this.NOTE_CONTENTS = NOTE_CONTENTS;
    }
}
