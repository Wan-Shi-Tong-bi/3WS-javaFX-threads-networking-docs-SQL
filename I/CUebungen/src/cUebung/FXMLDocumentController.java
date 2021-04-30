/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cUebung;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 *
 * @author bambl
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player, String> vornameC;
    @FXML
    private TableColumn<?, ?> nachnameC;
    @FXML
    private TableColumn<Player, Integer> ToreC;
    @FXML
    private TextField fieldVorname;
    @FXML
    private TextField fieldTore;
    @FXML
    private TextField fieldNachname;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ObservableList<Player> players = FXCollections.observableArrayList(
                new Player("Manuel", "Neuer", 0),
                new Player("Philipp", "Lahm", 1),
                new Player("Mats", "Hummels", 2),
                new Player("Jerome", "Boateng", 5),
                new Player("Benedikt", "Howedes", 0)
        );
        table.setItems(players);

        vornameC.setCellValueFactory(
                new PropertyValueFactory<Player, String>("firstName"));

        TableColumn<Player, Integer> neueSpalte = new TableColumn<Player, Integer>("Nummer in Liste");
        table.getColumns().add(neueSpalte);
        neueSpalte.setCellValueFactory(new PropertyValueFactory<Player, Integer>("goals"));

        ToreC.setCellValueFactory(
                new PropertyValueFactory<Player, Integer>("goals"));

        ToreC.setCellFactory(new Callback<TableColumn<Player, Integer>, TableCell<Player, Integer>>() {
            @Override
            public TableCell<Player, Integer> call(TableColumn<Player, Integer> param) {
                try {
                    return new GoalsCell();

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }
        });

        table.setEditable(true);
        vornameC.setCellFactory(TextFieldTableCell.forTableColumn());
        vornameC.setOnEditCommit(new EventHandler<CellEditEvent<Player, String>>() {
            @Override
            public void handle(CellEditEvent<Player, String> t) {
                ((Player) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())).setFirstName(t.getNewValue());
            }
        });

    }

    @FXML
    private void zeileHinzu(ActionEvent event) {
        String firstName = fieldVorname.getText();
        String lastName = fieldNachname.getText();
        int anzahlTore = Integer.parseInt(fieldTore.getText());
        Player p = new Player(firstName, lastName, anzahlTore);
        table.getItems().add(p);
    }

    @FXML
    private void zeileLoeschen(ActionEvent event) {
        Player p = table.getSelectionModel().getSelectedItem();

        System.out.println("Element " + p + " wird geloescht");
        table.getItems().remove(p);
    }

    @FXML
    private void handleClickTableTest(MouseEvent event) {
        System.out.println("--- " + table.getSelectionModel().getSelectedItem());
    }

}
