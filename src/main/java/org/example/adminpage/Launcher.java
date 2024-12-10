package org.example.adminpage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {

    private Stage primaryStage; // Declare a reference to the primary stage

    @Override
    public void start(Stage stage) throws IOException {
        // Save a reference to the primary stage
        this.primaryStage = stage;

        // Load the FXML file for the login screen
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1521, 800);

        // Set up the stage
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    // Controller-related fields and methods
    @FXML
    private Button LogInBtn;

    @FXML
    void handleLogIn(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Category.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1521, 800);

            // Update the primary stage with the new scene
            primaryStage.setTitle("Category Page");
            primaryStage.setScene(scene);
            primaryStage.show();

            System.out.println("Login button clicked!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
