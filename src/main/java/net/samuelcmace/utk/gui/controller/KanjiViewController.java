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
public class KanjiViewController {

    /**
     * The DBConnectionPool singleton instance associated with KanjiBrowserController.
     */
    private DBConnectionPool dbConnectionPool;

    /**
     * Initializes a new instance of KanjiBrowserController.
     */
    public KanjiViewController()
    {
        try {
            this.dbConnectionPool = DBConnectionPool.GetInstance();
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
        ControllerManager.SwitchScene(Controllers.KANJI_BROWSER);
    }

}