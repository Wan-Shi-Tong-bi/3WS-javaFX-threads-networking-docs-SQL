/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bUebung;

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
    public static ArrayList<Kunde> arr = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void handleOKClicked(MouseEvent event) throws IOException {
        Stage s = (Stage) anchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
        
        FXMLDocumentController fdc = loader.getController();
        arr.add(holen());
        fdc.tableView1.getItems().clear();
        ObservableList<Kunde> kunden = FXCollections.observableArrayList(arr);
        fdc.tableView1.setItems(kunden);       
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
