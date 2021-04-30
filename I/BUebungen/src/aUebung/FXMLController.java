package aUebung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aUebung.model.Artikel;
import java.awt.Color;
import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField herstellerTextField;
    @FXML
    private Button anzeigenButton;
    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleMouseClicked(MouseEvent event) throws IOException {
        //Reihenfolge hier wichtig
        //Wenn man hier nicht alles bedenkt, kann es sein,
        //dass man eine falsche Scene setzt... nicht die gewollte
        
        Stage s = (Stage) anchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
        
        FXMLDocumentController fdc = loader.getController();
        ArrayList<Artikel> al = suchen();
        if(al.isEmpty()){
            fdc.getLabel().setText("Vom Hersteller " + herstellerTextField.getText() + " exestieren keine Artikel!");
            fdc.getLabel().setStyle("-fx-text-fill: red;");
        }else{
            fdc.getLabel().setText("");
            ObservableList<Artikel> ol = FXCollections.observableArrayList(al);
            fdc.getList().setItems(ol);
        }
        
    }
    
    
    private ArrayList<Artikel> suchen() throws IOException{

        ArrayList<Artikel> al = new ArrayList<>();
        try {
            XMLDecoder xmld = new XMLDecoder(new FileInputStream("ArtikelListe"));
            al = (ArrayList<Artikel>) xmld.readObject();
            xmld.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Artikel> al2 = new ArrayList<>();
        for(Artikel art : al){
            if(art.getHersteller().equals(herstellerTextField.getText())){
                    al2.add(art);
            }
        }
        return al2;

    }
    
    
    
}
