package Cliente;
import java.util.Date;

public class Cliente {

  private String nome;
  private String cpf;
  private String endereco;
  private Date dataNascimento;

  public Cliente(String nome, String cpf, String endereco) {
    this.nome = nome;
    this.cpf = cpf;
    this.endereco = endereco;
    System.out.println("Cliente criado com sucesso");
  }

public String getNome() {
    return nome;
}

public String getEndereco() {
  return endereco;
}

public Date getDataNascimento() {
  return dataNascimento;
}

public String getCpf() {
    return cpf;
}

  
}
