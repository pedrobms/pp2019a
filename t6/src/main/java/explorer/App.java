//package explorer;

import java.io.IOException;
import java.util.Iterator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class App extends Application{
  private Stage primaryStage;
  private BorderPane rootLayout;
  private static final String CSV_DEFAULT_URL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vTO06Jdr3J1kPYoTPRkdUaq8XuslvSD5--FPMht-ilVBT1gExJXDPTiX0P3FsrxV5VKUZJrIUtH1wvN/pub?gid=0&single=true&output=csv";
  private FileController file = new FileController(CSV_DEFAULT_URL);

  private ObservableList<Question> questionData = FXCollections.observableArrayList();

  public App(){
    if(file.isInit()){
      Iterator<CSVFile> iterator = file.getBeans().iterator();
      while(iterator.hasNext()) {
        CSVFile csvBean = iterator.next();
        Question data = new Question(csvBean.getAno(),csvBean.getProva(),csvBean.getTipoquestao(),csvBean.getIdquestao(),csvBean.getObjeto(),csvBean.getObjetodetalhado(),csvBean.getAcertoscurso(),csvBean.getAcertosregiao(),csvBean.getAcertosbrasil(),csvBean.getAcertosdif(),csvBean.getGabarito(),csvBean.getUrlcrop());
        questionData.add(data);
      }
    }
  }

  public ObservableList<Question> getQuestionData(){
    return questionData;
  }

  @Override
  public void start(Stage primaryStage) {
    this.primaryStage = primaryStage;
    this.primaryStage.setTitle("Enade Explorer");

    initRootLayout();
    showQuestionTable();
  }

  public void initRootLayout() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("view/RootLayout.fxml"));
      rootLayout = (BorderPane) loader.load();

      RootController controller = loader.getController();
      controller.setApp(this);

      Scene scene = new Scene(rootLayout);
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showQuestionTable() {
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("view/QuestionTable.fxml"));
      AnchorPane questionTable = (AnchorPane) loader.load();

      rootLayout.setCenter(questionTable);

      QuestionTableController controller = loader.getController();
      controller.setApp(this);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void showDetailedWindow(Question selectedQuestion){
    try{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("view/DetailedWindowLayout.fxml"));
      GridPane detailedWindow = (GridPane) loader.load();

      Stage detailedWindowStage = new Stage();
      detailedWindowStage.setTitle("Detailed Question Information");
      detailedWindowStage.initModality(Modality.WINDOW_MODAL);
      detailedWindowStage.setResizable(false);
      detailedWindowStage.initOwner(primaryStage);
      Scene scene = new Scene(detailedWindow);
      detailedWindowStage.setScene(scene);

      DetailedWindowController controller = loader.getController();
      controller.setDetailedWindowStage(detailedWindowStage);
      controller.setSelectedQuestion(selectedQuestion);

      detailedWindowStage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void reloadQuestionData() {
    questionData.clear();
    file.setNewFile();
    if(file.isInit()){
      Iterator<CSVFile> iterator = file.getBeans().iterator();
      while(iterator.hasNext()) {
        CSVFile csvBean = iterator.next();
        Question data = new Question(csvBean.getAno(),csvBean.getProva(),csvBean.getTipoquestao(),csvBean.getIdquestao(),csvBean.getObjeto(),csvBean.getObjetodetalhado(),csvBean.getAcertoscurso(),csvBean.getAcertosregiao(),csvBean.getAcertosbrasil(),csvBean.getAcertosdif(),csvBean.getGabarito(),csvBean.getUrlcrop());
        questionData.add(data);
      }
    }
  }

  public void showURLWindow(){
    try {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getClassLoader().getResource("view/NewURLLayout.fxml"));
      HBox urlWindow = (HBox) loader.load();

      Stage urlWindowStage = new Stage();
      urlWindowStage.setTitle("Enter New URL");
      urlWindowStage.initModality(Modality.WINDOW_MODAL);
      urlWindowStage.setResizable(false);
      urlWindowStage.initOwner(primaryStage);
      Scene scene = new Scene(urlWindow);
      urlWindowStage.setScene(scene);

      NewURLController controller = loader.getController();
      controller.setURLStage(urlWindowStage);
      controller.setApp(this);

      urlWindowStage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void setNewURL(String url){
    file.setCsvUrl(url);
  }

  public Stage getPrimaryStage() {
    return primaryStage;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
