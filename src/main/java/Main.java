import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

import gui.QuizScene;
import util.Logger;

public class Main extends Application
{
    private Group objectCollection;

    private final String windowTitle = "Understanding the Kanji";
    private final int windowWidth = 800;
    private final int windowHeight = 600;

    private QuizScene scene;
    private Logger logger;

    public Main()
    {
        this.logger = new Logger("./log.txt");
        this.objectCollection = new Group();
        this.scene = new QuizScene(this.objectCollection, windowWidth, windowHeight, this.logger);
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(windowTitle);
        primaryStage.setResizable(false);
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}