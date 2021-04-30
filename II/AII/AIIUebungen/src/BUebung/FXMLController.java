/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUebung;

import BUebung.akkteure.Arzt;
import BUebung.akkteure.Empfangsdame;
import BUebung.akkteure.EnumArzt;
import BUebung.akkteure.EnumEmpfangsdame;
import BUebung.akkteure.Patient;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private ListView<Patient> listArzt1;
    @FXML
    private ListView<Patient> listArzt2;
    @FXML
    private Label labelArzt1;
    @FXML
    private Label labelArzt2;
    @FXML
    private Label labelEm1;
    @FXML
    private Label labelEm2;
    @FXML
    private Label labelEm3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Empfangsdame e1 = new Empfangsdame(EnumEmpfangsdame.Empfangsdame1, this);
        labelEm1.textProperty().bind(Bindings.concat("", e1.messageProperty()));
        Empfangsdame e2 = new Empfangsdame(EnumEmpfangsdame.Empfangsdame2, this);
        labelEm2.textProperty().bind(Bindings.concat("", e2.messageProperty()));
        Empfangsdame e3 = new Empfangsdame(EnumEmpfangsdame.Empfangsdame3, this);
        labelEm3.textProperty().bind(Bindings.concat("", e3.messageProperty()));
        
        Arzt a1 = new Arzt(EnumArzt.Allgemeinmediziner, this);
        labelArzt1.textProperty().bind(Bindings.concat("", a1.messageProperty()));
        Arzt a2 = new Arzt(EnumArzt.Facharzt, this);
        labelArzt2.textProperty().bind(Bindings.concat("", a2.messageProperty()));
        Thread t1 = new Thread(e1);
        Thread t2 = new Thread(e2);
        Thread t3 = new Thread(e3);
        Thread t4 = new Thread(a1);
        Thread t5 = new Thread(a2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }    

    public ListView<Patient> getListArzt1() {
        return listArzt1;
    }

    public void setListArzt1(ListView<Patient> listArzt1) {
        this.listArzt1 = listArzt1;
    }

    public ListView<Patient> getListArzt2() {
        return listArzt2;
    }

    public void setListArzt2(ListView<Patient> listArzt2) {
        this.listArzt2 = listArzt2;
    }

    public Label getLabelArzt1() {
        return labelArzt1;
    }

    public void setLabelArzt1(Label labelArzt1) {
        this.labelArzt1 = labelArzt1;
    }

    public Label getLabelArzt2() {
        return labelArzt2;
    }

    public void setLabelArzt2(Label labelArzt2) {
        this.labelArzt2 = labelArzt2;
    }

    public Label getLabelEm1() {
        return labelEm1;
    }

    public void setLabelEm1(Label labelEm1) {
        this.labelEm1 = labelEm1;
    }

    public Label getLabelEm2() {
        return labelEm2;
    }

    public void setLabelEm2(Label labelEm2) {
        this.labelEm2 = labelEm2;
    }

    public Label getLabelEm3() {
        return labelEm3;
    }

    public void setLabelEm3(Label labelEm3) {
        this.labelEm3 = labelEm3;
    }
    
    
    
}
