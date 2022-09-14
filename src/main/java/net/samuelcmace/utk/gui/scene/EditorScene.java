package net.samuelcmace.utk.gui.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

import net.samuelcmace.utk.util.Logger;

public class EditorScene extends Scene {

    private Logger logger;
    private Group mainGroup;
    private Button returnButton;
    private Text exampleText;

    public EditorScene(Parent parent, double width, double height, Logger m_logger)
    {
        super(parent, width, height);

        this.logger = m_logger;
        this.mainGroup = new Group(parent);

        this.returnButton = new Button("Back");
        this.returnButton.setLayoutX(10);
        this.returnButton.setLayoutY(10);
        this.mainGroup.getChildren().add(this.returnButton);

        this.exampleText = new Text("Welcome to the EditorScene!");
        this.mainGroup.getChildren().add(this.exampleText);
    }
}
