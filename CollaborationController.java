package insurance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.FileWriter;

public class CollaborationController implements Initializable {

    @FXML
    private TableView<Influencer> influencerTableView;
    @FXML
    private TableColumn<Influencer, String> colInfluencers;
    @FXML
    private TableColumn<Influencer, Integer> colFollowers;
    @FXML
    private TextArea proposalTextArea;

    private final ObservableList<Influencer> influencerData = FXCollections.observableArrayList(
        new Influencer("Influencer A", 5000),
        new Influencer("Influencer B", 10000),
        new Influencer("Influencer C", 7500)
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colInfluencers.setCellValueFactory(new PropertyValueFactory<>("name"));
        colFollowers.setCellValueFactory(new PropertyValueFactory<>("followers"));
        influencerTableView.setItems(influencerData);
    }

    @FXML
    private void handleSendProposal(ActionEvent event) {
        Influencer selectedInfluencer = influencerTableView.getSelectionModel().getSelectedItem();
        if (selectedInfluencer != null) {
            String proposal = proposalTextArea.getText();
            saveProposalData(selectedInfluencer, proposal);
            showAlert("Proposal Sent to Influencers!", "Proposal sent to: " + selectedInfluencer.getName());
        } else {
            showAlert("No Influencer Selected", "Please select an influencer to send a proposal.");
        }
    }

    private void saveProposalData(Influencer influencer, String proposal) {
        // Save the proposal details in a text file
        try (PrintWriter out = new PrintWriter(new FileWriter("influencer_proposal.txt", true))) {
            out.println("Influencer: " + influencer.getName() + ", Followers: " + influencer.getFollowers());
            out.println("Proposal: " + proposal);
            out.println();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save proposal to text file.");
        }

        // Save the proposal details in a binary file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("influencer_proposal.dat"))) {
            oos.writeObject(new InfluencerProposal(influencer, proposal));
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save proposal to binary file.");
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static class Influencer {
        private final String name;
        private final int followers;

        public Influencer(String name, int followers) {
            this.name = name;
            this.followers = followers;
        }

        public String getName() {
            return name;
        }

        public int getFollowers() {
            return followers;
        }
    }

    public static class InfluencerProposal implements java.io.Serializable {
        private final Influencer influencer;
        private final String proposal;

        public InfluencerProposal(Influencer influencer, String proposal) {
            this.influencer = influencer;
            this.proposal = proposal;
        }
    }
}
