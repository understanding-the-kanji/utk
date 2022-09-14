package net.samuelcmace.utk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import net.samuelcmace.utk.util.Logger;
import net.samuelcmace.utk.util.Scheduler;

import java.io.IOException;

public class Main extends Application {

    private Logger logger;
    private Scheduler scheduler;

    private FXMLLoader loadSceneLoader;
    private FXMLLoader quizSceneLoader;
    private FXMLLoader editorSceneLoader;

    private Scene loadScene;
    private Scene quizScene;
    private Scene editorScene;

    public Main() throws IOException {
        this.logger = new Logger();
        this.scheduler = new Scheduler(this.logger);

        this.loadSceneLoader = new FXMLLoader(Main.class.getResource("LoadScene.fxml"));
        this.quizSceneLoader = new FXMLLoader(Main.class.getResource("QuizScene.fxml"));
        this.editorSceneLoader = new FXMLLoader(Main.class.getResource("EditorScene.fxml"));

        this.loadScene = new Scene(this.loadSceneLoader.load(), 800, 600);
        this.quizScene = new Scene(this.quizSceneLoader.load(), 800, 600);
        this.editorScene = new Scene(this.editorSceneLoader.load(), 800, 600);
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Hello!");
        stage.setScene(this.loadScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}