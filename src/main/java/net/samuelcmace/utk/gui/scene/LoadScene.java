package net.samuelcmace.utk.gui.scene;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoadScene {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}