
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javafx.application.Platform;
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
        URL url = new URL("http://192.168.1.108:8080/rest/message/test1");
        

        while (true) {
            
            lauf++;
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = br.readLine();
            String[]args = str.split(":");
            int t  = args[1].indexOf("(");
            str = args[1].substring(0, t);
            int x = Integer.parseInt(str);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    
                    ((XYChart.Series)fdc.getLinechart().getData().get(0)).
                            getData().add(new XYChart.Data(lauf, x));
                    
                    if(lauf > 20){
                        ((XYChart.Series)fdc.getLinechart().getData().get(0)).
                            getData().remove(0);
                        
                        
                    }
                }
            });

            Thread.sleep(500);
            br.close();
            
        }
    }

}
