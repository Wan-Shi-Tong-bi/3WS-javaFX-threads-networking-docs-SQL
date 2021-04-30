/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPhilosophenproblem;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Philosoph extends Thread {

    Gabel linkeG;
    Gabel rechteG;
    String name;
    String zustand;
    boolean links;
    boolean rechts;

    public Philosoph(Gabel linkeG, Gabel rechteG, String name) {
        this.linkeG = linkeG;
        this.rechteG = rechteG;
        this.name = name;
        this.links = false;
        this.rechts = false;
        this.zustand = "denkt";
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        while (true) {
            synchronized (linkeG) {
                if (!linkeG.belget) {
                    linkeG.setBelegt(true, this);
                    links = true;
                }
            }

            synchronized (rechteG) {
                if (!rechteG.belget) {
                    rechteG.setBelegt(true, this);
                    rechts = true;
                }
            }

            if (rechts && links) {
                zustand = "isst";
                System.out.println("" + this + " " + links + " " + rechts);
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Philosoph.class.getName()).log(Level.SEVERE, null, ex);
                }
                zustand = "denkt";

                synchronized (rechteG) {
                    rechteG.setBelegt(false, null);
                    rechts = false;
                }

                synchronized (linkeG) {
                    linkeG.setBelegt(false, null);
                    links = false;
                }
                System.out.println("" + this + " " + links + " " + rechts);
            } else {
                System.out.println("" + this + " " + links + " " + rechts);
                synchronized (linkeG) {
                    if (linkeG.belget) {
                        linkeG.setBelegt(false, null);
                        links = false;
                    }
                }

                synchronized (rechteG) {
                    if (rechteG.belget) {
                        rechteG.setBelegt(false, null);
                        rechts = false;
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
