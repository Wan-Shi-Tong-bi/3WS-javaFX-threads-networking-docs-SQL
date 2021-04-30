/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuebung.model;

/**
 *
 * @author jerem
 */
public class Article {
    private String hersteller;
    private String bezeichnung;

    public Article(String hersteller, String bezeichnung) {
        this.hersteller = hersteller;
        this.bezeichnung = bezeichnung;
    }

    public Article() {
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    @Override
    public String toString() {
        return "Article{" + "hersteller=" + hersteller + ", bezeichnung=" + bezeichnung + '}';
    }
    
    
    
    
}
