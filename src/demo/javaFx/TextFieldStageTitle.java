package demo.javaFx;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextFieldStageTitle extends Application {

    StringProperty title = new SimpleStringProperty();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextField titleTextField;
        titleTextField = new TextField();
        titleTextField.setText("Stage Coach");
        titleTextField.setPrefColumnCount(15);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().add(new Label("title:"));
        hBox.getChildren().add(titleTextField);

        Scene scene  = new Scene(hBox,270,270);
        title.bind(titleTextField.textProperty());

        stage.setScene(scene);
        stage.titleProperty().bind(title);


        stage.show();
    }
}
