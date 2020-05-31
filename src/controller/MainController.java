package controller;


import model.HearingList;
import model.Hearing_Office;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Serialization;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MainController {

        private Main main;
        private HearingList hearingList;


        @FXML private TableView<Hearing_Office> tableView;
        @FXML private TableColumn<Hearing_Office,String> officeNameColumn;
        @FXML private TableColumn<Hearing_Office,String>  ho_codeColumn;
        @FXML private TableColumn<Hearing_Office,String>  regionColumn;
        @FXML private TableColumn<Hearing_Office,String>  averageWaitTimeColumn;

        public void initialize(){
                officeNameColumn.setCellValueFactory(new PropertyValueFactory<Hearing_Office,String>("hearingOfficeName"));
                ho_codeColumn.setCellValueFactory(new PropertyValueFactory<Hearing_Office,String>("ho_Code"));
                regionColumn.setCellValueFactory(new PropertyValueFactory<Hearing_Office,String>("region"));
                averageWaitTimeColumn.setCellValueFactory(new PropertyValueFactory<Hearing_Office,String>("processingTime"));
        }
        public void setController(Main mainWindow){
            this.main=mainWindow;
            this.hearingList = new HearingList();
            this.SetTableData();
            this.tableView.setItems(hearingList.getHearingOfficeList());
        }
        public void SetTableData(){

            try {
                hearingList.addOffice(Serialization.getHearingOfficeList());
            } catch (IOException | ParserConfigurationException| SAXException e) {
                e.printStackTrace();
            }
        }


}
