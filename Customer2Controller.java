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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Customer2Controller implements Initializable {

    @FXML
    private Button Back;

     @FXML
    private TableColumn<Budget, String> amnt;

    @FXML
    private TextField amount;

    @FXML
    private TableColumn<Budget, String> cid;

    @FXML
    private TextField id;

    @FXML
    private TableView<Budget> table;

    @FXML
    void ADD(ActionEvent event) {
        if (id != null && amount != null) {
        Budget b = new Budget(id.getText(), amount.getText());
        table.getItems().add(b);
    } else {
        // Handle the case where one or more text fields are null
        System.err.println("One or more text fields are null.");
    }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cid.setCellValueFactory(new PropertyValueFactory<>("dep"));
        amnt.setCellValueFactory(new PropertyValueFactory<>("exp"));
    }    

    @FXML
    private void Back2(ActionEvent event) {
         try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("dashboard2.fxml");
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
