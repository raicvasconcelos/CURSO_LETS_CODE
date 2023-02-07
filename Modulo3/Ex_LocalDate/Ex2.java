import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;

public class Ex2 {

  public static void main(String[] args) {
    LocalDate aniversario = LocalDate.of(1993, 5, 27);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu: EEEE");

    int esseAno = Year.now().getValue();
    for (
      LocalDate date = aniversario.plusYears(esseAno-aniversario.getYear());
      date.getYear() <= esseAno + 10;
      date = date.plusYears(1)
    ) System.out.println(date.format(formatter));
  }
}
