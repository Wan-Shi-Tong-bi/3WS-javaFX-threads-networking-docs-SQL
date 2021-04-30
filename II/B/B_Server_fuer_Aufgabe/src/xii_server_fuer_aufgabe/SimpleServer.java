/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xii_server_fuer_aufgabe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import javax.swing.DefaultListModel;

/**
 *
 * @author root
 */
public class SimpleServer {

    public static void main(String[] argv) throws IOException {
        ServerSocket s = new ServerSocket(5349);
        //while(true) {
        while (true) {
            Socket s1 = s.accept();
            System.out.println("----");
            OutputStream sout = s1.getOutputStream();
            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(sout));
            write.write("Hallo wie geht es Dir");
            write.close();
            s1.close();
        }
        //}

    }
}
