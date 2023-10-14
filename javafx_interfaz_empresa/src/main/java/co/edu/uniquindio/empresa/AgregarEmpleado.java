package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AgregarEmpleado extends Application {

    @Override
    public void start(Stage anadirEmpleadoWindow) {
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
            welcomeUiStage.start(anadirEmpleadoWindow);
        });

        Scene scene = new Scene(raiz, 1920, 1080);

        anadirEmpleadoWindow.setScene(scene);
        anadirEmpleadoWindow.setTitle("Gestionar Empleados: Agregar Empleado");
        anadirEmpleadoWindow.show();
    }
}
