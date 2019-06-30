import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class FileController{
  private Reader reader;
  private CsvToBean<CSVFile> csvToBean;
  private URL csvUrl;
  private File csvFile;
  private Boolean isInit = false;
  private static final String CSV_FILE_PATH = "enade.csv";

  public FileController(String defaultUrl){
    try{
      this.csvFile = new File(CSV_FILE_PATH);
      this.csvUrl = new URL(defaultUrl);
      if(!csvFile.exists()){
        FileUtils.copyURLToFile(this.csvUrl, this.csvFile);
        System.out.println("download ok");
      }
      this.reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
      this.csvToBean = new CsvToBeanBuilder(reader)
        .withType(CSVFile.class)
        .withIgnoreLeadingWhiteSpace(true)
        .build();
      this.isInit = true;
    } catch(IOException e) {
        this.isInit = false;
        System.out.println("fail to load");
    }
  }

  public void setNewFile(){
      try{
        FileUtils.copyURLToFile(csvUrl, csvFile);
        System.out.println("download ok");
        this.reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
        this.csvToBean = new CsvToBeanBuilder(reader)
          .withType(CSVFile.class)
          .withIgnoreLeadingWhiteSpace(true)
          .build();
        this.isInit = true;
      } catch(IOException e) {
          this.isInit = false;
          System.out.println("fail to load");
      }
  }

  public void setCsvUrl(String url){
    try{
      this.csvUrl = new URL(url);
    } catch (IOException e){
      System.out.println("fail to add new url");
    }
  }

  public Boolean isInit(){
    return isInit;
  }

  public CsvToBean getBeans(){
    return csvToBean;
  }

}
