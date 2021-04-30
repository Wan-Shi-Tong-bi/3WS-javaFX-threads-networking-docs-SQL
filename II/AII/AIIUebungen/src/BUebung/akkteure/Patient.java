/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUebung.akkteure;

/**
 *
 * @author jerem
 */
public class Patient {
    EnumEmpfangsdame empfangsdame;
    EnumArzt arzt;

    public Patient(EnumEmpfangsdame empfangsdame, EnumArzt arzt) {
        this.empfangsdame = empfangsdame;
        this.arzt = arzt;
    }

    @Override
    public String toString() {
        return "zugewiesen durch " + empfangsdame + " an " + arzt;
    }

    public EnumEmpfangsdame getEmpfangsdame() {
        return empfangsdame;
    }

    public EnumArzt getArzt() {
        return arzt;
    }
    
    
    
}
