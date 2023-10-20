package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
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

        Button consultarEmpleado = new Button("Buscar");

        consultarEmpleado.setOnAction(event ->{
            MostrarEmpleadoConsultado mostrarEmpleadoWindow = new MostrarEmpleadoConsultado();
            mostrarEmpleadoWindow.start(consultarEmpleadoWindow);
        });

        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        Label numeroDeDocumentoEmpleadoLabel = new Label("Ingrese el número de documento del empleado");
        numeroDeDocumentoEmpleadoLabel.setTranslateY(-90);
        TextField numeroDeDocumentoEmpleado = new TextField();
        numeroDeDocumentoEmpleado.setPromptText("Ingrese el número de documento del empleado");
        numeroDeDocumentoEmpleado.setTranslateY(-50);

        Button buscar = new Button("Buscar");

        buscar.setOnAction(event -> {
            boolean numeroDocumentoValido = !numeroDeDocumentoEmpleado.getText().isEmpty();
            switch (evaluarCampos(numeroDocumentoValido)){
                case "ÉXITO":
                MostrarEmpleadoConsultado mostrarEmpleadoConsultadoWindow = new MostrarEmpleadoConsultado();
                mostrarEmpleadoConsultadoWindow.start(consultarEmpleadoWindow);
                break;
                case "ERROR_DOCUMENTO":
                mostrarAdvertencia("¡Este campo es obligatorio!", "El campo de nombre del objeto es un campo obligatorio");
        }
        });

        StackPane contenedorStackPane = new StackPane();
        contenedorStackPane.getChildren().addAll(numeroDeDocumentoEmpleado, buscar, numeroDeDocumentoEmpleadoLabel);
        contenedorStackPane.setMaxWidth(270);

        raiz.setCenter(contenedorStackPane);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(consultarEmpleadoWindow);
        });
 
        Scene scene = new Scene(raiz, 1920, 780);

        consultarEmpleadoWindow.setScene(scene);
        consultarEmpleadoWindow.setTitle("Gestionar Empleados: Consultar Empleado");
        consultarEmpleadoWindow.show();
    }
    
        private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private String evaluarCampos(boolean numeroDocumentoValido){
        if (numeroDocumentoValido){
            return "ÉXITO";}// Todos los campos llenos
        else if (!numeroDocumentoValido){
            return "ERROR_DOCUMENTO";}//Nombre vacío

        return "ERROR ERUJ-43897";//Para cubrir otros tipos de errores no contemplados en los else if
        }
}
