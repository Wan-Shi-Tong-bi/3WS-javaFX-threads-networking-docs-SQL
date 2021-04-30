
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Producer extends Thread{
    String name;
    Storage obj;

    public Producer(String name, Storage obj) {
        this.name = name;
        this.obj = obj;
    }

    @Override
    public void run() {
        while(true){
        String temp = ""+(Math.random());
        System.out.println(""+name+" "+temp);
        obj.speichernUndNehmen(temp);
            try {
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
