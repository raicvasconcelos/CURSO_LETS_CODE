import java.time.LocalDateTime;
import java.util.Comparator;

public class ComparadorData implements Comparator<LocalDateTime> {

  @Override
  public int compare(LocalDateTime o1, LocalDateTime o2) {
    if (o1.isBefore(o2)) {
        return 1;
      } else if (o1.isAfter(o2)) {
        return -1;
      }
      return 0;
    }
}
