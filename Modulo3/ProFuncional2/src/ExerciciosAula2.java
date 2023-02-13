import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class ExerciciosAula2 {

  private static List<Pessoa> pessoas = Arrays.asList(
    new Pessoa(12, EstadoCivil.SOLTEIRO),
    new Pessoa(40, EstadoCivil.CASADO),
    new Pessoa(30, EstadoCivil.DIVORCIADO),
    new Pessoa(55, EstadoCivil.SOLTEIRO),
    new Pessoa(120, EstadoCivil.CASADO)
  );
  private static List<Estudante> estudantes = Arrays.asList(
    new Estudante(12, Double.valueOf(44.5)),
    new Estudante(20, Double.valueOf(64.5)),
    new Estudante(19, Double.valueOf(99.5)),
    new Estudante(22, Double.valueOf(88.75)),
    new Estudante(25, Double.valueOf(94.15))
  );

  private static List<String> strg1 = Arrays.asList("aaaaa", "bbbbb", "ccccc");
  private static List<String> strg2 = Arrays.asList("aaaaa", "bbbbb", "ccccc");

  public static void main(String[] args) {
    exercicio1();
    exercicio2();
    exercicio3();
    exercicio4();
  }

  public static void exercicio1() {
    Predicate<Pessoa> verificaSolteiro = p ->
      p.getEstadoCivil() == EstadoCivil.SOLTEIRO;
    Predicate<Pessoa> verifica50anos = p -> p.getIdade() > 50;

    System.out.println(
      filter(pessoas, verifica50anos.and(verificaSolteiro)).toString()
    );
  }

  public static void exercicio2() {
    Predicate<Pessoa> verificaCasado = p ->
      p.getEstadoCivil() == EstadoCivil.CASADO;
    Predicate<Pessoa> verifica50anos = p -> p.getIdade() > 50;

    System.out.println(
      filter(pessoas, verifica50anos.and(verificaCasado)).toString()
    );
  }

  public static void exercicio3() {
    Predicate<Estudante> verifica18anos = e -> e.getIdade() >= 18;
    Predicate<Estudante> verificaMediaAcima85 = e ->
      e.getMediaNotas() >= Double.valueOf(85);

    System.out.println(
      filter(estudantes, verifica18anos.and(verificaMediaAcima85)).toString()
    );
  }

  public static void exercicio4() {
    BiPredicate<List<String>, List<String>> verificaStrings = (strg1, strg2) ->
      strg1.equals(strg2);
    if (verificaStrings.test(strg1, strg2)) {
      System.out.println("As listas são iguais");
    } else {
      System.out.println("As listas não são iguais");
    }
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> condition) {
    List<T> listaFiltrada = new ArrayList<>();
    for (T t : list) {
      if (condition.test(t)) {
        listaFiltrada.add(t);
      }
    }
    return listaFiltrada;
  }
}
