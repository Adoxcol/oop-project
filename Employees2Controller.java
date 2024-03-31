/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxapplication18;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Employees2Controller implements Initializable {

    @FXML
    private Button Back;
    @FXML
    private TableColumn< Employees, String> Names;

    @FXML
    private TableColumn< Employees, String> Salaries;

    @FXML
    private Label label;

    @FXML
    private TableView< Employees> table;
    
    @FXML
    private final ObservableList<Employees> dataList = FXCollections.observableArrayList();


    

    @FXML
    void pay(ActionEvent event) {
        Employees selectedLeave = table.getSelectionModel().getSelectedItem();
        if (selectedLeave != null) {
            System.out.println("**"+selectedLeave.getNam3() + " salary sent ");
            label.setText("**"+selectedLeave.getNam3() + " salary sent ");
        } else {
            System.out.println("Please select a row before accepting.");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Names.setCellValueFactory(new PropertyValueFactory<>("nam3"));
       Salaries.setCellValueFactory(new PropertyValueFactory<>("sal"));
        
       dataList.add(new Employees("Mukesh Ambani","56,900"));
       dataList.add(new Employees("Bill Gates","20,000"));
       dataList.add(new Employees("Warren Buffet","9,000"));
       dataList.add(new Employees("Elon Musk","99,000"));
       dataList.add(new Employees("Dorbesh","99,000"));
       dataList.add(new Employees("Gautam Adani","16,000"));
       table.setItems(dataList);
         
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
