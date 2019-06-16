import java.io.*;
import java.util.List;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.geometry.Pos;

public class RandomPickerGUI extends Application{
  private Menu menuFile = new Menu("File");
  private Menu menuHelp = new Menu("Help");
  private MenuBar menu = new MenuBar();
  private MenuItem itemOpen = new MenuItem("Open");
  private MenuItem itemExit = new MenuItem("Exit");
  private MenuItem itemAbout = new MenuItem("About");
  private TextArea txtArea = new TextArea();
  private Button btnShuffleOn = new Button("Shuffle Online");
  private Button btnShuffleOff = new Button("Shuffle");
  private Button btnNext = new Button("Next");
  private FileChooser fileChooser = new FileChooser();
  private StringListController names = new StringListController();
  private Alert about = new Alert(AlertType.NONE, "Random Picker\nCreated by Pedro Bilar Montero", ButtonType.OK);

  public static void main(String[] args) {
    launch(args);
  }

  public void start(Stage stage) {
    stage.setTitle("Random Picker");
    menuFile.getItems().addAll(itemOpen, itemExit);
    menuHelp.getItems().add(itemAbout);
    menu.getMenus().addAll(menuFile, menuHelp);

    btnNext.setDisable(true);

    GridPane grid = new GridPane();
    HBox buttons = new HBox();

    buttons.setAlignment(Pos.CENTER);
    buttons.getChildren().addAll(btnShuffleOff,btnShuffleOn, btnNext);

    itemExit.setOnAction(e->Platform.exit());
    itemAbout.setOnAction(e->about.show());
    itemOpen.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(final ActionEvent e){
        File file = fileChooser.showOpenDialog(stage);
        if (file != null){
           names.setFile(file);
           btnNext.setDisable(true);
           txtArea.clear();
           names.removeAllListNames();
           names.addAllFileNames();
           for(String str: names.getAllListNames()){
             txtArea.appendText(str + "\n");
           }
        }
      }
    });

    btnShuffleOff.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(final ActionEvent e){
        if (names != null){
           names.removeAllListNames();
           for (String line : txtArea.getText().split("\\n")){
             names.addSingleListName(line);
           }
           names.randomizeListNames();
           btnNext.setDisable(false);
           txtArea.clear();
        }
      }
    });
    btnShuffleOn.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(final ActionEvent e){
        if (names != null){
           names.removeAllListNames();
           for (String line : txtArea.getText().split("\\n")){
             names.addSingleListName(line);
           }
           btnNext.setDisable(false);
           names.randomizeListNamesOnline();
           txtArea.clear();
        }
      }
    });
    btnNext.setOnAction(new EventHandler<ActionEvent>(){
      public void handle(final ActionEvent e){
        if (names.getAllListNames().size() > 0){
          String str = names.getFirstListName();
          txtArea.appendText(str + "\n");
          names.removeListName(str);
        }else{
          btnNext.setDisable(true);
        }
      }
    });

    grid.add(menu,0,0);
    grid.add(txtArea,0,1);
    grid.add(buttons,0,2);
    stage.setScene(new Scene(grid, 230, 230));
    stage.show();
  }
}
