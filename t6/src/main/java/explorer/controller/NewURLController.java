import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class NewURLController {
  @FXML
  private TextField userInput;

  private Stage URLStage;
  private App app;

  public NewURLController(){}

  public void initialize(){}

  public void setURLStage(Stage URLStage) {
    this.URLStage = URLStage;
  }

  public void setApp (App app){
    this.app = app;
  }

  @FXML
  public void handleOk() {
    String txtInput = userInput.getText();
    if(txtInput!=null && txtInput.endsWith("csv")){
      app.setNewURL(txtInput);
      URLStage.close();
    }else{
      Alert alert = new Alert(AlertType.NONE, "Invalid URL", ButtonType.OK);
      alert.show();
    }
  }
}
