package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class EliminarCliente extends Application {

    @Override
    public void start(Stage eliminarClienteWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);
        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(eliminarClienteWindow);
        });


        Scene scene = new Scene(raiz, 1920, 1080);

        eliminarClienteWindow.setScene(scene);
        eliminarClienteWindow.setTitle("Gestionar Clientes: Eliminar Cliente");
        eliminarClienteWindow.show();
    }
}
