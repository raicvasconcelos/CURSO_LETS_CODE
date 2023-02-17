import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import org.w3c.dom.views.DocumentView;

public class ExerciciosAula {

  private static List<Pessoa> pessoas = Arrays.asList(
    new Pessoa(12, EstadoCivil.SOLTEIRO),
    new Pessoa(40, EstadoCivil.CASADO),
    new Pessoa(30, EstadoCivil.DIVORCIADO),
    new Pessoa(55, EstadoCivil.SOLTEIRO),
    new Pessoa(120, EstadoCivil.CASADO)
  );

  private static List<Estudante> listEstudantes = Arrays.asList(
    new Estudante("Joan", 12, 58.3, 83.6, 90.6),
    new Estudante("Victor", 20, 81.3, 0.6, 91.),
    new Estudante("Samael", 19, 95.3, 99.6, 92.7),
    new Estudante("Godah", 22, 96.2, 95.6, 95.7),
    new Estudante("Meire", 25, 99.3, 78.6, 55.7)
  );

  private static List<Funcionario> listFuncionarios = Arrays.asList(
    new Funcionario("Tonio", "gerente"),
    new Funcionario("Camila", "vendedor"),
    new Funcionario("Valter", "vendedor")
  );

  private static List<String> listaString1 = Arrays.asList(
    "aaaaa",
    "bbbbb",
    "ccccc",
    "ddd"
  );
  private static List<String> listaString2 = Arrays.asList(
    "aaaaa",
    "bbbbb",
    "ccccc",
    "ddd"
  );

  private static List<Integer> listaInteiros = Arrays.asList(
    0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377
  );

  public static void main(String[] args) {
    exercicio1();
    exercicio2();
    exercicio3();
    exercicio4(listaString1, listaString2);
    exercicio5(listFuncionarios).forEach(System.out::println);
    exercicio6(listEstudantes).forEach(System.out::println);
    exercicio7(listEstudantes);
    exercicio8(listaInteiros);
  }

  public static void exercicio1() {
    System.out.println("######### EX1 ##########");
    // Escreva um método que aceite uma lista de pessoas e use Predicates para verificar se há pelo menos uma pessoa com idade
    // acima de 50 anos e que seja solteira.
    Predicate<Pessoa> verificaSolteiro = p ->
      p.getEstadoCivil() == EstadoCivil.SOLTEIRO;
    Predicate<Pessoa> verifica50anos = p -> p.getIdade() > 50;

    System.out.println(
      filter(pessoas, verifica50anos.and(verificaSolteiro)).toString()
    );
  }

  public static void exercicio2() {
    System.out.println("######### EX2 ##########");
    // Escreva um método que aceite uma lista de pessoas e use Predicates para verificar se há pelo menos uma pessoa com
    // idade acima de 50 anos e que seja casada.

    Predicate<Pessoa> verificaCasado = p ->
      p.getEstadoCivil() == EstadoCivil.CASADO;
    Predicate<Pessoa> verifica50anos = p -> p.getIdade() > 50;

    System.out.println(
      filter(pessoas, verifica50anos.and(verificaCasado)).toString()
    );
  }

  public static void exercicio3() {
    System.out.println("######### EX3 ##########");
    //  Escreva um método que aceite uma lista de estudantes e use Predicates para verificar se há pelo menos um estudante com idade acima de 18 anos e que
    //  tenha uma média de notas acima de 85.

    Predicate<Estudante> verifica18anos = e -> e.getIdade() >= 18;
    Predicate<Estudante> verificaMediaAcima85 = e ->
      e.getMediaNotas() >= Double.valueOf(85);

    System.out.println(
      filter(listEstudantes, verifica18anos.and(verificaMediaAcima85))
        .toString()
    );
  }

  public static void exercicio4(List<String> listaString1,List<String> listaString2
  ) {
    System.out.println("######### EX4 ##########");
    //  Escreva um método que aceite duas listas de strings e use um BiPredicate para verificar se a primeira string da primeira lista é igual à primeira
    // string da segunda lista, a segunda string da primeira lista é igual à segunda string da segunda lista, e assim por diante.
    BiPredicate<String, String> verificaStrings = (s1, s2) -> s1.equals(s2);

    if (BiFilter(listaString2, listaString1, verificaStrings)) {
      System.out.println("As listas são iguais");
    } else {
      System.out.println("As listas não são iguais");
    }
  }

  public static List<String> exercicio5(List<Funcionario> funcionarios) {
    System.out.println("######### EX5 ##########");
    // Escreva um método que aceite uma lista de objetos de funcionários e use uma Function para extrair o nome de cada
    // funcionário e retornar uma lista de strings.
    List<String> nomeFuncionario = new ArrayList();
    funcionarios.forEach(f -> {
      nomeFuncionario.add(f.getNome());
    });
    return nomeFuncionario;
  }

  public static List<Integer> exercicio6(List<Estudante> listEstudates) {
    System.out.println("######### EX6 ##########");
    // Escreva um método que aceite uma lista de estudantes e use uma Function para extrair a média de notas de cada
    // estudante e retornar uma lista de números inteiros.
    List<Integer> listNotasInt = new ArrayList<Integer>();
    listEstudates.forEach(estudante -> {
      listNotasInt.add(estudante.getMediaNotas().intValue());
    });
    return listNotasInt;
  }

  public static void exercicio7(List<Estudante> listEstudates) {
    System.out.println("######### EX7 ##########");
    // Escreva um método que aceite uma lista de estudantes e use um Consumer para calcular a média de notas de todos os estudantes,
    // e depois imprimir o resultado na tela.

    Consumer<List<Estudante>> calculaMedia = list -> list
        .stream()
        .forEach(a -> {
          OptionalDouble dbStream = DoubleStream.of(a.getN1(), a.getN2(), a.getN3()).average();
          if (dbStream.isPresent()) {
            System.out.println(dbStream.getAsDouble());
          }
        });

    calculaMedia.accept(listEstudates);
  }

  public static void exercicio8(List<Integer> listaInteiros){
    System.out.println("######### EX8 ##########");
     // Escreva um método que aceite uma lista de números inteiros e use um Consumer para aplicar 
    // uma operação matemática (raiz quadrada ou cálculo do quadrado) em cada elemento da lista, e depois imprimir o resultado na tela.

    Consumer <List<Integer>> consumerInteiros = list -> list.stream().forEach(a->{
    System.out.println(Math.sqrt(a));
    // System.out.println(Math.pow(a, 2));
    });

    consumerInteiros.accept(listaInteiros);
   

  }


 public void exercicio9() {
  System.out.println("######### EX9 ##########");
  // Escreva um método que use um Supplier para gerar uma lista de números inteiros aleatórios. Imprima a lista na tela.
  
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

  public static Boolean BiFilter(
    List<String> list1,
    List<String> list2,
    BiPredicate condition
  ) {
    for (int i = 0; i < list1.size(); i++) {
      boolean isEqual = condition.test(list1.get(i), list2.get(i));
      System.out.println(list1.get(i) + "  " + list2.get(i));
      if (!isEqual) {
        return false;
      }
    }
    return true;
  }
}
