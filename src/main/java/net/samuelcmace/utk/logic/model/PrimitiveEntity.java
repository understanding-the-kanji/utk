package net.samuelcmace.utk.logic.model;

/**
 * Class that describes the PRIMITIVE entity in the database.
 * This class is read-only, since all the data is already contained in the table.
 */
public class PrimitiveEntity {

    /**
     * The primary key of the primitive object.
     */
    private int PRIMITIVE_ID;

    /**
     * The Heisig index that represents the first Kanji character that follows this primitive.
     */
    private int NEXT_FRAME;

    /**
     * Represents the file path where the SVG file is stored in the project resources.
     * All file paths are proceeded by net/samuelcmace/utk/kanji/primitives
     */
    private String SVG_PATH;

    /**
     * Represents the Heisig keyword that is associated with the Kanji's primitive.
     */
    private String KEYWORD;

    /**
     * Initializes a new instance of PrimitiveEntity.
     *
     * @param m_primitiveID The primary key of the primitive object.
     * @param m_nextFrame   The Heisig index that represents the first Kanji character that follows this primitive.
     * @param m_svgPath     The SVG resource path that corresponds to the primitive.
     * @param m_keyword     The keyword that Heisig gave to the primitive.
     */
    public PrimitiveEntity(int m_primitiveID, int m_nextFrame, String m_svgPath, String m_keyword) {

    }
}
