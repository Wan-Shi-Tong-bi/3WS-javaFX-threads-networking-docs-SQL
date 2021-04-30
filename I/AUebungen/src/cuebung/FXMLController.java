/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuebung;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import cuebung.model.Article;
import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {
    
    public ArrayList<Article> artikeldaten;
    @FXML
    private TextField herstellerField;
    @FXML
    private TextField bezeichnungField;
    @FXML
    private Button buttonSpeichern;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        artikeldaten = new ArrayList<>();
    }    

    @FXML
    private void buttonClicked(MouseEvent event) {
        Article art = new Article(herstellerField.getText(), bezeichnungField.getText());
        artikeldaten.add(art);
    }
    
    public ArrayList<Article> getArtikeldaten(){
        return artikeldaten;
    }
    
    
    
}
