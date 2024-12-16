package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.adminpage.DaoImpl.LoginDao;
import org.example.adminpage.Model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogInCont implements Initializable {

    @FXML
    private Button LogInBtn;

    @FXML
    private PasswordField PasswordTF;

    @FXML
    private TextField UsernameTF;

    @FXML
    private JFXButton CreateAccBTN;

    private LoginDao loginDao;



    @FXML
    public void initilize(){
        Platform.runLater(() -> LogInBtn.requestFocus());
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void handleLogIn(ActionEvent event) {
        if(UsernameTF.getText().isEmpty() || PasswordTF.getText().isEmpty()){
            showError("Please fill in all fields");
        }else{

            User user = new User();
            user.setUsername(UsernameTF.getText());
            user.setPassword(PasswordTF.getText());

            if (loginDao.findUser(user)) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginDao = new LoginDao();

    }
}

