package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ListSingleLayout implements Initializable {
    @FXML private Circle imageCircle;
    @FXML private Label name;
    @FXML private Label designation;
    @FXML private AnchorPane pan;
    public void setImage(String url){
        Image image = new Image(url,true);
        image.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                //System.out.println(Math.rint(newValue.doubleValue() * 100));
                if(newValue.intValue()==1){
                    ImagePattern imagePattern=new ImagePattern(image);
                    imageCircle.setFill(imagePattern);
                }
            }
        });
    }
    public void setName(String string){
        name.setText(string);
        pan.setOnMouseClicked(event->{
            String toastMsg = name.getText().toString();
            int toastMsgTime = 1500;
            int fadeInTime = 1000;
            int fadeOutTime= 500;
            Toast.makeText(MainScreen.stage, toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
        });
    }
    public void setDesignation(String string){
        designation.setText(string);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/resources/avatar.png");
        Image image = new Image(file.toURI().toString());
        ImagePattern imagePattern=new ImagePattern(image);
        imageCircle.setFill(imagePattern);
    }
}
