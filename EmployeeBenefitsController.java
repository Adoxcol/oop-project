package javafxapplication3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeBenefitsController {

    @FXML
    private TableView<EmployeeRecord> employeeBenefitsTable;

    @FXML
    private TableColumn<EmployeeRecord, String> employeeIDColumn;

    @FXML
    private TableColumn<EmployeeRecord, String> employeeNameColumn;

    @FXML
    private TableColumn<EmployeeRecord, String> benefitEnrolledColumn;

    @FXML
    private TableColumn<EmployeeRecord, String> durationColumn;

    @FXML
    private TextField employeeIDField;

    @FXML
    private TextField employeeNameField;

    @FXML
    private TextField benefitEnrolledField;

    @FXML
    private TextField durationField;

    @FXML
    private Button addRecordButton;

    @FXML
    private Button BenefitProgam;

    @FXML
    private Button BenefitOfferings;

    @FXML
    private Button backToDashboardButton;

    // This method is automatically called after the FXML file has been loaded
    private void initialize() {
        // Initialize the TableView and its columns
        // This is where you would typically set cell value factories and other properties

        // For demonstration purposes, I'm creating some sample records and adding them to the TableView
        EmployeeRecord record1 = new EmployeeRecord("1", "John Doe", "Health Insurance", "1 year");
        EmployeeRecord record2 = new EmployeeRecord("2", "Jane Smith", "Dental Insurance", "6 months");
        employeeBenefitsTable.getItems().addAll(record1, record2);

        // Set up the button click events
        addRecordButton.setOnAction(event -> addRecordButtonClicked());
        BenefitProgam.setOnAction(event -> printRecords());
        // You can add similar logic for BenefitOfferings button
    }

    @FXML
    private void addRecordButtonClicked() {
        // Get values from TextFields and add a new record to the TableView
        String employeeID = employeeIDField.getText();
        String employeeName = employeeNameField.getText();
        String benefitEnrolled = benefitEnrolledField.getText();
        String duration = durationField.getText();

        // For demonstration purposes, I'm adding a new record to the TableView
        EmployeeRecord newRecord = new EmployeeRecord(employeeID, employeeName, benefitEnrolled, duration);
        employeeBenefitsTable.getItems().add(newRecord);

        // Clear the TextFields after adding the record
        employeeIDField.clear();
        employeeNameField.clear();
        benefitEnrolledField.clear();
        durationField.clear();
    }

    @FXML
    private void printRecords() {
        // Print records to a text file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_records.txt"))) {
            for (EmployeeRecord record : employeeBenefitsTable.getItems()) {
                writer.write(String.format("%s\t%s\t%s\t%s%n",
                        record.getEmployeeID(), record.getEmployeeName(),
                        record.getBenefitEnrolled(), record.getDuration()));
            }
            System.out.println("Records printed to employee_records.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
   private void backToDashboard(ActionEvent event) {
        
        try {
            // Load the dashboard FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HRDashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) backToDashboardButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // You can add more methods and logic as needed

    // Sample EmployeeRecord class
    public static class EmployeeRecord {
        private final String employeeID;
        private final String employeeName;
        private final String benefitEnrolled;
        private final String duration;

        public EmployeeRecord(String employeeID, String employeeName, String benefitEnrolled, String duration) {
            this.employeeID = employeeID;
            this.employeeName = employeeName;
            this.benefitEnrolled = benefitEnrolled;
            this.duration = duration;
        }

        // Add getters if necessary
        public String getEmployeeID() {
            return employeeID;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public String getBenefitEnrolled() {
            return benefitEnrolled;
        }

        public String getDuration() {
            return duration;
        }
    }
}
