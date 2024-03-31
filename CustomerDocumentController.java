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
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class CustomerDocumentController implements Initializable {

    @FXML
    private ListView<?> showarealist;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void downloaddocument(ActionEvent event) {
    }

    @FXML
    private void updatedocument(ActionEvent event) {
    }

    @FXML
    private void deletedocument(ActionEvent event) {
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
