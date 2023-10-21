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

public class RealizarPrestamo extends Application {

    @Override
    public void start(Stage realizarPrestamoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        TextField idProducto = new TextField();
        idProducto.setPromptText("Ingrese el ID del producto");
        idProducto.setTranslateY(-100);

        Label idProductoLabel = new Label("Ingrese el ID del produto");
        idProductoLabel.setTranslateY(-150);

        TextField cantidadDeUnidades = new TextField();
        cantidadDeUnidades.setPromptText("Ingrese la cantidad de unidades a prestar");

        Label cantidadDeUnidadesLabel = new Label("Ingrese la cantidad de unidades a prestar");
        cantidadDeUnidadesLabel.setTranslateY(-50);

        Button realizarPrestamo = new Button("Realizar préstamo");
        realizarPrestamo.setTranslateY(50);

        realizarPrestamo.setOnAction(event -> {
            boolean idProductoValida = !idProducto.getText().isEmpty();
            boolean cantidadStockValida = !cantidadDeUnidades.getText().isEmpty();

            switch(evaluarCampos(idProductoValida, cantidadStockValida)){
                case "ÉXITO":
                PrestamoRealizado prestamoRealizadoWindow = new PrestamoRealizado();
                prestamoRealizadoWindow.start(realizarPrestamoWindow);
                break;
                case "ERROR_ID":
                mostrarAdvertencia("El producto no fue encontrado", "Ingrese una ID válida");
                break;
                case "ERROR_CANTIDAD":
                mostrarAdvertencia("La cantidad de productos que desea eliminar no es posible", "Ingrese un cantidad válida de productos a eliminar");
                break;
            }
        });

        StackPane contenedor = new StackPane();
        contenedor.getChildren().addAll(idProducto, idProductoLabel, cantidadDeUnidades, cantidadDeUnidadesLabel, realizarPrestamo);
        contenedor.setMaxWidth(400);

        raiz.setCenter(contenedor);


        
        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(realizarPrestamoWindow);
        });


        Scene scene = new Scene(raiz, 1920, 780);

        realizarPrestamoWindow.setScene(scene);
        realizarPrestamoWindow.setTitle("Gestionar Préstamo(s): Realizar Préstamo(s)");
        realizarPrestamoWindow.show();
    }
    
    private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
}

//Sirve para evaluar que cada campo esté lleno y si no es así lanza un error en pantalla
private String evaluarCampos(boolean idProductoValida, boolean cantidadValida){
    if (idProductoValida && cantidadValida){
        return "ÉXITO";}// Todos los campos llenos
    else if (!idProductoValida){
        return "ERROR_ID";}//Nombre vacío
    else if (!cantidadValida){
        return "ERROR_CANTIDAD";}//Código vacío

    return "ERROR ERUJ-43897";//Para cubrir otros tipos de errores no contemplados en los else if
    }

}
