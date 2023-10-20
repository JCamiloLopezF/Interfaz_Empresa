package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MostrarClienteConsultado extends Application{

    @Override
    public void start(Stage mostrarClienteConsultadoWindow){
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label mostrarEmpleadoConsultado = new Label("El cliente que buscó es: ");// añadir el empleado
        mostrarEmpleadoConsultado.setTranslateY(-200);
        
        raiz.setCenter(mostrarEmpleadoConsultado);

        Scene scene = new Scene(raiz, 1920, 780);

        mostrarClienteConsultadoWindow.setScene(scene);
        mostrarClienteConsultadoWindow.setTitle("Cliente Encontrado");
        mostrarClienteConsultadoWindow.show();
        
    }

}
