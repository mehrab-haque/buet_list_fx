package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen {
    public static Stage stage;
    public static Group mainGroup;
    public static final int WIDTH=360;
    public static final int HEIGHT=600;
    public MainScreen(Stage stage) throws IOException {
        this.stage=stage;
        mainGroup=new Group();
        Parent bottomLayout = FXMLLoader.load(getClass().getResource("bottom_layout.fxml"));
        bottomLayout.setLayoutY(HEIGHT-60);
        mainGroup.getChildren().add(bottomLayout);
        Scene scene=new Scene(mainGroup,WIDTH,HEIGHT);
        stage.setScene(scene);
    }
    public void launch(){
        stage.show();
    }
}
