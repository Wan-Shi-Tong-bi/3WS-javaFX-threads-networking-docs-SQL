
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class ObjectServer {
   
    public static void main(String[] args) throws IOException{
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(3333);
        } catch (IOException ex) {
            Logger.getLogger(ObjectServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
        //Warten auf Verbindung
        Socket client = ss.accept();
        
        //Patienten aussenden
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        Patient o = new Patient("Klaus", 2);
        oos.writeObject(o);
        oos.close();
        }
    }
            
}
