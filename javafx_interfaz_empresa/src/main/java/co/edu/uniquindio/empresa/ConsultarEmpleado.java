package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConsultarEmpleado extends Application {

    @Override
    public void start(Stage consultarEmpleadoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        TextField codigoEmpleado = new TextField();
        codigoEmpleado.setPromptText("Ingrese el código del empleado");

        Label etiquetaCodigoEmpleado = new Label("Código del empleado");
        etiquetaCodigoEmpleado.setTranslateY(-200);

        VBox contenedorVBoxCodigoEmpleado = new VBox();
        contenedorVBoxCodigoEmpleado.getChildren().addAll(codigoEmpleado);
        contenedorVBoxCodigoEmpleado.setTranslateY(-200);

        Button consultarEmpleado = new Button("Buscar");

        consultarEmpleado.setOnAction(event ->{
            MostrarEmpleadoConsultado mostrarEmpleadoWindow = new MostrarEmpleadoConsultado();
            mostrarEmpleadoWindow.start(consultarEmpleadoWindow);
        });

        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(consultarEmpleadoWindow);
        });


        Scene scene = new Scene(raiz, 1920, 780);

        consultarEmpleadoWindow.setScene(scene);
        consultarEmpleadoWindow.setTitle("Gestionar Empleados: Consultar Empleado");
        consultarEmpleadoWindow.show();
    }
}
