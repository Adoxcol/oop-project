package customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerDashboardController implements Initializable {

    private Stage mainStage; // Reference to the main stage

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }

    @FXML
    void Payment(ActionEvent event) {
        openFXMLInterface("Payment.fxml", "Payment");
    }

    @FXML
    void ReportAClaim(ActionEvent event) {
        openFXMLInterface("ReportAClaim.fxml", "Report a Claim");
    }

    @FXML
    void requestaquote(ActionEvent event) {
        openFXMLInterface("RequestAQuote.fxml", "Request a Quote");
    }

    @FXML
    void requestpolicy(ActionEvent event) {
        openFXMLInterface("RequestPolicy.fxml", "Request Policy");
    }

    @FXML
    void updatecontact(ActionEvent event) {
        openFXMLInterface("UpdateContactInformation.fxml", "Update Contact Information");
    }

    @FXML
    void viewpolicy(ActionEvent event) {
        openFXMLInterface("ViewPolicyInformation.fxml", "View Policy Information");
    }
    
    @FXML
    void ContractSupport(ActionEvent event) {
        openFXMLInterface("ContactCustomerSupport.fxml", "Contract Customer Support");
    }

    @FXML
    void CencelInsurance(ActionEvent event) {
        openFXMLInterface("CancelInsurance.fxml", "Cancel Insurance");
        
    }
    
    private void openFXMLInterface(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            mainStage.setScene(new Scene(root));
            mainStage.setTitle(title);
            mainStage.show();
        } catch (IOException e) {
            // Handle exception (e.g., show an error dialog)
            
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    

    

}
