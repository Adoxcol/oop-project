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
public class Expense2Controller implements Initializable {

    @FXML
    private Button Back;
    
    @FXML
    private TableColumn<EXPENSE2, String> department;

    @FXML
    private TextField departmentfeild;

    @FXML
    private TextField expenseFeild;

    @FXML
    private TableColumn<EXPENSE2, Integer> expenses;

    @FXML
    private TableView<EXPENSE2> table;

    @FXML
    private TextField totalexpense;

    @FXML
    void ADD(ActionEvent event) {
        if (departmentfeild != null && expenseFeild != null) 
            try {
                // Assuming expenseFeild is a TextField and it contains a valid integer
                int expenseValue = Integer.parseInt(expenseFeild.getText());

                EXPENSE2 exp = new EXPENSE2(departmentfeild.getText(), expenseValue);
                table.getItems().add(exp);
            } catch (NumberFormatException e) {
                System.err.println("Invalid expense value. Please enter a valid integer.");
            
            } else {
            System.err.println("One or more text fields are null.");
        }
    }

    

    

    @FXML
    void TotalExpense(ActionEvent event) {
        int totalExpense = 0;
        for (EXPENSE2 exp : table.getItems()) {
            totalExpense += exp.getTE(); // Assuming getTE() returns an integer
        }
        totalexpense.setText(String.valueOf(totalExpense));
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
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        department.setCellValueFactory(new PropertyValueFactory<>("dp"));
        expenses.setCellValueFactory(new PropertyValueFactory<>("TE"));
    } 
    
    
}
