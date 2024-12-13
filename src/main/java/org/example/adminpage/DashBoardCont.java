
package org.example.adminpage;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DashBoardCont {

        @FXML
        private ImageView imageView;

        @FXML
        private JFXButton DashboardBTN;

        @FXML
        private JFXButton MenuItemsBTN;

        @FXML
        private JFXButton StocksBTN;

        @FXML
        void showMenuItems(ActionEvent event) {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageMenu.fxml"));
                Parent root = fxmlLoader.load();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    @FXML
        void showStocks(ActionEvent event) {
            try{
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
        public void initialize() {
            // Create a circular clip
            Circle clip = new Circle();

            // Set the center and radius of the circle based on ImageView dimensions
            clip.setCenterX(imageView.getFitWidth() / 2); // Center horizontally
            clip.setCenterY(imageView.getFitHeight() / 2); // Center vertically
            clip.setRadius(Math.min(imageView.getFitWidth(), imageView.getFitHeight()) / 2); // Smaller dimension

            // Apply the clip to the ImageView
            imageView.setClip(clip);
        }
    }


