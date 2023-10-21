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

public class ConsultarPrestamos extends Application {

    @Override
    public void start(Stage consultarPrestamosWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        TextField idPrestamo = new TextField();
        idPrestamo.setPromptText("Ingrese el ID del préstamo");
        idPrestamo.setTranslateY(-50);

        Label etiquetaIdPrestamo = new Label("ID del préstamo");
        etiquetaIdPrestamo.setTranslateY(-90);

        Button consultarIdPrestamo = new Button("Buscar");

        consultarIdPrestamo.setOnAction(event ->{
            MostrarPrestamoConsultado mostrarPrestamoWindow = new MostrarPrestamoConsultado();
            mostrarPrestamoWindow.start(consultarPrestamosWindow);
            });

        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        Button buscar = new Button("Buscar");
        
        buscar.setOnAction(event -> {
            boolean idPrestamoValido = !idPrestamo.getText().isEmpty();
            switch (evaluarCampos(idPrestamoValido)){
                case "ÉXITO":
                MostrarPrestamoConsultado mostrarPrestamoWindow = new MostrarPrestamoConsultado();
                mostrarPrestamoWindow.start(consultarPrestamosWindow);
                break;
                case "ERROR_PRÉSTAMO":
                mostrarAdvertencia("¡Este campo es obligatorio!", "El campo del Id del préstamo es un campo obligatorio");
                break;
        }
        });

        StackPane contenedorStackPane = new StackPane();
        contenedorStackPane.getChildren().addAll(idPrestamo, buscar, etiquetaIdPrestamo);
        contenedorStackPane.setMaxWidth(270);

        raiz.setCenter(contenedorStackPane);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(consultarPrestamosWindow);
        });


        Scene scene = new Scene(raiz, 1920, 780);

        consultarPrestamosWindow.setScene(scene);
        consultarPrestamosWindow.setTitle("Gestionar Préstamo(s): Consultar Préstamo(s)");
        consultarPrestamosWindow.show();
    }
    
    private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private String evaluarCampos(boolean idPrestamoValido){
        if (idPrestamoValido){
            return "ÉXITO";}// Todos los campos llenos
        else if (!idPrestamoValido){
            return "ERROR_PRÉSTAMO";}

        return "ERROR ERUJ-43897";//Para cubrir otros tipos de errores no contemplados en los else if
        }
}
