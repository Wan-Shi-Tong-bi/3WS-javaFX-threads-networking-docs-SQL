
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
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
public class TimeClient {
    //normalerweise erstellt man nicht Client und Server in der selben Klasse
    //aus praktischen Gründen hier aber gemacht
    
    public static void main(String[] args) throws IOException{
        while(true){
        Socket s = new Socket("localhost", 1030);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String temp = br.readLine();
        System.out.println("" + temp);
        br.close();
        s.close();
        }
    }
}
