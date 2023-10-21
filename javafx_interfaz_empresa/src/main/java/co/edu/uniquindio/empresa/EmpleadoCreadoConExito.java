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

public class EmpleadoCreadoConExito extends Application {

    @Override
    public void start(Stage empleadoAgregadoConExitoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label empleadoAgregadoConExitoLabel = new Label("El empleado fue agregado exitosamente");

        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event ->{
            AgregarEmpleado agregarEmpleadoWindow = new AgregarEmpleado();
            agregarEmpleadoWindow.start(empleadoAgregadoConExitoWindow);
        });

        raiz.setCenter(empleadoAgregadoConExitoLabel);
        raiz.setTop(volver);

        Scene scene = new Scene(raiz, 1920, 780);

        empleadoAgregadoConExitoWindow.setScene(scene);
        empleadoAgregadoConExitoWindow.setTitle("Empleado Agregado con Éxito");
        empleadoAgregadoConExitoWindow.show();
    }

}
