package pl;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.PopupBuilder;
import javafx.stage.Stage;

import java.time.Duration;

import static java.lang.Math.random;


public class MenuRozwijane {

    static void pokazMenuROzwijane(MouseEvent event, GridPane kratka) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem pierwszy = new MenuItem("Informacje o autorze");
//        Definicja tego co sie stanie, gdy klikniemy pierwszy przycisk w menu
        pierwszy.setOnAction(klikniecie -> {
            wyswieltInfoOAutorze();
        });
        MenuItem drugi = new MenuItem("Zmien tlo");
        drugi.setOnAction(klikniecie -> {
            zmienTlo(kratka);
        });
        contextMenu.getItems().addAll(pierwszy, drugi);
        contextMenu.show(kratka, event.getScreenX(), event.getScreenY());

//        jesli klikniemyna na kratke 'GridPane', to zamykamy menu
        kratka.setOnMouseClicked(klikniecie ->
                contextMenu.hide()
        );
    }

    private static void zmienTlo(GridPane kratka) {
//        jezeli klikniemy, to zmieniami kolor elementu kratka
        kratka.setStyle("-fx-background-color: #CCFF99");
    }

    private static void wyswieltInfoOAutorze() {
        Stage oknoDialogowe = new Stage();
        Group glownyElement = new Group();
        Scene scene = new Scene(glownyElement, 800, 600, Color.BLACK);
        oknoDialogowe.setScene(scene);
        Circle circle = new Circle(150, Color.web("white", 0.05));

        glownyElement.getChildren().add(circle);
//        tutaj tylko pokazanie
        oknoDialogowe.show();
    }
}
