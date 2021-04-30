/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folien;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private TreeView<String> tree1;
    @FXML
    private TreeView<Person> tree2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Eins
        TreeItem<String> t = new TreeItem<>("Personen");
        TreeItem<String> t1 = new TreeItem<>("Sepp");
        TreeItem<String> t2 = null;
        try {
            t2 = new TreeItem<>("Gina", new ImageView(new Image(new FileInputStream("oldPhoto.jpg"))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        t.getChildren().addAll(t1,t2);
        tree1.setRoot(t);
        
        //Zwei
        TreeItem<Person> t20 = new TreeItem<Person>(null);
        TreeItem<Person> t2r = new TreeItem<>(new Person("Hewig", "Mayr", "Dame1.PNG"));
        TreeItem<Person> t21 = new TreeItem<>(new Person("Frieda", "Musterfrau", "Dame2.PNG"));
        TreeItem<Person> t22 = new TreeItem<>(new Person("Kurt", "Mustermann", "Herr1.PNG"));
        t20.getChildren().add(t2r);
        t2r.getChildren().addAll(t21,t22);
        tree2.setRoot(t20);
        tree2.setEditable(true);
        tree2.setCellFactory(new Callback<TreeView<Person>, TreeCell<Person>>() {
            @Override
            public TreeCell<Person> call(TreeView<Person> param) {
                return new TreeCellPerson();
            }
        });
        
        
    }    

    @FXML
    private void testClick(MouseEvent event) {
       
        //1
//        System.out.println("selektiertes Element" + tree2.getSelectionModel().getSelectedItem().getValue().toString());
        //2
//        System.out.println("editierbares Element"+ tree2.getEditingItem());
        //3
//        tree2.getSelectionModel().getSelectedItem()
//                .getChildren().add(
//                    new TreeItem<>(
//                        new Person("SARARAH", "Ping", "Dame3.PNG")));
        //4
//        TreeItem paren = tree2.getSelectionModel().getSelectedItem().getParent();
//        TreeItem child = tree2.getSelectionModel().getSelectedItem();
//        paren.getChildren().remove(child);
        
    }
    
}
