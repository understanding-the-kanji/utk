import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application
{
    private final String windowTitle = "Hello World";
    private final int windowWidth = 600;
    private final int windowHeight = 400;

    private Scene scene;
    private StackPane layout;
    private Button button;

    public Main()
    {
        this.button = new Button();
        this.layout = new StackPane();
        this.scene = new Scene(this.layout, 300, 250);
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
                MessageDialog.ShowInfoDialog("Hey There! Thanks for Clicking on Me.");
            }
        });

        this.layout.getChildren().add(this.button);

        primaryStage.setScene(this.scene);
        primaryStage.show();
    }
}