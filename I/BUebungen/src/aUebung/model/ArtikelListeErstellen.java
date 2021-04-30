/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aUebung.model;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class ArtikelListeErstellen {
    public static void main(String[] args){
        ArrayList<Artikel> al = new ArrayList<>();
        al.add(new Artikel("Audi", "A4"));
        al.add(new Artikel("BMW", "Luxury 7"));
        al.add(new Artikel("BMW", "WasWeissIch"));
        al.add(new Artikel("Audi", "R7"));
        al.add(new Artikel("VW", "Kombi"));
        al.add(new Artikel("VW", "Golf"));
        try {
            XMLEncoder xmle = new XMLEncoder(new FileOutputStream("ArtikelListe"));
            xmle.writeObject(al);
            xmle.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArtikelListeErstellen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
