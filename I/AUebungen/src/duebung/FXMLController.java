/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duebung;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import cuebung.model.Article;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private TextField textfield1;
    @FXML
    private PasswordField passwordfield1;
    @FXML
    private Spinner<Double> spinner1;
    @FXML
    private Spinner<Article> spinner2;
    @FXML
    private Button knopf;
    @FXML
    private TextArea textArea1;
    @FXML
    private Button button2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory svf = new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 30, 10, 0.1);
        spinner1.setValueFactory(svf);
        
        ArrayList<Article> al = new ArrayList<>();
        al.add(new Article("Franz", "Kruege"));
        al.add(new Article("Hans", "Polster"));
        ObservableList<Article> ol = FXCollections.observableArrayList(al);
        svf = new SpinnerValueFactory.ListSpinnerValueFactory(ol);
        spinner2.setValueFactory(svf);
        spinner2.getValueFactory().setValue(new Article("ja", "nein"));
    }    

    @FXML
    private void handleLabel1ChangeValue(MouseEvent event) {
        System.out.println("" + label1.getText());
        label1.setText("Franz");
    }

    @FXML
    private void handleTextFieldMouseExited(MouseEvent event) {
        System.out.println("" + textfield1.getText());
        textfield1.setText("Susi");
    }

    @FXML
    private void handleButtonPressed(ActionEvent event) {
        System.out.println("gedrueckt");
    }

    @FXML
    private void handleButton2(ActionEvent event) {
        System.out.println("" + textArea1.getText());
        System.out.println("" + textArea1.getSelectedText());
        textArea1.setText("ersetzt");
    }
    
}
