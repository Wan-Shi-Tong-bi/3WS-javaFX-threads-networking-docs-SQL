/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bUebung.model;

/**
 *
 * @author jerem
 */
public class Uebungen {
    private String name;
    private String url;
    private int anz;

    public Uebungen(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public int getAnz() {
        return anz;
    }

    public void setAnz(int anz) {
        this.anz = anz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
