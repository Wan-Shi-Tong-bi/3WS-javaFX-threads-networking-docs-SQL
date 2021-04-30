/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUebung.akkteure;

import BUebung.FXMLController;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;

/**
 *
 * @author jerem
 */
public class Arzt extends Task<Void> {

    EnumArzt arzt;
    FXMLController controller;

    public Arzt(EnumArzt arzt, FXMLController controller) {
        this.arzt = arzt;
        this.controller = controller;
    }

    @Override
    protected Void call(){
        Random r = new Random();
        while (true) {
            if (arzt == EnumArzt.Allgemeinmediziner) {

                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        
                        synchronized (controller.getListArzt1()) {

                            if (controller.getListArzt1().getItems().size() > 0) {
                                updateMessage("Patient wird behandelt");
                                controller.getListArzt1().getItems().remove(0);     
                            }
                        }
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Arzt.class.getName()).log(Level.SEVERE, null, ex);
                                }
                    }

                });
            } else {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {

                        synchronized (controller.getListArzt2()) {

                            if (controller.getListArzt2().getItems().size() > 0) {
                                updateMessage("Patient wird behandelt");
                                controller.getListArzt2().getItems().remove(0);

                            }       
                            }
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(Arzt.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            

                        }

                    

                });
            }
            updateMessage("Patient weg");
            try {
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Arzt.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
