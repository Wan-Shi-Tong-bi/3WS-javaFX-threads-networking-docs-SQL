/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPhilosophenproblem;

/**
 *
 * @author jerem
 */
public class Ausfuehren {
    public static void main(String args[]){
        Gabel g1 = new Gabel("g1");
        Gabel g2 = new Gabel("g2");
        Gabel g3 = new Gabel("g3");
        Gabel g4 = new Gabel("g4");
        Gabel g5 = new Gabel("g5");
        
        Philosoph p1 = new Philosoph(g1, g2, "Aristoteles");
        Philosoph p2 = new Philosoph(g2, g3, "Platon");
        Philosoph p3 = new Philosoph(g3, g4, "Newton");
        Philosoph p4 = new Philosoph(g4, g5, "King");
        Philosoph p5 = new Philosoph(g5, g1, "Leander");
        
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
    }
}
