package customer;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class CustomerSupportController {
    
    @FXML
    private ListView<String> viewCustomerSupportList;
    

    @FXML
    private void customerInteraction(ActionEvent event) {
        // Logic for customer interaction
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Customer Interaction");
        alert.setContentText("Initiating customer interaction...");
        alert.showAndWait();
    }
    @FXML
    private void viewTasks(ActionEvent event) {
        // Logic to view tasks
        // Example: Retrieve and display tasks in the ListView
        viewCustomerSupportList.getItems().addAll("Task 1498", "Task 9482", "Task 3437");
    }

    @FXML
    private void viewtickets(ActionEvent event) {
        viewCustomerSupportList.getItems().addAll("Ticket 1995", "Ticket 9372", "Ticket 3764");
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