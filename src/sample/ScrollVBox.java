package sample;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.json.*;

import java.io.IOException;

public class ScrollVBox {
    private Group group;
    public ScrollVBox(JSONArray jsonArray) throws IOException {
        group=new Group();
        ScrollPane scrollPan=new ScrollPane();
        scrollPan.setPrefHeight(540);
        scrollPan.setPrefWidth(360);
        VBox vBox=new VBox();
        for(int i=0;i<jsonArray.length();i++){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("list_single_layout.fxml"));
            Parent single_layout = loader.load();
            ListSingleLayout singleLayout = loader.getController();
            singleLayout.setName(jsonArray.getJSONObject(i).getString("name"));
            singleLayout.setDesignation(jsonArray.getJSONObject(i).getString("designation"));
            singleLayout.setImage(jsonArray.getJSONObject(i).getString("image"));
            vBox.getChildren().add(single_layout);
        }

        scrollPan.setContent(vBox);
        group.getChildren().add(scrollPan);
    }
    public Group getLayout(){
        return group;
    }
}
