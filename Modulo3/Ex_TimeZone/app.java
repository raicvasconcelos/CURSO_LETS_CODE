import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.TimeUnit;

public class app {

  public static void main(String[] args) {
    // Exercicio 1: Converta um ZonedDateTime de "Asia/Tokyo" para "Europe/London".

    ZonedDateTime local = ZonedDateTime.now();
    // System.out.println(local);

    // ZonedDateTime Tokyo = ZonedDateTime.of(LocalDate.now(),ZoneId.of( "Europe/Paris" ));

    ZonedDateTime kolkata = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));

    ZonedDateTime paris = ZonedDateTime.now(ZoneId.of("Europe/Paris"));

    ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

    System.out.println("Em Tóquio é: " + tokyo.toLocalTime());
    System.out.println("Em Paris é: " + paris.toLocalTime());

    ZonedDateTime timeConvert = tokyo.withZoneSameInstant(
      ZoneId.of("Europe/Paris")
    );
    System.out.println("A conversão de tempo é: "+timeConvert.toLocalTime());

    // Exercicio 2: Calcule a diferença em horas entre dois ZonedDateTime em diferentes timezones.
    // System.out.println(kolkata);
    // System.out.println(tokyo);
    // System.out.println(paris);

    Duration timeDiff = Duration.between(
      tokyo.toLocalTime(),
      kolkata.toLocalTime()
    );

    // System.out.println(timeDiff);
    System.out.println(
      "A Diferença de horas entre Tokyo e Calcutá é " +
      timeDiff.abs().toHours() +
      " horas e " +
      timeDiff.abs().toMinutesPart() + 
      " minutos"
    );


    // Exercício 3: Calcule a quantidade de dias úteis entre duas datas.

    int workDays = diasUteis(
      LocalDate.of(2023, 02, 06),
      LocalDate.of(2023, 8, 31)
    );

    System.out.println(
      "Tem " + workDays + " dias úteis entre as datas pesquisadas"
    );

    // Exercício 4: Calcule a quantidade de horas, minutos e segundos entre dois horarios.

    LocalTime tempoI = LocalTime.of(19, 30, 0);
    LocalTime tempoF = LocalTime.of(23, 0, 0);

    LocalTime tempoEntre = quantidadeHoras(tempoI, tempoF);
    System.out.println(
      "Entre " +
      tempoI +
      " e " +
      tempoF +
      " tem: " +
      tempoEntre.getHour() +
      " horas " +
      tempoEntre.getMinute() +
      " minutos" +
      " e " +
      tempoEntre.getSecond() +
      " segundos"
    );
  }

  public static int diasUteis(LocalDate d1, LocalDate d2) {
    int dias = 0;
    for (LocalDate date = d1; !date.isAfter(d2); date = date.plusDays(1)) {
      DayOfWeek diaSemana = date.getDayOfWeek();
      if (
        !(
          diaSemana.equals(DayOfWeek.SATURDAY) ||
          diaSemana.equals(DayOfWeek.SUNDAY)
        )
      ) {
        dias++;
      }
    }
    return dias;
  }

  public static LocalTime quantidadeHoras(LocalTime t1, LocalTime t2) {
    int sec = 0;
    for (
      LocalTime hora1 = t1;
      hora1.isBefore(t2);
      hora1 = hora1.plusSeconds(1)
    ) {
      sec++;
    }
    return LocalTime.ofSecondOfDay(sec);
  }
}
