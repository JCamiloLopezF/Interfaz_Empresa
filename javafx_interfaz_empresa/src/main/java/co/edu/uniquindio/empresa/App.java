package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage welcomeUiStage) { //Crear la ventana
        // Crear el contenedor o la raíz de toda la ventana
        BorderPane raiz = new BorderPane();

        // Crear el fondo
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Scene scene = new Scene(raiz, 1920, 1080);

        //Crea la barra de menú
        MenuBar barraDeMenu = new MenuBar();
        Menu gestionarEmpleadosItem = new Menu("Gestionar Empleados");
        Menu gestionarProductosItem = new Menu("Gestionar Productos");
        Menu gestionarClientesItem = new Menu("Gestionar Clientes");
        Menu gestionarPrestamosItem = new Menu("Gestionar Préstamos");
        barraDeMenu.getMenus().add(gestionarEmpleadosItem);
        barraDeMenu.getMenus().add(gestionarPrestamosItem);
        barraDeMenu.getMenus().add(gestionarProductosItem);
        barraDeMenu.getMenus().add(gestionarClientesItem);


        // Cambiar la fuente:
        gestionarEmpleadosItem.setStyle("-fx-font-family:'Branding'");
        gestionarPrestamosItem.setStyle("-fx-font-family: 'Branding'");
        gestionarProductosItem.setStyle("-fx-font-family: 'Branding'");
        gestionarClientesItem.setStyle("-fx-font-family: 'Branding'");

        // Cambiar el color de la barra de menú
        barraDeMenu.setStyle("-fx-background-color: #9999CC;");


        // Colocar la barra de menú arriba
        raiz.setTop(barraDeMenu);

        welcomeUiStage.setScene(scene);
        welcomeUiStage.setTitle("PréstamosBox");
        welcomeUiStage.show();
    }

    public static void main(String[] args) {// No sé qué hace, pero es importante, no lo borren pofavo'
        launch(args);
    }

    public static void setRoot(String string) {//También no sé que hace, pero hace que corra el programa :)
    }
}
