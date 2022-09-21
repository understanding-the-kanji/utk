package net.samuelcmace.utk.gui.controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import net.samuelcmace.utk.gui.object.Radical;
import net.samuelcmace.utk.util.Logger;
import net.samuelcmace.utk.util.MessageDialog;
import net.samuelcmace.utk.util.object.Coordinate;

public class QuizController {

    Logger logger;

    @FXML
    private Group objectCollection;
    private Radical rect;

    private Coordinate eventCoordinate;
    private Coordinate targetCoordinate;
    private Coordinate offsetCoordinate;

    public QuizController() {
        this.objectCollection = new Group();
        this.logger = new Logger();
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
                    } catch (Exception ex) {
                        MessageDialog.ShowInfoDialog("Error in Retrieving Rectangle Coordinates on Mouse Click");
                    }
                } catch (Exception ex) {
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
                    } catch (Exception e) {
                        MessageDialog.ShowInfoDialog("Error in Retrieving Rectangle Coordinates on Mouse Drag");
                    }

                    try {
                        Radical testRect = (Radical) event.getTarget();

                        testRect.setX(eventCoordinate.GetX() + offsetCoordinate.GetX());
                        testRect.setY(eventCoordinate.GetY() + offsetCoordinate.GetY());
                    } catch (Exception e) {
                        MessageDialog.ShowInfoDialog("Error in Setting New Rectangle Coordinates on Mouse Drag");
                    }
                } catch (Exception ex) {
                    System.out.println("There was an error in setting the Rectangle's new coordinates.");
                }
            }
        });
    }
}