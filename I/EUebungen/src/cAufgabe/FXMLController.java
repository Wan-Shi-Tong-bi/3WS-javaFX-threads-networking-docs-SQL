/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cAufgabe;

import daten.Daten;
import daten.TermperaturDaten;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private TableView<TermperaturDaten> tableView;
    @FXML
    private TableColumn<TermperaturDaten, Integer> tcnummer;
    @FXML
    private TableColumn<TermperaturDaten, Integer> tcTemperatur;
    @FXML
    private LineChart<Integer, Integer> chart;
    @FXML
    private TextField tfNummer;
    @FXML
    private TextField tfTemperatur;
    @FXML
    private Button speichern;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tcnummer.setCellValueFactory(new PropertyValueFactory<TermperaturDaten, Integer>("id"));
        tcTemperatur.setCellValueFactory(new PropertyValueFactory<>("temperatur"));
        chart.setTitle("Temperaturaufzeichnung");
        
        XYChart.Series<Integer,Integer> s = new XYChart.Series();
        chart.getData().add(s);
    }

    @FXML
    private void handleSpeichernButton(MouseEvent event) {
        tableView.getItems().add(new TermperaturDaten(Integer.parseInt(tfNummer.getText()), Integer.parseInt(tfTemperatur.getText())));
        chart.getData().get(0).getData().add(new XYChart.Data(Integer.parseInt(tfNummer.getText()), Integer.parseInt(tfTemperatur.getText())));
    }

}
