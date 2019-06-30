import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class RootController {
  private App app;

  public void setApp(App app){
    this.app = app;
  }

  @FXML
  public void handleReload() {
    app.getQuestionData().clear();
    app.reloadQuestionData();
    Alert alert = new Alert(AlertType.NONE, "File reloaded", ButtonType.OK);
    alert.show();
  }

  @FXML
  public void handleSource() {
    app.showURLWindow();
  }

  @FXML
  public void handleClose() {
    app.getPrimaryStage().close();
  }

  @FXML
  public void handleAbout() {
    Alert alert = new Alert(AlertType.NONE, "Enade Explorer\nCreated by Pedro Bilar Montero", ButtonType.OK);
    alert.setTitle("About");
    alert.show();
  }
}
