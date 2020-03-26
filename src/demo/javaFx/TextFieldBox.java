package demo.javaFx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
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

        //按钮
        Button button = new Button();
        button.setText("获取文本值");
        button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        //输入文本框1
        final TextField name = new TextField();
        name.setPromptText("Enter your first name.");
        name.setPrefColumnCount(10);
        name.getText();
        name.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        //输入文本框2
        final TextField name2 = new TextField();
        name2.setPromptText("Enter your first name.");
        name2.setPrefColumnCount(10);
        name2.getText();
        name2.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        //输入文本框3
        final TextField name3 = new TextField();
        name3.setPromptText("Enter your first name.");
        name3.setPrefColumnCount(10);
        name3.getText();
        name3.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

        //复选框1
        final CheckBox cb = new CheckBox("checkBox");
        final Tooltip tooltip = new Tooltip("$ tooltip");
        tooltip.setFont(new Font("Arial", 32));
        cb.setTooltip(tooltip);
        cb.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
                System.out.println(cb.isSelected());
                if (cb.isSelected()==true){
                    System.out.println(name2.getText());
                }
            }
        });

        //复选框2
        final CheckBox cb2 = new CheckBox("checkBox");
        final Tooltip tooltip2 = new Tooltip("$ tooltip");
        tooltip.setFont(new Font("Arial", 32));
        cb2.setTooltip(tooltip2);
        cb2.selectedProperty().addListener(new ChangeListener<Boolean>() {
            public void changed(ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) {
                System.out.println(cb2.isSelected());
                if (cb2.isSelected()==true){
                    System.out.println(name3.getText());
                }
            }
        });

        //按钮点击事件
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
        grid.add(cb,0,1);
        grid.add(name2,1,1);
        grid.add(cb2,0,2);
        grid.add(name3,1,2);
        GridPane.setMargin(button, new Insets(0,0,0,30));
        //grid.getChildren().addAll(name,button);
        grid.setAlignment(Pos.CENTER);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }
}
