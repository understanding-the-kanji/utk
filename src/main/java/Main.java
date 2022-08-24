import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import util.MessageDialog;
import util.Logger;

public class Main extends Application
{
    private final String windowTitle = "Hello World";
    private final int windowWidth = 600;
    private final int windowHeight = 400;

    private Scene scene;
    private StackPane layout;
    private Button button;

    private Logger logger;

    public Main()
    {
        this.button = new Button();
        this.layout = new StackPane();
        this.scene = new Scene(this.layout, 300, 250);

        this.logger = new Logger("./log.txt");
    }

    public static void main(String args[]) { launch(args); }

    @Override public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("The Stage of the JavaFX Application");

        this.button = new Button();
        this.button.setText("The Button's Text");

        this.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                logger.Information("Hey There! Thanks for Clicking on Me.");
            }
        });

        this.layout.getChildren().add(this.button);

        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}