/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DPhilosophenproblem;

/**
 *
 * @author jerem
 */
public class Gabel {
    String name;
    boolean belget;
    Philosoph belegtvon;

    public Gabel(String name) {
        this.name = name;
        this.belget = false;
        this.belegtvon = null;
    }

    public boolean getBelegt(){
        return belget;
    }
    
    public Philosoph getBelegtvon(){
        return belegtvon;
    }
    
    public void setBelegt(boolean belegt, Philosoph philosoph){
        this.belget = belegt;
        this.belegtvon = philosoph;
    }

    @Override
    public String toString() {
        return "" + name;
    }
    
    
}
