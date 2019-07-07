import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;

public class URLListController {
  @FXML
  private ListView<GitUrl> table;

  private GitHubAnalyserGUI app;

  public URLListController(){}

  public void setApp(GitHubAnalyserGUI app){
    this.app = app;
    table.setItems(app.getUrlList());
  }

  @FXML
  private void initialize() {
  }
}
