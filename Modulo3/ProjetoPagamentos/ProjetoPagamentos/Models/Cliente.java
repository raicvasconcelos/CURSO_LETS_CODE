package ProjetoPagamentos.Models;

import ProjetoPagamentos.Dao.Database;

public class Cliente {

    private final Integer classificacaoPadrao = 10;
    
    private String cpf;
    private String nome;
    private Integer classificacao;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Integer getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }
    
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.classificacao = classificacaoPadrao;
    }
    
    public String convertToCSV(){

        StringBuilder sb = new StringBuilder();
        sb.append(this.getCpf())
            .append(";")
            .append(this.getNome())
            .append(";")
            .append(this.getClassificacao())
            .append(";");

        return sb.toString();
    }

    public static Cliente convertToObject(String stringCliente){
    

        String cpf = Database.getValue(Cliente.class, stringCliente, "cpf");
        String nome = Database.getValue(Cliente.class, stringCliente, "nome");
        String classificacao = Database.getValue(Cliente.class, stringCliente, "classificacao");

        Cliente cliente = new Cliente(cpf, nome);
        cliente.classificacao = Integer.parseInt(classificacao);

        return cliente;
    }

}
