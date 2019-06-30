import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class QuestionTableController {
  @FXML
  private TableView<Question> table;
  @FXML
  private TableColumn<Question, String> ano;
  @FXML
  private TableColumn<Question, String> prova;
  @FXML
  private TableColumn<Question, String> tipoQuestao;
  @FXML
  private TableColumn<Question, String> idQuestao;
  @FXML
  private TableColumn<Question, String> objeto;
  @FXML
  private TableColumn<Question, String> acertosCurso;
  @FXML
  private TableColumn<Question, String> acertosRegiao;
  @FXML
  private TableColumn<Question, String> acertosBrasil;
  @FXML
  private TableColumn<Question, String> acertosDif;

  private EnadeUFSMExplorer app;

  public QuestionTableController() {

  }

  @FXML
  private void initialize() {
    ano.setCellValueFactory(new PropertyValueFactory<Question, String>("ano"));
    prova.setCellValueFactory(new PropertyValueFactory<Question, String>("prova"));
    tipoQuestao.setCellValueFactory(new PropertyValueFactory<Question, String>("tipoquestao"));
    idQuestao.setCellValueFactory(new PropertyValueFactory<Question, String>("idquestao"));
    objeto.setCellValueFactory(new PropertyValueFactory<Question, String>("objeto"));
    acertosCurso.setCellValueFactory(new PropertyValueFactory<Question, String>("acertoscurso"));
    acertosRegiao.setCellValueFactory(new PropertyValueFactory<Question, String>("acertosregiao"));
    acertosBrasil.setCellValueFactory(new PropertyValueFactory<Question, String>("acertosbrasil"));
    acertosDif.setCellValueFactory(new PropertyValueFactory<Question, String>("acertosdif"));
    table.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> app.showDetailedWindow(newValue));
  }

  public void setApp(EnadeUFSMExplorer app) {
    this.app = app;
    table.setItems(app.getQuestionData());
  }
}
