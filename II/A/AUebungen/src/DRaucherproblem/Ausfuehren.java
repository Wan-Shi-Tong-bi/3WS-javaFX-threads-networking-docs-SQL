/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DRaucherproblem;

/**
 *
 * @author jerem
 */
public class Ausfuehren {
    public static void main(String[] args) {
        Tisch t = new Tisch();
        Tabakhaendler tabak = new Tabakhaendler("Mathias", t);
        Raucher r1 = new Raucher(Gegenstaende.Tabak, t, "Leander");
        Raucher r2 = new Raucher(Gegenstaende.Papier, t, "Papierboy");
        Raucher r3 = new Raucher(Gegenstaende.Hoelzer, t, "Holzmadl");
        
        tabak.start();
        r1.start();
        r2.start();
        r3.start();
    }
}
