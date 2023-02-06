public class Multiplicacao implements Calculo {

  private double total;

  public double calculo(double primeiroNumero, double segundoNumero) {
    total = primeiroNumero * segundoNumero;
    return total;
  }
}
