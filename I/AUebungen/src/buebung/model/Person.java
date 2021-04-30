/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buebung.model;

/**
 *
 * @author jerem
 */
public class Person {
    private String name;
    private String vorname;
    private String anschrift;
    private Geschlecht geschlecht;
    
    public Person(){}
    
    public Person(String name, String vorname, String anschrift, Geschlecht geschlecht) {
        this.name = name;
        this.vorname = vorname;
        this.anschrift = anschrift;
        this.geschlecht = geschlecht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getAnschrift() {
        return anschrift;
    }

    public void setAnschrift(String anschrift) {
        this.anschrift = anschrift;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", vorname=" + vorname + ", anschrift=" + anschrift + ", geschlecht=" + geschlecht + '}';
    }
    
    
}
