
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
public class Consumer extends Thread{
    String name;
    Storage obj;

    public Consumer(String name, Storage obj) {
        this.name = name;
        this.obj = obj;
    }
    
        @Override
    public void run() {
        while(true){
        String temp = (String) obj.speichernUndNehmen(null);
        System.out.println(""+name+" "+temp);
            try {
                Thread.sleep((long)(Math.random()*10000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
