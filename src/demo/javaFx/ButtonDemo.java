package demo.javaFx;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ButtonDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");

        //1、创建按钮
        /*Button btn = new Button();
        btn.setText("Say Hello");*/

        //2、设备文本框大小
        /*int buttonSize = 50;
        btn.setMaxSize(buttonSize,buttonSize);
        btn.setPrefSize(buttonSize,buttonSize);
        btn.setMinSize(buttonSize,buttonSize);
        btn.setStyle(String.format("-fx-font-size:%dpx;",(int)(0.45*buttonSize)));*/

        //3、创建带有文本和图标的按钮
        /*Image imageOk = new Image(getClass().getResourceAsStream("ruihua.png"));
        Button btn = new Button("OK", new ImageView(imageOk));*/

        //4、将图像安装到按钮
        Button btn = new Button();
        Image okImage = new Image(getClass().getResourceAsStream("ruihua.png"));
        btn.setGraphic(new ImageView(okImage));

        //5、按钮效果
        DropShadow shadow = new DropShadow();
        btn.setEffect(shadow);
        //btn.setEffect(null);//remove the effect

        //6、按钮的点击事件
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }
}
