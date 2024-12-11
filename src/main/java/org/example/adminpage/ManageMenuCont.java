package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ManageMenuCont {

    @FXML
    private JFXButton CategoryBTN;

    @FXML
    private AnchorPane CategoryTable;

    @FXML
    private JFXButton ProductBTN;

    @FXML
    private JFXButton addCategoryBTN;

    @FXML
    private JFXButton addMenuBTN;


    private void toggleVisibility(boolean isCategoryVisible) {
        CategoryTable.setVisible(isCategoryVisible);
        addCategoryBTN.setVisible(isCategoryVisible);
        addMenuBTN.setVisible(!isCategoryVisible);
    }

    @FXML
    void showCategoryTable(ActionEvent event) {
        toggleVisibility(true);
    }

    @FXML
    void showProductTable(ActionEvent event) {
        toggleVisibility(false);
    }
}
