
package org.example.adminpage;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

    public class DashBoardCont {

        @FXML
        private ImageView imageView;

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


