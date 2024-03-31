package javafxapplication3;

import java.awt.Desktop;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AttendanceController {

    @FXML
    private TextField employeeNameField;

    @FXML
    private TextField dateField;

    @FXML
    private TextField additionalField1;

    @FXML
    private TextField additionalField2;

    @FXML
    private TableView<AttendanceRecord> attendanceTable;

    @FXML
    private TableColumn<AttendanceRecord, String> employeeIdColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> employeeNameColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> dateColumn;

    @FXML
    private TableColumn<AttendanceRecord, String> statusColumn;

    @FXML
    private Button addRecordBtn;

    @FXML
    private Button backToDashboardButton;

    @FXML
    private Button printAttendanceSheetBtn;

    public void initialize() {
        // Initialize table columns
        employeeIdColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty());
        employeeNameColumn.setCellValueFactory(cellData -> cellData.getValue().employeeNameProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        // Add dummy records
        addDummyRecords();
    }

    @FXML
    private void handleAddRecord(ActionEvent event) {
        // Get data from text fields
        String employeeName = employeeNameField.getText();
        String date = dateField.getText();
        String additionalField1Value = additionalField1.getText();
        String additionalField2Value = additionalField2.getText();

        // Add a new record to the table
        AttendanceRecord newRecord = new AttendanceRecord("1", employeeName, date, "Present", additionalField1Value, additionalField2Value);
        attendanceTable.getItems().add(newRecord);

        // Clear text fields after adding the record
        employeeNameField.clear();
        dateField.clear();
        additionalField1.clear();
        additionalField2.clear();
    }

    private void addDummyRecords() {
        // Add dummy records
        attendanceTable.getItems().add(new AttendanceRecord("1", "IKRAM", "2023-01-01", "Present", "Additional1Value", "Additional2Value"));
        attendanceTable.getItems().add(new AttendanceRecord("2", "MAHMOOD", "2023-01-02", "Present", "Additional1Value", "Additional2Value"));
        attendanceTable.getItems().add(new AttendanceRecord("3", "RAYED", "2023-01-03", "Present", "Additional1Value", "Additional2Value"));
        attendanceTable.getItems().add(new AttendanceRecord("4", "REDWAN", "2023-01-04", "Present", "Additional1Value", "Additional2Value"));
    }

    @FXML
    private void backToDashboard(ActionEvent event) {
    
        
        try {
            // Load the dashboard FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdministratorDashboard.fxml"));
            Parent root = loader.load();

            // Create a new scene and set it on the stage
            Scene scene = new Scene(root);
            Stage stage = (Stage) backToDashboardButton.getScene().getWindow();
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void printAttendanceSheet(ActionEvent event) {
        // Create a text file and write the attendance records
        File file = createAttendanceSheetFile();

        // Open the text file with the default system application
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createAttendanceSheetFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        fileChooser.setTitle("Save Attendance Sheet");

        // Show save file dialog
        Stage stage = (Stage) printAttendanceSheetBtn.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        // If the user selected a file, write the attendance records to the file
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (AttendanceRecord record : attendanceTable.getItems()) {
                    writer.write(String.format("%s, %s, %s, %s%n", record.getEmployeeId(), record.getEmployeeName(), record.getDate(), record.getStatus()));
                }
                showInformationAlert("Attendance Sheet Saved", "The attendance sheet has been saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                showInformationAlert("Error", "An error occurred while saving the attendance sheet.");
            }
        }

        return file;
    }

    private void showInformationAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
