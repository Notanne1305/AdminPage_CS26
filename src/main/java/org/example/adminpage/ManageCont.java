package org.example.adminpage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ManageCont implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ManageCB.setValue("Manage");
        ManageCB.getItems().addAll("Category", "Products");
    }

    @FXML
    private ComboBox<String> ManageCB;

    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Button LogOutBTN;

    @FXML
    void cancelButton(MouseEvent event) {

    }

    @FXML
    void LogOutAction(ActionEvent event) {

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
