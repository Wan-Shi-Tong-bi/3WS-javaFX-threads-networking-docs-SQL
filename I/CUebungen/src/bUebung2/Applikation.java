package bUebung2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bUebung.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jerem
 */
public class Applikation extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Fenster1 window1 = new Fenster1();
        Fenster2 window2 = new Fenster2();
        window1.secondWindow = window2;
        window2.firstWindow = window1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
