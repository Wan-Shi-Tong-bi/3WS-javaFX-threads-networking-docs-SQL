
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalTimeStringConverter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Informer extends Thread{
    Socket s;

    public Informer(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            Thread.sleep(5000);
            bw.write("" + LocalTime.now().toString());
            bw.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Informer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Informer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
