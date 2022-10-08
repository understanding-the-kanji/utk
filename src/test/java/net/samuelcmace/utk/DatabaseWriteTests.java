package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import net.samuelcmace.utk.logic.DatabaseConnection;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * Test that deal with writing to the database.
 */
public class DatabaseWriteTests {


    /**
     * Test to see if the note can be set properly.
     */
    @Test
    public void setNote()
    {
        try {
            DatabaseConnection readConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());

            Integer sharedPrimaryKey = null;

            readConnection.getCardBy6thEditionKeyword("about that time");
            readConnection.RunActiveQuery();


            while (readConnection.ActiveResultSet.next()) {
                sharedPrimaryKey = readConnection.ActiveResultSet.getInt("CARD_ID");
                System.out.println(sharedPrimaryKey);
            }

            readConnection.ActiveResultSet.close();
            readConnection.ActiveStatement.close();
            readConnection.ActiveConnection.close();

            String testNote = "When your younger brother starts throwing spoons at your head, you know it's about that time to give him what he wants.";

            if(sharedPrimaryKey != null)
            {
                DatabaseConnection writeConnection = new DatabaseConnection(AppStoragePaths.GetDBConnectionString());
                writeConnection.setNote(sharedPrimaryKey, testNote);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
