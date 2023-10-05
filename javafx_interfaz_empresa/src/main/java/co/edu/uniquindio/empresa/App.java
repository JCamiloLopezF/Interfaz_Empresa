package co.edu.uniquindio.empresa;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Crear un contenedor raíz (por ejemplo, BorderPane)
        Parent root = loadFXML("primary");

        // Crear un Pane y establecer la imagen de fondo
        Pane pane = new Pane();
        Image backgroundImage = new Image("file:/Users/macbook/Desktop/Camilo/Repositorios/Interfaz_Empresa/Interfaz_Empresa/javafx_interfaz_empresa/Imágenes/background_empresa.png"); // Cambiar por la ruta de la imagen de acuerdo al computador de cada uno
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage background = new BackgroundImage(backgroundImage, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background backgroundWithImage = new Background(background);
        pane.setBackground(backgroundWithImage);

        // Agregar el contenedor raíz y el Pane con la imagen de fondo al StackPane
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(pane, root);

        // Configurar la escena
        scene = new Scene(stackPane, 1920, 1080);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
