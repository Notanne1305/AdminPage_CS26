package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

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
