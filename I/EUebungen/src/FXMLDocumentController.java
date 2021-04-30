/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import daten.Daten;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.StringConverter;
import org.omg.CORBA.TCKind;

/**
 *
 * @author jerem
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<Daten> table;
    @FXML
    private BarChart<String, Integer> diagram;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //einlesen Daten
        ArrayList<TableColumn> al = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("XXIV_gesundheitsausgaben.csv"));
            int i = 0;
            br.readLine();
            String line = br.readLine();

            while (line != null) {
                String[] arr = line.split(";");
                if (i == 0) {
                    TableColumn<Daten, String> current1Column = new TableColumn<>(arr[0]);
                    current1Column.setCellValueFactory(new PropertyValueFactory<Daten, String>("bezeichnung"));              
                    
                    table.getColumns().add(current1Column);
                    al.add(current1Column);
                    for (int e = 1; e < 5; e++) {
                        int help = e;
                        TableColumn<Daten, Integer> currentColumn = new TableColumn<>(arr[e]);
                        currentColumn.setCellValueFactory(new PropertyValueFactory<Daten, Integer>("jahr" + e));
                        table.getColumns().add(currentColumn);
                    }
                    i++;
                } else if (i != 0) {
                    table.getItems().add(new Daten(arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4])));
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @FXML
    private void handelMouseEvent(MouseEvent event) {
        diagram.getData().clear();

        if (!table.getSelectionModel().isEmpty()) {

            Daten d = table.getSelectionModel().getSelectedItem();
            diagram.setTitle(d.getBezeichnung());
            XYChart.Series<String, Integer> s = new XYChart.Series<>();
            ObservableList l = FXCollections.observableArrayList(
                    new XYChart.Data<String, Integer>(table.getColumns().get(1).getText(), d.getJahr1()),
                    new XYChart.Data<String, Integer>(table.getColumns().get(2).getText(), d.getJahr2()),
                    new XYChart.Data<String, Integer>(table.getColumns().get(3).getText(), d.getJahr3()),
                    new XYChart.Data<String, Integer>(table.getColumns().get(4).getText(), d.getJahr4())
            );
            s.setData(l);
            diagram.getData().add(s);
        }
    }

}
