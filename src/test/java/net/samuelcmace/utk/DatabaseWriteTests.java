package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.AppStoragePaths;
import net.samuelcmace.utk.logic.DatabaseReadConnection;
import net.samuelcmace.utk.logic.DatabaseWriteConnection;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * Test that deal with writing to the database.
 */
public class DatabaseWriteTests {


    /**
     * Test to see if the note can be set properly.
     * It asserts true if the operation was a success,
     * otherwise if an exception was thrown, it asserts false.
     */
    @Test
    public void setNote()
    {
        try {
            DatabaseReadConnection readConnection = new DatabaseReadConnection(AppStoragePaths.GetDBConnectionString());

            Integer sharedPrimaryKey = null;

            readConnection.getCardBy6thEditionKeyword("about that time");
            readConnection.RunActiveQuery();

            while (readConnection.ActiveResultSet.next()) {
                sharedPrimaryKey = readConnection.ActiveResultSet.getInt("CARD_ID");
                System.out.println(sharedPrimaryKey);
            }

            String testNote = "When your younger brother starts throwing spoons at your head, you know it's about that time to give him what he wants.";

            DatabaseWriteConnection writeConnection = new DatabaseWriteConnection(AppStoragePaths.GetDBConnectionString());
            writeConnection.setNote(sharedPrimaryKey, testNote);
            assert true;
        } catch (SQLException e) {
            e.printStackTrace();
            assert false;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }
}
