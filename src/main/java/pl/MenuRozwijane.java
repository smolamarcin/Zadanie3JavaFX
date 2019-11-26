package pl;

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


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
    }

    private static void zmienTlo(GridPane kratka) {
//        jezeli klikniemy, to zmieniami kolor elementu kratka
        kratka.setStyle("-fx-background-color: #CCFF99");
    }

    private static void wyswieltInfoOAutorze() {
        GridPane kratka = new GridPane();
        kratka.setStyle("-fx-background-color: linear-gradient(#2A5058, #61a2b1)");
        final Stage oknoDialogowe = new Stage();
        kratka.setPadding(new Insets(25, 25, 25, 25));
        Text tekst = new Text("AUTOR :)");
        tekst.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        kratka.add(tekst, 1, 1);
        Scene scena = new Scene(kratka, 1000, 200);
        oknoDialogowe.setScene(scena);
        oknoDialogowe.show();
    }
}
