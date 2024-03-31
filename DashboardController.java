/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication18;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class DashboardController implements Initializable {

    @FXML
    private Button NO;
    @FXML
    private Button Report;
    @FXML
    private Button SalesAct;
    @FXML
    private Button ASS;
    @FXML
    private Button Staff;
    @FXML
    private Button Signout;
    
    @FXML
   
    private void switchToNOScene() {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("newOrder.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) NO.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
   
    private void switchToSecondScene() {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("SalesAct.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage)  SalesAct.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
    
    
    @FXML
   
    private void switchToReportScene() {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Report.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) Report.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
   
    private void switchToStaffScene() {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("salesAgent.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) Staff.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    void handleExitButton(ActionEvent event) {
       

        // Exit the application
        Platform.exit();
        System.exit(0);
    }
}
