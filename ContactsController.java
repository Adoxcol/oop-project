/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication18;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class ContactsController implements Initializable {

    @FXML
    private Button Back;
    @FXML
    private Button Signout1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back2(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Dashboard.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) Back.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
