/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restjerseyheart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author User
 */
@Path("message")
public class MessageResource {
     static int x = 0;
    @GET
    @Path("test1")
    @Produces(MediaType.TEXT_XML)
    public String message() throws FileNotFoundException, IOException {
        FileReader f = new FileReader("heart");
        BufferedReader br = new BufferedReader(f);
        int temp = Integer.parseInt(br.readLine());
        temp += x;
        x++;
        if (x == 50) {
            x = 0;
        }
        br.close();
        return "" + temp;
    }
}
