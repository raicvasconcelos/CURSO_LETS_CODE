import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CSVWriter {

  public static void main(String[] args) throws IOException {
    Writer();
  }

  public static void Writer() throws IOException {
    List<List<String>> rows = Arrays.asList(
      Arrays.asList("Jean", "author", "Java"),
      Arrays.asList("David", "editor", "Python"),
      Arrays.asList("Scott", "editor", "Node.js")
    );

    FileWriter csvWriter = new FileWriter("new.csv");
    csvWriter.append("Name");
    csvWriter.append(",");
    csvWriter.append("Role");
    csvWriter.append(",");
    csvWriter.append("Topic");
    csvWriter.append("\n");

    for (List<String> rowData : rows) {
      csvWriter.append(String.join(",", rowData));
      csvWriter.append("\n");
    }

    csvWriter.flush();
    csvWriter.close();
  }
}
