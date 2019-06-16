import java.net.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PostRandomOrg {
  List<String> namesRandomized = new ArrayList<String>();
  public List<String> getRandomizeOnline(StringListController file){
  	try {
      String urlstr = "https://www.random.org/lists/?mode=advanced";
      URL url = new URL(urlstr);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("POST");
      con.setRequestProperty("User-Agent", "Mozilla/5.0");
      con.setDoOutput(true);
      String data = "list=";
      for(String str: new ArrayList<String>(file.getAllListNames())){
        data = data + str + "%0D%0A";
      }
      data = data + "&format=plain&rnd=new";
      System.out.println(data);
      // Envia dados pela conexão aberta
      con.getOutputStream().write(data.getBytes("UTF-8"));
      System.out.println("Response code: " + con.getResponseCode());

      // Cria objeto que fará leitura da resposta pela conexão aberta
      BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));

      // Lê resposta, linha por linha
      String responseLine;
      while ((responseLine = in.readLine()) != null) {
        //response.append(responseLine + "\n");
        namesRandomized.add(responseLine);
      }
      in.close();
    } catch (IOException e) {
      System.out.println("Fail");
    	//e.printStackTrace();
    }
    return namesRandomized;
  }
}
