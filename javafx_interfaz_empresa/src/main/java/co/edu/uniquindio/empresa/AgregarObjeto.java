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

        VBox contenedor = new VBox();
        contenedor.setSpacing(10);

        TextField nombreObjeto = new TextField();
        nombreObjeto.setPromptText("Ingrese el Producto");

        TextField cantidadStock = new TextField();
        cantidadStock.setPromptText("Ingrese la cantidad del que dispone");

        Label etiquetaNombreProducto = new Label("Producto");
        etiquetaNombreProducto.setTranslateY(5);

        Label etiquetaCantidadStock = new Label("Unidades Disponibles");
        etiquetaCantidadStock.setTranslateY(5);

        Button agregarProductoButton = new Button("Agregar Producto");

        Label mensajeError = new Label();
        mensajeError.setTextFill(Color.RED);

        agregarProductoButton.setOnAction(event -> {
            String nombreProducto = nombreObjeto.getText();
            String cantidadDisponible = cantidadStock.getText();

            if (nombreProducto.isEmpty() || cantidadDisponible.isEmpty()) {
                mostrarAdvertencia("¡Todos los campos son obligatorios!", "Ingrese un valor válido");
            } else {
                try {
                    int cantidad = Integer.parseInt(cantidadDisponible);

                    // Lógica para agregar el objeto (a implementar)
                    // Por ejemplo, si tienes una clase Objeto y un método para agregar, sería algo como:
                    // Objeto nuevoObjeto = new Objeto(nombreProducto, cantidad);
                    // empresa.agregarObjeto(nuevoObjeto);

                    // Mostrar mensaje de éxito en una nueva ventana
                    ObjetoCreadoConExito ObjetoCreadoConExitoWindow = new ObjetoCreadoConExito();
                    ObjetoCreadoConExitoWindow.start(agregarObjetoWindow);

                } catch (NumberFormatException e) {
                    // Si no se pudo convertir a número la cantidad
                    mensajeError.setText("La cantidad debe ser un número entero");
                    mensajeError.setTextFill(Color.RED);
                } catch (Exception e) {
                    // Otro tipo de error
                    mensajeError.setText("Error al agregar el objeto");
                    mensajeError.setTextFill(Color.RED);
                }
            }
        });

        contenedor.getChildren().addAll(etiquetaNombreProducto, nombreObjeto, etiquetaCantidadStock, cantidadStock, agregarProductoButton, mensajeError);

        StackPane recuadroPequenoCentrado = new StackPane();
        recuadroPequenoCentrado.getChildren().addAll(contenedor);
        recuadroPequenoCentrado.setMaxWidth(300);

        raiz.setCenter(recuadroPequenoCentrado);

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

    public static void main(String[] args) {
        launch(args);
    }
}
