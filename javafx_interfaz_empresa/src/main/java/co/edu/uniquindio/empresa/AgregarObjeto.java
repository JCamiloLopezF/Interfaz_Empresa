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

public class AgregarObjeto extends Application {

    @Override
    public void start(Stage agregarObjetoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        TextField nombreObjeto = new TextField();
        nombreObjeto.setPromptText("Ingrese el Producto");

        TextField cantidadStock = new TextField();
        cantidadStock.setPromptText("Ingrese la cantidad del que dispone");

        Label etiquetaNombreProducto = new Label("Producto");
        etiquetaNombreProducto.setTranslateY(50);

        Label etiquetaCantidadStock = new Label("Unidades Disponibles");
        etiquetaCantidadStock.setTranslateY(50);

        VBox contenedorVBoxNombreProducto = new VBox();
        contenedorVBoxNombreProducto.getChildren().addAll(nombreObjeto);
        contenedorVBoxNombreProducto.setTranslateY(300);

        VBox contenedorVBoxCantidadStock = new VBox();
        contenedorVBoxCantidadStock.getChildren().addAll(cantidadStock);
        contenedorVBoxCantidadStock.setTranslateY(300);

        Button agregarProductoButton = new Button("Agregar Producto");
        agregarProductoButton.setTranslateY(150);

        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(etiquetaNombreProducto, etiquetaCantidadStock, contenedorVBoxNombreProducto, contenedorVBoxCantidadStock, agregarProductoButton);

        agregarProductoButton.setOnAction(event->{
            String nombreProducto = nombreObjeto.getText();
            String cantidadDisponible = cantidadStock.getText();

            if (nombreProducto.isEmpty() || cantidadDisponible.isEmpty()){
                mostrarAdvertencia("¡Este campo es obligatorio!", "Ingrese un valor válido");}
            else {
            ProductoCreadoConExito productoCreadoConExitoWindow = new ProductoCreadoConExito();
            productoCreadoConExitoWindow.start(agregarObjetoWindow);}
         });

        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(agregarObjetoWindow);
        });

        Scene scene = new Scene(raiz, 1920, 780);

        agregarObjetoWindow.setScene(scene);
        agregarObjetoWindow.setTitle("Gestionar Productos: Agregar Objetos");
        agregarObjetoWindow.show();
    }
            

    private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
        }

}
