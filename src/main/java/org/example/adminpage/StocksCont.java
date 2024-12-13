package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class StocksCont {

    @FXML
    private JFXButton AllTimeFavBTN;
    @FXML
    private TableView<?> AllTimeFavTable;

    @FXML
    private JFXButton BreakfastMenuBTN;
    @FXML
    private TableView<?> BreakfastMenuTable;

    @FXML
    private JFXButton BurgerBTN;
    @FXML
    private TableView<?> BurgerTable;

    @FXML
    private JFXButton ChickenBTN;
    @FXML
    private TableView<?> ChickenTable;

    @FXML
    private TableView<?> DessertsTable;
    @FXML
    private JFXButton DessertsBTN;

    @FXML
    private JFXButton SidesBTN;
    @FXML
    private TableView<?> SidesTable;

    private Map<JFXButton, TableView<?>> buttonTableMap;

    @FXML
    private JFXButton StockBackButton;

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
    public void initialize() {
        // Initialize the button-to-table mapping for easy management
        buttonTableMap = new HashMap<>();
        buttonTableMap.put(AllTimeFavBTN, AllTimeFavTable);
        buttonTableMap.put(BreakfastMenuBTN, BreakfastMenuTable);
        buttonTableMap.put(BurgerBTN, BurgerTable);
        buttonTableMap.put(ChickenBTN, ChickenTable);
        buttonTableMap.put(DessertsBTN, DessertsTable);
        buttonTableMap.put(SidesBTN, SidesTable);
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        // Hide all tables
        buttonTableMap.values().forEach(table -> table.setVisible(false));

        // Show the table associated with the clicked button
        JFXButton clickedButton = (JFXButton) event.getSource();
        TableView<?> associatedTable = buttonTableMap.get(clickedButton);

        if (associatedTable != null) {
            associatedTable.setVisible(true);
        }
    }
}
