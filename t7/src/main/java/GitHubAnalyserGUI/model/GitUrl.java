import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class GitUrl {
  private SimpleStringProperty url;
  private SimpleIntegerProperty commitCount;
  private SimpleFloatProperty messageCount;

  public GitUrl(String url, int commitCount, float messageCount){
    this.url = new SimpleStringProperty(url);
    this.commitCount = new SimpleIntegerProperty(commitCount);
    this.messageCount = new SimpleFloatProperty(messageCount);
  }

  public String getUrl(){
    return url.get();
  }

  public void setUrl(String url){
    this.url.set(url);
  }

  public StringProperty urlProperty() {
    return url;
  }

  public int getCommitCount(){
    return commitCount.get();
  }

  public void setCommitCount(int commitCount){
    this.commitCount.set(commitCount);
  }

  public IntegerProperty commitCountProperty() {
    return commitCount;
  }

  public float getMessageCount(){
    return messageCount.get();
  }

  public void setMessageCount(float messageCount){
    this.messageCount.set(messageCount);
  }

  public FloatProperty messageCountProperty() {
    return messageCount;
  }


  @Override
  public String toString(){
    return this.getUrl();
  }
}
