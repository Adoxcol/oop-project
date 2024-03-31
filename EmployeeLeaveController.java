package javafxapplication3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Adoxcol
 */
public class EmployeeLeaveController implements Initializable {

    @FXML
    private VBox sidebar;
    @FXML
    private VBox mainContent;
    @FXML
    private TableView<EmployeeRecord> leaveRequestsTable;
    @FXML
    private Button receiveRequestsBtn;
    @FXML
    private TableColumn<EmployeeRecord, String> employeeIDColumn;
    @FXML
    private TableColumn<EmployeeRecord, String> employeeNameColumn;
    @FXML
    private TableColumn<EmployeeRecord, String> leaveTypeColumn;
    @FXML
    private TableColumn<EmployeeRecord, String> startDateColumn;
    @FXML
    private TableColumn<EmployeeRecord, String> endDateColumn;
    @FXML
    private TableColumn<EmployeeRecord, String> statusColumn;

    private final ObservableList<EmployeeRecord> dummyRecords = FXCollections.observableArrayList();
    @FXML
    private Button notifyEmployeesBtnn;
    @FXML
    private Button printRecordsBtn;
    @FXML
    private Button backToDashboardBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize TableView columns
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        leaveTypeColumn.setCellValueFactory(new PropertyValueFactory<>("leaveType"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        // Add dummy records
        dummyRecords.add(new EmployeeRecord("1", "John Doe", "Vacation", "2023-12-01", "2023-12-05", "Pending"));
        dummyRecords.add(new EmployeeRecord("2", "Jane Smith", "Sick Leave", "2023-12-03", "2023-12-07", "Approved"));

        // Set dummy records to the TableView
        leaveRequestsTable.setItems(dummyRecords);
    }

    @FXML
    private void receiveRequestsButtonClicked(ActionEvent event) {
        // Add your logic for receiving leave requests here
        // For demonstration, I'm adding a new dummy record when the button is clicked
        dummyRecords.add(new EmployeeRecord("3", "Bob Johnson", "Maternity Leave", "2023-12-10", "2023-12-20", "Pending"));
    }

    @FXML
    private void notifyEmployeesButtonClicked(ActionEvent event) {
        // Add your logic for notifying employees here
    }

    @FXML
    private void printRecordsButtonClicked(ActionEvent event) {
        // Generate a text file with the records
        generateTextFile("LeaveRecords.txt");
    }

  @FXML
private void backToDashboardButtonClicked(ActionEvent event) {
    try {
        // Load the dashboard FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorDashboard.fxml"));
        Parent root = loader.load();

        // Create a new scene and set it on the stage
        Scene scene = new Scene(root);
        Stage stage = (Stage) backToDashboardBtn.getScene().getWindow();  // Corrected line
        stage.setScene(scene);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    

    // Sample EmployeeRecord class
    public static class EmployeeRecord {
        private final String employeeID;
        private final String employeeName;
        private final String leaveType;
        private final String startDate;
        private final String endDate;
        private final String status;

        public EmployeeRecord(String employeeID, String employeeName, String leaveType, String startDate, String endDate, String status) {
            this.employeeID = employeeID;
            this.employeeName = employeeName;
            this.leaveType = leaveType;
            this.startDate = startDate;
            this.endDate = endDate;
            this.status = status;
        }

        // Add getters if necessary
        public String getEmployeeID() {
            return employeeID;
        }

        public String getEmployeeName() {
            return employeeName;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public String getStartDate() {
            return startDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public String getStatus() {
            return status;
        }
    }

    private void generateTextFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (EmployeeRecord record : dummyRecords) {
                writer.write("Employee ID: " + record.getEmployeeID() + "\n");
                writer.write("Employee Name: " + record.getEmployeeName() + "\n");
                writer.write("Leave Type: " + record.getLeaveType() + "\n");
                writer.write("Start Date: " + record.getStartDate() + "\n");
                writer.write("End Date: " + record.getEndDate() + "\n");
                writer.write("Status: " + record.getStatus() + "\n");
                writer.write("\n"); // Separate records with a blank line
            }
            System.out.println("Text file generated successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
