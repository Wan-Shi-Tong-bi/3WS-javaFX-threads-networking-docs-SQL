package bUebung2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bUebung.model.Uebungen;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author jerem
 */
public class PictureCell extends TableCell<Uebungen, String>{
    private final HBox uebungenBox;

    public PictureCell(){
        uebungenBox = new HBox();  
    
    }
    
    @Override
    protected void updateItem(String item, boolean empty){
         uebungenBox.getChildren().clear();
         setText("");
        if(item != null & !empty){
           
        try {
            uebungenBox.getChildren().add(new ImageView(new Image(new FileInputStream(item))));
            setText(item);
            setGraphic(uebungenBox);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PictureCell.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
        
        }
    }
}
