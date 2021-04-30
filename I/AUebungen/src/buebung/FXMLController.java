/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buebung;

import buebung.model.Person;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private Label lname;
    @FXML
    private Label lvorname;
    @FXML
    private Label lAnschrift;
    @FXML
    private Label lGeschlecht;
    @FXML
    private Button zurueckButton;
    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Person p = new Person();
        try {
            XMLDecoder xmld = new XMLDecoder(new FileInputStream("person"));
            p = (Person) xmld.readObject();
            xmld.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lname.setText(p.getName());
        lvorname.setText(p.getVorname());
        String[] arr =  p.getAnschrift().split("\n");
        if(arr.length > 1){
            String zeile = "";
            for(String s : arr){
                if(s.equals(arr[arr.length-1])){
                    zeile += s;  
                }else{
                    zeile += s + " - ";  
                }
            }
            lAnschrift.setText(zeile);
        }else{
            lAnschrift.setText(p.getAnschrift());
        }
        lGeschlecht.setText(p.getGeschlecht().toString());
        
    }    

    @FXML
    private void handleMouseClicked(MouseEvent event) {
        try {
            Stage s = (Stage) anchor.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            s.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
