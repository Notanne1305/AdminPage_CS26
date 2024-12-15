package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInCont {

    @FXML
    private Button LogInBtn;

    @FXML
    private PasswordField PasswordTF;

    @FXML
    private TextField UsernameTF;

    @FXML
    private JFXButton CreateAccBTN;



    @FXML
    public void initilize(){
        Platform.runLater(() -> LogInBtn.requestFocus());
    }

    @FXML
    void handleLogIn(ActionEvent event) {

        String username = "admin";
        String password = "admin";

        if (UsernameTF.getText().equals(username) && PasswordTF.getText().equals(password)) {
            try {

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1521, 800);

                // Update the primary stage with the new scene
                Stage stage = new Stage();
                stage.setTitle("Dashboard Page");
                stage.setScene(scene);
                stage.show();

                Stage window = (Stage) LogInBtn.getScene().getWindow();
                window.close();

                System.out.println("Login button clicked!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (UsernameTF.getText().isBlank()) {
            UsernameTF.setStyle("-fx-border-color: red");
        } else if (PasswordTF.getText().isBlank()) {
            PasswordTF.setStyle("-fx-border-color: red");

        } else {
            System.out.println("Invalid username or password!");
            UsernameTF.setStyle("-fx-border-color: red");
            PasswordTF.setStyle("-fx-border-color: red");
        }

    }

    @FXML
    void showSignUp(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    }

