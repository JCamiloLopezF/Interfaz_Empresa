package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProductoEliminadoConExito extends Application {

    @Override
    public void start(Stage productoEliminadoConExitoWindow){

        BorderPane raiz = new BorderPane();
        
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label productoEliminadoConExitoLabel = new Label("El producto fue eliminado exitosamente");

        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event ->{
            AgregarCliente agregarClienteWindow = new AgregarCliente();
            agregarClienteWindow.start(productoEliminadoConExitoWindow);
        });

        raiz.setCenter(productoEliminadoConExitoLabel);
        raiz.setTop(volver);

        Scene scene = new Scene(raiz, 1920, 780);

        productoEliminadoConExitoWindow.setScene(scene);
        productoEliminadoConExitoWindow.setTitle("Gestionar Clientes: Agregar Cliente");
        productoEliminadoConExitoWindow.show();
    }

}