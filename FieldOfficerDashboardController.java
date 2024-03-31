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

public class FieldOfficerDashboardController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openMonitor(ActionEvent event) throws IOException {
        loadFXML("Monitor.fxml", event);
    }

    @FXML
    private void openSchedule(ActionEvent event) throws IOException {
        loadFXML("Schedule.fxml", event);
    }

    @FXML
    private void openUpdatePolicy(ActionEvent event) throws IOException {
        loadFXML("UpdatePolicy.fxml", event);
    }

    @FXML
    private void openReports(ActionEvent event) throws IOException {
        loadFXML("Reports.fxml", event);
    }

    @FXML
    private void openEventOrganization(ActionEvent event) throws IOException {
        loadFXML("EventOrganization.fxml", event);
    }

    @FXML
    private void openRegister(ActionEvent event) throws IOException {
        loadFXML("Register.fxml", event);
    }

    @FXML
    private void openBilling(ActionEvent event) throws IOException {
        loadFXML("Billing.fxml", event);
    }

    @FXML
    private void openUpdateClaim(ActionEvent event) throws IOException {
        loadFXML("UpdateClaim.fxml", event);
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
