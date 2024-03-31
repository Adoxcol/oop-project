/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package insurance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rayed Mahmud
 */


public class MainDashboardController implements Initializable {
    
    @FXML
    private Button uploadSongButton ; // Declare the login Button    
    
    @FXML
    private Button scheduleTourButton; 
          
    @FXML
    private Button reviewLyricsButton; 
 
    @FXML
    private Button merchandiseSalesButton; 
    
    @FXML
    private Button bandAvailabilityButton; 
    
    @FXML
    private Button setListButton; 
    
    @FXML
    private Button createAnnouncementButton; 
    
    @FXML
    private Button prepareConcertButton; 
    
    @FXML
    private Button logOutButton; 
    
    @FXML
    private void handleSongButtonAction() { // New login action method

        // For now, we're just printing the entered values for simplicity
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UploadSong.fxml"));
            Parent dashboardRoot = loader.load();
            Scene scene = new Scene(dashboardRoot);
            Stage primaryStage = (Stage) uploadSongButton.getScene().getWindow();
            primaryStage.setScene(scene);
        }
        catch(IOException e){
            System.out.println("Login Failed");
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        uploadSongButton.setOnAction(e-> {
        handleSongButtonAction();
        });
    }    
    
}
