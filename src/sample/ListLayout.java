package sample;

import javafx.scene.Group;
import org.json.JSONArray;

import java.io.IOException;

public class ListLayout {
    private Group group;
    private ScrollVBox scrollVBox;
    public ListLayout(JSONArray jsonArray, Group group) throws IOException {
        this.group=group;
        scrollVBox=new ScrollVBox(jsonArray);
    }
    public void launch(){
        if(group.getChildren().size()>1)group.getChildren().remove(1);
        group.getChildren().add(scrollVBox.getLayout());
    }
}
