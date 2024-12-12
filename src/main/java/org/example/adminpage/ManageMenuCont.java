package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
