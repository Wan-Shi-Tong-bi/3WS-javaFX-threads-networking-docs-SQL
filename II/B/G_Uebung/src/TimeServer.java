
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class TimeServer {
    
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(1030);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        while(true){
            System.out.println("...Verbindung zu Server aufgebaut");
            Socket current = ss.accept();
            Informer f = new Informer(current);
            f.start();
            System.out.println("...neuer Kommunikations-Thread erstellt");
            
        }
    }
}
