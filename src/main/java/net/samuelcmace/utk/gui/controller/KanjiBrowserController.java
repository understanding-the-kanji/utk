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

            while (this.dbConnectionPool.dbConnection.activeResultSet.next()) {
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getInt("CARD_ID"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getString("CARD_KANJI"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getInt("HEISIG_INDEX_5_EDITION"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getInt("HEISIG_INDEX_6_EDITION"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getString("KEYWORD_5_EDITION"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getString("KEYWORD_6_EDITION"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getString("ON_READING"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getString("KUN_READING"));
                System.out.println(this.dbConnectionPool.dbConnection.activeResultSet.getString("NOTE"));
            }
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