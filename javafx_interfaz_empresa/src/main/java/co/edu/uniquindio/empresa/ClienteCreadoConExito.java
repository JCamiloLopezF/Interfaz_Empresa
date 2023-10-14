package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClienteCreadoConExito extends Application {

    @Override
    public void start(Stage clienteCreadoConExitoWindow){

        BorderPane raiz = new BorderPane();
        
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label clienteCreadoConExitoLabel = new Label("El cliente fue agregado exitosamente");

        raiz.setCenter(clienteCreadoConExitoLabel);

        Scene scene = new Scene(raiz, 1920, 1080);

        clienteCreadoConExitoWindow.setScene(scene);
        clienteCreadoConExitoWindow.setTitle("Gestionar Clientes: Agregar Cliente");
        clienteCreadoConExitoWindow.show();
    }

}
