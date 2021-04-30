
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.chart.XYChart;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jerem
 */
public class CustomTask extends Task<Void> {

    FXMLDocumentController fdc;
    int lauf;
    public CustomTask(FXMLDocumentController fdc) {
        this.fdc = fdc;
        lauf = 0;
    }

    @Override
    protected Void call() throws Exception {
        URL url = new URL("http://localhost:8080/rest/message/test1");
        

        while (true) {
            
            lauf++;
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            int x = Integer.parseInt(br.readLine());
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    
                    ((XYChart.Series)fdc.getLinechart().getData().get(0)).
                            getData().add(new XYChart.Data(lauf, x));
                    
                    if(lauf > 20){
                        ((XYChart.Series)fdc.getLinechart().getData().get(0)).
                            getData().remove(0);
                        ObservableList<XYChart.Series<Integer, Integer>> ol = fdc.getLinechart().getData();
                        for(int i = 0; i < ol.size(); i++){
                            ol.get(0).getData().set(i, new XYChart.Data<Integer,Integer>(i, ol.get(0).getData().get(i).getYValue()));
                        }
                        fdc.getLinechart().getData().clear();
                        fdc.getLinechart().setData(ol);
                        
                    }
                }
            });

            Thread.sleep(200);
            br.close();
            
        }
    }

}
