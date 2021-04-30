/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bUebung2;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jerem
 */
public class Fenster2 extends Stage{
    Fenster1 firstWindow;
    FXMLController fdc;

    public Fenster2() throws IOException {
        super();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = loader.load();
        fdc = loader.getController();
        Scene scene = new Scene(root);
        this.setScene(scene);
    }
}
