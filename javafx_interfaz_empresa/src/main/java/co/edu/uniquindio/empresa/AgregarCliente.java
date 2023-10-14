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

        devolverse.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(anadirClienteWindow);
        });

        TextField nombreCliente = new TextField();
        nombreCliente.setPromptText("Ingrese el nombre del cliente");

        TextField codigoCliente = new TextField();
        codigoCliente.setPromptText("Ingrese el código del cliente");

        Label etiquetaNombreCliente = new Label("Nombre del cliente");
        etiquetaNombreCliente.setTranslateY(-200);

        Label etiquetaCodigoCliente = new Label("Código cliente");
        etiquetaCodigoCliente.setTranslateY(-100);

        VBox contenedorVBoxNombreCliente = new VBox();
        contenedorVBoxNombreCliente.getChildren().addAll(nombreCliente);
        contenedorVBoxNombreCliente.setTranslateY(200);

        VBox contenedorVBoxCodigoCliente = new VBox();
        contenedorVBoxCodigoCliente.getChildren().addAll(codigoCliente);
        contenedorVBoxCodigoCliente.setTranslateY(300);

        ChoiceBox<String> selectorDocumentoID = new ChoiceBox<>(FXCollections.observableArrayList("Cédula", "Pasaporte", "Cédula de Extranjería"));
        selectorDocumentoID.setTranslateY(-250);

        Label etiquetaSelectorDocumentoID = new Label("Seleccione");
        etiquetaSelectorDocumentoID.setTranslateY(-277);

        ChoiceBox<String> selectorGenero = new ChoiceBox<>(FXCollections.observableArrayList("Femenino", "Masculino", "Otro", "Prefiero no decirlo"));
        selectorGenero.setTranslateY(0);

        Label etiquetaSelectorGenero = new Label("Seleccione");
        etiquetaSelectorGenero.setTranslateY(-25);

        Button agregarClienteButton = new Button("Agregar Cliente");
        agregarClienteButton.setTranslateY(50);

        StackPane crearRecuadroPequeñoPane = new StackPane();
        crearRecuadroPequeñoPane.getChildren().addAll(contenedorVBoxNombreCliente, etiquetaNombreCliente,contenedorVBoxCodigoCliente, etiquetaCodigoCliente, selectorDocumentoID, etiquetaSelectorDocumentoID, selectorGenero, etiquetaSelectorGenero, agregarClienteButton);
        crearRecuadroPequeñoPane.setMaxWidth(250);

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
