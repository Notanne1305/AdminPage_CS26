package org.example.adminpage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageMenuLauncher extends Application {

    private Stage PrimaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        this.PrimaryStage = stage;

        // Load the FXML file for the login screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1521, 800);
        stage.setTitle("ManageMenu");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
