package gui.scene;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

import util.Logger;
import util.object.AppData;
import util.object.Coordinate;

public class LoadScene extends Scene {

    private Group objectCollection;
    private Rectangle rect;

    private Coordinate eventCoordinate;
    private Coordinate targetCoordinate;
    private Coordinate offsetCoordinate;

    Logger logger;

    public LoadScene(Parent parent, double width, double height, Logger loggerObject, AppData objectCollection)
    {
        super(parent, width, height);

        this.logger = loggerObject;

        this.objectCollection = (Group) parent;
    }
}
