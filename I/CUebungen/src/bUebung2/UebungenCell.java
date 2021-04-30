/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bUebung2;

import bUebung.model.Uebungen;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author jerem
 */
public class UebungenCell extends ListCell<Uebungen>{
    ImageView iv;
    @Override
    protected void updateItem(Uebungen item, boolean empty){
        super.updateItem(item, empty);
        if(item != null & !empty){
        try {
            iv = new ImageView(new Image(new FileInputStream(item.getUrl())));
        } catch (FileNotFoundException ex) {}
        setText(item.getName());
        setGraphic(iv);
        }else{
            
        }
    }
}
