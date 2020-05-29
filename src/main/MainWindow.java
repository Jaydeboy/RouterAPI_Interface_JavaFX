package main;

import hearingOffice.Hearing_Office;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainWindow extends Application {

   private  TableView tableView;
   private TableColumn<String, Hearing_Office> column1;
   private TableColumn<String, Hearing_Office> column2;
   private TableColumn<String, Hearing_Office> column3;
   private Stage primaryStage;


    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;

        stage.setTitle("Social Security Hearing Office");
        stage.setWidth(550);
        stage.setHeight(400);

        tableView = new TableView();
        tableView.setMaxWidth(550);

        column1 = new TableColumn<>("Region");
        column1.setCellValueFactory(new PropertyValueFactory<>("region"));
        column1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.11));

        column2 = new TableColumn<>("Hearing Office");
        column2.setCellValueFactory(new PropertyValueFactory<>("hearingOffice"));
        column2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));

        column3 = new TableColumn<>("Processing time");
        column3.setCellValueFactory(new PropertyValueFactory<>("processingTime"));
        column3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));



        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);
        tableView.getColumns().add(column3);

        VBox vBox = new VBox(tableView);

        Scene scene = new Scene(vBox);

        stage.setScene(scene);

        stage.show();




    }
}
