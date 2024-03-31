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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ContactCustomerSupportController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void callnow(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Calling Now");
        alert.setContentText("Initiating a phone call...");
        alert.showAndWait();
    }

    @FXML
    private void emailnow(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sending Email");
        alert.setContentText("Opening email client...");
        alert.showAndWait();
    }

    @FXML
    private void livechat(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Live Chat");
        alert.setContentText("Initiating live chat...");
        alert.showAndWait();
    }

    @FXML
    private void CD(ActionEvent event) {
        LoginPage();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    public void LoginPage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Customer Dashboard.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Customer Dashboard");
            stage.show();
            
            // Optionally, you can close the current window if needed
            // 
            
        } catch (IOException e) {
            // Handle any exceptions here (e.g., show an error message)
            
        }
    }
    
}
