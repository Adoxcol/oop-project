/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AccessEducationalResourcesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addartical(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Article");
        dialog.setHeaderText("Enter Article Details");
        dialog.setContentText("Enter article title:");
        dialog.showAndWait().ifPresent(title -> {
            System.out.println("Article Title: " + title);
            // You can perform actions with the entered title, such as adding it to a list, database, etc.
        });
        
    }

    @FXML
    private void addvideo(ActionEvent event) {
        
        // Logic to add a video
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Video");
        dialog.setHeaderText("Enter Video Details");
        dialog.setContentText("Enter video URL:");
        dialog.showAndWait().ifPresent(url -> {
            System.out.println("Video URL: " + url);
            // You can perform actions with the entered URL, such as saving it, playing the video, etc.
        });
    }

    @FXML
    private void addguideline(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Add Guideline");
        alert.setHeaderText(null);
        alert.setContentText("Guidelines can be added through a separate interface.");
        alert.showAndWait();
    }

    @FXML
    private void CS(ActionEvent event) {
        back();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
    

    public void back(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupportDashboard.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Support Dashboard");
            stage.show();
            
            // Optionally, you can close the current window if needed
            // 
            
        } catch (IOException e) {
            // Handle any exceptions here (e.g., show an error message)
            
        }
    }
    
}
