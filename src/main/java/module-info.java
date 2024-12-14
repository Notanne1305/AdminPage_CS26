module org.example.adminpage {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.jfoenix;
    requires java.desktop;

    opens org.example.adminpage to javafx.fxml;
    exports org.example.adminpage;
}