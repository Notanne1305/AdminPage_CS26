package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.adminpage.DaoImpl.CategoryDao;
import org.example.adminpage.Model.Category;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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

    private File file;


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

    public void setImage(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg")
        );
        file = fileChooser.showOpenDialog(null);
        if(file != null){
            img.setImage(new javafx.scene.image.Image(file.toURI().toString()));
            categoryLabel.setText(nameField.getText());
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


    public void saveBTN() {
        CategoryDao categoryDao = new CategoryDao();
        if (nameField.getText().isEmpty()) {
            showError("Please enter a category name");
            return;
        }
        if (file == null) {
            showError("Please select an image");
            return;
        }
        if (categoryDao.checkDuplicateCategory(nameField.getText())) {
            showError("Category already exists");
        } else {
            Category category = new Category();
            category.setCategoryName(nameField.getText());
            category.setCategoryImage("C:/Users/Sean Rommel E/Documents/Back Up Codes/VDatabase/src/main/resources/pic_resources/new/"+file.getName());

            saveImage(file, "C:/Users/Sean Rommel E/Documents/Back Up Codes/VDatabase/src/main/resources/pic_resources/new/" + file.getName());
            System.out.println("Category name: " + nameField.getText());
            System.out.println("Image path: " + file.getPath());
            categoryDao.createCategory(category);
            showError("Category added successfully");

            nameField.setText("");
            img.setImage(null);
            file = null;
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


    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
