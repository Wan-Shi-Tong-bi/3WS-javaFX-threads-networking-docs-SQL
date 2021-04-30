/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DGrafisch;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author jerem
 */
public class Applikation extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        FXMLController fc = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Gabel g1 = new Gabel("g1");
        Gabel g2 = new Gabel("g2");
        Gabel g3 = new Gabel("g3");
        Gabel g4 = new Gabel("g4");
        Gabel g5 = new Gabel("g5");
               
        Philosoph p1 = new Philosoph(g1, g2, "Aristoteles", fc.p1, fc.g1, fc.g2);
        Philosoph p2 = new Philosoph(g2, g3, "Platon", fc.p2, fc.g2, fc.g3);
        Philosoph p3 = new Philosoph(g3, g4, "Newton", fc.p3, fc.g3, fc.g4);
        Philosoph p4 = new Philosoph(g4, g5, "King", fc.p4, fc.g4, fc.g5);
        Philosoph p5 = new Philosoph(g5, g1, "Leander", fc.p5, fc.g5, fc.g1);
        
        Thread t1 = new Thread((Runnable) p1);
        t1.start();
        Thread t2 = new Thread((Runnable) p2);
        t2.start();        
        Thread t3 = new Thread((Runnable) p3);
        t3.start();        
        Thread t4 = new Thread((Runnable) p4);
        t4.start();        
        Thread t5 = new Thread((Runnable) p5);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
