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