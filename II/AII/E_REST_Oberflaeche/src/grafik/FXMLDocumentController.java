package grafik;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Eintrag;
import model.Patient;
import model.TaskEinsetzen;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jerem
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TitledPane uebersichtPane;
    @FXML
    public TableView<Patient> ueTabView1;
    @FXML
    public Label ueIDLab;
    @FXML
    public Label ueNachLab;
    @FXML
    public Label ueVorLab;
    @FXML
    public TableView<Eintrag> ueTabView2;
    @FXML
    public TitledPane patientPane;
    @FXML
    public TextField npVorTextField;
    @FXML
    private TextField npNachTextField;
    @FXML
    private Button npButton;
    @FXML
    private Label neLabID;
    @FXML
    private Label neLabVor;
    @FXML
    private Label neLabNach;
    @FXML
    private TextField neEintragTextField;
    @FXML
    private Button neButton;
    @FXML
    public TableColumn<Patient, Integer> ueIDColumn;
    @FXML
    public TableColumn<Patient, String> ueVorColumn;
    @FXML
    public TableColumn<Patient, String> ueNachColumn;
    @FXML
    public TableColumn<Eintrag, String> ueDateColumn;
    @FXML
    public TableColumn<Eintrag, String> ueEintragColumn;
    private Patient help;
    @FXML
    private AnchorPane neIDLabel;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ueIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        ueVorColumn.setCellValueFactory(new PropertyValueFactory<>("vorname"));
        ueNachColumn.setCellValueFactory(new PropertyValueFactory<>("nachname"));
        ueDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        ueEintragColumn.setCellValueFactory(new PropertyValueFactory<>("eintrag"));
        
        Thread t = new Thread(new TaskEinsetzen(this));
        t.start();
    }    



    @FXML
    private void handleTableClicked(MouseEvent event) {
        if(!ueTabView1.getSelectionModel().isEmpty()){
            help = ueTabView1.getSelectionModel().getSelectedItem();
            ObservableList<Eintrag> eintraege = FXCollections.observableList(help.getListe());
                        ueTabView2.getItems().clear();
                        ueTabView2.getItems().addAll(eintraege);
                        ueIDLab.setText(""+help.getiD());
                        ueNachLab.setText(""+ help.getNachname());
                        ueVorLab.setText(""+ help.getVorname());
        }
    }

    @FXML
    private void handleNPB(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/E_REST_Server/resources/patienten/newpatient/" + npVorTextField.getText() + "/" + npNachTextField.getText());
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        br.readLine();
        br.close();
        npNachTextField.clear();
        npVorTextField.clear();
        
    }

    @FXML
    private void handlePatientAccordion(MouseEvent event) {
        
    }

    @FXML
    private void handleNEButton(ActionEvent event) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/E_REST_Server/resources/patienten/newentry/" + help.getiD() + "/" + neEintragTextField.getText());
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        br.readLine();
        br.close();
        neEintragTextField.clear();
    }

    @FXML
    private void handleEintragAccordion(MouseEvent event) {
        neLabID.setText(""+ help.getiD());
        neLabNach.setText(help.getNachname());
        neLabVor.setText(help.getVorname());
    }

    
}
