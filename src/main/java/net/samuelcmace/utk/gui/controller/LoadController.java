package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;

/**
 * The controller that corresponds to the Load view.
 */
public class LoadController {

    /**
     * Called when the quiz button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_quizButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.QUIZ);
    }

    /**
     * Called when the kanji browser button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_browserButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.KANJI_SEARCH);
    }

    /**
     * Called when the about button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_aboutButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.ABOUT);
    }

    /**
     * Called when the exit button is pressed.
     *
     * @param actionEvent The default arguments passed to the event.
     */
    public void onClick_exitButton(ActionEvent actionEvent) {
        System.exit(0);
    }
}