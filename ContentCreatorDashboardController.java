package insurance;

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

public class ContentCreatorDashboardController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialization logic (if any)
    }

    @FXML
    private void openAnalysis(ActionEvent event) throws IOException {
        loadFXML("Analysis.fxml", event);
    }

    @FXML
    private void openFeedback(ActionEvent event) throws IOException {
        loadFXML("Feedback.fxml", event);
    }

    @FXML
    private void openCampaigning(ActionEvent event) throws IOException {
        loadFXML("Campaigning.fxml", event);
    }

    @FXML
    private void openCollaboration(ActionEvent event) throws IOException {
        loadFXML("Collaboration.fxml", event);
    }

    @FXML
    private void openOutreach(ActionEvent event) throws IOException {
        loadFXML("Outreach.fxml", event);
    }

    @FXML
    private void openSchedule(ActionEvent event) throws IOException {
        loadFXML("Schedule.fxml", event);
    }

    @FXML
    private void openNewsLetter(ActionEvent event) throws IOException {
        loadFXML("NewsLetter.fxml", event);
    }

    @FXML
    private void openSocialMedia(ActionEvent event) throws IOException {
        loadFXML("SocialMedia.fxml", event);
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        loadFXML("Login.fxml", event);
    }


    private void loadFXML(String fxml, ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
