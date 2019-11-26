package pl;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OknoRejestracji {

    static void pokazOknoRejestracji() {
        GridPane kratka = new GridPane();
        kratka.setStyle("-fx-background-color: linear-gradient(#2A5058, #61a2b1)");
        final Stage oknoDialogowe = new Stage();
        kratka.setPadding(new Insets(25, 25, 25, 25));
        Label nazwaUzytkownika = new Label("Nazwa uzytkownika:");
        TextField tekstNazwaUzytkownika = new TextField();
        kratka.add(nazwaUzytkownika, 1, 1);
        kratka.add(tekstNazwaUzytkownika, 1, 2);

        Label haslo = new Label("Haslo:");
        PasswordField poleHasla = new PasswordField();
        kratka.add(haslo, 1, 4);
        kratka.add(poleHasla, 1, 5);
        Button przyciskRejestracji = new Button("Rejestruj!");
        kratka.add(przyciskRejestracji, 1, 6);
// TUTAJ WYWOLUJEMY REJESTRACJE UZYTKOWNIKA
        przyciskRejestracji.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean rejestracjaUdana = SerwisUzytkownikow
                        .rejestruj(tekstNazwaUzytkownika.getText(), poleHasla.getText());
                if (rejestracjaUdana) {
                    new Alert(Alert.AlertType.INFORMATION, "Rejestracja powiodla sie").show();
                    oknoDialogowe.close();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Uzytkownik o takiej nazwie juz istnieje!").show();
                }
            }
        });
        Scene scena = new Scene(kratka, 300, 200);
        oknoDialogowe.setScene(scena);
        oknoDialogowe.show();
    }
}
