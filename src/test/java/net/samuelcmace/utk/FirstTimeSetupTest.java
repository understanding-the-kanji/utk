package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.Configuration;
import net.samuelcmace.utk.logic.DatabaseConnection;
import net.samuelcmace.utk.logic.model.CardEntity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Test to see if the first-time setup procedure
 * (the creation of the .understanding-the-kanji directory
 * and the copying of the utk database was a success).
 */
public class FirstTimeSetupTest {

    /**
     * The test associated with the first-time setup.
     */
    @Test
    public void firstTimeSetupTest() {
        try {
            Configuration configuration = Configuration.GetInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @Test
    public void getCardByKanjiTest() {
        try {
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            CardEntity cardEntity = dbConnection.getCardByKanji('覚');


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
