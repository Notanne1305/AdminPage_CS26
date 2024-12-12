package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

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
    private JFXButton DessetsBTN;

    @FXML
    private JFXButton SidesBTN;

    @FXML
    private TableView<?> SidesTable;

    @FXML
    void showAllTimeFav(ActionEvent event) {
        AllTimeFavTable.setVisible(true);
    }

    @FXML
    void showBreakfastMenu(ActionEvent event) {
        BreakfastMenuTable.setVisible(true);
    }

    @FXML
    void showBurgerMenu(ActionEvent event) {
        BurgerTable.setVisible(true);
    }

    @FXML
    void showChickenMenu(ActionEvent event) {
        ChickenTable.setVisible(true);
    }

    @FXML
    void showDessertsMenu(ActionEvent event) {
        DessertsTable.setVisible(true);
    }

    @FXML
    void showSideMenu(ActionEvent event) {
        SidesTable.setVisible(true);

    }

}

