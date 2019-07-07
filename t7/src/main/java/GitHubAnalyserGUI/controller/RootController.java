import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class RootController {
  private GitHubAnalyserGUI app;

  public void setApp(GitHubAnalyserGUI app){
    this.app = app;
  }

  @FXML
  public void handleOpen() {
    FileChooser fileChooser = new FileChooser();
    File userFile = fileChooser.showOpenDialog(app.getPrimaryStage());
    if(userFile!=null && userFile.getPath().endsWith(".txt")){
      app.getFileController().setFile(userFile);
      app.loadUrlList();
    } else {
      Alert alert = new Alert(AlertType.NONE, "Invalid File", ButtonType.OK);
      alert.show();
    }
  }

  @FXML
  public void handleCommitAnalyzer() {
    app.runCommitAnalyzer();
  }

  @FXML
  public void handleAbout() {
    
  }
}
