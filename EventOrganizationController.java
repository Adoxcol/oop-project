package insurance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class EventOrganizationController implements Initializable {

    @FXML
    private TextField eventNameField;
    @FXML
    private DatePicker eventDatePicker;
    @FXML
    private TextField eventTimeField;
    @FXML
    private TextField eventDemographicsField;
    @FXML
    private Button sendInvitesButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // You can initialize any data or set default values here
    }

    @FXML
    private void handleSendInvites(ActionEvent event) {
        String eventName = eventNameField.getText();
        String eventDate = eventDatePicker.getValue() != null ? eventDatePicker.getValue().toString() : "";
        String eventTime = eventTimeField.getText();
        String eventDemographics = eventDemographicsField.getText();

        if (eventName.isEmpty() || eventDate.isEmpty() || eventTime.isEmpty() || eventDemographics.isEmpty()) {
            showAlert("Incomplete Information", "Please fill in all fields to send invites.");
            return;
        }

        // Logic to send invites would go here. For now, we simulate with an alert.
        showAlert("Invites Sent", "Invitations for " + eventName + " on " + eventDate + " at " + eventTime + " have been sent to " + eventDemographics + ".");
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
