package net.samuelcmace.utk.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoadController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onClick_quizButton(ActionEvent actionEvent) {
    }

    public void onClick_browserButton(ActionEvent actionEvent) {
    }

    public void onClick_aboutButton(ActionEvent actionEvent) {
    }

    public void onClick_exitButton(ActionEvent actionEvent) {
        System.exit(0);
    }
}