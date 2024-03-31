package customer;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PolicyInquiryController implements Initializable {

    @FXML
    private TableView<Quote> quoteTableView;


    private TableColumn<Quote, String> quoteRequestColumn;

    @FXML
    private TableView<Quote> addingCoverageTableView;


    private TableColumn<Quote, String> addingCoverageRequestColumn;

    @FXML
    private TableView<Quote> changingBeneficiariesTableView;


    private TableColumn<Quote, String> changingBeneficiariesRequestColumn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize columns for quote table
        quoteRequestColumn.setCellValueFactory(cellData -> cellData.getValue().quoteTextProperty());

        // Initialize columns for Adding Coverage table
        addingCoverageRequestColumn.setCellValueFactory(cellData -> cellData.getValue().quoteTextProperty());

        // Initialize columns for Changing Beneficiaries table
        changingBeneficiariesRequestColumn.setCellValueFactory(cellData -> cellData.getValue().quoteTextProperty());

        // Populate quote table with sample data (Replace this with your actual data retrieval logic)
        populateQuoteTable();

        // Populate Adding Coverage table with sample data (Replace this with actual data)
        populateAddingCoverageTable();

        // Populate Changing Beneficiaries table with sample data (Replace this with actual data)
        populateChangingBeneficiariesTable();
    }

    private void populateQuoteTable() {
        // Fetch quote requests and populate quote table (Replace this with actual data)
        // Example: Replace these lines with your actual logic to retrieve Quote objects
        quoteTableView.getItems().addAll();
        
    }

    public void populateAddingCoverageTable() {
        // Fetch adding coverage requests and populate adding coverage table (Replace this with actual data)
        // Example: Replace these lines with your actual logic to retrieve Quote objects for adding coverage
        addingCoverageTableView.getItems().addAll();
    }

    public void populateChangingBeneficiariesTable() {
        // Fetch changing beneficiaries requests and populate changing beneficiaries table (Replace this with actual data)
        // Example: Replace these lines with your actual logic to retrieve Quote objects for changing beneficiaries
        changingBeneficiariesTableView.getItems().addAll(/* Retrieve Quote objects related to Changing Beneficiaries */);
    }

    private void handleAcceptButton(ActionEvent event) {
        // Handle accept button action
        // Implement the action for accept button in the quote table
        Quote selectedQuote = quoteTableView.getSelectionModel().getSelectedItem();
        if (selectedQuote != null) {
            // Mark the selected quote as accepted
            selectedQuote.setAccepted(true);

            // Remove the selected quote from the table (since it's accepted)
            quoteTableView.getItems().remove(selectedQuote);
        }
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
