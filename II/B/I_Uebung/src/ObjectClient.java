
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javafx.scene.control.TreeView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class ObjectClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Socket s = new Socket("localhost", 3333);
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        Patient o = (Patient) ois.readObject();
        System.out.println("" + o.name + " " + o.alter);
       
    }
}
