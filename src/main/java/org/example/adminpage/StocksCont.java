package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.adminpage.DaoImpl.KioskDao;
import org.example.adminpage.Model.Food;
import org.example.adminpage.Model.Item;

import java.util.List;

public class StocksCont {

    @FXML
    private JFXButton BreakfastMenuBTN;
    @FXML
    private JFXButton beveragesBTN;
    @FXML
    private TableView<Item> table;

    @FXML
    private JFXButton BurgerBTN;
    @FXML
    private JFXButton ChickenBTN;
    @FXML
    private JFXButton DessertsBTN;
    @FXML
    private JFXButton SidesBTN;
    @FXML
    private JFXButton StockBackButton;

    @FXML
    private TableColumn<Item, String> nameColumn;
    @FXML
    private TableColumn<Item, Integer> stockColumn;
    @FXML
    private TableColumn<Item, Integer> foodIdColumn;

    @FXML
    private TableColumn<Item, String> operation;

    @FXML
    private AnchorPane stockOperation;

    @FXML
    private TextField stockQuantityField;

    @FXML
    private JFXButton addBTN;

    @FXML
    private JFXButton removeBTN;
    private KioskDao kioskDao;
    private Item currentItem;


    @FXML
    void handleBackDashboard(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chickenView() {
        nameColumn.setText("Chicken");
        stockColumn.setText("Stock");
        List<Food> chicken = kioskDao.getFoodsByCategoryId(2);
        populateTable(chicken);
    }

    public void burgerView() {
        nameColumn.setText("Burger");
        List<Food> burger = kioskDao.getFoodsByCategoryId(3);
        populateTable(burger);
    }

    public void breakFastMenuView(){
        nameColumn.setText("Breakfast Menu");
        List<Food> breakFastMenu = kioskDao.getFoodsByCategoryId(5);
        populateTable(breakFastMenu);

    }
    public void beveragesView() {
        nameColumn.setText("Beverages");
        List<Food> beverages = kioskDao.getFoodsByCategoryId(4);
        populateTable(beverages);
    }

    public void dessertView() {
        nameColumn.setText("Dessert");
        List<Food> desserts = kioskDao.getFoodsByCategoryId(6);
        populateTable(desserts);
    }

    public void sidesView() {
        nameColumn.setText("Sides");
        List<Food> Sides = kioskDao.getFoodsByCategoryId(7);
        populateTable(Sides);

    }

    public void populateTable(List<Food> foods){
        table.getItems().clear();
        for (Food food : foods) {
            table.getItems().add(new Item(food.getName(), food.getStock(), food.getFoodId()));
        }
    }
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void onAddBTN(){
        stockOperation.setVisible(false);
        checkField(true);

    }

    private void onRemoveBTN(){
        stockOperation.setVisible(false);
        checkField(false);

    }

private void checkField(boolean add) {
    System.out.println(currentItem.getFoodId());
    if (stockQuantityField.getText().isEmpty()) {
        showError("Please fill in the quantity field");
    } else if (!stockQuantityField.getText().matches("[0-9]+")) {
        showError("Please enter a valid number");
    } else if (Integer.parseInt(stockQuantityField.getText()) <= 0) {
        showError("Please enter a valid number");
    } else if (currentItem != null) {
        int quantity = Integer.parseInt(stockQuantityField.getText());
        if (add) {
            kioskDao.updateStock(currentItem.getFoodId(), quantity);
            currentItem.setStock(kioskDao.getStockByFoodId(currentItem.getFoodId()));
            showError("Operation Successful");
        } else if (!add && currentItem.getStock() >= quantity) {
            kioskDao.subtractStock(currentItem.getFoodId(), quantity);
            currentItem.setStock(kioskDao.getStockByFoodId(currentItem.getFoodId()));
            showError("Operation Successful");
        }else{
            showError("Operation Failed. Invalid amount");
        }
        table.refresh();
        stockQuantityField.setText("");
    } else {
        showError("Operation Failed");
    }
}

    @FXML
    public void initialize() {
        kioskDao = new KioskDao();
        // Initialize the table columns

        foodIdColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("foodId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Item, String>("name"));
        stockColumn.setCellValueFactory(new PropertyValueFactory<Item, Integer>("stock"));

        // Add button handlers
        BreakfastMenuBTN.setOnAction(event -> breakFastMenuView());
        BurgerBTN.setOnAction(event -> burgerView());
        ChickenBTN.setOnAction(event -> chickenView());
        DessertsBTN.setOnAction(event -> dessertView());
        SidesBTN.setOnAction(event -> sidesView());
        beveragesBTN.setOnAction(event -> beveragesView());

        addBTN.setOnAction(event -> onAddBTN());
        removeBTN.setOnAction(event -> onRemoveBTN());

        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                currentItem = newSelection;
                stockOperation.setVisible(true);
            }
        });
    }
}