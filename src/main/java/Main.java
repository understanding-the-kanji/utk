import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

import gui.scenes.QuizScene;
import util.object.AppData;
import util.Logger;

public class Main extends Application
{
    private AppData applicationData;
    private Logger logger;

    private Group objectCollection;
    private QuizScene scene;

    public Main()
    {
        this.applicationData = new AppData();
        this.logger = new Logger("./log.txt");

        this.objectCollection = new Group();
        this.scene = new QuizScene(this.objectCollection, applicationData.WindowWidth, applicationData.WindowHeight, this.logger);
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(applicationData.WindowName);
        primaryStage.setResizable(false);
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}