package Funcionario;

public enum ECargo {
  VENDEDOR(3000),
  GERENTE(6000),
  CONTADOR(5000);

  private double salario;

  private ECargo(double salario) {
    this.salario = salario;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }
}
