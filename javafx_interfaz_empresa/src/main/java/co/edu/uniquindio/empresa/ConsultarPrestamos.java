package co.edu.uniquindio.empresa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConsultarPrestamos extends Application {

    @Override
    public void start(Stage consultarPrestamosWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);
        
        Button volver = new Button("<--");
        volver.setMaxWidth(40);
        raiz.setTop(volver);

        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(consultarPrestamosWindow);
        });


        Scene scene = new Scene(raiz, 1920, 1080);

        consultarPrestamosWindow.setScene(scene);
        consultarPrestamosWindow.setTitle("Gestionar Préstamo(s): Consultar Préstamo(s)");
        consultarPrestamosWindow.show();
    }
}
