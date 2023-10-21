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

public class EliminarObjeto extends Application {

    @Override
    public void start(Stage eliminarObjetoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        //Se crea un campo donde se puede ingresar texto
        TextField nombreObjeto = new TextField();
        //Se le coloca una marca de agua al campo donde se ingresa el texto
        nombreObjeto.setPromptText("Ingrese el ID del objeto");

         //Se crea un campo donde se puede ingresar texto
        TextField cantidadStock = new TextField();
        //Se le coloca una marca de agua al campo donde se ingresa el texto
        cantidadStock.setPromptText("Ingrese la cantidad de unidades a eliminar");
            
        //Crear un texto o etiqueta, en este caso se pone encima del TextField nombreObjeto
        Label etiquetaNombreProducto = new Label("ID del Objeto");
        etiquetaNombreProducto.setTranslateY(-200);

        Label etiquetaCantidadStock = new Label("Unidades que desea eliminar");
        etiquetaCantidadStock .setTranslateY(-100);

        //Contenedor para poder trasladar más cómodamente el nombreObjeto
        VBox contenedorVBoxNombreProducto = new VBox();
        contenedorVBoxNombreProducto.getChildren().addAll(nombreObjeto);
        contenedorVBoxNombreProducto.setTranslateY(200);

        VBox contenedorVBoxCantidadStock = new VBox();
        contenedorVBoxCantidadStock.getChildren().addAll(cantidadStock);
        contenedorVBoxCantidadStock.setTranslateY(300);

        Button eliminarProductoButton = new Button("Eliminar Producto");
        eliminarProductoButton.setTranslateY(150);

        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(etiquetaNombreProducto, etiquetaCantidadStock, contenedorVBoxNombreProducto, contenedorVBoxCantidadStock, eliminarProductoButton);
        crearRecuadroPequeñoPane.setMaxWidth(250);

         //Si se presiona el bóton y la elimiación es correcta, pasará a la ventana que muestra que el producto fue eliminado con éxito
        eliminarProductoButton.setOnAction(event -> {
            // Variables para rastrear el resultado de la validación
            boolean nombreValido = !nombreObjeto.getText().isEmpty();
            boolean cantidadStockDisponible = !cantidadStock.getText().isEmpty();

           // Usar un switch para manejar diferentes escenarios
            switch (evaluarCampos(nombreValido, cantidadStockDisponible)) {
                case "ÉXITO":
                    // Todos los campos están llenos y son válidos, pasar a la ventana de éxito
                    ObjetoEliminadoConExito objetoEliminadoConExitoWindow = new ObjetoEliminadoConExito();
                    objetoEliminadoConExitoWindow.start(eliminarObjetoWindow);
                    break;
                case "ERROR_NOMBRE":
                    // Mostrar advertencia para el campo de nombre
                    mostrarAdvertencia("¡Campo obligatorio!", "Ingrese un nombre válido");
                    break;
                case "ERROR_CANTIDAD_STOCK_DISPONIBLE":
                mostrarAdvertencia("¡Campo obligatorio!", "Ingrese una cantidad de stock disponible válida");
            }
            });
        
        raiz.setCenter(crearRecuadroPequeñoPane);

        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event ->{
            App welcomeUi = new App();
            welcomeUi.start(eliminarObjetoWindow);
        });

        raiz.setTop(volver);


        Scene scene = new Scene(raiz, 1920, 780);

        eliminarObjetoWindow.setScene(scene);
        eliminarObjetoWindow.setTitle("Gestionar Producto: Eliminar producto");
        eliminarObjetoWindow.show();
    }
    
           //Funcion para mostar una advertencia cuándo un campo no se llena
        private void mostrarAdvertencia(String titulo, String mensaje) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle(titulo);
            alert.setHeaderText(null);
            alert.setContentText(mensaje);
            alert.showAndWait();
}

    //Sirve para evaluar que cada campo esté lleno y si no es así lanza un error en pantalla
    private String evaluarCampos(boolean nombreValido, boolean cantidadStockValida){
        if (nombreValido && cantidadStockValida){
            return "ÉXITO";}// Todos los campos llenos
        else if (!nombreValido){
            return "ERROR_NOMBRE";}//Nombre vacío
        else if (!cantidadStockValida){
            return "ERROR_CÓDIGO";}//Código vacío

        return "ERROR ERUJ-43897";//Para cubrir otros tipos de errores no contemplados en los else if
        }
}

