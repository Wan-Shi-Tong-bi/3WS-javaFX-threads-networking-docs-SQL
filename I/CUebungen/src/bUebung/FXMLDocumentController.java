package bUebung;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bUebung.model.Kunde;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public TableView<Kunde> tableView1;
    @FXML
    public TableColumn<Kunde, Integer> kundenNrColumn;
    @FXML
    public TableColumn<Kunde, String> nameColumn;
    @FXML
    public TableColumn<Kunde, String> adresseColumn;
    @FXML
    private TableView<?> tableView2;
    @FXML
    private ListView<?> listView;
    @FXML
    private Button neueUebungButton;
    @FXML
    private Button hinzufuegenButton;
    @FXML
    private Button aendernButton;
    @FXML
    private Button loeschenButton;
    @FXML
    private AnchorPane anchor;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        kundenNrColumn.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Kunde, String>("name"));
        adresseColumn.setCellValueFactory(new PropertyValueFactory<Kunde, String>("adresse"));
    }    

    @FXML
    private void handleNeueUebungAction(MouseEvent event) {
    }

    @FXML
    private void handleHinzufuegenAction(MouseEvent event) throws IOException {
        Stage s = (Stage) anchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
    }

    @FXML
    private void handleAendernAction(MouseEvent event) throws IOException {
        Stage s = (Stage) anchor.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        s.setScene(scene);
        FXMLController fc = loader.getController();
        
    }

    @FXML
    private void handleLoeschenAction(MouseEvent event) {
    }
    
}
