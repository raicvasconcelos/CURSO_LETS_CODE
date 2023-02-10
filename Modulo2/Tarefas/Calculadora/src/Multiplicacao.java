public class Multiplicacao implements ICalculo {

  private double total;

  public double calculo(double primeiroNumero, double segundoNumero) {
    total = primeiroNumero * segundoNumero;
    return total;
  }
}
