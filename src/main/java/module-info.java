module org.example.adminpage {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.adminpage to javafx.fxml;
    exports org.example.adminpage;
}