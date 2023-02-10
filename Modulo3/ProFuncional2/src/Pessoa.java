package Exercícios;

public class Pessoa {
    private Integer idade;
    private EstadoCivil estadoCivil;
    
    public Pessoa(Integer idade, EstadoCivil estadoCivil) {
        this.idade = idade;
        this.estadoCivil = estadoCivil;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return "Pessoa [idade=" + idade + ", estadoCivil=" + estadoCivil + "]";
    }
    
}
