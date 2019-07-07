import java.io.*;
import java.net.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.*;
//import java.io.File;
import java.io.IOException;
import java.io.Reader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// javac -cp .:gson-2.8.5.jar DemoParseGithubWithGson.java
// java -cp .:gson-2.8.5.jar DemoParseGithubWithGson



public class GsonThread extends Thread {
  private String[] repoUrls;
  private GitHubAnalyserGUI app;
  private ObservableList<GitUrl> repoData = FXCollections.observableArrayList();

  public GsonThread(String[] repoUrls, GitHubAnalyserGUI app) {
    this.repoUrls = repoUrls;
    this.app = app;
  }

  public void setApp(GitHubAnalyserGUI app){
    this.app = app;
  }

  public ObservableList<GitUrl> getRepoData() {
    return repoData;
  }

  public void run(){
    int urlCount = repoUrls.length;
    try{
      for(int i=0; i<urlCount; i++){
        repoData.add(getRepoInfo(repoUrls[i]));
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  public synchronized GitUrl getRepoInfo(String repoUrl) throws IOException {
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
    System.out.println(con.getHeaderFields().get("Link").get(0));

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
