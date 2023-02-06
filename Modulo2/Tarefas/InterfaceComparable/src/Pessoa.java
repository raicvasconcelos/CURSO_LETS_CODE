public class Pessoa implements Comparable<Pessoa> {

  private String nome;
  private int idade;

  public Pessoa(final String nome, final int idade) {
    this.nome = nome;
    this.idade = idade;
  }

  public String getNome() {
    return this.nome;
  }

  @Override
  public String toString() {
    return "O meu nome é " + this.nome + " e tenho " + this.idade + " anos!";
  }

  @Override
  public int compareTo(Pessoa pessoa) {
    if (this.nome.charAt(0) > pessoa.getNome().charAt(0)) {
      return 1;
    } else if (this.nome.charAt(0) < pessoa.getNome().charAt(0)) {
      return -1;
    } else {
      return 0;
    }
  }
}
