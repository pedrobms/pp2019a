//package GitHubAnalyserGUI;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GitHubAnalyserGUI extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    private FileController file = new FileController();
    private GsonThread commitAnalyzerThread = new GsonThread();

    private ObservableList<GitUrl> urlList = FXCollections.observableArrayList();

    public GitHubAnalyserGUI(){}

    public void loadUrlList(){
      urlList.clear();
      for(String str: file.getURLList()){
        GitUrl gitUrl = new GitUrl(str, 0, 0);
        urlList.add(gitUrl);
        commitAnalyzerThread.setRepoUrl(gitUrl.getUrl());
      }
    }

    public void loadRepoData(ObservableList<GitUrl> repoInfo) {
      urlList.clear();
      urlList.addAll(repoInfo);
    }

    public void runCommitAnalyzer() {
      commitAnalyzerThread.start();
      commitAnalyzerThread.conditionWait();
      System.out.println(commitAnalyzerThread.getRepoData());
      loadRepoData(commitAnalyzerThread.getRepoData());
    }

    public FileController getFileController(){
      return file;
    }

    public void setUrlList(ObservableList<GitUrl> urlList) {
      this.urlList = urlList;
    }

    public Stage getPrimaryStage() {
      return primaryStage;
    }

    public ObservableList<GitUrl> getUrlList() {
      return urlList;
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

    public void showURLList() {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/URLListLayout.fxml"));
        AnchorPane URLList = (AnchorPane) loader.load();

        rootLayout.setCenter(URLList);

        URLListController controller = loader.getController();
        controller.setApp(this);

      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    @Override
    public void start(Stage primaryStage){
      this.primaryStage = primaryStage;
      this.primaryStage.setTitle("GitHub Analyser");

      initRootLayout();
      showURLList();
    }

    public static void main(String[] args) {
      launch(args);
    }
}
