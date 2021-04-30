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
import javafx.scene.control.Label;

/**
 *
 * @author jerem
 */
public class Empfangsdame extends Task<Void> {

    EnumEmpfangsdame empfangsdame;
    FXMLController controller;

    public Empfangsdame(EnumEmpfangsdame empfangsdame, FXMLController controller) {
        this.empfangsdame = empfangsdame;
        this.controller = controller;
    }

    @Override
    protected Void call() throws Exception {
        Random r = new Random();
        while (true) {
            Patient pat = new Patient(empfangsdame, EnumArzt.values()[r.nextInt(2)]);
            updateMessage("Patient eingetroffen");
            
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}

            if (pat.getArzt()== EnumArzt.Allgemeinmediziner) {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (controller.getListArzt1()) {
                            controller.getListArzt1().getItems().add(pat);
                        }
                    }
                });
            } else {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (controller.getListArzt2()) {
                            controller.getListArzt2().getItems().add(pat);
                        }
                    }
                });
            }
            updateMessage("Patient weg");
            Thread.sleep(2000);
        }
    }

}
