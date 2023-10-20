package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        //Añadir una imagen:
        Image imagen = new Image("file:/Users/macbook/Desktop/Camilo/Repositorios/Interfaz_Empresa/Interfaz_Empresa/javafx_interfaz_empresa/Imágenes/Logo.png");
        //Mostrar la imagen:
        ImageView imagenView = new ImageView(imagen);
        imagenView.setFitWidth(240);
        imagenView.setFitHeight(140);
        raiz.setCenter(imagenView);
        imagenView.setTranslateX(-510);
        imagenView.setTranslateY(-295);

        // Crear el fondo
        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Scene scene = new Scene(raiz, 1920, 780);

        //Crea la barra de menú
        MenuBar barraDeMenu = new MenuBar();
        //Crear items dentro de las opciones que aparecen en la barra de menú
        Menu gestionarEmpleadosItem = new Menu("Gestionar Empleados");
        MenuItem anadirEmpleado = new MenuItem("Añadir Empleado");
        MenuItem consultarEmpleado = new MenuItem("Consultar Empleado");
        MenuItem eliminarEmpleado = new MenuItem("Eliminar Empleado");

        Menu gestionarProductosItem = new Menu("Gestionar Productos");
        MenuItem agregarObjeto = new MenuItem ("Agregar Objeto");
        MenuItem eliminarObjeto = new MenuItem("Eliminar Objeto");
        MenuItem mostrarObjetos = new MenuItem("Mostrar Objetos");

        Menu gestionarClientesItem = new Menu("Gestionar Clientes");
        MenuItem anadirCliente = new MenuItem("Añadir Cliente");
        MenuItem consultarCliente = new MenuItem("Consultar Cliente");
        MenuItem eliminarCliente = new MenuItem("Eliminar Cliente");

        Menu gestionarPrestamosItem = new Menu("Gestionar Préstamos");
        MenuItem realizarPrestamo = new MenuItem("Realizar Préstamo");
        MenuItem consultarPrestamos = new MenuItem("Consultar Préstamos");


        gestionarEmpleadosItem.getItems().addAll(anadirEmpleado, consultarEmpleado, eliminarEmpleado);
        barraDeMenu.getMenus().add(gestionarEmpleadosItem);
        barraDeMenu.getMenus().add(gestionarPrestamosItem);
        gestionarProductosItem.getItems().addAll(agregarObjeto, eliminarObjeto, mostrarObjetos);
        gestionarPrestamosItem.getItems().addAll(realizarPrestamo, consultarPrestamos);
        barraDeMenu.getMenus().add(gestionarProductosItem);
        gestionarClientesItem.getItems().addAll(anadirCliente, consultarCliente, eliminarCliente);
        barraDeMenu.getMenus().add(gestionarClientesItem);


        // Cambiar la fuente:
        gestionarEmpleadosItem.setStyle("-fx-font-family:'Branding'");
        gestionarPrestamosItem.setStyle("-fx-font-family: 'Branding'");
        gestionarProductosItem.setStyle("-fx-font-family: 'Branding'");
        gestionarClientesItem.setStyle("-fx-font-family: 'Branding'");

        //Inicializar la ventana si se presiona el botón que direcciona a ella:
        anadirEmpleado.setOnAction(event -> {
            // Crear y mostrar la ventana de "Agregar Empleados"
            AgregarEmpleado anadirEmpleadoWindow = new AgregarEmpleado();
            anadirEmpleadoWindow.start(welcomeUiStage);
        });

        consultarEmpleado.setOnAction(event -> {
            ConsultarEmpleado consultarEmpleadoWindow = new ConsultarEmpleado();
            consultarEmpleadoWindow.start(welcomeUiStage);
        });

        eliminarEmpleado.setOnAction(event -> {
            EliminarEmpleado eliminarEmpleadoWindow = new EliminarEmpleado();
            eliminarEmpleadoWindow.start(welcomeUiStage);
        });

        realizarPrestamo.setOnAction(event ->{
            RealizarPrestamo realizarPrestamoWindow = new RealizarPrestamo();
            realizarPrestamoWindow.start(welcomeUiStage);
        });

        consultarPrestamos.setOnAction(event ->{
            ConsultarPrestamos consultarPrestamosWindow = new ConsultarPrestamos();
            consultarPrestamosWindow.start(welcomeUiStage);
        });

        agregarObjeto.setOnAction(event ->{
            AgregarObjeto agregarObjetoWindow = new AgregarObjeto();
            agregarObjetoWindow.start(welcomeUiStage);
        });
        eliminarObjeto.setOnAction(event->{
            EliminarObjeto eliminarObjetoWindow = new EliminarObjeto();
            eliminarObjetoWindow.start(welcomeUiStage);
        });

        mostrarObjetos.setOnAction(event->{
            ConsultarObjetos consultarObjetosWindow = new ConsultarObjetos();
            consultarObjetosWindow.start(welcomeUiStage);
        });

        anadirCliente.setOnAction(event ->{
            AgregarCliente agregarClienteWindow = new AgregarCliente();
            agregarClienteWindow.start(welcomeUiStage);
        });

        consultarCliente.setOnAction(event->{
            ConsultarCliente consultarClienteWindow = new ConsultarCliente();
            consultarClienteWindow.start(welcomeUiStage);
        });

        eliminarCliente.setOnAction(event->{
            EliminarCliente eliminarClienteWindow = new EliminarCliente();
            eliminarClienteWindow.start(welcomeUiStage);
        });


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