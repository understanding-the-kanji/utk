package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;

public class LoadController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onClick_quizButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.QUIZ);
    }

    public void onClick_browserButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.KANJI_BROWSER);
    }

    public void onClick_aboutButton(ActionEvent actionEvent) {
        ControllerManager.SwitchScene(Controllers.ABOUT);
    }

    public void onClick_exitButton(ActionEvent actionEvent) {
        System.exit(0);
    }
}