package co.edu.uniquindio.empresa;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MostrarEmpleadoConsultado extends Application {

    @Override
    public void start(Stage mostrarEmpleadoConsultadoWindow) {
        BorderPane raiz = new BorderPane();

        BackgroundFill backgroundFill = new BackgroundFill(Color.web("#CCCCFF"), null, null);
        Background background = new Background(backgroundFill);
        raiz.setBackground(background);

        Label mostrarEmpleadoConsultado = new Label("El empleado que buscó es: ");// añadir el empleado
        mostrarEmpleadoConsultado.setTranslateY(-200);

        Button volver = new Button("Salir");
                
        volver.setOnAction(event -> {
            App welcomeUiStage = new App();
            welcomeUiStage.start(mostrarEmpleadoConsultadoWindow);
        });
    
        raiz.setCenter(mostrarEmpleadoConsultado);
        raiz.setTop(volver);

        Scene scene = new Scene(raiz, 1920, 780);

        mostrarEmpleadoConsultadoWindow.setScene(scene);
        mostrarEmpleadoConsultadoWindow.setTitle("Empleado Encontrado");
        mostrarEmpleadoConsultadoWindow.show();
        
    }
        
}
