package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

    private Stage primaryStage;

    @Override
    public void start(Stage primarystage) throws Exception {
            this.primaryStage = primarystage;
            this.mainWindow();

    }
    public void  mainWindow() {

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("../view/MainWindowView.fxml"));
            AnchorPane pane = loader.load();

            MainController mainController = loader.getController();
            mainController.setController(this);

            Scene scene = new Scene(pane);

            scene.getStylesheets().add("/stylesheets/styles.css");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {
        launch(args);

    }

}

