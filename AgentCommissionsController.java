package javafxapplication3;

import java.awt.Desktop;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AgentCommissionsController {

    @FXML
    private TableView<AgentCommission> commissionsTable;

    @FXML
    private TableColumn<AgentCommission, String> agentIdColumn;

    @FXML
    private TableColumn<AgentCommission, String> agentNameColumn;

    @FXML
    private TableColumn<AgentCommission, String> commissionAmountColumn;

    @FXML
    private TextField agentNameField;

    @FXML
    private TextField commissionAmountField;

    @FXML
    private Button addRecordBtn;

    @FXML
    private Button clearFieldsBtn;

    @FXML
    private Button verifyApproveBtn;

    @FXML
    private Button calculateCommissionsBtn;

    @FXML
    private Button backToDashboardButton;

    private ObservableList<AgentCommission> commissionsList;

    public void initialize() {
        // Initialize the table columns
        agentIdColumn.setCellValueFactory(cellData -> cellData.getValue().agentIdProperty());
        agentNameColumn.setCellValueFactory(cellData -> cellData.getValue().agentNameProperty());
        commissionAmountColumn.setCellValueFactory(cellData -> cellData.getValue().commissionAmountProperty());

        // Initialize the dummy data
        commissionsList = FXCollections.observableArrayList(
                new AgentCommission("1", "Mahmood", "1000"),
                new AgentCommission("2", "Redwan", "1500"),
                new AgentCommission("3", "Ikram", "1200"),
                new AgentCommission("4", "Rayed", "1200")
        );

        // Set the data to the table
        commissionsTable.setItems(commissionsList);
    }

    @FXML
    private void handleAddRecord(ActionEvent event) {
        // Get data from text fields
        String agentName = agentNameField.getText();
        String commissionAmount = commissionAmountField.getText();

        // Generate a dummy agent ID (you may use a proper mechanism to generate unique IDs)
        String agentId = String.valueOf(commissionsList.size() + 1);

        // Add a new record to the table
        commissionsList.add(new AgentCommission(agentId, agentName, commissionAmount));

        // Clear text fields
        agentNameField.clear();
        commissionAmountField.clear();
    }

    @FXML
    private void handleClearFields(ActionEvent event) {
        // Clear text fields
        agentNameField.clear();
        commissionAmountField.clear();
    }

    @FXML
    private void handleCalculateCommissions(ActionEvent event) {
        // Calculate total commissions
        double totalCommissions = commissionsList.stream()
                .mapToDouble(agentCommission -> Double.valueOf(agentCommission.getCommissionAmount()))
                .sum();

        // Create a text file and write the total commissions
        File file = createCommissionsFile(totalCommissions);

        // Open the text file with the default system application
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createCommissionsFile(double totalCommissions) {
        // Create a text file with the total commissions
        File file = new File("TotalCommissions.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Total Commissions: $" + totalCommissions);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
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
}
