/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cUebung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.control.TableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author bambl
 */
public class GoalsCell extends TableCell<Player, Integer> {

    private final HBox goalsBox;
    private final Image goalImage;

    public GoalsCell() throws FileNotFoundException {
        goalsBox = new HBox();
        goalImage = new Image(new FileInputStream("serveimage.png"));

    }
    
    @Override
    protected void updateItem(Integer item, boolean empty) {
        setText("");
        goalsBox.getChildren().clear();
        if (item != null) {
            for (int i = 0; i < item; i++) {
                goalsBox.getChildren().add(new ImageView(goalImage));
            }
        }
        setGraphic(goalsBox);
        
    }

}
