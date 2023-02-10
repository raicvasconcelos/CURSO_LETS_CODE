public class Calculadora {

  //   public Calculadora2(double v1, double v2){}

  private ICalculo getOperacao(int operacao) {
    if (operacao == 1) {
      return new Soma();
    } else if (operacao == 2) {
      return new Subtracao();
    } else if (operacao == 3) {
      return new Multiplicacao();
    } else if (operacao == 4) {
      return new Divisao();
    }
    return null;
  }

  public void executaOperacao(int op, double v1, double v2) {
    // calculo.calculo(v1, v2);
    System.out.println("O resultado da operação é: " +  getOperacao(op).calculo(v1, v2));
  }
}
