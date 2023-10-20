package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MostrarNombreObjetoConsultado extends Application {
    @Override
    public void start(Stage mostrarNombreObjetoConsultadoWindow){
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label mostrarObjetoConsultado = new Label("El objeto que buscó es: ");

        raiz.setCenter(mostrarObjetoConsultado);

        Scene scene = new Scene(raiz, 1920, 780);

        mostrarNombreObjetoConsultadoWindow.setScene(scene);
        mostrarNombreObjetoConsultadoWindow.setTitle("Objeto encontrado");
        mostrarNombreObjetoConsultadoWindow.show();
    }
}
