package net.samuelcmace.utk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.util.Logger;
import net.samuelcmace.utk.util.Scheduler;

import java.io.IOException;

public class Main extends Application {

    private Scene applicationScene;

    public Main() throws IOException {

        this.applicationScene = new Scene(new Pane(), 600, 400);

        ControllerManager.SetScene(this.applicationScene);
        ControllerManager.SwitchScene(Controllers.LOAD);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hello!");
        stage.setScene(this.applicationScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}