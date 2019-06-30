import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class DetailedWindowController {
  @FXML
  private TextField txtAno;
  @FXML
  private TextField txtProva;
  @FXML
  private TextField txtTipoquestao;
  @FXML
  private TextField txtIdquestao;
  @FXML
  private TextArea txtObjeto;
  @FXML
  private TextArea txtObjetodetalhado;
  @FXML
  private TextField txtGabarito;
  @FXML
  private TextField txtAcertoscurso;
  @FXML
  private TextField txtAcertosregiao;
  @FXML
  private TextField txtAcertosbrasil;
  @FXML
  private TextField txtAcertosdif;
  @FXML
  private Button btnImage;

  private Stage detailedWindowStage;
  private Question selectedQuestion;

  public DetailedWindowController(){}

  @FXML
  public void initialize(){

  }

  public void setDetailedWindowStage(Stage detailedWindowStage){
    this.detailedWindowStage = detailedWindowStage;
  }

  public void setSelectedQuestion(Question selectedQuestion){
    this.selectedQuestion = selectedQuestion;

    txtAno.setText(selectedQuestion.getAno());
    txtProva.setText(selectedQuestion.getProva());
    txtTipoquestao.setText(selectedQuestion.getTipoquestao());
    txtIdquestao.setText(selectedQuestion.getIdquestao());
    txtObjeto.setText(selectedQuestion.getObjeto());
    txtObjetodetalhado.setText(selectedQuestion.getObjetodetalhado());
    txtGabarito.setText(selectedQuestion.getGabarito());
    txtAcertoscurso.setText(selectedQuestion.getAcertoscurso());
    txtAcertosregiao.setText(selectedQuestion.getAcertosregiao());
    txtAcertosbrasil.setText(selectedQuestion.getAcertosbrasil());
    txtAcertosdif.setText(selectedQuestion.getAcertosdif());
    if(selectedQuestion.getUrlcrop()==null) btnImage.setDisable(true);
  }

  public void showImageWindow(String selectedQuestionURL){
    try{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(App.class.getClassLoader().getResource("view/ImageWindowLayout.fxml"));
      Pane window = (Pane) loader.load();

      Stage imageWindowStage = new Stage();
      imageWindowStage.setTitle("Question Image");
      Scene scene = new Scene(window);
      imageWindowStage.setScene(scene);

      ImageWindowController controller = loader.getController();
      controller.setImageWindowStage(imageWindowStage);
      controller.setSelectedQuestionURL(selectedQuestionURL);

      btnImage.setDisable(true);
      imageWindowStage.showAndWait();
      btnImage.setDisable(false);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void handleImageWindow(){
    String selectedQuestionURL = selectedQuestion.getUrlcrop();
    showImageWindow(selectedQuestionURL);
  }
}
