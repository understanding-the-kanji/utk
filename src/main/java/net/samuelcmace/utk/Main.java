package net.samuelcmace.utk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;
import net.samuelcmace.utk.gui.MessageBox;
import net.samuelcmace.utk.logic.AppStoragePaths;
import net.samuelcmace.utk.logic.Logger;

import java.io.IOException;

/**
 * The main class for the program.
 */
public class Main extends Application {

    /**
     * The scene that contains the views for the application.
     */
    private Scene applicationScene;

    /**
     * The method called when the JavaFX Application starts.
     *
     * @param stage The primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     */
    @Override
    public void start(Stage stage) {
        Logger.ConsoleInformation("Application Started");

        this.applicationScene = new Scene(new Pane(), 600, 400);

        try {
            AppStoragePaths.FirstTimeSetup();
            Logger.ConsoleInformation("Application Storage Directory: " + AppStoragePaths.GetAppStorageDir());
            Logger.ConsoleInformation("Application Log File Path: " + AppStoragePaths.GetLogFilePath());
            Logger.ConsoleInformation("Application Database Path: " + AppStoragePaths.GetDBFilePath());
        } catch (IOException e) {
            MessageBox.ShowErrorDialog("There was an error in setting up the application storage system: " + e.getLocalizedMessage());
        }

        stage.setTitle("Understanding the Kanji");
        stage.setScene(this.applicationScene);

        ControllerManager.SetScene(this.applicationScene);
        ControllerManager.SwitchScene(Controllers.LOAD);

        stage.show();
    }

    /**
     * The main function for the program.
     *
     * @param args The arguments passed to the program at runtime.
     */
    public static void main(String[] args) {
        launch();
    }
}