/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Ausfuehren {
    public static void main(String args[]){
        Storage obj = new Storage();
        Producer p = new Producer("p1", obj);
        Consumer c = new Consumer("c1", obj);
        Producer p2 = new Producer("p2", obj);
        Consumer c2 = new Consumer("c2", obj);
        p.start();
        c.start();
        p2.start();
        c2.start();
        System.out.println("Main Thread fertig");
    }
}
