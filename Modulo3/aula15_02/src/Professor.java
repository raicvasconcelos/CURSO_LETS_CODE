import java.util.List;

public class Professor extends Pessoa {

    private int avaliacao;
    private List<Pessoa> estudantes;

    public Professor(int idade, String nome, int avaliacao, List<Pessoa> estudantes) {
        super(idade, nome);
        this.avaliacao = avaliacao;
        this.estudantes = estudantes;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Pessoa> getEstudantes() {
        return estudantes;
    }



    
}
