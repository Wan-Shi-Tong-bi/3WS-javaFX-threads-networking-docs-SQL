
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Patient implements Serializable {
    //wichtig für Objektübertragung
    String name;
    int alter;

    public Patient(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
    
    
}
