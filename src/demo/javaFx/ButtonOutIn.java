package demo.javaFx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonOutIn extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new Group());
        stage.setWidth(300);
        stage.setHeight(190);

        VBox vbox = new VBox();
        vbox.setLayoutX(20);
        vbox.setLayoutY(20);

        final Button button = new Button("OK");

        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        System.out.println("mouse entered");
                    }
                });

        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        System.out.println("mouse out");
                    }
                });

        vbox.getChildren().add(button);
        ((Group) scene.getRoot()).getChildren().add(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
