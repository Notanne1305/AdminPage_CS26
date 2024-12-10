package org.example.adminpage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    void cancelButton(MouseEvent event) {

    }

}
