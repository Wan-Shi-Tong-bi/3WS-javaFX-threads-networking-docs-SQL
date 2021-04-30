/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daten;

/**
 *
 * @author jerem
 */
public class Daten {
    private String bezeichnung;
    private int jahr1;
    private int jahr2;
    private int jahr3;
    private int jahr4;

    public Daten(String bezeichnung, int jahr1, int jahr2, int jahr3, int jahr4) {
        this.bezeichnung = bezeichnung;
        this.jahr1 = jahr1;
        this.jahr2 = jahr2;
        this.jahr3 = jahr3;
        this.jahr4 = jahr4;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getJahr1() {
        return jahr1;
    }

    public void setJahr1(int jahr1) {
        this.jahr1 = jahr1;
    }

    public int getJahr2() {
        return jahr2;
    }

    public void setJahr2(int jahr2) {
        this.jahr2 = jahr2;
    }

    public int getJahr3() {
        return jahr3;
    }

    public void setJahr3(int jahr3) {
        this.jahr3 = jahr3;
    }

    public int getJahr4() {
        return jahr4;
    }

    public void setJahr4(int jahr4) {
        this.jahr4 = jahr4;
    }

    @Override
    public String toString() {
        return "Daten{" + "bezeichnung=" + bezeichnung + ", jahr1=" + jahr1 + ", jahr2=" + jahr2 + ", jahr3=" + jahr3 + ", jahr4=" + jahr4 + '}';
    }
    
    
}
