package javafxapplication3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeePerformanceController implements Initializable {

    @FXML
    private TableView<EmployeeRecord> employeeAppraisalsTable;

    @FXML
    private TableColumn<EmployeeRecord, String> employeeIdColumn;

    @FXML
    private TableColumn<EmployeeRecord, String> employeeNameColumn;

    @FXML
    private TableColumn<EmployeeRecord, String> performanceColumn;

    @FXML
    private TableColumn<EmployeeRecord, String> durationColumn;

    @FXML
    private TextField employeeIdField;

    @FXML
    private TextField employeeNameField;

    @FXML
    private TextField performanceField;

    @FXML
    private TextField durationField;

    @FXML
    private Button addRecordBtn;

    private ObservableList<EmployeeRecord> employeeRecords;
    @FXML
    private VBox employeeRecordsSidebar;
    @FXML
    private VBox employeeRecordsMainContent;
    @FXML
    private VBox employeePerformanceSection;
    @FXML
    private Button backToDashboardBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the columns
        employeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty());
        employeeNameColumn.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());
        performanceColumn.setCellValueFactory(cellData -> cellData.getValue().performanceProperty());
        durationColumn.setCellValueFactory(cellData -> cellData.getValue().durationProperty());

        // Initialize the employeeRecords list
        employeeRecords = FXCollections.observableArrayList();

        // Bind the list to the table
        employeeAppraisalsTable.setItems(employeeRecords);

        // Add dummy records
        addDummyRecords();
    }

    private void addDummyRecords() {
        employeeRecords.add(new EmployeeRecord("1", "John Doe", "Excellent", "3 months"));
        employeeRecords.add(new EmployeeRecord("2", "Jane Smith", "Good", "6 months"));
        employeeRecords.add(new EmployeeRecord("3", "Bob Johnson", "Satisfactory", "4 months"));
    }

    @FXML
    private void handleAddRecord(ActionEvent event) {
        String employeeId = employeeIdField.getText();
        String employeeName = employeeNameField.getText();
        String performance = performanceField.getText();
        String duration = durationField.getText();

        if (!employeeId.isEmpty() && !employeeName.isEmpty() && !performance.isEmpty() && !duration.isEmpty()) {
            EmployeeRecord newRecord = new EmployeeRecord(employeeId, employeeName, performance, duration);
            employeeRecords.add(newRecord);

            // Clear input fields
            clearInputFields();
        }
    }

    private void clearInputFields() {
        employeeIdField.clear();
        employeeNameField.clear();
        performanceField.clear();
        durationField.clear();
    }

    @FXML
    private void backToDashboardButtonClicked(ActionEvent event) {
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

