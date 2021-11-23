package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Comparator;

public class GetJSON {

    private Stage stage = new Stage();
    private StringBuilder fieldContent;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea jsonDataField;

    @FXML
    private Button consoleClear;

    @FXML
    private Button exitProgram;

    @FXML
    private Button outputData;

    @FXML
    void initialize() {
        consoleClear.setOnAction(event -> {
            jsonDataField.clear();
        });
        exitProgram.setOnAction(event -> {
            ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
            stage.close();
        });
        outputData.setOnAction(event -> {
            JSONGetter jsonGetter = new JSONGetter();
            fieldContent = new StringBuilder();

            JSONGetter.url = "https://api-mobilespecs.azharimm.site/v2/brands";
            jsonGetter.run();

            String jsonString = jsonGetter.jsonIn;

            JSONObject obj = null;
            try {
                obj = (JSONObject) new JSONParser().parse(jsonString);
            }
            catch (ParseException e) {
                e.printStackTrace();
            }

            JSONArray jsonArray = null;
            if (obj != null)
                jsonArray = (JSONArray) obj.get("data");

            Mobile mobile = new Mobile();
            mobile.setStatus((boolean) obj.get("status"));
            for (Object jsonObject : jsonArray)
            {
                JSONObject current = (JSONObject) jsonObject;
                String brandName = (String) current.get("brand_name");
                String brandSlug = (String) current.get("brand_slug");
                String detail = (String) current.get("detail");
                int deviceCount = Integer.parseInt(current.get("device_count").toString());
                int brandId = Integer.parseInt(current.get("brand_id").toString());
                Device device = new Device(brandId, brandName, brandSlug, deviceCount, detail);
                mobile.addDevice(device);
            }
            fieldContent.append(mobile + "\n");
            fieldContent.append("Sorted by id:\n");
            mobile.getDevice().sort(Comparator.comparing(Device::getBrandId));
            fieldContent.append(mobile + "\n");
            jsonDataField.setText(fieldContent.toString());
        });
    }
}