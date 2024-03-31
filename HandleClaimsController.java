package customer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HandleClaimsController implements Initializable {

    private TableColumn<Claim, String> customerIDColumn;

    private TableColumn<Claim, String> claimViewColumn;

    private TableView<Claim> claimsTableView;

    private ObservableList<Claim> pendingClaimsList;
    private ObservableList<Claim> processedClaimsList;

    private Customers currentCustomer; // Make sure you have access to the current customer
    @FXML
    private TableColumn<?, ?> CustomerID;
    @FXML
    private TableColumn<?, ?> ClaimsView;

    private void processClaim(ActionEvent event) {
        Claim selectedClaim = claimsTableView.getSelectionModel().getSelectedItem();
        if (selectedClaim != null) {
            pendingClaimsList.remove(selectedClaim);
            processedClaimsList.add(selectedClaim);
        }
    }

    private void claimHistory(ActionEvent event) {
        claimsTableView.setItems(processedClaimsList);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customerIDColumn.setCellValueFactory(cellData -> {
            StringProperty customerID = new SimpleStringProperty();
            Customers customer = cellData.getValue().getCustomerID();
            if (customer != null) {
                customerID.set(String.valueOf(customer.getCustomerID())); // Convert to String
            }
            return customerID;
        });

        claimViewColumn.setCellValueFactory(cellData -> cellData.getValue().claimTextProperty());

        pendingClaimsList = FXCollections.observableArrayList();
        processedClaimsList = FXCollections.observableArrayList();

        loadClaimsFromFile(); // Load claims from the file

        claimsTableView.setItems(pendingClaimsList);
    }

    private void loadClaimsFromFile() {
        // Read claims from the file and add them to the list
        try (BufferedReader reader = new BufferedReader(new FileReader("ClaimReports.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 2) {
                    String customerID = parts[0].substring(parts[0].indexOf(":") + 2);
                    String claimText = parts[1].substring(parts[1].indexOf(":") + 2);

                    // Convert customerID to an integer
                    int customerIdInt = Integer.parseInt(customerID);

                    // Create a new Claim object with the converted customerID
                ///    pendingClaimsList.add(new Claim(customerIdInt, claimText));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void processclaim(ActionEvent event) {
    }

    @FXML
    private void UpdateClaim(ActionEvent event) {
    }

    @FXML
    private void claimhistory(ActionEvent event) {
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
