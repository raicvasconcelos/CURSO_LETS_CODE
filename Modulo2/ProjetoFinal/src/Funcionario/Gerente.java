package Funcionario;

public class Gerente extends Funcionario {

  public Gerente(String nome, String cpf, String senha) {
    super(nome, cpf, senha,  ECargo.GERENTE);
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
