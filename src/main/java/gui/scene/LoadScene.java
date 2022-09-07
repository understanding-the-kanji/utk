package gui.scene;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

import util.Logger;
import util.object.Coordinate;

public class LoadScene extends Scene {

    private Logger logger;
    private Rectangle rect;

    private Coordinate eventCoordinate;
    private Coordinate targetCoordinate;
    private Coordinate offsetCoordinate;

    private QuizScene quizScene;
    private EditorScene editorScene;

    public LoadScene(Parent parent, double width, double height, Logger m_logger)
    {
        super(parent, width, height);
        this.logger = m_logger;

        this.quizScene = new QuizScene(parent, this.logger.ApplicationData.WindowWidth, this.logger.ApplicationData.WindowHeight, this.logger);
    }
}
