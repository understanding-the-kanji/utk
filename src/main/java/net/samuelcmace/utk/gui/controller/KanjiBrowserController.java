package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;

/**
 * The controller that corresponds to the KanjiBrowser view.
 */
public class KanjiBrowserController {

    /**
     * Called when the return button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_returnButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.LOAD);
    }

}