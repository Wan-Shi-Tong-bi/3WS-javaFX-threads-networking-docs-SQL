/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bUebung2;

import bUebung.*;
import bUebung.model.Kunde;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private AnchorPane anchor;
    @FXML
    private TextField vornameTextF;
    @FXML
    private TextField nachnameTextF;
    @FXML
    private TextField strasseTextF;
    @FXML
    private TextField plzTextF;
    @FXML
    private TextField nrTextF;
    @FXML
    private TextField ortTextF;
    @FXML
    private Button okButton;

    public TextField getVornameTextF() {
        return vornameTextF;
    }

    public void setVornameTextF(TextField vornameTextF) {
        this.vornameTextF = vornameTextF;
    }

    public TextField getNachnameTextF() {
        return nachnameTextF;
    }

    public void setNachnameTextF(TextField nachnameTextF) {
        this.nachnameTextF = nachnameTextF;
    }

    public TextField getStrasseTextF() {
        return strasseTextF;
    }

    public void setStrasseTextF(TextField strasseTextF) {
        this.strasseTextF = strasseTextF;
    }

    public TextField getPlzTextF() {
        return plzTextF;
    }

    public void setPlzTextF(TextField plzTextF) {
        this.plzTextF = plzTextF;
    }

    public TextField getNrTextF() {
        return nrTextF;
    }

    public void setNrTextF(TextField nrTextF) {
        this.nrTextF = nrTextF;
    }

    public TextField getOrtTextF() {
        return ortTextF;
    }

    public void setOrtTextF(TextField ortTextF) {
        this.ortTextF = ortTextF;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleOKClicked(MouseEvent event) throws IOException {
        Fenster2 stage = (Fenster2) anchor.getScene().getWindow();
        stage.hide();
        Fenster1 fenster1 = stage.firstWindow;
        fenster1.show(); 
        
        int i = fenster1.fdc.getHelp();
        switch(i){
            case 0:
                fenster1.fdc.tableView1.getItems().add(holen());
                break;
            case 1:
                Kunde k = fenster1.fdc.tableView1.getSelectionModel().getSelectedItem();
                k.setNachname(nachnameTextF.getText());
                k.setNr(Integer.parseInt(nrTextF.getText()));
                k.setVorname(vornameTextF.getText());
                k.setStrasse(strasseTextF.getText());
                k.setPlz(Integer.parseInt(plzTextF.getText()));
                k.setOrt(ortTextF.getText());
                k.setAdresse();
                k.setName();
                fenster1.fdc.tableView1.getItems().set(fenster1.fdc.tableView1.getSelectionModel().getSelectedIndex(), k);
                break;
        }
        
        
        
        
    }
    
    private Kunde holen(){
        Kunde k = new Kunde(
            vornameTextF.getText(),
            nachnameTextF.getText(),
            strasseTextF.getText(),
            Integer.parseInt(nrTextF.getText()),
            Integer.parseInt(plzTextF.getText()),
            ortTextF.getText()
            );
        return k;
    }
    
}
