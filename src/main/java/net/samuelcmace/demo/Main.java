package net.samuelcmace.demo;

import net.samuelcmace.demo.gui.scene.EditorScene;
import net.samuelcmace.demo.gui.scene.QuizScene;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import net.samuelcmace.demo.gui.scene.LoadScene;

import net.samuelcmace.demo.util.Logger;
import net.samuelcmace.demo.util.Scheduler;

public class Main extends Application
{
    private Logger logger;
    private Scheduler scheduler;

    private Group loadSceneGroup;
    private Group quizSceneGroup;
    private Group editorSceneGroup;

    private LoadScene loadScene;
    private QuizScene quizScene;
    private EditorScene editorScene;

    public Main()
    {
        this.logger = new Logger();
        this.scheduler = new Scheduler(this.logger);

        this.loadSceneGroup = new Group();
        this.quizSceneGroup = new Group();
        this.editorSceneGroup = new Group();

        this.loadScene = new LoadScene(this.loadSceneGroup, this.logger.ApplicationData.WindowWidth, this.logger.ApplicationData.WindowHeight, this.logger);
        this.quizScene = new QuizScene(this.quizSceneGroup, this.logger.ApplicationData.WindowWidth, this.logger.ApplicationData.WindowHeight, this.logger);
        this.editorScene = new EditorScene(this.editorSceneGroup, this.logger.ApplicationData.WindowWidth, this.logger.ApplicationData.WindowHeight, this.logger);
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(this.logger.ApplicationData.WindowName);
        primaryStage.setResizable(false);
        primaryStage.setScene(this.loadScene);

        this.loadScene.QuizSceneButton.setOnMouseClicked(new EventHandler<MouseEvent>() { @Override public void handle(MouseEvent event) { primaryStage.setScene(quizScene); }});
        this.loadScene.EditorSceneButton.setOnMouseClicked(new EventHandler<MouseEvent>() { @Override public void handle(MouseEvent event) { primaryStage.setScene(editorScene); }});

        primaryStage.show();
    }
}