package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MostrarPrestamoConsultado extends Application {

    @Override
    public void start(Stage mostrarPrestamoConsultadoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label mostrarPrestamoConsultado = new Label("El prestamo que buscó es: ");
        mostrarPrestamoConsultado.setTranslateY(-200);

        raiz.setCenter(mostrarPrestamoConsultado);

        Scene scene = new Scene(raiz, 1920, 780);

        mostrarPrestamoConsultadoWindow.setScene(scene);
        mostrarPrestamoConsultadoWindow.setTitle("Prestamo Encontrado");
        mostrarPrestamoConsultadoWindow.show();
        
    }
}

