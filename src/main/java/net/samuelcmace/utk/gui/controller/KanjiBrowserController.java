package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.logic.DBConnectionPool;
import net.samuelcmace.utk.logic.Logger;

import java.sql.SQLException;

/**
 * The controller that corresponds to the KanjiBrowser view.
 */
public class KanjiBrowserController {

    /**
     * The DBConnectionPool singleton instance associated with KanjiBrowserController.
     */
    private DBConnectionPool dbConnectionPool;

    /**
     * Initializes a new instance of KanjiBrowserController.
     */
    public KanjiBrowserController()
    {
        try {
            this.dbConnectionPool = DBConnectionPool.GetInstance();
            String queryResult = "";

            while (this.dbConnectionPool.dbConnection.ActiveResultSet.next()) {
                queryResult += "Card ID: " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("CARD_ID") + '\n';
                queryResult += "Kanji Character: " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("CARD_KANJI") + '\n';
                queryResult += "Heisig Index (5th Edition): " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("HEISIG_INDEX_5_EDITION") + '\n';
                queryResult += "Heisig Index (6th Edition): " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("HEISIG_INDEX_6_EDITION") + '\n';
                queryResult += "Keyword (5th Edition): " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("KEYWORD_5_EDITION") + '\n';
                queryResult += "Keyword (6th Edition): " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("KEYWORD_6_EDITION") + '\n';
                queryResult += "On-Reading (Chinese Reading): " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("ON_READING") + '\n';
                queryResult += "Kun-Reading (Japanese Reading): " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("KUN_READING") + '\n';
                queryResult += "Note: " + this.dbConnectionPool.dbConnection.ActiveResultSet.getString("NOTE") + '\n';
            }

            Logger.Information(queryResult);
        } catch (SQLException e) {
            Logger.Error("There was an error in connecting to the database: " + e.getLocalizedMessage());
        }
    }

    /**
     * Called when the return button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_returnButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.KANJI_SEARCH);
    }

}