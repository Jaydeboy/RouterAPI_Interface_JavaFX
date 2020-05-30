package main;


import hearingOffice.HearingList;
import hearingOffice.Hearing_Office;
import hearingOffice.Serialization;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class MainWindow extends Application {


    private TableColumn<String, Hearing_Office> column1;
    private TableColumn<String, Hearing_Office> column2;
    private TableColumn<String, Hearing_Office> column3;


   public void init() throws ParserConfigurationException, SAXException, IOException, URISyntaxException {
       try {
           Serialization.Hearing_wait_Time_XML_To_Object();
       } catch (IOException e) {
           e.printStackTrace();
       } catch (ParserConfigurationException e) {
           e.printStackTrace();
       } catch (SAXException e) {
           e.printStackTrace();
       }

   }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Social Security Hearing Office");
        stage.setWidth(600);
        stage.setHeight(600);

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root,400,400);

        TableView<Hearing_Office> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        TableColumn<Hearing_Office,String> ho_code = new TableColumn<>("HO Code");
        ho_code.setCellValueFactory(new PropertyValueFactory<>("ho_Code"));


        TableColumn<Hearing_Office,String> hearingOfficeName = new TableColumn<>("Hearing Office");
        hearingOfficeName.setCellValueFactory(new PropertyValueFactory<>("hearingOfficeName"));

        TableColumn<Hearing_Office,String> processingTime = new TableColumn<>("Processing Time");
        processingTime.setCellValueFactory(new PropertyValueFactory<>("processingTime"));



        table.getColumns().addAll(ho_code,hearingOfficeName,processingTime);


        ObservableList<Hearing_Office> data = FXCollections.observableArrayList();
        data.addAll(HearingList.hearingOfficeList.values());
        table.setItems(data);

        root.setCenter(table);
        scene.getStylesheets().add("stylesheets/styles.css");
        stage.setScene(scene);
        stage.show();

    }

}
