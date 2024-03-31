package javafxapplication3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccessEmployeeRecordsController implements Initializable {

    @FXML
    private TableView<IndividualEmployeeRecord> employeeRecordsTable;
    @FXML
    private TableColumn<IndividualEmployeeRecord, String> empID;
    @FXML
    private TableColumn<IndividualEmployeeRecord, String> empName;
    @FXML
    private TableColumn<IndividualEmployeeRecord, String> DOB;
    @FXML
    private TableColumn<IndividualEmployeeRecord, String> empJob;
    @FXML
    private Button backToDashboardButton;

    private final ObservableList<IndividualEmployeeRecord> employeeRecords = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize columns with corresponding property values
        empID.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty());
        empName.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());
        DOB.setCellValueFactory(cellData -> cellData.getValue().dateOfBirthProperty());
        empJob.setCellValueFactory(cellData -> cellData.getValue().employeeJobProperty());

        // Add dummy records
        for (int i = 1; i <= 9; i++) {
            employeeRecords.add(new IndividualEmployeeRecord("ID" + i, "Employee " + i, "DOB" + i, "Agent" + i));
        }

        // Set dummy records to the table
        employeeRecordsTable.setItems(employeeRecords);
    }

    @FXML
    private void showSpecificEmployee(ActionEvent event) {
        // Implement logic to show specific employee based on selection
        // You can access the selected record using employeeRecordsTable.getSelectionModel().getSelectedItem()
    }

    @FXML
    private void showAllEmployee(ActionEvent event) {
        // Implement logic to show all employees
        // For demonstration purposes, let's create a text file with employee records
        File file = createEmployeeRecordsFile();

        // Open the text file with the default system application
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void deleteSelectedRecord(ActionEvent event) {
        // Implement logic to delete the selected record
        IndividualEmployeeRecord selectedRecord = employeeRecordsTable.getSelectionModel().getSelectedItem();
        if (selectedRecord != null) {
            employeeRecords.remove(selectedRecord);
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

    private File createEmployeeRecordsFile() {
        // Implement logic to create a text file with formatted employee records
        // For demonstration purposes, let's create a simple text file in the project directory
        File file = new File("EmployeeRecords.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (IndividualEmployeeRecord record : employeeRecords) {
                String line = String.format("Employee ID: %s, Employee Name: %s, Date of Birth: %s, Employee Job: %s",
                        record.getEmployeeId(), record.getEmployeeName(),
                        record.getDateOfBirth(), record.getEmployeeJob());
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
