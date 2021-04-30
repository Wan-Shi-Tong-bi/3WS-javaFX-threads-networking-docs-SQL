package aUebung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import aUebung.model.Artikel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
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
    private MenuItem anzeigeMenuebutton;
    @FXML
    private AnchorPane anchor;
    @FXML
    private ListView<Artikel> list;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Stage s = (Stage) anchor.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        Scene scene = new Scene(root);
        s.setScene(scene);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    public ListView<Artikel> getList() {
        return list;
    }

    public void setList(ListView<Artikel> list) {
        this.list = list;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }
    
    

    
}
