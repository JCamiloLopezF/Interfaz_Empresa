module co.edu.uniquindio.empresa {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.empresa to javafx.fxml;
    exports co.edu.uniquindio.empresa;
}
