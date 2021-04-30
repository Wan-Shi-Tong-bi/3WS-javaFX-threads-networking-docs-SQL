/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cUebung;

import cUebung.model.Wetter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 *
 * @author jerem
 */
public class WetterCell extends ListCell<Wetter>{
    
    ImageView iv;
    @Override
    protected void updateItem(Wetter item, boolean empty){
        super.updateItem(item, empty);
        if(item != null & !empty){
        try {
            iv = new ImageView(new Image(new FileInputStream(item.getWeather())));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WetterCell.class.getName()).log(Level.SEVERE, null, ex);
        }
        setText(item.getDate().getDayOfWeek().name() + "\n" + item.getDate() + "\n" + item.getTempDay() + "\n" + item.getTempNight());
        if(item.getTempDay() > 30){
            setTextFill(Color.PURPLE);
            setTooltip(new Tooltip("Heißer Tag oder Hitzetag, älter auch Tropentag, ist die meteorologisch-klimatologische Bezeichnung für Tage, an denen die Tageshöchsttemperatur 30 °C erreicht oder übersteigt."));
        }else{
            setTextFill(Color.BLUE);
            setTooltip(new Tooltip("Tag im Bereich der normalen Grenzen"));
        }
        if(item.getTempNight() > 20){
            setTextFill(Color.RED);
            setTooltip(new Tooltip("Tropische Nacht: Unter einer Tropennacht versteht man in der deutschsprachigen Meteorologie eine Nacht, in der die niedrigste Lufttemperatur zwischen 18 und 06 Uhr nicht unter 20 °C fällt"));
        }
        setGraphic(iv);
        }else{
            setText(null);
            setTextFill(null);
            setTooltip(null);
            setGraphic(null);
        }
    }
}
