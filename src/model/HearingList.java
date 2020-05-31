package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Hearing_Office;

import java.io.InputStream;
import java.util.List;


public class HearingList {

    private ObservableList<Hearing_Office> hearingOfficeList = FXCollections.observableArrayList();


    public void addOffice(Hearing_Office office){
        hearingOfficeList.add(office);
    }
    public boolean addOffice(List<Hearing_Office> offices){

       return hearingOfficeList.addAll(offices);
    }

    public  ObservableList<Hearing_Office> getHearingOfficeList() {
        return hearingOfficeList;
    }
}