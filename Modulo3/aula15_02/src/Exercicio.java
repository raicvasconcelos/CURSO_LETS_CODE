import java.util.*;
import java.util.stream.*;

public class Exercicio {

  public static void main(String[] args) {
    ex1();
    ex2();
    ex3();
    ex4();
    ex5();
  }

  public static void ex1() {
    // 1. Dado um array de inteiros, retorne a soma de todos os números pares

    int[] inteiros = { 1, 2, 3, 4, 5 };
    IntStream stream = Arrays.stream(inteiros);
    int soma = stream.filter(inteiro -> inteiro % 2 == 0).sum();
    System.out.println(soma);
  }

  public static void ex2() {
    // 2. Dado uma lista de strings, selecione apenas as palavras que começam com 'C' e
    // retorne a quantidade de elementos que possuem mais de 5 caracteres.
    List<String> strings = List.of(
      "aaaa",
      "bbbb",
      "cccc",
      "cccccc",
      "ccccccc",
      "dddd"
    );

    long quantidade = strings
      .stream()
      .filter(string -> string.toLowerCase().startsWith("c"))
      .filter(string -> string.length() > 5)
      .count();
    System.out.println(quantidade);
  }

  public static void ex3() {
    // 3. Dado uma lista de Pessoas, retorne uma lista de nomes dos que possuem mais de 30 anos.
    List<Pessoa> pessoas = new ArrayList<>() {
      {
        add(new Pessoa(20, "Maria"));
        add(new Pessoa(40, "Pedro"));
        add(new Pessoa(60, "Paulo"));
      }
    };

    pessoas
      .stream()
      .filter(pessoa -> pessoa.getIdade() > 30)
      .map(pessoa -> pessoa.getNome())
      .forEach(System.out::println);
  }

  public static void ex4() {
    // 4. Dado uma lista de números inteiros, retorne a média dos números maiores que 10.
    List<Integer> listaInteiros = List.of(5, 10, 20, 30, 40, 50);
    listaInteiros
      .stream()
      .filter(inteiro -> inteiro > 10)
      .mapToInt(Integer::intValue)
      .average()
      .ifPresent(System.out::println);
  }

  public static void ex5() {
    // 5. Dado uma lista de Professores, identifique os que possuem avaliação superior a 80
    // e retorne uma lista com nome de seus estudantes, por ordem alfabetica e sem repetição.
    List<Pessoa> pessoas = new ArrayList<>() {
      {
        add(new Pessoa(20, "Maria"));
        add(new Pessoa(40, "Pedro"));
        add(new Pessoa(60, "Paulo"));
      }
    };

    List<Professor> professores = new ArrayList<>() {
      {
        add(new Professor(10, "Zé", 100, pessoas));
        add(new Professor(10, "Carla", 90, pessoas));
        add(new Professor(10, "Juliana", 70, pessoas));
      }
    };

    professores
      .stream()
      .filter(professor -> professor.getAvaliacao() > 80)
      .flatMap(professor -> professor.getEstudantes().stream())
      .map(estudante -> estudante.getNome())
      .distinct()
      .forEach(System.out::println);
  }
}
