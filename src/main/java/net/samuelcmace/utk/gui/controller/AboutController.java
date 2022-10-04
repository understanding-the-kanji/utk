package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;

/**
 * The controller for the About view.
 */
public class AboutController {

    /**
     * Called when the return button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_returnButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.LOAD);
    }

    /**
     * Called when the license button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_licenseButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.ABOUT_LICENSES);
    }
}