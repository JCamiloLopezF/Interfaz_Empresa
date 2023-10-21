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
//Im eating, por si las moscas :D;
public class EliminarCliente extends Application {

    @Override
    public void start(Stage eliminarClienteWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        // Se crea un campo donde se puede ingresar texto
        TextField nombreCliente = new TextField();
        // Se le coloca una marca de agua al campo donde se ingresa el texto
        nombreCliente.setPromptText("Ingrese el nombre del cliente");
        nombreCliente.setTranslateY(-150);

        TextField codigoCliente = new TextField();
        codigoCliente.setPromptText("Ingrese el código del cliente");
        codigoCliente.setTranslateY(-65);

        // Crear un texto o etiqueta, en este caso se pone encima del TextField nombreCliente
        Label etiquetaNombreCliente = new Label("Nombre del cliente");
        etiquetaNombreCliente.setTranslateY(-200);

        Label etiquetaCodigoCliente = new Label("Código cliente");
        etiquetaCodigoCliente.setTranslateY(-100);

        // Se crea el botón para eliminar el cliente
        Button eliminarClienteButton = new Button("Eliminar Cliente");
        eliminarClienteButton.setTranslateY(150);

        // Dentro de este Pane se agrega todo para poder acomodar toda la escena, o en pocas palabras modificar el tamaño y posición de todos los elementos conjuntos
        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(nombreCliente, etiquetaNombreCliente, codigoCliente, etiquetaCodigoCliente, eliminarClienteButton);
        crearRecuadroPequeñoPane.setMaxWidth(250);
        raiz.setCenter(crearRecuadroPequeñoPane);

        // Si se presiona el botón y el registro es correcto, pasará a la ventana que muestra que el cliente fue eliminado con éxito
        eliminarClienteButton.setOnAction(event -> {
            // Variables para rastrear el resultado de la validación
            boolean nombreValido = !nombreCliente.getText().isEmpty();
            boolean codigoValido = !codigoCliente.getText().isEmpty();

            // Usar un switch para manejar diferentes escenarios
            switch (evaluarCampos(nombreValido, codigoValido)) {
                case "ÉXITO":
                    // Todos los campos están llenos y son válidos, pasar a la ventana de éxito
                    ClienteEliminadoConExito clienteEliminadoConExitoWindow = new ClienteEliminadoConExito();
                    clienteEliminadoConExitoWindow.start(eliminarClienteWindow);
                break;
                case "ERROR_NOMBRE":
                    // Mostrar advertencia para el campo de nombre
                    mostrarAdvertencia("¡Campo obligatorio!", "Ingrese un nombre válido");
                break;
                case "ERROR_CÓDIGO":
                    // Mostrar advertencia para el campo de código
                    mostrarAdvertencia("¡Campo obligatorio!", "Ingrese un código válido");
                    break;
                case "CLIENTE_NO_ENCONTRADO":

                    mostrarAdvertencia("El cliente no se encontró", "No fue posible encontrar al cliente al que busca");
                    break;
            }
        });

        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(eliminarClienteWindow);
        });

        Scene scene = new Scene(raiz, 1920, 780);

        eliminarClienteWindow.setScene(scene);
        eliminarClienteWindow.setTitle("Gestionar Clientes: Eliminar Cliente");
        eliminarClienteWindow.show();
    }

    // Función para mostrar una advertencia cuando un campo no se llena
    private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Sirve para evaluar que cada campo esté lleno y si no es así, lanza un error en pantalla
    private String evaluarCampos(boolean nombreValido, boolean codigoValido) {
        if (nombreValido && codigoValido) {
            return "ÉXITO"; // Todos los campos llenos
        } else if (!nombreValido) {
            return "ERROR_NOMBRE"; // Nombre vacío
        } else if (!codigoValido) {
            return "ERROR_CÓDIGO"; // Código vacío
        }

        return "ERROR ERUJ-43897"; // Para cubrir otros tipos de errores no contemplados en los else if
    }
}
