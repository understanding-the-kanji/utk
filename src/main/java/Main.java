import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import util.Logger;

public class Main extends Application
{
    private final String windowTitle = "Understanding the Kanji";
    private final int windowWidth = 800;
    private final int windowHeight = 600;

    private Scene scene;
    private Group group;
    private Logger logger;

    private Rectangle rect;

    private double clickX;
    private double clickY;

    public Main()
    {
        this.group = new Group();
        this.scene = new Scene(this.group, windowWidth, windowHeight);

        this.logger = new Logger("./log.txt");

        this.rect = new Rectangle();

        this.clickX = 0.0d;
        this.clickY = 0.0d;
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle(windowTitle);

        this.rect.setStrokeWidth(2);
        this.rect.setFill(Color.RED);
        this.rect.setHeight(200);
        this.rect.setWidth(200);
        this.rect.setX(100);
        this.rect.setY(100);
        this.rect.toFront();

        this.group.getChildren().add(this.rect);

        this.group.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    System.out.println("Clicked Coordinates: " + event.getX() + ", " + event.getY());
                    clickX = event.getX();
                    clickY = event.getY();
                }
                catch(Exception ex)
                {
                    System.out.println("There was an error in getting the origin coordinates of the Rectangle object.");
                }
            }
        });

        this.group.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    System.out.println("Set Coordinates: " + event.getX() + ", " + event.getY());

                    clickX = event.getX();
                    clickY = event.getY();

                    Rectangle testRect = (Rectangle) event.getTarget();

                    testRect.setX(clickX);
                    testRect.setY(clickY);
                }
                catch(Exception ex)
                {
                    System.out.println("There was an error in setting the Rectangle's new coordinates.");
                }
            }
        });

        primaryStage.setResizable(false);
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}