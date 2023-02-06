package Funcionario;

public class Vendedor extends Funcionario {

  public Vendedor(String nome, String cpf, String senha) {
    super(nome, cpf, senha, ECargo.VENDEDOR);
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
