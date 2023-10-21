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

public class EliminarEmpleado extends Application {

    @Override
    public void start(Stage eliminarEmpleadoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        //Se crea un campo donde se puede ingresar texto
        TextField nombreEmpleado = new TextField();
        //Se le coloca una marca de agua al campo donde se ingresa el texto
        nombreEmpleado.setPromptText("Ingrese el nombre del empleado");
        nombreEmpleado.setTranslateY(-150);

        TextField codigoEmpleado = new TextField();
        codigoEmpleado.setPromptText("Ingrese el código del empleado");
        codigoEmpleado.setTranslateY(-65);

        //Crear un texto o etiqueta, en este caso se pone encima del TextField nombreEmpleado
        Label etiquetaNombreEmpleado = new Label("Nombre del empleado");
        etiquetaNombreEmpleado.setTranslateY(-200);

        Label etiquetaCodigoEmpleado = new Label("Código empleado");
        etiquetaCodigoEmpleado.setTranslateY(-100);

        Button eliminarEmpleadoButton = new Button("Eliminar Empleado");
        eliminarEmpleadoButton.setTranslateY(150);

        StackPane crearRecuadro = new StackPane();
        crearRecuadro.getChildren().addAll(nombreEmpleado, codigoEmpleado, etiquetaNombreEmpleado, etiquetaCodigoEmpleado, eliminarEmpleadoButton);
        crearRecuadro.setMaxWidth(350);

        raiz.setCenter(crearRecuadro);

        eliminarEmpleadoButton.setOnAction(event ->{
            boolean nombreValido = !nombreEmpleado.getText().isEmpty();
            boolean codigoValido = !codigoEmpleado.getText().isEmpty();

            switch(evaluarCampos(nombreValido, codigoValido)){
                case "ÉXITO":
                EmpleadoEliminadoConExito empleadoEliminadoConExitoWindow = new EmpleadoEliminadoConExito();
                empleadoEliminadoConExitoWindow.start(eliminarEmpleadoWindow);
                break;
                case "ERROR_NOMBRE":
                    mostrarAdvertencia("¡Ingrese un nombre válido!", "El nombre no es válido, ingrese un valor");
                break;
                case "ERROR_CÓDIGO":
                    mostrarAdvertencia("¡Ingrese un código válido!", "El código no es válido, ingrese otro valor");
                break;
                case "EMPLEADO_NO_ENCONTRADO":
                    mostrarAdvertencia("Empleado no encontrado", "No fue posible encontrar el empleado, por favor compruebe los datos");
                break;

            }
        });
        
        
        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(eliminarEmpleadoWindow);
        });


        Scene scene = new Scene(raiz, 1920, 780);

        eliminarEmpleadoWindow.setScene(scene);
        eliminarEmpleadoWindow.setTitle("Gestionar Empleados: Eliminar Empleado");
        eliminarEmpleadoWindow.show();
    }
    
    private void mostrarAdvertencia(String titulo, String mensaje) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

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
