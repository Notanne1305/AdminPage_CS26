package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageMenuCont {

    @FXML
    private JFXButton CategoryBTN;

    @FXML
    private AnchorPane CategoryPane;

    @FXML
    private JFXButton ProductBTN;

    @FXML
    private TableView<?> ProductsTable;

    @FXML
    private TableView<?> CategoryTable;

    @FXML
    private JFXButton addCategoryBTN;

    @FXML
    private JFXButton addProductBTN;

    @FXML
    private JFXButton addMenuBTN;

    @FXML
    private JFXButton MenuBackBTN;

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
    void handleAddMenuItem(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProducts.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    void handleAddCategory(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddCategory.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void showCategoryTable(ActionEvent event) {
        CategoryTable.setVisible(true);
        ProductsTable.setVisible(false);
        addCategoryBTN.setVisible(true);
        addProductBTN.setVisible(false);

    }

    @FXML
    void showProductTable(ActionEvent event) {
        CategoryTable.setVisible(false);
        ProductsTable.setVisible(true);
        addCategoryBTN.setVisible(false);
        addProductBTN.setVisible(true);

    }

    @FXML
    void handleAddProduct(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMenu.fxml"));
            Parent root = fxmlLoader.load();

            // Get the current stage (window)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setAddProductBTNBTN(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMenu.fxml"));
            Parent root = fxmlLoader.load();

            // Get the current stage (window)
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
