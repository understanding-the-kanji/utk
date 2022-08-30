import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import util.Logger;
import util.object.Coordinate;

public class Main extends Application
{
    private final String windowTitle = "Understanding the Kanji";
    private final int windowWidth = 800;
    private final int windowHeight = 600;

    private Scene scene;
    private Group group;
    private Logger logger;

    private Rectangle rect;

    private Coordinate eventCoordinate;
    private Coordinate targetCoordinate;
    private Coordinate offsetCoordinate;

    public Main()
    {
        this.group = new Group();
        this.scene = new Scene(this.group, windowWidth, windowHeight);

        this.logger = new Logger("./log.txt");

        this.rect = new Rectangle();

        this.eventCoordinate = new Coordinate();
        this.targetCoordinate = new Coordinate();
        this.offsetCoordinate = new Coordinate();
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
                    eventCoordinate.SetCoordinate(event.getX(), event.getY());

                    try {
                        Rectangle clickedObject = (Rectangle) event.getTarget();
                        targetCoordinate.SetCoordinate(clickedObject.getX(), clickedObject.getY());

                        offsetCoordinate = Coordinate.CalculateCoordinateOffset(eventCoordinate, targetCoordinate);

                        clickedObject.setX(eventCoordinate.GetX() + offsetCoordinate.GetX());
                        clickedObject.setY(eventCoordinate.GetY() + offsetCoordinate.GetY());
                    } catch (Exception ex)
                    {
                        logger.ConsoleInformation("Error in Retrieving Rectangle Coordinates on Mouse Click");
                    }
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

                    eventCoordinate.SetCoordinate(event.getX(), event.getY());

                    try {
                        Rectangle testRect = (Rectangle) event.getTarget();
                        targetCoordinate.SetCoordinate(testRect.getX(), testRect.getY());
                    } catch (Exception e)
                    {
                        logger.ConsoleInformation("Error in Retrieving Rectangle Coordinates on Mouse Drag");
                    }

                    try {
                        Rectangle testRect = (Rectangle) event.getTarget();

                        testRect.setX(eventCoordinate.GetX() + offsetCoordinate.GetX());
                        testRect.setY(eventCoordinate.GetY() + offsetCoordinate.GetY());
                    } catch (Exception e)
                    {
                        logger.ConsoleInformation("Error in Setting New Rectangle Coordinates on Mouse Drag");
                    }
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