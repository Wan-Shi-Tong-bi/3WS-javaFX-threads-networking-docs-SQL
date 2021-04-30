/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private TextField eingabeLabel;
    public static String text;
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
    private void handelOKClicked(MouseEvent event) throws IOException {
        text = eingabeLabel.getText();
        Fenster2 stage = (Fenster2) anchor.getScene().getWindow();
        stage.hide();
        Fenster1 fenster1 = stage.window1;
        
                if(fenster1.fdc.treeView.getSelectionModel().getSelectedItem() != null){
             fenster1.fdc.treeView.getSelectionModel().getSelectedItem().setValue(FXMLController.text);
         }
        fenster1.fdc.inTextAreaSchreiben();
        
        fenster1.show();
    }
    
}
