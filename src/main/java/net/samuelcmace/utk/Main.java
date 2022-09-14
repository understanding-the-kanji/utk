package net.samuelcmace.utk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.samuelcmace.utk.util.Logger;
import net.samuelcmace.utk.util.Scheduler;

import java.io.IOException;

public class Main extends Application {

    private Logger logger;
    private Scheduler scheduler;

    public Main()
    {
        this.logger = new Logger();
        this.scheduler = new Scheduler(this.logger);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoadScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}