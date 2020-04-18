package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.*;
import javafx.scene.chart.Axis;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class LoadingScreen {
    public LoadingScreen(Stage primaryStage,int fadeIn,int stay, int fadeOut){
        Stage stage=new Stage();
        stage.initOwner(primaryStage);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        Group group=new Group();
        Rectangle rectangle=new Rectangle(600,360);

        File file = new File("src/resources/earth/galaxy.jpg");
        Image image = new Image(file.toURI().toString());
        rectangle.setFill(new ImagePattern(image));
        Camera camera = new PerspectiveCamera(true);
        camera.setNearClip(1);
        camera.setFarClip(1000);
        camera.translateZProperty().set(-1000);

        Group world = new Group();
        world.getChildren().add(prepareEarth());
        world.translateXProperty().set(300);
        world.translateYProperty().set(180);
        world.setRotationAxis(Rotate.Y_AXIS);


        AnimationTimer animationTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                world.rotateProperty().set(world.getRotate()+2);
            }
        };
        animationTimer.start();

        group.getChildren().add(rectangle);
        group.getChildren().add(world);
        Scene scene=new Scene(group);
        stage.setScene(scene);
        stage.show();

        Timeline fadeInTimeline = new Timeline();
        KeyFrame fadeInKey1 = new KeyFrame(Duration.millis(fadeIn), new KeyValue(group.opacityProperty(), 1));
        fadeInTimeline.getKeyFrames().add(fadeInKey1);
        fadeInTimeline.setOnFinished((ae) ->
        {
            new Thread(() -> {
                try
                {
                    Thread.sleep(stay);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Timeline fadeOutTimeline = new Timeline();
                KeyFrame fadeOutKey1 = new KeyFrame(Duration.millis(fadeOut), new KeyValue (group.opacityProperty(), 0));
                KeyFrame fadeOutKey2 = new KeyFrame(Duration.millis(fadeOut), new KeyValue (group.getChildren().get(group.getChildren().size()-1).opacityProperty(), 0));
                fadeOutTimeline.getKeyFrames().add(fadeOutKey2);
                fadeOutTimeline.getKeyFrames().add(fadeOutKey1);
                fadeOutTimeline.setOnFinished((aeb) ->{
                    stage.close();
                    try {
                        MainScreen mainScreen=new MainScreen(primaryStage);
                        mainScreen.launch();
                        //animationTimer.stop();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                fadeOutTimeline.play();
            }).start();
        });
        fadeInTimeline.play();
    }

    private Node prepareEarth() {
        PhongMaterial earthMaterial = new PhongMaterial();
        File file = new File("src/resources/earth/earth-d.jpg");
        Image image = new Image(file.toURI().toString());
        File file1 = new File("src/resources/earth/earth-l.jpg");
        Image image1 = new Image(file1.toURI().toString());
        File file2 = new File("src/resources/earth/earth-s.jpg");
        Image image2 = new Image(file2.toURI().toString());
        File file3 = new File("src/resources/earth/earth-n.jpg");
        Image image3 = new Image(file3.toURI().toString());
        earthMaterial.setDiffuseMap(image);
        earthMaterial.setSelfIlluminationMap(image1);
        earthMaterial.setSpecularMap(image2);
        earthMaterial.setBumpMap(image3);
        Sphere sphere = new Sphere(100);
        sphere.setMaterial(earthMaterial);
        return sphere;
    }
}
