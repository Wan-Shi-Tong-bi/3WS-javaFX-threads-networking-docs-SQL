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
public class Tabakhaendler extends Thread{
    String name;
    Tisch tisch;

    public Tabakhaendler(String name, Tisch tisch) {
        this.name = name;
        this.tisch = tisch;
    }

    
    
    

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while(true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Tabakhaendler.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println(this + " prüft den Tisch");
                       
            synchronized(tisch){
                
                if(tisch.getEins() == null){
                    Random r = new Random();
                    int i = r.nextInt(3);
                    int e = -1;
                    do{
                        e = r.nextInt(3);
                    }while(e == i);
                    Gegenstaende[] g = Gegenstaende.values();
                    tisch.setEins(g[i]);
                    tisch.setZwei(g[e]);
                    System.out.println(this + " legt " + 
                            g[i] + " und " + g[e]  +" auf den Tisch");
                    
                }
                
                
            }
        }
    }

    @Override
    public String toString() {
        return "" + name;
    }
    
    
    
    
}
