package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpCont {

    @FXML
    private TextField UsernameTF;

    @FXML
    private JFXButton SigInBTN;

    @FXML
    private TextField UseremailTF;

    @FXML
    private PasswordField PasswordTF;

    @FXML
    private PasswordField ConfirmPasswordTF;

    @FXML
    private JFXButton CreateAccountBTN;

    @FXML
    private ImageView emailIcon;

    @FXML
    private ImageView passwordIcon;

    @FXML
    private ImageView confirmPasswordIcon;

    @FXML
    private Text signUpText;

    @FXML
    private Text poweredByText;

    /**
     * This method handles the "Create Account" button action.
     * It validates the input fields and provides feedback to the user.
     */
    @FXML
    private void handleCreateAccountAction() {
        String username = UsernameTF.getText();
        String email = UseremailTF.getText();
        String password = PasswordTF.getText();
        String confirmPassword = ConfirmPasswordTF.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            System.out.println("All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            return;
        }

        // TODO: Add logic for creating an account (e.g., saving user info to a database)
        System.out.println("Account created successfully for: " + username);
    }

    /**
     * Initialize method is automatically called after the FXML is loaded.
     * You can use this to set up event listeners or initialize UI components.
     */
    @FXML
    private void initialize() {
        System.out.println("LogInCont initialized.");
        // Optional: Add placeholder setup or focus listeners here
    }

    @FXML
    void showSignIn(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
