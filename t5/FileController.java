import java.io.*;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileController{
  private Scanner scanner;

  public FileController(File userFile){
    try{
      this.scanner = new Scanner(userFile);
    }catch (IOException e) {
      e.printStackTrace();
    }
  }
  public List<String> getAllNames(){
    List<String> listAux = new ArrayList<String>();
    while(scanner.hasNextLine()){
      listAux.add(scanner.nextLine());
    }
    return listAux;
  }
}
