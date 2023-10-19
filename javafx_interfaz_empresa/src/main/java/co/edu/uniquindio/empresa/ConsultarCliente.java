package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConsultarCliente extends Application {

    @Override
    public void start(Stage consultarClienteWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        TextField numeroDeDocumentoCliente = new TextField();
        numeroDeDocumentoCliente.setPromptText("Ingrese el número de documento del ciente");

        Button buscar = new Button("Buscar");

        buscar.setOnAction(event -> {
            boolean numeroDocumentoValido = !numeroDeDocumentoCliente.getText().isEmpty();
            switch (evaluarCampos(numeroDocumentoValido)){
                case "ÉXITO":
                MostrarClienteConsultado mostrarClienteConsultadoWindow = new MostrarClienteConsultado();
                mostrarClienteConsultadoWindow.start(consultarClienteWindow);
                break;
                case "ERROR_DOCUMENTO":
                mostrarAdvertencia("¡Este campo es obligatorio!", "El campo de documento es un campo obligatorio");
        }
        });

        StackPane contenedorStackPane = new StackPane();
        contenedorStackPane.getChildren().addAll(numeroDeDocumentoCliente, buscar);
        contenedorStackPane.setMaxWidth(250);

        raiz.setCenter(contenedorStackPane);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(consultarClienteWindow);
        });

        Scene scene = new Scene(raiz, 1920, 780);

        consultarClienteWindow.setScene(scene);
        consultarClienteWindow.setTitle("Gestionar Clientes: Consultar Cliente");
        consultarClienteWindow.show();
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
