package pl;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

// Glowna klasa. Rozszerza klase Application, dlatego Java FX wie, ze ma jej uzywac.
public class GlownaKlasa extends Application {

    //    Musimy nadpisac metode stary z klasy Application, aby wskazac JavieFX miejsce rozpoczecia dzialania.
    @Override
    public void start(Stage glownaScena) {
//        Ustawienie tytulu
        glownaScena.setTitle("Moja aplikacja");

        GridPane kratka = new GridPane();
        //        ustawienie parametrow kratki
        kratka.setAlignment(Pos.CENTER);
        kratka.setHgap(10);
        kratka.setVgap(10);
        kratka.setPadding(new Insets(25, 25, 25, 25));
        Scene scena = new Scene(kratka, 300, 300);
        glownaScena.setScene(scena);
        Text glownyTekst = new Text("Witaj! Podaj nazwe i haslo!");
//        Ustawienie rozmiaru czcionki.
        glownyTekst.setFont(Font.font(20));
//        Tutaj jest pokazane jak dzialaja indeksy: https://docs.oracle
// .com/javase/8/javafx/get-started-tutorial/img/login_gridlines_co.png
        kratka.add(glownyTekst, 0, 0, 2, 1);
        Label nazwaUzytkownika = new Label("Nazwa uzytkownika:");
//        Dodanie "Labelu" nazwaUzytkownika do kratki. Na pierwszym miejscu (0) jest numer kolumny, na drugim (1),
// jest nazwa wiersza.
        kratka.add(nazwaUzytkownika, 0, 1);

        TextField tekstNazwaUzytkownika = new TextField();
//        Dodanie elementu do kratki (rodzica) w odpowiednim miejscu (kolumna 1, wiersz 1).
        kratka.add(tekstNazwaUzytkownika, 1, 1);


        Label haslo = new Label("Haslo:");
//        Dodanie "Labelu" haslo do kratki na odpowiedniej pozycji (kolumna 0, wiersz 2).
        kratka.add(haslo, 0, 2);

//        Stowrzenie komponentu z wpisywaniem hasla.
        PasswordField poleHasla = new PasswordField();
        kratka.add(poleHasla, 1, 2);

        Button przyciskLogowania = new Button("Zaloguj!");
        kratka.add(przyciskLogowania, 1, 4);


//        Ustawinie akcji. Tutaj definiujemy co sie stanie, jak ktos kliknie na przycisk.
        przyciskLogowania.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent interakcjaUzytkownika) {
                if (SerwisUzytkownikow.czyUdaloSieZalogowac(tekstNazwaUzytkownika.getText(), poleHasla.getText())) {
                    OknoPoZalogowaniu.pokazOknoPoZalogowaniu();
                } else {
                    Alert blad = new Alert(Alert.AlertType.ERROR, "Nie udalo sie zalogowac. Sprawdz nazwe i/lub " +
                            "haslo.");
//                    pokaz okienko z bledem
                    blad.show();
                }
            }
        });

        Button przyciskRejestracij = new Button("Zarejestruj");
        kratka.add(przyciskRejestracij, 0, 4);

        przyciskRejestracij.setOnAction(klikniecie -> OknoRejestracji.pokazOknoRejestracji());

//        Tutaj zdefiniowano co sie stanie, gdy klikniemy prawym przyciskiem myszy w obszarze 'GridPane'
        kratka.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent klikniecie) {
//               Jezeli kliknieto prawym przyciskiem myszy
                if (klikniecie.getButton().equals(MouseButton.SECONDARY)) {
                    MenuRozwijane.pokazMenuROzwijane(klikniecie, kratka);
                }
            }
        });
        glownaScena.show();
    }


    // Tutaj uruchamiamy aplikacje.
    public static void main(String[] args) {
        launch(args);
    }
}
