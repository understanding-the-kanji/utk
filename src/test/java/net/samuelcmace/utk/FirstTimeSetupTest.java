package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppState;
import net.samuelcmace.utk.logic.DatabaseConnection;
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
            AppState appState = AppState.GetInstance();
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
            AppState appState = AppState.GetInstance();
            DatabaseConnection dbConnection = new DatabaseConnection(appState.DBConnectionString);
            dbConnection.getCardByKanji('何');

            while (dbConnection.activeResultSet.next()) {
                System.out.println(dbConnection.activeResultSet.getInt("CARD_ID"));
                System.out.println(dbConnection.activeResultSet.getString("CARD_KANJI"));
                System.out.println(dbConnection.activeResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(dbConnection.activeResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(dbConnection.activeResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(dbConnection.activeResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(dbConnection.activeResultSet.getString("ON_READING"));
                System.out.println(dbConnection.activeResultSet.getString("KUN_READING"));
                System.out.println(dbConnection.activeResultSet.getString("NOTE"));
            }

            dbConnection.activeConnection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
