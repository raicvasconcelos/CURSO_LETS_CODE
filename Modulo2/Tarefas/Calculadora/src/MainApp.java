import java.util.*;

public class MainApp {

  public static void main(String[] args) throws Exception {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Qual operação você deseja realizar?");
    System.out.println("Entre o digito: ");
    System.out.println("1 - Soma ");
    System.out.println("2 - Subtração ");
    System.out.println("3 - Multiplicação ");
    System.out.println("4 - Divisão ");
    int digito = keyboard.nextInt();

    Calculadora cal = new Calculadora();

    System.out.println("Entre o primeiro número: ");
    double primeiroNumero = keyboard.nextDouble();
    System.out.println("Entre o segundo número: ");
    double segundoNumero = keyboard.nextDouble();

    cal.executaOperacao(digito, primeiroNumero, segundoNumero);

    keyboard.close();
  }
}
