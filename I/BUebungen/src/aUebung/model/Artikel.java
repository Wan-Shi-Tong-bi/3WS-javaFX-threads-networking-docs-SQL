/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aUebung.model;

/**
 *
 * @author jerem
 */
public class Artikel {
    private String hersteller;
    private String artikelbezeichnung;

    public Artikel(String hersteller, String artikelbezeichnung) {
        this.hersteller = hersteller;
        this.artikelbezeichnung = artikelbezeichnung;
    }

    public Artikel() {
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getArtikelbezeichnung() {
        return artikelbezeichnung;
    }

    public void setArtikelbezeichnung(String artikelbezeichnung) {
        this.artikelbezeichnung = artikelbezeichnung;
    }

    @Override
    public String toString() {
        return hersteller + ", " + artikelbezeichnung;
    }
    
    
}
