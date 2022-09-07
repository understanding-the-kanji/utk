import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;

import gui.scene.LoadScene;

import util.Logger;
import util.Scheduler;

public class Main extends Application
{
    private Logger logger;
    private Scheduler scheduler;

    private Group objectCollection;

    private LoadScene loadScene;

    public Main()
    {
        this.logger = new Logger();
        this.scheduler = new Scheduler(this.logger);

        this.objectCollection = new Group();
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(this.logger.ApplicationData.WindowName);
        primaryStage.setResizable(false);
        primaryStage.setScene(this.loadScene);
        primaryStage.show();
    }
}