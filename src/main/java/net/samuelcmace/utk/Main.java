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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The main class for the program.
 */
public class Main extends Application {

    /**
     * The scene that contains the views for the application.
     */
    private Scene applicationScene;

    /**
     * Ensures that the application-level storage directory and database exist.
     *
     * @throws IOException Thrown if either the default directory failed to create or the template database file failed to copy.
     */
    public void FirstTimeSetup() throws IOException {
        File appStorageDirectory = new File(AppStoragePaths.GetAppStorageDir());
        if (!appStorageDirectory.exists()) {
            appStorageDirectory.mkdir();
        }

        File databaseFile = new File(AppStoragePaths.GetDBFilePath());
        if (!databaseFile.exists()) {
            Files.copy(Main.class.getResourceAsStream("kanji/default.db"), Paths.get(AppStoragePaths.GetDBFilePath()));
        }
    }

    /**
     * The method called when the JavaFX Application starts.
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     */
    @Override
    public void start(Stage stage) {
        Logger.ConsoleInformation("Application Started at " + java.time.LocalDate.now() + " " + java.time.LocalTime.now());

        this.applicationScene = new Scene(new Pane(), 600, 400);

        try {
            this.FirstTimeSetup();
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