package demo.javaFx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ShadowButton extends Application {

    DropShadow shadow = new DropShadow();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        //Scene是javaFX中的窗体、场景
        Scene scene = new Scene(new Group());
        stage.setTitle("Button Sample");
        stage.setWidth(300);
        stage.setHeight(190);

        //javaFX中的布局
        VBox vbox = new VBox();
        vbox.setLayoutX(20);
        vbox.setLayoutY(20);

        final Button button = new Button("Accept");

        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        button.setEffect(shadow);
                    }
                });

        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });

        vbox.getChildren().add(button);
        vbox.setSpacing(10);
        ((Group) scene.getRoot()).getChildren().add(vbox);

        stage.setScene(scene);
        stage.show();
    }
}
