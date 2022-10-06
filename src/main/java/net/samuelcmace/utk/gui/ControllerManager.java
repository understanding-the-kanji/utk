package net.samuelcmace.utk.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import net.samuelcmace.utk.Main;
import net.samuelcmace.utk.logic.Logger;

/**
 * Abstract class to control the switching behavior of the FXML views and their corresponding controllers.
 */
public abstract class ControllerManager {

    /**
     * The scene set by the application on load.
     */
    private static Scene applicationScene;

    /**
     * Method called by the Main class to set the default scene.
     */
    public static void SetScene(Scene scene) {
        applicationScene = scene;
    }

    /**
     * Method to switch the view that the scene controls.
     *
     * @param m_controller The enum that corresponds to the view to switch to.
     */
    public static void SwitchScene(Controllers m_controller) {
        try {
            Parent fxmlLoader = FXMLLoader.load(Main.class.getResource(Controllers.FilePath(m_controller)));
            ControllerManager.applicationScene.setRoot(fxmlLoader);
        } catch (Exception e) {
            Logger.Error("The View Failed to Switch: " + e.getLocalizedMessage());
        }
    }
}
