import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageWindowController {
  @FXML
  private ImageView imageContainer;
  private Image imageTexture;

  private Stage imageWindowStage;
  private String selectedQuestionURL;

  public ImageWindowController(){

  }

  public void initialize(){

  }

  public void setImageWindowStage(Stage imageWindowStage){
    this.imageWindowStage = imageWindowStage;
  }

  public void setSelectedQuestionURL(String selectedQuestionURL){
    this.selectedQuestionURL = selectedQuestionURL;
    if(selectedQuestionURL!=null){
      this.imageTexture = new Image(selectedQuestionURL);
      this.imageContainer.setImage(imageTexture);
      this.imageContainer.setCache(true);
    }else{
      this.imageTexture = null;
      this.imageContainer = null;
    }
  }

}
