/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRaucherproblem;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Raucher extends Thread{
    Gegenstaende g;
    Tisch tisch;
    String name;

    public Raucher(Gegenstaende g, Tisch tisch, String name) {
        this.g = g;
        this.tisch = tisch;
        this.name = name;
    }
    
    
    
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true){
            synchronized(tisch){
                if(tisch.getEins() != null && !tisch.getEins().equals(g) && !tisch.getZwei().equals(g)){
                    System.out.println(""+ name + " macht sich jetzt ans Rauchen.");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Raucher.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    tisch.setEins(null);
                    tisch.setZwei(null);
                    System.out.println(""+ name + " hat das Rauchen beendet.");
                    
                }
            }
            System.out.println(""+ name + " schläft jetzt eine Weile.");
                    
                    try {
                        Thread.sleep((new Random()).nextInt(4000)+1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Raucher.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    
}
