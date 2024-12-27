package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.adminpage.DaoImpl.CategoryDao;
import org.example.adminpage.DaoImpl.FoodDao;
import org.example.adminpage.Model.Food;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {

    @FXML
    private JFXButton MenuItemsBTN;

    @FXML
    private JFXButton StocksBTN;

    @FXML
    private Circle clip;

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView img;

    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField priceField;

    @FXML
    private Label priceLabel;

    @FXML
    private TextField stockField;

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

    @FXML
    private ComboBox<String> categoryBox;

    private CategoryDao categoryDao;
    private File file;
    private FoodDao foodDao;

    //TODO: Implement every edge case in this page.

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void saveBTN(){
        if(nameField.getText().isEmpty() || priceField.getText().isEmpty() || stockField.getText().isEmpty()) {
            showError("Please fill in all fields");
        }else if(categoryBox.getValue() == null) {
            showError("Please select a category");
        }else if(file == null) {
            showError("Please select an image");
        }else if(!stockField.getText().matches("[0-9]+")){
            showError("Please enter a valid stock number");
        }else{
            saveImage(file, "C:/Users/Sean Rommel E/Documents/Back Up Codes/VDatabase/src/main/resources/pic_resources/new/" + file.getName());

            Food food = new Food();
            food.setCategoryId(categoryDao.getCategoryId(categoryBox.getValue()));
            food.setName(nameField.getText());
            food.setPrice(BigDecimal.valueOf(Integer.parseInt(priceField.getText())));
            food.setStock(Integer.parseInt(stockField.getText()));
            food.setImgSrc("C:/Users/Sean Rommel E/Documents/Back Up Codes/VDatabase/src/main/resources/pic_resources/new/"+file.getName());

            foodDao.addFood(food);
            showError("Product added successfully");

        }

    }

    public void cancelBTN(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMenu.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void setImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        file = fileChooser.showOpenDialog(null);
        if(file != null){
            img.setImage(new javafx.scene.image.Image(file.toURI().toString()));
            nameLabel.setText(nameField.getText());
            priceLabel.setText("₱ " + priceField.getText());
            System.out.println(categoryBox.getValue());
        }else{
            showError("Please select an image");
        }
    }

    private void saveImage(File sourceFile, String destinationPath) {
        try {
            Files.copy(sourceFile.toPath(), Path.of(destinationPath), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image saved to: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
            showError("Failed to save image");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        foodDao = new FoodDao();
        categoryDao = new CategoryDao();
        categoryBox.getItems().addAll(categoryDao.getAllCategoryNames());




    }
}
