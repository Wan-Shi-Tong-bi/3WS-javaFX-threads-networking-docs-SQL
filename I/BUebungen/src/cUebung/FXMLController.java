/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cUebung;

import cUebung.model.Wetter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author jerem
 */
public class FXMLController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private ListView<Wetter> llistView;
    ArrayList<Wetter> arl = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readData();
        llistView.getItems().addAll(arl);
        llistView.setCellFactory((param) -> {
            return new WetterCell(); //To change body of generated lambdas, choose Tools | Templates.
        });
        
        choiceBoxLogic();
    }
    
    private void readData(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Wetter.csv"));
            br.readLine();
            String zeile = br.readLine();
            
            while(zeile != null){
                String[] werte = zeile.split(";");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate date = LocalDate.parse(werte[0].toString(), formatter);
                Wetter w = new Wetter(date, Integer.parseInt(werte[1]), Integer.parseInt(werte[2]), werte[3].toString());
                arl.add(w);
                zeile = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void choiceBoxLogic(){
        for(Auswahlmoeglichkeiten a : Auswahlmoeglichkeiten.values()){
            choiceBox.getItems().add(a.toString());
        }
        choiceBox.setValue(Auswahlmoeglichkeiten.Alle_Tage.toString());
        
        choiceBox.getSelectionModel().selectedIndexProperty().addListener(
         (observable, oldValue, newValue) -> {
               Auswahlmoeglichkeiten a = Auswahlmoeglichkeiten.valueOf(choiceBox.getItems().get(newValue.intValue()));
               llistView.getItems().clear();
               
               llistView.refresh();
               switch(a){
                    case Alle_Tage:
                            llistView.getItems().setAll(arl);
                       break;
                    case Heisser_Tag:
                            for(Wetter w : arl){
                                if(w.getTempDay() > 30){
                                    llistView.getItems().add(w);
                                }
                            }
                        break;
                    case Normaler_Tag:
                            for(Wetter w : arl){
                                if(w.getTempDay() < 30 && w.getTempNight() < 20){
                                    llistView.getItems().add(w);
                                }
                            }
                        break;
                    case Tropische_Nacht:    
                        for(Wetter w : arl){
                                if(w.getTempNight() > 20){
                                    llistView.getItems().add(w);
                                }
                                
                            }
                           
                        break;
               }
         });
    }

    
}
