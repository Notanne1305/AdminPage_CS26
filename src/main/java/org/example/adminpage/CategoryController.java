package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CategoryController {

    @FXML
    private JFXButton MenuItemsBTN;

    @FXML
    private JFXButton StocksBTN;

    @FXML
    private JFXButton cancelBTN;

    @FXML
    private Label categoryLabel;

    @FXML
    private Circle clip;

    @FXML
    private JFXButton imageBtn;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView img;

    @FXML
    private TextField nameField;

    @FXML
    private JFXButton saveBtn;


    @FXML
    void handleBackDashboard(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void showMenuItems(ActionEvent event) {

        try{
            System.out.println("MenuItems button clicked!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMenu.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void showStocks(ActionEvent event) {
        try{
            System.out.println("Stocks button clicked!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Stocks.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
