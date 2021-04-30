/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author jerem
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private LineChart<Integer, Integer> linechart;
    @FXML
    private NumberAxis xAxis;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Einstellungen
        linechart.setTitle("Pulsaufzeichnung");
        XYChart.Series series = new XYChart.Series();
        series.setName("Aufzeichnung 1");
        series.getData().add(new XYChart.Data(0,0));
        
        ObservableList<XYChart.Series<Integer, Integer>> ol = FXCollections.observableArrayList();
        ol.add(series);
        linechart.setData(ol);
        

    }    

    public LineChart<Integer, Integer> getLinechart() {
        return linechart;
    }

    public void setLinechart(LineChart<Integer, Integer> linechart) {
        this.linechart = linechart;
    }

    @FXML
    private void handleStartButtonClicked(MouseEvent event) {
        //aktualisieren
        CustomTask ct = new CustomTask(this);
        Thread t = new Thread(ct);
        t.start();
    }
    
}
