/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuebung;

import buebung.FXMLDocumentController;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import cuebung.model.Article;
import java.util.ArrayList;

/**
 *
 * @author jerem
 */
public class Anwendung extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        stage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
                
            public void handle(WindowEvent event) {
                FXMLController fc = loader.getController();
                XMLEncoder xmle;
                try {
                    xmle = new XMLEncoder(new FileOutputStream("artikeldaten"));
                    xmle.writeObject(fc.artikeldaten);
                    xmle.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Anwendung.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
