package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPage {

    private Stage stage = new Stage();
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button getJsonButton;

    @FXML
    void initialize() {
        getJsonButton.setOnAction(event -> {
            try
            {
                root = FXMLLoader.load(getClass().getResource("getJSONPage.fxml"));
                stage.setScene(new Scene(root, 800, 500));
                stage.setTitle("JSON Data Page");
                stage.show();
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }catch(IOException e)
            { e.printStackTrace(); }
        });
    }
}