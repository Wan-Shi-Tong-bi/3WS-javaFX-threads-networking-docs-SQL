/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DGrafisch;


import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author jerem
 */
public class Philosoph implements Runnable{

    Gabel linkeG;
    Gabel rechteG;
    String name;
    String zustand;
    boolean links;
    boolean rechts;
    Button b;
    Label li;
    Label lr;

    public Philosoph(Label linkeG, Label rechteG, String name, Button b, Label li, Label lr) {
        this.linkeG = (Gabel) linkeG;
        this.rechteG = (Gabel) rechteG;
        this.name = name;
        this.links = false;
        this.rechts = false;
        this.zustand = "denkt";
        this.b = b;
        this.li = li;
        this.lr = lr;
    }

    @Override
    public void run() {
        
        while (true) {
            synchronized (linkeG) {
                if (!linkeG.belget) {
                    linkeG.setBelegt(true, this);
                    links = true;
                    li.setText(name);
                }
            }

            synchronized (rechteG) {
                if (!rechteG.belget) {
                    rechteG.setBelegt(true, this);
                    rechts = true;
                    lr.setText(name);
                }
            }

            if (rechts && links) {
                zustand = "isst";
                
                b.setText("" + this);
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Philosoph.class.getName()).log(Level.SEVERE, null, ex);
                }
                zustand = "denkt";

                synchronized (rechteG) {
                    rechteG.setBelegt(false, null);
                    rechts = false;
                    lr.setText("frei");
                }

                synchronized (linkeG) {
                    linkeG.setBelegt(false, null);
                    links = false;
                    li.setText("frei");
                }
                b.setText("" + this);
            } else {
                b.setText("" + this);
                synchronized (linkeG) {
                    if (linkeG.belget) {
                        linkeG.setBelegt(false, null);
                        links = false;
                        li.setText("frei");
                    }
                }

                synchronized (rechteG) {
                    if (rechteG.belget) {
                        rechteG.setBelegt(false, null);
                        rechts = false;
                        li.setText("frei");
                    }
                }
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Philosoph.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    public String toString() {
        return "" + name + ", " + zustand;
    }

}
