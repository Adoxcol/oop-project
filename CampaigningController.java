package insurance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class CampaigningController implements Initializable {

    @FXML
    private TextField campaignNameField;
    @FXML
    private ComboBox<String> targetAudienceComboBox;
    @FXML
    private TextArea campaignMessageArea;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        targetAudienceComboBox.getItems().addAll("Adults", "Teens", "Seniors");
    }

    @FXML
    private void handleSubmitCampaign(ActionEvent event) {
        String campaignName = campaignNameField.getText();
        String targetAudience = targetAudienceComboBox.getValue();
        String campaignMessage = campaignMessageArea.getText();

        try {
            saveCampaignData(campaignName, targetAudience, campaignMessage);
            showAlert("Campaign Drafted", "Campaign data has been saved.");
            resetCampaignForm();
        } catch (IOException e) {
            showAlert("Error", "Failed to save campaign data.");
        }
    }

    private void saveCampaignData(String name, String audience, String message) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("campaign_data.txt", true))) {
            writer.write("Campaign Name: " + name + "\n");
            writer.write("Target Audience: " + audience + "\n");
            writer.write("Campaign Message: " + message + "\n\n");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetCampaignForm() {
        campaignNameField.clear();
        targetAudienceComboBox.getSelectionModel().clearSelection();
        campaignMessageArea.clear();
    }

    @FXML
    private void handleDashboardButton(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ContentCreatorDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
