package net.samuelcmace.utk.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import net.samuelcmace.utk.Main;
import net.samuelcmace.utk.util.MessageBox;

public abstract class ControllerManager {

    private static Scene applicationScene;

    public static void SetScene(Scene scene) {
        applicationScene = scene;
    }

    public static void SwitchScene(Controllers m_controller) {
        try {
            Parent fxmlLoader = FXMLLoader.load(Main.class.getResource(Controllers.FilePath(m_controller)));
            ControllerManager.applicationScene.setRoot(fxmlLoader);
        } catch (Exception e) {
            MessageBox.ShowErrorDialog("The View Failed to Switch!\n" + e.toString());
        }
    }
}
