package net.samuelcmace.utk;

import net.samuelcmace.utk.logic.DatabaseConnection;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionTests {

    @Test
    public void databaseConnectionTest() {
        try {
            DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
            databaseConnection.getCardByKanji('覚');
            assert true;
        } catch (Exception e) {
            e.printStackTrace();
            assert false;
        }
    }

}
