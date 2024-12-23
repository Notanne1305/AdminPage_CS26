package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.adminpage.DaoImpl.CategoryDao;
import org.example.adminpage.DaoImpl.FoodDao;
import org.example.adminpage.Model.Category;
import org.example.adminpage.Model.Food;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ManageMenuCont implements Initializable {

    @FXML
    private JFXButton CategoryBTN;

    @FXML
    private AnchorPane CategoryPane;

    @FXML
    private JFXButton ProductBTN;

    @FXML
    private TableView<Food> ProductsTable;

    @FXML
    private TableColumn<Food, Integer> productPriceColumn;

    @FXML
    private TableColumn<Food,String> productNameColumn;

    @FXML
    private TableColumn<Food,Integer> productIdColumn;

    @FXML
    private TableView<Category> CategoryTable;

    @FXML
    private TableColumn<Category,String> categoryNameColumn;

    @FXML
    private TableColumn<Category,Integer> categoryIdColumn;

    @FXML
    private JFXButton addCategoryBTN;

    @FXML
    private JFXButton addProductBTN;

    @FXML
    private JFXButton addMenuBTN;

    @FXML
    private JFXButton MenuBackBTN;
    
    private CategoryDao categoryDao;
    private FoodDao foodDao;

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

        List<Category> categories = categoryDao.getAllCategory();
        CategoryTable.getItems().clear();
        
        for(Category category: categories){
            CategoryTable.getItems().add(category);
        }


    }

    @FXML
    void showProductTable(ActionEvent event) {
        CategoryTable.setVisible(false);
        ProductsTable.setVisible(true);
        addCategoryBTN.setVisible(false);
        addProductBTN.setVisible(true);

        List<Food> foods = foodDao.getAllFood();
        ProductsTable.getItems().clear();

        for(Food food: foods){
            ProductsTable.getItems().add(food);
        }

    }

    @FXML
    void handleAddProduct(ActionEvent event) {
        try {
            // Load the FXML file
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProducts.fxml"));
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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        foodDao = new FoodDao();
        categoryDao = new CategoryDao();
        categoryIdColumn.setCellValueFactory(new PropertyValueFactory<Category, Integer>("categoryId"));
        categoryNameColumn.setCellValueFactory(new PropertyValueFactory<Category, String>("categoryName"));


        productIdColumn.setCellValueFactory(new PropertyValueFactory<Food, Integer>("categoryId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<Food, Integer>("price"));
    }
}
