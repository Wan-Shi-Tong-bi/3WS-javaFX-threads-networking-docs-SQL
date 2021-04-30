/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folien;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author jerem
 */
public class TreeCellPerson extends TreeCell<Person>{
    Person current = null;
    TextField f;
    
    
    @Override
    public void startEdit(){
        if(!isEmpty() && getItem() != null){
        super.startEdit();
        current = getItem();
        HBox h = new HBox();
        f = new TextField();
        h.getChildren().add(f);
        setGraphic(h);
        }
    }
    
    @Override
    public void cancelEdit(){
        if(!isEmpty() && getItem() != null){
        super.cancelEdit();
        current.setFirstName(f.getText());
        setText(current.toString());
        try {
            setGraphic(new ImageView(new Image(new FileInputStream(current.getPathToPicture()))));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TreeCellPerson.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    @Override
    protected void updateItem(Person item, boolean empty){
        super.updateItem(item, empty);
        if(!empty && item != null){
            setText(item.toString());
            HBox h = new HBox();
            try {
                setGraphic(new ImageView(new Image(new FileInputStream(item.getPathToPicture()))));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            setText("");
            setGraphic(null);
        }
    }
}
