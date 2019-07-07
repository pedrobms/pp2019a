import java.io.*;
import java.net.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
//import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class GsonThread extends Thread {
  private List<String> repoUrls = new ArrayList<String>();
  private GitHubAnalyserGUI app;
  private ObservableList<GitUrl> repoData = FXCollections.observableArrayList();

  public void setRepoUrl(String url){
    repoUrls.add(url);
  }

  public void setApp(GitHubAnalyserGUI app){
    this.app = app;
  }

  public synchronized ObservableList<GitUrl> getRepoData() {
    return repoData;
  }

  @Override
  public void run(){
  for(String str: repoUrls){
    try{
      repoData.add(getRepoInfo(str));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
  conditionSignal();
  }

  public synchronized void conditionSignal() {
    this.notifyAll();
  }

  public synchronized void conditionWait() {
    try{
      this.wait();
    } catch(InterruptedException e){
      e.printStackTrace();
    }
  }

  public GitUrl getRepoInfo(String repoUrl) throws IOException {
    int commitCount = 0;
    int messageCount = 0;
    URL url = new URL(repoUrl);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", "Mozilla/5.0");
    System.out.println("Response code: " + con.getResponseCode());

    BufferedReader in = new BufferedReader(
      new InputStreamReader(con.getInputStream()));

    // Response header (includes pagination links)
    //System.out.println(con.getHeaderFields().get("Link").get(0));

    // Parse a nested JSON response using Gson
    JsonParser parser = new JsonParser();
    JsonArray results = parser.parse(in.readLine()).getAsJsonArray();
    System.out.println("Size: "+ results.size());

    for (JsonElement e : results) {
      messageCount = messageCount + e.getAsJsonObject().get("commit").getAsJsonObject().get("message").toString().length();
      commitCount++;
    }
    GitUrl repoData = new GitUrl(repoUrl, commitCount, (float)messageCount/commitCount);
    in.close();
    return repoData;
  }

}
