
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

import java.awt.event.MouseEvent;


public class DashBoardCont {

        @FXML
        private ImageView first_pic;

        @FXML
        private ImageView second_pic;

        @FXML
        private ImageView first_pic1;

        @FXML
        private ImageView second_pic1;

        @FXML
        private ImageView first_pic11;

        @FXML
        private ImageView second_pic11;

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
        public void initialize() {
                // Set clipping to the ImageView
                Circle clip = new Circle();
                clip.setCenterX(imageView.getFitWidth() / 2);
                clip.setCenterY(imageView.getFitHeight() / 2);
                clip.setRadius(Math.min(imageView.getFitWidth(), imageView.getFitHeight()) / 2);

                imageView.setClip(clip);
            }


            public void HeartReact(){
                first_pic.setVisible(false);
                second_pic.setVisible(true);

            }

            public void Heart() {
                    first_pic.setVisible(true);
                    second_pic.setVisible(false);
            }
            public void HeartReact1(){
                first_pic1.setVisible(false);
                second_pic1.setVisible(true);

            }

            public void Heart1() {
                first_pic1.setVisible(true);
                second_pic1.setVisible(false);
    }
            public void HeartReact11(){
                first_pic11.setVisible(false);
                second_pic11.setVisible(true);

            }

            public void Heart11() {
                first_pic11.setVisible(true);
                second_pic11.setVisible(false);
            }


    }


