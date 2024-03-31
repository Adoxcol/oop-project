package insurance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BillingController implements Initializable {

    @FXML
    private TableView<ClientPayment> clientPaymentTable;
    @FXML
    private TableColumn<ClientPayment, String> colClient;
    @FXML
    private TableColumn<ClientPayment, Double> colDueAmount;
    @FXML
    private TableColumn<ClientPayment, String> colDueDate;
    @FXML
    private TableColumn<ClientPayment, String> colStatus;
    @FXML
    private Button sendRemindersButton;
    @FXML
    private Button dashboardButton;

    private final ObservableList<ClientPayment> data = FXCollections.observableArrayList(
        new ClientPayment("Client A", 100.0, "2023-08-01", "Due"),
        new ClientPayment("Client B", 200.0, "2023-07-15", "Overdue"),
        new ClientPayment("Client C", 150.0, "2023-08-10", "Paid"),
        new ClientPayment("Client D", 250.0, "2023-09-01", "Due"),
        new ClientPayment("Client E", 350.0, "2023-07-20", "Overdue"),
        new ClientPayment("Client F", 175.0, "2023-08-15", "Paid"),
        new ClientPayment("Client G", 300.0, "2023-09-05", "Due")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colClient.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());
        colDueAmount.setCellValueFactory(cellData -> cellData.getValue().dueAmountProperty().asObject());
        colDueDate.setCellValueFactory(cellData -> cellData.getValue().dueDateProperty());
        colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        clientPaymentTable.setItems(data);
    }

    @FXML
    private void handleSendReminders(ActionEvent event) {
        for (ClientPayment clientPayment : data) {
            if ("Due".equals(clientPayment.getStatus()) || "Overdue".equals(clientPayment.getStatus())) {
                clientPayment.setStatus("Reminder Sent");
            }
        }
        clientPaymentTable.refresh();
        showAlert("Reminders Sent", "Payment reminders have been sent to all due clients.");
    }

    @FXML
    private void handleDashboardButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FieldOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

public static class ClientPayment {
    private final SimpleStringProperty clientName;
    private final SimpleDoubleProperty dueAmount;
    private final SimpleStringProperty dueDate;
    private final SimpleStringProperty status;

    public ClientPayment(String clientName, double dueAmount, String dueDate, String status) {
        this.clientName = new SimpleStringProperty(clientName);
        this.dueAmount = new SimpleDoubleProperty(dueAmount);
        this.dueDate = new SimpleStringProperty(dueDate);
        this.status = new SimpleStringProperty(status);
    }

    // Getters
    public String getClientName() { return clientName.get(); }
    public double getDueAmount() { return dueAmount.get(); }
    public String getDueDate() { return dueDate.get(); }
    public String getStatus() { return status.get(); }

    // Setters
    public void setClientName(String value) { clientName.set(value); }
    public void setDueAmount(double value) { dueAmount.set(value); }
    public void setDueDate(String value) { dueDate.set(value); }
    public void setStatus(String value) { status.set(value); }

    // Property getters
    public SimpleStringProperty clientNameProperty() { return clientName; }
    public SimpleDoubleProperty dueAmountProperty() { return dueAmount; }
    public SimpleStringProperty dueDateProperty() { return dueDate; }
    public SimpleStringProperty statusProperty() { return status; }
}

}
