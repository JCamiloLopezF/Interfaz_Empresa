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

public class PrestamoRealizado extends Application{
    @Override
    public void start(Stage prestamoRealizadoWindow){

        // Crear un contenedor principal de tipo BorderPane
        BorderPane raiz = new BorderPane();

        // Crear un objeto BackgroundFill para definir el fondo
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);

        // Crear un objeto Background que utilizará el BackgroundFill
        Background background = new Background(backgroundFill);

        // Establecer el fondo del contenedor principal raiz
        raiz.setBackground(background);

        //  muestra un mensaje en la interfaz de usuario cuando un producto ha sido agregado con éxito
        Label prestamoRealizadoLabel = new Label("El préstamo fue aprobado exitosamente, el ID del préstamo es: ");

        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event ->{
            AgregarObjeto agregarProductoWindow = new AgregarObjeto();
            agregarProductoWindow.start(prestamoRealizadoWindow);
        });

        // Ubica el contenido de productoCreadoConExitoLabel en el centro del contenedor raiz
        raiz.setCenter(prestamoRealizadoLabel);

        // Ubica el botón "volver" en la parte superior del contenedor raiz
        raiz.setTop(volver);

        Scene scene = new Scene(raiz, 1920, 780);

        prestamoRealizadoWindow.setScene(scene);
        prestamoRealizadoWindow.setTitle("Gestionar Productos: Producto Creado con Éxito");
        prestamoRealizadoWindow.show();
    }
}
