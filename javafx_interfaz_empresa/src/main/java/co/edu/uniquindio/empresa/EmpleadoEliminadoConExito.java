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

public class EmpleadoEliminadoConExito extends Application {
    @Override
    public void start(Stage empleadoEliminadoConExitoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label etiquetaEmpleadoEliminadoConExito = new Label("El empleado fue eliminado exitosamente");


        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event ->{
            EliminarCliente eliminarClienteWindow = new EliminarCliente();
            eliminarClienteWindow.start(empleadoEliminadoConExitoWindow);
        });

        raiz.setCenter(etiquetaEmpleadoEliminadoConExito);
        raiz.setTop(volver);

        Scene scene = new Scene(raiz, 1920, 780);

        empleadoEliminadoConExitoWindow.setScene(scene);
        empleadoEliminadoConExitoWindow.setTitle("Empleado eliminado con éxito");
        empleadoEliminadoConExitoWindow.show();
    
    }
}
