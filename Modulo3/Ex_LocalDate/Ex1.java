import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex1 {

  public static List<String> datas = Arrays.asList(
    "01/02/2023",
    "05/08/2030",
    "07/04/2024 08:56:00",
    "09/03/2008",
    "18/09/2015",
    "24/06/2042 09:23:00",
    "29/07/2018",
    "30/02/2020",
    "24/06/2042 18:50:00",
    "16/02/2002"
  );

  private static ArrayList<String> listaDatasString = new ArrayList<>();
  private static ArrayList<LocalDateTime> listaDatasFormated = new ArrayList<>();

  public static final DateTimeFormatter formarterDateTime = DateTimeFormatter.ofPattern(
    "dd/MM/uuuu HH:mm:ss"
  );

  public static final DateTimeFormatter formarterDate = DateTimeFormatter.ofPattern(
    "dd/MM/yyyy"
  );

  // static DateTimeFormatter formatterIN = DateTimeFormatter.ofPattern(
  //   "dd/MM/yyyy HH:mm:ss"
  // );

  public static void main(String[] args) {
    normaliza();

    datasRecenteAntiga();
  }

  public static void datasRecenteAntiga() {


    // System.out.println(listaDatasString);
    // Cometario Teste GitHyb

    // System.out.println(listaDatasFormated);
    // listaDatasFormated.sort(compData);
    // System.out.println(listaDatasFormated);

    LocalDateTime dataAntiga = listaDatasFormated.get(0);
    LocalDateTime dataRecente = listaDatasFormated.get(
      listaDatasFormated.size() - 1
    );

    System.out.println(
      "Mais recente -> " +
      dataRecente.toLocalDate().format(formarterDate) +
      " | " +
      dataRecente.toLocalTime() +
      " | " +
      dataRecente.format(formarterDateTime)
    );
    System.out.println(
      "Mais antiga  -> " +
      dataAntiga.toLocalDate().format(formarterDate) +
      " | " +
      dataAntiga.toLocalTime() +
      " | " +
      dataAntiga.format(formarterDateTime)
    );
  }

  public static void normaliza() {
    ArrayList<String> listaTEMP = new ArrayList<>();

    for (String data : datas) {
      if (data.length() <= 10) {
        String dataTEMP = data.concat(" 00:00:00");
        listaTEMP.add(dataTEMP);
      } else {
        listaTEMP.add(data);
      }
    }
    // System.out.println(listaTEMP);

    for (String data : listaTEMP) {
      listaDatasString.add(data);
    }

    
    for (String data : listaDatasString) {
      try {
        listaDatasFormated.add(
          LocalDateTime.parse(
            data,
            formarterDateTime.withResolverStyle(ResolverStyle.STRICT)
          )
        );
      } catch (DateTimeParseException e) {
        System.out.println(e.getMessage());
      }
    }
    // System.out.println(listaDatasFormated);
  }


}
