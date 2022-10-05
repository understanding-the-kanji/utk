package net.samuelcmace.utk;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.samuelcmace.utk.gui.ControllerManager;
import net.samuelcmace.utk.gui.Controllers;

import java.io.IOException;
import java.sql.SQLException;

/**
 * The main class for the program.
 */
public class Main extends Application {

    /**
     * The scene that contains the views for the application.
     */
    private Scene applicationScene;

    /**
     * Initializes a new instance of Main.
     *
     * @throws IOException Thrown if the main program scene was unable to load.
     */
    public Main() throws IOException, SQLException {
        this.applicationScene = new Scene(new Pane(), 600, 400);

        ControllerManager.SetScene(this.applicationScene);
        ControllerManager.SwitchScene(Controllers.LOAD);
    }

    /**
     * The method called when the JavaFX Application starts.
     *
     * @param stage the primary stage for this application, onto which
     *              the application scene can be set.
     *              Applications may create other stages, if needed, but they will not be
     *              primary stages.
     * @throws IOException Thrown if the main scene was unable to instantiate.
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hello!");
        stage.setScene(this.applicationScene);
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