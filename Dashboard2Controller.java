package javafxapplication18;

import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Dashboard2Controller {

    @FXML
    private Button PD;

    @FXML
    private Button PD1;

    @FXML
    private Button PD2;

    @FXML
    private Button PD3;

    @FXML
    private Button SD;

    @FXML
    private Button TD;

    @FXML
    private Button n;

    @FXML
    void emp(ActionEvent event) {
        try {
            URL secondSceneUrl = getClass().getResource("Employees2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) PD1.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void notifications(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Notifications2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) n.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void prod(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Expense2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) PD2.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void prod2(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Customer2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) PD.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void prod5(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Report2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) PD3.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void sales(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Sales2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) SD.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void trans(ActionEvent event) {
        try {
            // Load the SecondScene.fxml
            URL secondSceneUrl = getClass().getResource("Budget2.fxml");
            AnchorPane secondSceneRoot = FXMLLoader.load(secondSceneUrl);

            // Create a new scene and set it on the stage
            Scene secondScene = new Scene(secondSceneRoot);
            Stage currentStage = (Stage) TD.getScene().getWindow();
            currentStage.setScene(secondScene);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void handleExitButton(ActionEvent event) {
        // Close the current scene or do any necessary cleanup
        // You can add additional logic before exiting if needed

        // Exit the application
        Platform.exit();
        System.exit(0);
    }

}
