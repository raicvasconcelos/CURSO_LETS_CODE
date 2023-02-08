import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterfaceFuncional {

  //        Exercicio 1: Reimplemente a calculadora utilizando interface funcional.
  //        Exception 2: Crie uma função em Java que filtre uma lista de strings e retorne apenas aquelas que tenham mais de 5 caracteres usando programação funcional.
  //        Exercício 3: Crie uma função em Java que retorne a soma dos números pares de uma lista de números inteiros usando programação funcional.
  //        Exercício 4: Crie uma função em Java que retorne a soma dos números impares de uma lista de números inteiros usando programação funcional.
  //        Exercicio 5: Crie uma implementação de foreach usando a interface Consumer

  public static void main(String[] args) {
    exercicio1(5, 4);
    exercicio2();
    exercicio3();
    exercicio4();
    exercicio5();
  }

  public static void exercicio1(double v1, double v2) {
    ICalculadora soma = (valor1, valor2) -> valor1 + valor2;
    ICalculadora subtracao = (valor1, valor2) -> valor1 - valor2;
    ICalculadora multiplicacao = (valor1, valor2) -> valor1 * valor2;
    ICalculadora divisao = (valor1, valor2) -> valor1 / valor2;

    System.out.println("Exercício 1-------------------");
    System.out.println("Soma: " + soma.calcula(v1, v2));
    System.out.println("Subtração: " + subtracao.calcula(v1, v2));
    System.out.println("Multiplicação: " + multiplicacao.calcula(v1, v2));
    System.out.println("Divisão: " + divisao.calcula(v1, v2));
  }

  public static void exercicio2() {
    List<String> arr = Arrays.asList(
      "ana",
      "banana",
      "casa",
      "interface",
      "computador"
    );

    List<String> result = arr
      .stream()
      .filter(k -> k.length() > 5)
      .collect(Collectors.toList());

    System.out.println("Exercício 2-------------------");
    System.out.println(result);
  }

  public static void exercicio3() {
    List<Integer> arr = Arrays.asList(1, 2, 5, 3, 6, 7);
    Stream<Integer> filter = arr.stream().filter(k -> k % 2 == 0);
    Integer result = filter.reduce(0, (a, b) -> a + b);

    System.out.println("Exercício 3-------------------");
    System.out.println("Soma dos números pares: " + result);
  }

  public static void exercicio4() {
    List<Integer> arr = Arrays.asList(1, 2, 5, 3, 6, 7);
    Stream<Integer> filter = arr.stream().filter(k -> k % 2 == 1);
    Integer result = filter.reduce(0, (a, b) -> a + b);

    System.out.println("Exercício 4-------------------");
    System.out.println("Soma dos números ímpares: " + result);
  }

  public static void exercicio5() {
    List<String> lista = Arrays.asList("a", "b", "c");
    Consumer<String> stringConsumer = a -> System.out.println(a);

    System.out.println("Exercício 5-------------------");
    lista.forEach(stringConsumer);
  }
}
