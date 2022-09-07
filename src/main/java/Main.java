import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

import gui.scene.LoadScene;
import gui.scene.QuizScene;
import gui.scene.EditorScene;

import util.Logger;

public class Main extends Application
{
    private Logger logger;

    private Group objectCollection;

    private LoadScene loadScene;
    private QuizScene quizScene;
    private EditorScene editorScene;

    public Main()
    {
        this.logger = new Logger();

        this.objectCollection = new Group();
        this.quizScene = new QuizScene(this.objectCollection, this.logger.ApplicationData.WindowWidth, this.logger.ApplicationData.WindowHeight, this.logger);
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(this.logger.ApplicationData.WindowName);
        primaryStage.setResizable(false);
        primaryStage.setScene(this.quizScene);
        primaryStage.show();
    }
}