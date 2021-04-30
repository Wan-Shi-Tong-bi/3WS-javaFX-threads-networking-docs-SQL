
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jerem
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        
        Socket s = new Socket("localhost", 5349);
        InputStream input = s.getInputStream();
        BufferedReader read = new BufferedReader(new InputStreamReader(input));
        String str = read.readLine();
        System.out.println("server says: " +str);
        
        read.close();
        s.close();
        
        
    }
    
}
