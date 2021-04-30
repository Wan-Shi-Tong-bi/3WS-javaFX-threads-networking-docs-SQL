/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buebung;

import buebung.model.Geschlecht;
import buebung.model.Person;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author jerem
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField nameField;
    @FXML
    private TextField vornameField;
    @FXML
    private TextArea anschriftField;
    @FXML
    private Button okButton;
    @FXML
    private Spinner<Geschlecht> spinner;
    @FXML
    private AnchorPane anchor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<Geschlecht> ol = FXCollections.observableArrayList(Geschlecht.values());
        SpinnerValueFactory svf = new SpinnerValueFactory.ListSpinnerValueFactory(ol);
        spinner.setValueFactory(svf);
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) {
        Person p = new Person(nameField.getText(), vornameField.getText(), anschriftField.getText(), spinner.getValue());
        try {
            XMLEncoder xmle = new XMLEncoder(new FileOutputStream("person"));
            xmle.writeObject(p);
            xmle.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage s = (Stage) anchor.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
            Scene scene = new Scene(root);
            s.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
