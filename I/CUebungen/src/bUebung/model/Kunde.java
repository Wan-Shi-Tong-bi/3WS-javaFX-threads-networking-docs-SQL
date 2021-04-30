/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bUebung.model;

import java.util.ArrayList;

/**
 *
 * @author jerem
 */
public class Kunde {
    private String vorname;
    private String nachname;
    private String name;
    private String strasse;
    private int nr;
    private int plz;
    private String ort;
    private String adresse;
    private int id;
    private static int lauf = 0;
    private ArrayList<Uebungen> uebeungen;


    public Kunde(String vorname, String nachname, String strasse, int nr, int plz, String ort) {
        uebeungen = new ArrayList<>();
        lauf++;
        id = lauf;
        this.vorname = vorname;
        this.nachname = nachname;
        this.name = vorname + ", " + nachname;
        this.strasse = strasse;
        this.nr = nr;
        this.plz = plz;
        this.ort = ort;
        this.adresse = ""+plz+", "+ort+", "+strasse+", "+nr;
    }

    public ArrayList<Uebungen> getUebeungen() {
        return uebeungen;
    }

    public void addUebeung(Uebungen u) {
        this.uebeungen.add(u);
    }

    public void setUebeungen(ArrayList<Uebungen> uebeungen) {
        this.uebeungen = uebeungen;
    }
    
    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = vorname + ", " + nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse() {
        this.adresse = ""+plz+", "+ort+", "+strasse+", "+nr;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getLauf() {
        return lauf;
    }

    public static void setLauf(int lauf) {
        Kunde.lauf = lauf;
    }
    
    
    
    
}
