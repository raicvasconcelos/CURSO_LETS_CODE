package Exercícios;

public class Estudante{

    private Integer idade;
    private Double mediaNotas;

    public Estudante(Integer idade, Double mediaNotas) {
        this.idade = idade;
        this.mediaNotas = mediaNotas;
    }
    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public Double getMediaNotas() {
        return mediaNotas;
    }
    public void setMediaNotas(Double mediaNotas) {
        this.mediaNotas = mediaNotas;
    }
    @Override
    public String toString() {
        return "Estudante [idade=" + idade + ", mediaNotas=" + mediaNotas + "]";
    }

    

}
