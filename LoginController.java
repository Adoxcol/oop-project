package insurance;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roleComboBox.getItems().addAll("Content Creator", "Field Officer", "Administrator", "Human Resource","Customer","Customer Support","Accounts Manager","Sales Manager");
    }

    @FXML
    private void handleLoginButtonAction(ActionEvent event) throws Exception {
    String username = usernameField.getText();
    String password = passwordField.getText();
    String role = roleComboBox.getValue();

    if (username.equals("admin") && password.equals("admin")) {
        Stage stage = (Stage) usernameField.getScene().getWindow();
        Parent root = null;

        switch (role) {
            case "Content Creator":
                root = FXMLLoader.load(getClass().getResource("/insurance/ContentCreatorDashboard.fxml"));
                break;
            case "Field Officer":
                root = FXMLLoader.load(getClass().getResource("/insurance/FieldOfficerDashboard.fxml"));
                break;
            case "Administrator":
                root = FXMLLoader.load(getClass().getResource("/JavaFXApplication3/AdministratorDashboard.fxml"));
                break;
            case "Human Resource":
                root = FXMLLoader.load(getClass().getResource("/JavaFXApplication3/HRDashboard.fxml"));
                break;
            case "Customer":
                root = FXMLLoader.load(getClass().getResource("/customer/Customer Dashboard.fxml"));
                break;
            case "Customer Support":
                root = FXMLLoader.load(getClass().getResource("/customer/SupportDashboard.fxml"));
                break;
            case "Accounts Manager":
                root = FXMLLoader.load(getClass().getResource("/javafxapplication18/dashboard2.fxml"));
                break;
            case "Sales Manager":
                root = FXMLLoader.load(getClass().getResource("/javafxapplication18/dashboard.fxml"));
                break;
            default:
                // Show error message or log
                break;
        }

        if (root != null) {
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    } else {
        }
    }
}
