import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pagamento {

private String clienteNome;
private LocalDate dataVencimento ;
private Double valor;
private Integer classificacao;

public static final DateTimeFormatter formarterDate = DateTimeFormatter.ofPattern(
    "dd/MM/yyyy"
  );


public Pagamento(String clienteNome, LocalDate dataVencimento, Double valor, Integer classificacao) {
    this.clienteNome = clienteNome;
    this.dataVencimento = dataVencimento;
    this.valor = valor;
    this.classificacao = classificacao;
}


public String getClienteNome() {
    return clienteNome;
}


public void setDataVencimento(LocalDate dataVencimento) {
    this.dataVencimento = dataVencimento;
}


public void setValor(Double valor) {
    this.valor = valor;
}


public void setClassificacao(Integer classificacao) {
    this.classificacao = classificacao;
}


public LocalDate getDataVencimento() {
    return dataVencimento;
}


public Double getValor() {
    return valor;
}


public Integer getClassificacao() {
    return classificacao;
}


@Override
public String toString() {
    return "Pagamento [clienteNome = " + clienteNome + ", dataVencimento = " + dataVencimento.format(formarterDate) + ", valor = " + valor
            + ", classificacao = " + classificacao + "]";
}


    
}
