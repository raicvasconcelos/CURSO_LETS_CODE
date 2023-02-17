public class Estudante {

  private String nome;
  private Integer idade;
  private Double n1;
  private Double n2;
  private Double n3;
  private Double mediaNotas;

  public Estudante(String nome, Integer idade, Double n1, Double n2, Double n3) {
    this.nome =nome;
    this.idade = idade;
    this.n1 = n1;
    this.n2 = n2;
    this.n3 = n3;
    this.mediaNotas = (n1+n2+n3)/3;
  }

  public String getNome() {
    return nome;
  }


  public Double getN1() {
    return n1;
  }

  public Double getN2() {
    return n2;
  }

  public Double getN3() {
    return n3;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public Double getMediaNotas() {
    return mediaNotas ;
  }

  @Override
  public String toString() {
    return "Estudante [idade=" + idade + ", mediaNotas=" + mediaNotas + "]";
  }
}
