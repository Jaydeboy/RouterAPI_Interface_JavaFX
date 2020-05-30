package main;

import javafx.application.Application;


public class Main{

    public static void main(String[] args) {
        Application.launch(MainWindow.class,args);
        new Controller(new MainWindow(), new Model());
    }

}
