package co.edu.uniquindio.empresa;
import javafx.application.Application;
import javafx.scene.Scene;
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

public class AgregarEmpleado extends Application {

    @Override
    public void start(Stage anadirEmpleadoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        VBox contenedor = new VBox();
        contenedor.setSpacing(10);

        TextField nombreEmpleado = new TextField();
        nombreEmpleado.setPromptText("Ingrese el nombre del empleado");

        TextField codigoEmpleado = new TextField();
        codigoEmpleado.setPromptText("Ingrese el código del empleado");

        TextField emailEmpleado = new TextField();
        emailEmpleado.setPromptText("Ingrese el email del empleado");

        TextField experienciaEmpleado = new TextField();
        experienciaEmpleado.setPromptText("Ingrese los años de experiencia");

        Label etiquetaNombreEmpleado = new Label("Nombre del Empleado");
        etiquetaNombreEmpleado.setTextFill(Color.BLACK); // Establecer el color del texto
        etiquetaNombreEmpleado.setTranslateY(5);

        Label etiquetaCodigoEmpleado = new Label("Código del Empleado");
        etiquetaCodigoEmpleado.setTextFill(Color.BLACK); // Establecer el color del texto
        etiquetaCodigoEmpleado.setTranslateY(5);

        Label etiquetaEmailEmpleado = new Label("Email del Empleado");
        etiquetaEmailEmpleado.setTextFill(Color.BLACK); // Establecer el color del texto
        etiquetaEmailEmpleado.setTranslateY(5);

        Label etiquetaExperienciaEmpleado = new Label("Años de Experiencia");
        etiquetaExperienciaEmpleado.setTextFill(Color.BLACK); // Establecer el color del texto
        etiquetaExperienciaEmpleado.setTranslateY(5);

        Button agregarEmpleadoButton = new Button("Agregar Empleado");

        Label mensajeError = new Label();
        mensajeError.setTextFill(Color.RED);

        agregarEmpleadoButton.setOnAction(event -> {
            String nombre = nombreEmpleado.getText();
            String codigo = codigoEmpleado.getText();
            String email = emailEmpleado.getText();
            String experienciaText = experienciaEmpleado.getText();

            if (nombre.isEmpty() || codigo.isEmpty() || email.isEmpty() || experienciaText.isEmpty()) {
                mensajeError.setText("Todos los campos son obligatorios");
                mensajeError.setTextFill(Color.RED);
            } else {
                try {
                    int experiencia = Integer.parseInt(experienciaText);

                    // Lógica para agregar el empleado (a implementar)
                    // Por ejemplo, si tienes una clase Empleado y un método para agregar, sería algo como:
                    // Empleado nuevoEmpleado = new Empleado(nombre, codigo, email, experiencia);
                    // empresa.agregarEmpleado(nuevoEmpleado);

                    // Mostrar mensaje de éxito en una nueva ventana
                    EmpleadoCreadoConExito empleadoCreadoConExitoWindow = new EmpleadoCreadoConExito();
                    empleadoCreadoConExitoWindow.start(anadirEmpleadoWindow);

                } catch (NumberFormatException e) {
                    // Si no se pudo convertir a número la experiencia
                    mensajeError.setText("Los años de experiencia deben ser un número entero");
                    mensajeError.setTextFill(Color.RED);
                } catch (Exception e) {
                    // Otro tipo de error
                    mensajeError.setText("Error al agregar el empleado");
                    mensajeError.setTextFill(Color.RED);
                }
            }
        });

        contenedor.getChildren().addAll(etiquetaNombreEmpleado, nombreEmpleado, etiquetaCodigoEmpleado, codigoEmpleado, etiquetaEmailEmpleado, emailEmpleado, etiquetaExperienciaEmpleado, experienciaEmpleado, agregarEmpleadoButton, mensajeError);

        StackPane recuadroPequenoCentrado = new StackPane();
        recuadroPequenoCentrado.getChildren().addAll(contenedor);
        recuadroPequenoCentrado.setMaxWidth(300);

        raiz.setCenter(recuadroPequenoCentrado);

        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event -> {
            App welcomeUi = new App();
            welcomeUi.start(anadirEmpleadoWindow);
        });

        raiz.setTop(volver);

        Scene scene = new Scene(raiz, 1920, 780);

        anadirEmpleadoWindow.setScene(scene);
        anadirEmpleadoWindow.setTitle("Agregar Empleado");
        anadirEmpleadoWindow.show();
    }
}

