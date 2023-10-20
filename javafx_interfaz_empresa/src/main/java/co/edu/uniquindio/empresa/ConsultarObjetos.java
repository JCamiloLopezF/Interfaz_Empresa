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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConsultarObjetos extends Application {

    @Override
    public void start(Stage consultarObjetosWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        TextField nombreObjeto = new TextField();
        nombreObjeto.setPromptText("Ingrese el nombre del objeto");
        
        Label etiquetaNombreProducto = new Label("Nombre del Objeto");
        etiquetaNombreProducto.setTranslateY(-200);

        VBox contenedorVBoxNombreProducto = new VBox();
        contenedorVBoxNombreProducto.getChildren().addAll(nombreObjeto);
        contenedorVBoxNombreProducto.setTranslateY(200);
        
        Button consultarProductoButton = new Button("consultar Producto");
        consultarProductoButton.setTranslateY(150);

        Button consultarNombreObjeto = new Button("Buscar");

        consultarNombreObjeto.setOnAction(event ->{
            MostrarNombreObjetoConsultado mostrarObjetoWindow = new MostrarNombreObjetoConsultado();
            mostrarObjetoWindow.start(consultarObjetosWindow);
            });

        Button buscar = new Button("Buscar");

        buscar.setOnAction(event -> {
            boolean nombreObjetoValido = !nombreObjeto.getText().isEmpty();
            switch (evaluarCampos(nombreObjetoValido)){
                case "ÉXITO":
                MostrarNombreObjetoConsultado mostrarObjetoWindow = new MostrarNombreObjetoConsultado();
                mostrarObjetoWindow.start(consultarObjetosWindow);
                break;
                case "ERROR_PRÉSTAMO":
                mostrarAdvertencia("¡Este campo es obligatorio!", "El campo del Id del préstamo es un campo obligatorio");
                break;
        }
        });

        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(nombreObjeto, buscar ,etiquetaNombreProducto);
        crearRecuadroPequeñoPane.setMaxWidth(250);

        raiz.setCenter(crearRecuadroPequeñoPane);

    
        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);
        
        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(consultarObjetosWindow);
        });


        Scene scene = new Scene(raiz, 1920, 780);

        consultarObjetosWindow.setScene(scene);
        consultarObjetosWindow.setTitle("Gestionar Productos: Consultar Objetos");
        consultarObjetosWindow.show();
    }

    
        private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    //Sirve para evaluar que cada campo esté lleno y si no es así lanza un error en pantalla
    private String evaluarCampos(boolean objetoValido){
        if (objetoValido){
            return "ÉXITO";}// Todos los campos llenos
        else if (!objetoValido){
            return "ERROR_OBJETO";}//Nombre vacío

        return "ERROR ERUJ-43897";//Para cubrir otros tipos de errores no contemplados en los else if
        }
}
