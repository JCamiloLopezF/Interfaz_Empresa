package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AgregarCliente extends Application {

    @Override
    public void start(Stage anadirClienteWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        MenuBar barraMenu = new MenuBar();
        Menu utilidades = new Menu("Utilidades");
        MenuItem devolverse = new MenuItem("Atrás");
        utilidades.getItems().addAll(devolverse);
        barraMenu.getMenus().add(utilidades);

        barraMenu.setStyle("-fx-background-color: #9999CC;");

        raiz.setTop(barraMenu);
        //si presiona la opción de "Atrás, en el menú, se devolverá a la ventana anterior, en este caso a la ventana de inicio"
        devolverse.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(anadirClienteWindow);
        });
        //Se crea un campo donde se puede ingresar texto
        TextField nombreCliente = new TextField();
        //Se le coloca una marca de agua al campo donde se ingresa el texto
        nombreCliente.setPromptText("Ingrese el nombre del cliente");

        TextField codigoCliente = new TextField();
        codigoCliente.setPromptText("Ingrese el código del cliente");
        //Crear un texto o etiqueta, en este caso se pone encima del TextField nombreCliente
        Label etiquetaNombreCliente = new Label("Nombre del cliente");
        etiquetaNombreCliente.setTranslateY(-200);

        Label etiquetaCodigoCliente = new Label("Código cliente");
        etiquetaCodigoCliente.setTranslateY(-100);
        //Contenedor para poder trasladar más cómodamente el nombreCliente
        VBox contenedorVBoxNombreCliente = new VBox();
        contenedorVBoxNombreCliente.getChildren().addAll(nombreCliente);
        contenedorVBoxNombreCliente.setTranslateY(200);

        VBox contenedorVBoxCodigoCliente = new VBox();
        contenedorVBoxCodigoCliente.getChildren().addAll(codigoCliente);
        contenedorVBoxCodigoCliente.setTranslateY(300);
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
        agregarClienteButton.setTranslateY(50);
        //Dentro de este Pane se agrega todo para poder acomodar toda la escena, o en pocas palabras modificar el tamaño y posición de todos los elementos conjuntos
        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(contenedorVBoxNombreCliente, etiquetaNombreCliente,contenedorVBoxCodigoCliente, etiquetaCodigoCliente, selectorDocumentoID, etiquetaSelectorDocumentoID, selectorGenero, etiquetaSelectorGenero, agregarClienteButton);
        crearRecuadroPequeñoPane.setMaxWidth(250);
        //Si se presiona el bóton y el registro es correcto, pasará a la ventana que muestra que el cliente fue creado con éxito
        agregarClienteButton.setOnAction(event->{
            ClienteCreadoConExito clienteCreadoConExitoWindow = new ClienteCreadoConExito();
            clienteCreadoConExitoWindow.start(anadirClienteWindow);
        });

        raiz.setCenter(crearRecuadroPequeñoPane);


        Scene scene = new Scene(raiz, 1920, 1080);

        anadirClienteWindow.setScene(scene);
        anadirClienteWindow.setTitle("Gestionar Clientes: Agregar Cliente");
        anadirClienteWindow.show();
    }
}
