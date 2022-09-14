package net.samuelcmace.demo.gui.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import net.samuelcmace.demo.util.Logger;

public class LoadScene extends Scene {

    private Logger logger;

    private Group mainGroup;

    private Text titleText;

    private VBox mainLayout;

    private HBox quizSceneHBox;
    private Label quizSceneLabel;
    public Button QuizSceneButton;

    private HBox editorSceneHBox;
    private Label editorSceneButton;
    public Button EditorSceneButton;

    public LoadScene(Parent parent, double width, double height, Logger m_logger)
    {
        super(parent, width, height);
        this.logger = m_logger;

        this.mainGroup = new Group();

        this.mainLayout = new VBox();
        this.titleText = new Text("Welcome to the LoadScene!");
        this.mainLayout.getChildren().add(titleText);

        this.quizSceneHBox = new HBox();
        this.QuizSceneButton = new Button("Quiz Myself");
        this.quizSceneHBox.getChildren().add(this.QuizSceneButton);
        this.mainGroup.getChildren().add(this.quizSceneHBox);

        this.editorSceneHBox = new HBox();
        this.EditorSceneButton = new Button("Kanji Builder");
        this.editorSceneHBox.getChildren().add(this.EditorSceneButton);
        this.mainGroup.getChildren().add(this.editorSceneHBox);

        this.mainGroup.getChildren().add(this.mainLayout);
    }
}
