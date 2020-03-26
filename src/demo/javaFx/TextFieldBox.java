package demo.javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//这个类实现了，按钮获取文本框的值，GridPane对按钮的布局
public class TextFieldBox extends Application {

    public static void main(String[] args)throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Group容器组，可以管理一组节点，group.getChildren().addAll(b1 , b2 , b3);
        Group root = new Group();
        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
        stage.setTitle("Text Field Sample");

        //GridPane布局管理器
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 30, 10, 20));
        grid.setVgap(5);
        grid.setHgap(5);

        scene.setRoot(grid);

        Button button = new Button();
        button.setText("获取文本值");
        button.setLayoutX(100);
        button.setLayoutY(10);
        button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        final TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        name.getText();
        name.setLayoutX(200);
        name.setLayoutY(50);
        name.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(name.getText());
            }
        });
        //GridPane.setConstraints(name, 0, 0);
        //grid.getChildren().add(name);
        grid.add(name,0,0);
        grid.add(button,1,0);
        GridPane.setMargin(button, new Insets(0,0,0,115));
        //grid.getChildren().addAll(name,button);
        grid.setAlignment(Pos.CENTER);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }
}
