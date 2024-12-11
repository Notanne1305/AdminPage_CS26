package org.example.adminpage;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class AddProductCont implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       CategoryCB.setValue("All time favourites");
       CategoryCB.getItems().addAll("Chicken", "Burger","Beverages","Desserts","Breakfast Meal","Sides");;
    }

    @FXML
    private JFXComboBox<String> CategoryCB;

}
