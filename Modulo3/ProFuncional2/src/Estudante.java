public class Estudante {

  private String nome;
  private Integer idade;
  private Double n1;
  private Double n2;
  private Double n3;

  public Estudante(String nome, Integer idade, Double n1, Double n2, Double n3) {
    this.nome =nome;
    this.idade = idade;
    this.n1 = n1;
    this.n2 = n2;
    this.n2 = n2;
   
  }

  public void setN1(Double n1) {
    this.n1 = n1;
  }

  public void setN2(Double n2) {
    this.n2 = n2;
  }

  public void setN3(Double n3) {
    this.n3 = n3;
  }

  private Double mediaNotas;



 

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public Double getMediaNotas() {
    return (n1+n2+n3)/3;
  }

  public void setMediaNotas(Double mediaNotas) {
    this.mediaNotas = mediaNotas;
  }

  @Override
  public String toString() {
    return "Estudante [idade=" + idade + ", mediaNotas=" + mediaNotas + "]";
  }
}
