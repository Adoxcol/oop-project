package insurance;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FeedbackController implements Initializable {

    @FXML
    private ListView<String> feedbackListView;
    @FXML
    private TextArea newFeedbackArea;
    @FXML
    private Button submitFeedbackButton;

    private final ObservableList<String> feedbackData = FXCollections.observableArrayList(
        "Campaign A: Great initiative, helped me understand the policy better!",
        "Campaign B: The content was clear and concise, well done.",
        "Campaign C: I appreciated the detailed explanations."
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        feedbackListView.setItems(feedbackData);
    }

    @FXML
    private void handleSubmitFeedback(ActionEvent event) {
        String newFeedback = newFeedbackArea.getText();
        if (newFeedback != null && !newFeedback.isEmpty()) {
            feedbackData.add(newFeedback);
            newFeedbackArea.clear();
        }
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
