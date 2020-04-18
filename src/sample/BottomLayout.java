package sample;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;


public class BottomLayout implements Initializable {
    @FXML
    private TextField txt;
    private AnimationTimer timer;
    private boolean isError=false;
    private String errorMessage="";
    private JSONArray jsonArray;
    public void submit(ActionEvent event) throws Exception {
        if(!txt.getText().toString().isEmpty() && isInteger(txt.getText().toString())){
            int num=Integer.parseInt(txt.getText().toString());
            if(num>0)fetchList(num);
        }
    }

    private void fetchList(int num) throws IOException {
        LoaderView loaderView=new LoaderView(360,540);
        MainScreen.mainGroup.getChildren().add(loaderView.getLayout());
        timer.start();
        Thread thread = new Thread() {
            public void run() {
                try {
                    String url="http://3.6.68.11/buet?n="+num;
                    URL url2=new URL(url);
                    HttpURLConnection con=(HttpURLConnection) url2.openConnection();
                    int response=con.getResponseCode();
                    String data="";
                    if(response==200) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String input;
                        JSONArray ara = new JSONArray();
                        while ((input = br.readLine()) != null) {
                            data+=input;
                        }
                        jsonArray=new JSONArray(data);
                    }
                } catch(Exception v) {
                    isError=true;
                    errorMessage=v.getMessage();
                }
            }
        };
        thread.start();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        jsonArray=new JSONArray();
        timer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(jsonArray.length()!=0){
                    ListLayout listLayout= null;
                    try {
                        listLayout = new ListLayout(jsonArray, MainScreen.mainGroup);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    listLayout.launch();
                    timer.stop();
                }else if(isError){
                    isError=false;
                    timer.stop();
                    MainScreen.mainGroup.getChildren().remove(MainScreen.mainGroup.getChildren().size()-1);
                    String toastMsg = errorMessage;
                    int toastMsgTime = 1500;
                    int fadeInTime = 1000;
                    int fadeOutTime= 500;
                    Toast.makeText(MainScreen.stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
                }
            }
        };
    }
}
