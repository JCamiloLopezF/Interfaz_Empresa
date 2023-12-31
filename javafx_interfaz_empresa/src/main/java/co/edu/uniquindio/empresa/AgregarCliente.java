package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AgregarCliente extends Application {

    @Override
    public void start(Stage anadirClienteWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        //Se crea un campo donde se puede ingresar texto
        TextField nombreCliente = new TextField();
        //Se le coloca una marca de agua al campo donde se ingresa el texto
        nombreCliente.setPromptText("Ingrese el nombre del cliente");
        nombreCliente.setTranslateY(-150);

        TextField codigoCliente = new TextField();
        codigoCliente.setPromptText("Ingrese el código del cliente");
        codigoCliente.setTranslateY(-65);

        TextField direccionResidencia = new TextField();
        direccionResidencia.setPromptText("Ingrese la dirección de residencia");
        direccionResidencia.setTranslateY(85);
        //Crear un texto o etiqueta, en este caso se pone encima del TextField nombreCliente
        Label etiquetaNombreCliente = new Label("Nombre del cliente");
        etiquetaNombreCliente.setTranslateY(-200);

        Label etiquetaCodigoCliente = new Label("Código cliente");
        etiquetaCodigoCliente.setTranslateY(-100);

        Label etiquetaDireccionResidencia = new Label("Dirección de residencia");
        etiquetaDireccionResidencia.setTranslateY(50);
        //Contenedor para poder trasladar más cómodamente el nombreCliente

        //Crear un selector para que el usuario elija el tipo de documento
        ChoiceBox<String> selectorDocumentoID = new ChoiceBox<>(FXCollections.observableArrayList("Cédula", "Pasaporte", "Cédula de Extranjería"));
        selectorDocumentoID.setTranslateY(-250);

        Label etiquetaSelectorDocumentoID = new Label("Seleccione");
        etiquetaSelectorDocumentoID.setTranslateY(-277);
        //Selector para elegir el género
        ChoiceBox<String> selectorGenero = new ChoiceBox<>(FXCollections.observableArrayList("Femenino", "Masculino", "Otro", "Prefiero no decirlo"));
        selectorGenero.setTranslateY(0);

        Label etiquetaSelectorGenero = new Label("Seleccione");
        etiquetaSelectorGenero.setTranslateY(-25);
        //Se crea el botón para añadir el cliente
        Button agregarClienteButton = new Button("Agregar Cliente");
        agregarClienteButton.setTranslateY(150);
        //Dentro de este Pane se agrega todo para poder acomodar toda la escena, o en pocas palabras modificar el tamaño y posición de todos los elementos conjuntos
        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(nombreCliente, etiquetaNombreCliente,codigoCliente, etiquetaCodigoCliente, selectorDocumentoID, etiquetaSelectorDocumentoID, selectorGenero, etiquetaSelectorGenero, direccionResidencia, etiquetaDireccionResidencia, agregarClienteButton);
        crearRecuadroPequeñoPane.setMaxWidth(250);
        //Si se presiona el bóton y el registro es correcto, pasará a la ventana que muestra que el cliente fue creado con éxito
        agregarClienteButton.setOnAction(event -> {
            // Variables para rastrear el resultado de la validación
            boolean nombreValido = !nombreCliente.getText().isEmpty();
            boolean codigoValido = !codigoCliente.getText().isEmpty();
            boolean direccionValida = !direccionResidencia.getText().isEmpty();
        
            // Usar un switch para manejar diferentes escenarios
            switch (evaluarCampos(nombreValido, codigoValido, direccionValida)) {
                case "ÉXITO":
                    // Todos los campos están llenos y son válidos, pasar a la ventana de éxito
                    ClienteCreadoConExito clienteCreadoConExitoWindow = new ClienteCreadoConExito();
                    clienteCreadoConExitoWindow.start(anadirClienteWindow);
                    break;
                case "ERROR_NOMBRE":
                    // Mostrar advertencia para el campo de nombre
                    mostrarAdvertencia("¡Campo obligatorio!", "Ingrese un nombre válido");
                    break;
                case "ERROR_CÓDIGO":
                    // Mostrar advertencia para el campo de código
                    mostrarAdvertencia("¡Campo obligatorio!", "Ingrese un código válido");
                    break;
                case "ERROR_DIRECCIÓN":
                    // Mostrar advertencia para el campo de dirección
                    mostrarAdvertencia("¡Campo obligatorio!", "Ingrese una dirección válida");
                    break;
            }
        });
        

        raiz.setCenter(crearRecuadroPequeñoPane);

        Button volver = new Button("<--");
        volver.setMaxWidth(40);

        volver.setOnAction(event ->{
            App welcomeUi = new App();
            welcomeUi.start(anadirClienteWindow);
        });

        raiz.setTop(volver);


        Scene scene = new Scene(raiz, 1920, 780);

        anadirClienteWindow.setScene(scene);
        anadirClienteWindow.setTitle("Gestionar Clientes: Agregar Cliente");
        anadirClienteWindow.show();
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
    private String evaluarCampos(boolean nombreValido, boolean codigoValido, boolean direccionValida){
        if (nombreValido && codigoValido && direccionValida){
            return "ÉXITO";}// Todos los campos llenos
        else if (!nombreValido){
            return "ERROR_NOMBRE";}//Nombre vacío
        else if (!codigoValido){
            return "ERROR_CÓDIGO";}//Código vacío
        else if (!direccionValida){
            return "ERROR_DIRECCIÓN";}//Dirección vacía

        return "ERROR ERUJ-43897";//Para cubrir otros tipos de errores no contemplados en los else if 
        }

        }




