/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author jerem
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    public TreeView<String> treeView;
    @FXML
    private Button butLoeschen;
    @FXML
    private Button butAendern;
    @FXML
    private TextField textFieldSpeichern;
    @FXML
    private Button butSpeichern;
    @FXML
    private TextArea textArea;
    private String area;
    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TreeItem<String> root = new TreeItem<>("Baum");
        treeView.setEditable(true);
        treeView.setRoot(root);
        inTextAreaSchreiben();
    }    

    @FXML
    private void handleLoeschenAction(MouseEvent event) {
         if(treeView.getSelectionModel().getSelectedItem() != null && !treeView.getSelectionModel().getSelectedItem().equals(treeView.getRoot())){
             TreeItem parent = treeView.getSelectionModel().getSelectedItem().getParent();
             TreeItem child = treeView.getSelectionModel().getSelectedItem();
             parent.getChildren().remove(child);
         }
         inTextAreaSchreiben();
    }

    @FXML
    private void handleAendernAction(MouseEvent event) throws IOException {
        //eigentlich nicht mit JOptionPane, aber ist so einfacher :)
//        String text = JOptionPane.showInputDialog("Eingabe");

        Fenster1 stage = (Fenster1) anchor.getScene().getWindow();
        stage.hide();
        Fenster2 fenster2 = stage.window2;
        fenster2.show();
        
        
    }

    @FXML
    private void handleSpeichernAction(MouseEvent event) {
        TreeItem<String> t = new TreeItem<>(textFieldSpeichern.getText());
        if(treeView.getSelectionModel().getSelectedItem() == null){
            treeView.getRoot().getChildren().add(t);
        }else{
            treeView.getSelectionModel().getSelectedItem().getChildren().add(t);
        }
        inTextAreaSchreiben();
    }
    
    public void inTextAreaSchreiben(){
        TreeItem root = treeView.getRoot();
        area = "" + root.getValue()+ "\n";
        rekursion(root, 1);
        textArea.setText(area);
    }
    
    private int rekursion(TreeItem<String> t, int help){
        for(int i = 0; i < t.getChildren().size(); i++){
            int temp = 0;
            while(temp < help){
            area = area + "\t";
            temp ++;
            }
            area = area + t.getChildren().get(i).getValue() +"\n";
            
            if(!t.getChildren().get(i).isLeaf()){
                help++;
                help = rekursion(t.getChildren().get(i), help) - 1;
            }
        }
          return help;  
    }
}
