package ProjetoPagamentos.Models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import ProjetoPagamentos.Dao.Database;
import ProjetoPagamentos.Enums.SITUACAO_PAGAMENTO;
import ProjetoPagamentos.Models.Pagamento;

public class Pagamento {

    private Integer id;
    private String cpf;
    private LocalDate dataVencimento;
    private Double valor;
    private SITUACAO_PAGAMENTO situacaoPagamento;

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Double getValor() {
        return this.valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public SITUACAO_PAGAMENTO getSituacaoPagamento() {
        return this.situacaoPagamento;
    }

    public void setSituacaoPagamento(SITUACAO_PAGAMENTO situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public Pagamento(String cpf, LocalDate dataVencimento, Double valor) {
        this.cpf = cpf;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.situacaoPagamento = SITUACAO_PAGAMENTO.PENDENTE;
    }

    public Pagamento(Integer id, String cpf, LocalDate dataVencimento, Double valor,
            SITUACAO_PAGAMENTO situacaoPagamento) {
        this.id = id;
        this.cpf = cpf;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.situacaoPagamento = situacaoPagamento;
    }

    public String convertToCSV() {

        String stringData = this.getDataVencimento().format(dateTimeFormatter);

        StringBuilder sb = new StringBuilder();
        sb.append(this.getId())
                .append(";")
                .append(this.getCpf())
                .append(";")
                .append(stringData)
                .append(";")
                .append(this.getValor())
                .append(";")
                .append(this.getSituacaoPagamento())
                .append(";");

        return sb.toString();
    }

    public static Pagamento convertToObject(String stringPagamento) {

        Integer id = Integer.parseInt(Database.getValue(Pagamento.class, stringPagamento, "id"));
        String cpf = Database.getValue(Pagamento.class, stringPagamento, "cpf");
        LocalDate dataVencimento = LocalDate.parse(Database.getValue(Pagamento.class, stringPagamento, "dataVencimento"), dateTimeFormatter);
        String valor = Database.getValue(Pagamento.class, stringPagamento, "valor");
        String situacaoPagamento = Database.getValue(Pagamento.class, stringPagamento, "situacaoPagamento");


        Pagamento pagamento = new Pagamento(id, cpf, dataVencimento, Double.parseDouble(valor), SITUACAO_PAGAMENTO.getEnum(situacaoPagamento));
        return pagamento;
    }

}
