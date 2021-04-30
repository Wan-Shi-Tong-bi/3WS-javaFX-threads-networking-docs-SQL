package bUebung2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bUebung.*;
import bUebung.model.Kunde;
import bUebung.model.Uebungen;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private TableView<Uebungen> tableView2;
    @FXML
    private ListView<Uebungen> listView;
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
    private int help;
    @FXML
    private Spinner<Integer> spinner;
    @FXML
    private TableColumn<Uebungen, Integer> anzahlColumn;
    @FXML
    private TableColumn<Uebungen, String> idColumn;

    public int getHelp() {
        return help;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tableView1
        tableView1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!tableView1.getSelectionModel().isEmpty()) {
                    tableView2.getItems().clear();
                    idColumn.setText("" + tableView1.getSelectionModel().getSelectedItem().getId());
                    if (!tableView1.getSelectionModel().getSelectedItem().getUebeungen().isEmpty()) {
                    tableView2.getItems().addAll(tableView1.getSelectionModel().getSelectedItem().getUebeungen());
                    
                    }
                }
                
            }
        });
        kundenNrColumn.setCellValueFactory(new PropertyValueFactory<Kunde, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Kunde, String>("name"));
        adresseColumn.setCellValueFactory(new PropertyValueFactory<Kunde, String>("adresse"));
        
        //tableView2
        anzahlColumn.setCellValueFactory(new PropertyValueFactory<Uebungen, Integer>("anz"));
        anzahlColumn.setStyle("-fx-alignment: CENTER;");
        idColumn.setCellValueFactory(new PropertyValueFactory<Uebungen, String>("url"));
        
        idColumn.setCellFactory(new Callback<TableColumn<Uebungen, String>, TableCell<Uebungen, String>>() {
            @Override
            public TableCell<Uebungen, String> call(TableColumn<Uebungen, String> param) {
              return new PictureCell();
            }
            });
        
        //listView
        ObservableList<Uebungen> ol = FXCollections.observableArrayList(new ArrayList<Uebungen>());
        ol.add(new Uebungen("abduktoren", "abduktoren.jpg"));
        ol.add(new Uebungen("bankdruecken", "bankdruecken.jpg"));
        ol.add(new Uebungen("bizepscurls", "bizepscurls.jpg"));
        ol.add(new Uebungen("kniebeugen", "kniebeugen.jpg"));
        listView.setItems(ol);
        listView.setCellFactory((param) -> {
            return new UebungenCell(); //To change body of generated lambdas, choose Tools | Templates.
        });
        
        //spinner
        SpinnerValueFactory svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 20);
        spinner.setValueFactory(svf);
    }

    @FXML
    private void handleNeueUebungAction(MouseEvent event) {
        if (!listView.getSelectionModel().isEmpty()) {
            Uebungen u = listView.getSelectionModel().getSelectedItem();
            u.setAnz(spinner.getValue());

            if (tableView1.getSelectionModel().isEmpty()) {
                System.out.println("Keine Person selektiert!");
            } else {
                Kunde k = tableView1.getSelectionModel().getSelectedItem();
                k.addUebeung(u);
                tableView1.getItems().set(tableView1.getSelectionModel().getSelectedIndex(), k);
                
                tableView2.getItems().clear();
                tableView2.getItems().addAll(tableView1.getSelectionModel().getSelectedItem().getUebeungen());

            }
        }
    }

    @FXML
    private void handleHinzufuegenAction(MouseEvent event) throws IOException {
        Fenster1 stage = (Fenster1) anchor.getScene().getWindow();
        stage.hide();
        Fenster2 fenster2 = stage.secondWindow;
        fenster2.fdc.getNachnameTextF().clear();
        fenster2.fdc.getNrTextF().clear();
        fenster2.fdc.getOrtTextF().clear();
        fenster2.fdc.getPlzTextF().clear();
        fenster2.fdc.getStrasseTextF().clear();
        fenster2.fdc.getVornameTextF().clear();
        fenster2.show();
        help = 0;
    }

    @FXML
    private void handleAendernAction(MouseEvent event) throws IOException {
        Fenster1 stage = (Fenster1) anchor.getScene().getWindow();
        stage.hide();
        Fenster2 fenster2 = stage.secondWindow;
        Kunde k = tableView1.getSelectionModel().getSelectedItem();
        fenster2.fdc.getNachnameTextF().setText(k.getNachname());
        fenster2.fdc.getNrTextF().setText("" + k.getNr());
        fenster2.fdc.getOrtTextF().setText(k.getOrt());
        fenster2.fdc.getPlzTextF().setText("" + k.getPlz());
        fenster2.fdc.getStrasseTextF().setText(k.getStrasse());
        fenster2.fdc.getVornameTextF().setText(k.getVorname());
        fenster2.show();
        help = 1;
    }

    @FXML
    private void handleLoeschenAction(MouseEvent event) {
        tableView1.getItems().remove(tableView1.getSelectionModel().getSelectedItem());
        tableView2.getItems().clear();
    }
}
