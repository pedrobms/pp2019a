import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileController {
  private Scanner scanner;
  private Boolean isInit = false;

  public void setFile(File userFile){
    try{      
      this.scanner = new Scanner(userFile);
      this.isInit = true;
    }catch (IOException e) {
      e.printStackTrace();
    }
  }

  public Boolean isInit(){
    return isInit;
  }

  public List<String> getURLList() {
    List<String> listAux = new ArrayList<String>();
    while(scanner.hasNextLine()){
      listAux.add(scanner.nextLine());
    }
    return listAux;
  }
}
