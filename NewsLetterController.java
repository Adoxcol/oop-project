package insurance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.FileWriter;
import java.io.IOException;

public class NewsLetterController implements Initializable {

    @FXML
    private TextArea contentTextArea;

    @FXML
    private ListView<String> sectionListView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize ListView with sections of the newsletter
        sectionListView.getItems().addAll("Section 1", "Section 2", "Section 3"); // Example sections
        sectionListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Load the content for the selected section into the TextArea
            // This is where you would retrieve the actual content for each section
            contentTextArea.setText("Content for " + newValue);
        });
    }

    @FXML
    private void handleDashboardButton(ActionEvent event) throws IOException {
        // Redirect to Dashboard
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("ContentCreatorDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleSubmitChanges(ActionEvent event) {
        String selectedSection = sectionListView.getSelectionModel().getSelectedItem();
        String content = contentTextArea.getText();

        try {
            saveNewsletterContent(selectedSection, content);
            showAlert("Newsletter Updated!", "The changes to the newsletter have been saved.");
        } catch (IOException e) {
            showAlert("Error", "Failed to save newsletter content.");
            e.printStackTrace();
        }
    }

    private void saveNewsletterContent(String section, String content) throws IOException {
        try (FileWriter writer = new FileWriter("newsletter_content.txt", true)) { // Appends to the file
            writer.write("Section: " + section + "\n");
            writer.write(content + "\n\n");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
