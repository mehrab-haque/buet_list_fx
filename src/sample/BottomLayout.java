package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class BottomLayout {
    @FXML
    private TextField txt;
    public void submit(ActionEvent event) throws Exception {
        if(!txt.getText().toString().isEmpty() && isInteger(txt.getText().toString())){
            int num=Integer.parseInt(txt.getText().toString());
            if(num>0) {
                System.out.println(txt.getText().toString());
                fetchList(num);
            }
        }
    }

    private void fetchList(int num) throws IOException {
        Thread thread = new Thread() {
            public void run() {
                try {
                    String url="http://3.6.68.11/buet?n="+num;
                    URL url2=new URL(url);
                    HttpURLConnection con=(HttpURLConnection) url2.openConnection();
                    int response=con.getResponseCode();
                    String data="";
                    //System.out.println(""+response);
                    if(response==200) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String input;
                        JSONArray ara = new JSONArray();
                        while ((input = br.readLine()) != null) {
                            data+=input;
                        }
                        JSONArray jsonArray=new JSONArray(data);
                        System.out.println(jsonArray);
                        ListLayout listLayout=new ListLayout(jsonArray,MainScreen.mainGroup);
                        listLayout.launch();
                    }
                } catch(Exception v) {
                    System.out.println(v);
                }
            }
        };
        thread.run();

    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
}
