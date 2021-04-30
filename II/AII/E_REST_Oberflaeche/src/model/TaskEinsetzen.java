/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import grafik.FXMLDocumentController;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jerem
 */
public class TaskEinsetzen extends Task<Void> {
    private FXMLDocumentController controller;

    public TaskEinsetzen(FXMLDocumentController controller) {
        this.controller = controller;
    }
    
    
    @Override
    protected Void call() throws Exception {
        
        while(true){
            int i = 0;
            String temp = "http://localhost:8080/E_REST_Server/resources/patienten/patientenIDs?x=" + i;
            BufferedReader reader = new BufferedReader(new InputStreamReader((new URL(temp)).openStream()));
            JSONObject obj = new JSONObject(reader.readLine());
            JSONArray arr = obj.getJSONArray("Liste der IDs");
            ObservableList<Patient> obs = FXCollections.observableArrayList(new ArrayList<Patient>());
            for(int e = 0; e < arr.length(); e++){
                temp = "http://localhost:8080/E_REST_Server/resources/patienten/patient/" + e;
                BufferedReader reader2 = new BufferedReader(new InputStreamReader((new URL(temp)).openStream()));
                JSONObject objTemp = new JSONObject(reader2.readLine());
                Patient p = new Patient(objTemp.getInt("id"), objTemp.getString("vorname"), objTemp.getString("nachname"));
                
                JSONArray arrTemp = objTemp.getJSONArray("Daten");
                for(int j = 0; j < arrTemp.length(); j++){
                    Eintrag ein = new Eintrag(arrTemp.getJSONObject(j).getString("Datum"), arrTemp.getJSONObject(j).getString("Eintrag"));
                    p.addEintrag(ein);
                }
                obs.add(p);
            }
            
            Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    controller.ueTabView1.setItems(obs);
                    System.out.println("ausgabe");
                    
                }
            });
            
            Thread.sleep(3000);
            i++;
        }
        
    }
    
}
