import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import util.Logger;

public class Main extends Application
{
    private final String windowTitle = "Understanding the Kanji";
    private final int windowWidth = 800;
    private final int windowHeight = 600;

    private Scene scene;
    private Group group;
    private Canvas canvas;
    private GraphicsContext canvasContext;
    private Logger logger;

    public Main()
    {
        this.group = new Group();
        this.scene = new Scene(this.group, windowWidth, windowHeight);
        this.canvas = new Canvas(windowWidth, windowHeight);

        this.logger = new Logger("./log.txt");
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(windowTitle);

        this.canvasContext = this.canvas.getGraphicsContext2D();

        this.canvasContext.setFill(Color.RED);
        this.canvasContext.fillRect(100, 100, 200, 200);

        this.group.getChildren().add(this.canvas);

        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}