package Funcionario;

public class Contador extends Funcionario {

  public Contador(String nome, String cpf, String senha) {
    super(nome, cpf, senha, ECargo.CONTADOR);
    //TODO Auto-generated constructor stub
  }

  @Override
  public String toString() {
    return (
      super.getNome() +
      ", cpf: " +
      super.getCpf() +
      ", cargo: " +
      super.getCargo()
    );
  }
}
