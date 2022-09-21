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

    private FXMLLoader loadFXMLLoader;
    private FXMLLoader quizFXMLLoader;
    private FXMLLoader kanjiBrowserFXMLLoader;
    private FXMLLoader kanjiEditorFXMLLoader;
    private FXMLLoader aboutFXMLLoader;

    private Scene loadScene;
    private Scene quizScene;
    private Scene kanjiBrowserScene;
    private Scene kanjiEditorScene;
    private Scene aboutScene;

    public Main() throws IOException {
        this.logger = new Logger();
        this.scheduler = new Scheduler(this.logger);

        this.loadFXMLLoader = new FXMLLoader(Main.class.getResource("Load.fxml"));
        this.quizFXMLLoader = new FXMLLoader(Main.class.getResource("Quiz.fxml"));
        this.kanjiBrowserFXMLLoader = new FXMLLoader(Main.class.getResource("KanjiBrowser.fxml"));
        this.kanjiEditorFXMLLoader = new FXMLLoader(Main.class.getResource("KanjiEditor.fxml"));
        this.aboutFXMLLoader = new FXMLLoader(Main.class.getResource("About.fxml"));

        this.loadScene = new Scene(this.loadFXMLLoader.load(), 800, 600);
        this.quizScene = new Scene(this.quizFXMLLoader.load(), 800, 600);
        this.kanjiBrowserScene = new Scene(this.kanjiBrowserFXMLLoader.load(), 800, 600);
        this.kanjiEditorScene = new Scene(this.kanjiEditorFXMLLoader.load(), 800, 600);
        this.aboutScene = new Scene(this.aboutFXMLLoader.load(), 800, 600);
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