package customer;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaymentController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic if needed
    }



    private void displayAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @FXML
    private void makepayment(ActionEvent event) {
        displayAlert("Payment Successful", "Payment has been successfully processed.");
    }

    @FXML
    private void updatepaymentmethod(ActionEvent event) {
        displayAlert("Payment Method Updated", "Your payment method has been successfully updated.");
    }

    @FXML
    private void paymenthistory(ActionEvent event) {
        displayAlert("Payment History", "Display payment history in a new window or dialog.");
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
