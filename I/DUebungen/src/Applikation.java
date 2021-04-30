/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Fenster1 fenster1 = new Fenster1();
        Fenster2 fenster2 = new Fenster2();
        fenster1.window2 = fenster2;
        fenster2.window1 = fenster1;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
