import java.io.*;
import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class RandomPickerCmd{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in), enter = new Scanner(System.in);
    int op;
    String str;
    File txt;
    StringListController fileNames = new StringListController();
    try{
      if(null!=args[0] && args[0].endsWith(".txt")){
        txt = new File(args[0]);
        fileNames.setFile(txt);
      }else{
        System.out.println("Invalid file");
        System.exit(0);
      }
    } catch (NullPointerException e){
      e.printStackTrace();
    }
    System.out.print("1 - Random Offline\n2 - Random Online\nOption: ");
    op = input.nextInt();
    if(op==1){
      fileNames.addAllFileNames();
      fileNames.randomizeListNames();
      while(fileNames.getAllListNames().size() > 0){
        enter.nextLine();
        str = fileNames.getFirstListName();
        System.out.print(str);
        fileNames.removeListName(str);
      }
      System.out.print("\n");
    }else if(op==2){
      fileNames.addAllFileNames();
      fileNames.randomizeListNamesOnline();
      while(fileNames.getAllListNames().size() > 0){
        enter.nextLine();
        str = fileNames.getFirstListName();
        System.out.print(str);
        fileNames.removeListName(str);
      }
      System.out.print("\n");
    }else{
      System.exit(0);
    }
  }
}
