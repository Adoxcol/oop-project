package insurance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class AnalysisController implements Initializable {

    @FXML
    private TableView<CampaignData> tblFanFeedback;

    @FXML
    private TableColumn<CampaignData, String> colFanName;
    @FXML
    private TableColumn<CampaignData, String> colFeedback;
    @FXML
    private TableColumn<CampaignData, Double> colRating;

    private ObservableList<CampaignData> campaignData;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colFanName.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        colFeedback.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        colRating.setCellValueFactory(new PropertyValueFactory<>("rating"));

        // Mock data for demonstration. Replace with actual data retrieval logic.
        campaignData = FXCollections.observableArrayList(
            new CampaignData("Campaign 1", "Positive", 4.5),
            new CampaignData("Campaign 2", "Mixed", 3.0),
            new CampaignData("Campaign 3", "Negative", 2.0)
        );

        tblFanFeedback.setItems(campaignData);
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

    // Add a CampaignData class inside AnalysisController class to model the table data
    public static class CampaignData {
        private final String campaignName;
        private final String feedback;
        private final double rating;

        public CampaignData(String campaignName, String feedback, double rating) {
            this.campaignName = campaignName;
            this.feedback = feedback;
            this.rating = rating;
        }

        public String getCampaignName() {
            return campaignName;
        }

        public String getFeedback() {
            return feedback;
        }

        public double getRating() {
            return rating;
        }
    }
}
