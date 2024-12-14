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

public class ManageMenuCont {

    @FXML
    private JFXButton CategoryBTN;

    @FXML
    private AnchorPane CategoryPane;

    @FXML
    private TableView<?> CategoryTable1;

    @FXML
    private JFXButton ProductBTN;

    @FXML
    private TableView<?> ProductsTable;

    @FXML
    private JFXButton addCategoryBTN;

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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProduct.fxml"));
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
        CategoryPane.setVisible(true);
        addCategoryBTN.setVisible(true);

    }

    @FXML
    void showProductTable(ActionEvent event) {
        CategoryPane.setVisible(false);
        addCategoryBTN.setVisible(false);
        addMenuBTN.setVisible(true);

    }

}
