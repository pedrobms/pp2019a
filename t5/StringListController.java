import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class StringListController{
  private FileController file;
  private List<String> names = new ArrayList<String>();

  public void setFile(File userFile){
    file = new FileController(userFile);
  }
  public List<String> getAllListNames(){
    return names;
  }
  public String getFirstListName(){
    return names.get(0);
  }
  public void removeListName(String name){
    if(names.contains(name)) names.remove(name);
  }
  public void addAllFileNames(){
    names.addAll(file.getAllNames());
  }
  public void addSingleListName(String name){
    names.add(name);
  }
  public void removeAllListNames(){
    names.clear();
  }
  public void randomizeListNames(){
    Random rand = new Random();
    List<String> namesAux = new ArrayList<String>();
    String strAux;
    while(names.size() > 0){
      strAux = names.get(rand.nextInt(names.size()));
      namesAux.add(strAux);
      names.remove(strAux);
    }
    names.addAll(namesAux);
  }
  public void randomizeListNamesOnline(){
    PostRandomOrg rand = new PostRandomOrg();
    List<String> namesAux = new ArrayList<String>();
    namesAux.addAll(rand.getRandomizeOnline(this));
    names.clear();
    names.addAll(namesAux);
  }
  public void printNames(){
    for(String str: names){
      System.out.println(str);
    }
  }
}
