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
public class TermperaturDaten {
    private int id;
    private int temperatur;

    public TermperaturDaten(int id, int temperatur) {
        this.id = id;
        this.temperatur = temperatur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemperatur() {
        return temperatur;
    }

    public void setTemperatur(int temperatur) {
        this.temperatur = temperatur;
    }

    @Override
    public String toString() {
        return "TermperaturDaten{" + "id=" + id + ", temperatur=" + temperatur + '}';
    }
    
    
}
