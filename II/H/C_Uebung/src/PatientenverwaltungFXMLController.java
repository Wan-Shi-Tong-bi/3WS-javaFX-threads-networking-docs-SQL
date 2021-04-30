/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class PatientenverwaltungFXMLController implements Initializable {

    @FXML
    private TextField vorname;
    @FXML
    private TextField nachname;
    @FXML
    private ComboBox<String> religion;
    @FXML
    private Button save;
    Connection c;
    @FXML
    private Button getPatient;
    @FXML
    private Button saveChanges;
    @FXML
    private TextField id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            
            c = DriverManager.getConnection("jdbc:derby://localhost:1527/Patient", "Patient", "Patient");
            Statement f = c.createStatement();
            String temp = "Select konfession from Religion";
            ResultSet set = f.executeQuery(temp);

            while (set.next()) {
                religion.getItems().add(set.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PatientenverwaltungFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSaveClicked(ActionEvent event) {
        try {
            PreparedStatement pstmt = c.prepareStatement("insert into Patient values(?,?,?)");
            pstmt.setString(1, vorname.getText());
            pstmt.setString(2, nachname.getText());
            pstmt.setString(3, religion.getSelectionModel().getSelectedItem());
            int i = pstmt.executeUpdate();
            System.out.println(i + " records inserted");
        } catch (SQLException ex) {
            Logger.getLogger(PatientenverwaltungFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        vorname.setText("");
        nachname.setText("");
    }

    @FXML
    private void handleViewPatientsClicked(ActionEvent event) {
        try {
            Statement f = c.createStatement();
            String temp = "Select * from Patient";
            ResultSet set = f.executeQuery(temp);
            set.absolute(Integer.parseInt(id.getText()));
            vorname.setText(set.getString(1));
            nachname.setText(set.getString(2));
            religion.getSelectionModel().select(set.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(PatientenverwaltungFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSaveChangesClicked(ActionEvent event) throws SQLException {
        Statement f = c.createStatement();
            String temp = "Select * from Patient";
            ResultSet set = f.executeQuery(temp);
            set.absolute(Integer.parseInt(id.getText()));
            set.updateString(1, vorname.getText());
            set.updateString(2, nachname.getText());
            set.updateString(3, religion.getSelectionModel().getSelectedItem());
        vorname.setText("");
        nachname.setText("");
    }

}
