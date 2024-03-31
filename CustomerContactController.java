package javafxapplication3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomerContactController {

    @FXML
    private TableView<Customer> customerContactTable;

    @FXML
    private TableColumn<Customer, String> customerIdColumn;

    @FXML
    private TableColumn<Customer, String> customerNameColumn;

    @FXML
    private TableColumn<Customer, String> contactNumberColumn;

    @FXML
    private TextField customerIdField;

    @FXML
    private TextField customerNameField;                                                                                            

    @FXML
    private TextField contactNumberField;

    @FXML
    private Button updateCustomerInfoBtn;

    @FXML
    private Button reviewRecordsBtn;

    @FXML
    private Button addRecordBtn;

    @FXML
    private VBox sidebar;

    @FXML
    private VBox mainContent;

    @FXML
    private Button backToDashboardBtn;

    public void initialize() {
        // Initialize the table columns
        customerIdColumn.setCellValueFactory(cellData -> cellData.getValue().customerIdProperty());
        customerNameColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        contactNumberColumn.setCellValueFactory(cellData -> cellData.getValue().contactNumberProperty());

        // Add dummy records
        customerContactTable.getItems().add(new Customer("1", "Mahmood", "123456789"));
        customerContactTable.getItems().add(new Customer("2", "Ikram", "987654321"));
        customerContactTable.getItems().add(new Customer("3", "Redwan", "555555555"));
        customerContactTable.getItems().add(new Customer("4", "Rayed", "888888888"));
    }

    @FXML
    private void handleReviewRecords() {
        // Handle review records button action
        // You can access all records using: customerContactTable.getItems()
        // Do whatever you want with the records
    }

    @FXML
    private void handleAddRecord() {
        // Handle add record button action
        String customerId = customerIdField.getText();
        String customerName = customerNameField.getText();
        String contactNumber = contactNumberField.getText();

        // Add the new record to the table
        customerContactTable.getItems().add(new Customer(customerId, customerName, contactNumber));

        // Clear input fields
        customerIdField.clear();
        customerNameField.clear();
        contactNumberField.clear();
    }

    @FXML
    private void PrintOnClick(ActionEvent event) {
        // Implement logic to print records (e.g., to a file or console)
        for (Customer customer : customerContactTable.getItems()) {
            System.out.println("Customer ID: " + customer.getCustomerId()
                    + ", Customer Name: " + customer.getCustomerName()
                    + ", Contact Number: " + customer.getContactNumber());
        }
    }

    @FXML
    private void handleBackToDashboard(ActionEvent event) {
        // Implement logic to navigate back to the dashboard
        // For demonstration purposes, let's assume you have another FXML file for the dashboard
        // and you want to load it when the "Back to Dashboard" button is clicked
        try {
            // Load the dashboard FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorDashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) backToDashboardBtn.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
