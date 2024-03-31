package customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController implements Initializable {

    private List<Customers> customersList;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField addressField;

    @FXML
    private DatePicker dateOfBirthPicker;


    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customersList = new ArrayList<>();
    }

    @FXML
    private void handleRegisterButtonAction(ActionEvent event) {
        String password = passwordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        LocalDate dob = dateOfBirthPicker.getValue();

        if (password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || address.isEmpty() || dob == null) {
            // Handle empty fields, show error message, etc.
            return;
        }

        // Create a new customer object
        Customers newCustomer = new Customers(password, firstName, lastName, email, address, java.sql.Date.valueOf(dob));

        // Add the customer to the list
        customersList.add(newCustomer);

        LoginPage();
        
    }

    @FXML
    private void LogIndashborad(ActionEvent event) {
        LoginPage();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
    }
    public void LoginPage(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Login");
            stage.show();
            
            // Optionally, you can close the current window if needed
            // 
            
        } catch (IOException e) {
            // Handle any exceptions here (e.g., show an error message)
            
        }
    }
    // Getter method to access customersList
    public List<Customers> getCustomersList() {
        return customersList;
    }
}
