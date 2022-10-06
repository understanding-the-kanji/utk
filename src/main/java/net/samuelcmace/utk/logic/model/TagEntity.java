package net.samuelcmace.utk.logic.model;

/**
 * Class that describes the TAG entity in the database.
 * Unlike the CARD entity, the TAG entity *may* be modified so that the user can add custom tags.
 * Unlike NOTES (which contain CARD_IDs), TAGs are contained inside the NOTE object.
 */
public class TagEntity {

    /**
     * Represents the TAG_ID stored in the database.
     */
    private int TAG_ID;

    /**
     * Represents the TAG_NAME stored in the database.
     */
    private String TAG_NAME;

    /**
     * Initializes a new instance of TagEntity.
     */
    public TagEntity(int m_tagID, String m_tagName)
    {
        this.TAG_ID = m_tagID;
        this.TAG_NAME = m_tagName;
    }

    /**
     * Gets the value stored in TAG_ID.
     * @return The ID for the tag in question.
     */
    public int getTAG_ID() {
        return TAG_ID;
    }

    /**
     * Gets the value stored in TAG_NAME.
     * @return The name of the tag in question.
     */
    public String getTAG_NAME() {
        return TAG_NAME;
    }
}
