package gui.scene;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import util.Logger;
import util.object.Coordinate;

import gui.object.Radical;

public class QuizScene extends Scene {

    private Group objectCollection;
    private Radical rect;

    private Coordinate eventCoordinate;
    private Coordinate targetCoordinate;
    private Coordinate offsetCoordinate;

    Logger logger;

    public QuizScene(Parent parent, double width, double height, Logger loggerObject)
    {
        super(parent, width, height);

        this.logger = loggerObject;

        this.objectCollection = (Group) parent;
        this.rect = new Radical();

        this.eventCoordinate = new Coordinate();
        this.targetCoordinate = new Coordinate();
        this.offsetCoordinate = new Coordinate();
        this.rect.setStrokeWidth(2);
        this.rect.setFill(Color.RED);
        this.rect.setHeight(200);
        this.rect.setWidth(200);
        this.rect.setX(100);
        this.rect.setY(100);
        this.rect.toFront();

        this.objectCollection.getChildren().add(this.rect);

        this.objectCollection.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    System.out.println("Clicked Coordinates: " + event.getX() + ", " + event.getY());
                    eventCoordinate.SetCoordinate(event.getX(), event.getY());

                    try {
                        Radical clickedObject = (Radical) event.getTarget();
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

        this.objectCollection.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    System.out.println("Set Coordinates: " + event.getX() + ", " + event.getY());

                    eventCoordinate.SetCoordinate(event.getX(), event.getY());

                    try {
                        Radical testRect = (Radical) event.getTarget();
                        targetCoordinate.SetCoordinate(testRect.getX(), testRect.getY());
                    } catch (Exception e)
                    {
                        logger.ConsoleInformation("Error in Retrieving Rectangle Coordinates on Mouse Drag");
                    }

                    try {
                        Radical testRect = (Radical) event.getTarget();

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
    }
}
