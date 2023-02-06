package Pagamento;

public class Transferencia extends MetodoPagamento implements IPagamento {

  private String nomeConta;
  private String cpf;
  private String agencia;
  private String contaNumero;
  private EMetodoPagamento tipoPagamento;

  public Transferencia(
    String nomeConta,
    String cpf,
    String agencia,
    String contaNumero
  ) {
    this.nomeConta = nomeConta;
    this.cpf = cpf;
    this.agencia = agencia;
    this.contaNumero = contaNumero;
    this.tipoPagamento = EMetodoPagamento.TRANSFERENCIA;
    super.setTipoPagamento(tipoPagamento);
  }

  @Override
  public boolean validaPagamento() {
    if (getNomeConta().length() >= 3 && getCpf().length() == 11) {
      System.out.println("O dados do cartão foram validados");
      return true;
    } else System.out.println("Dados invalidos");
    return false;
  }

  @Override
  public void paga(Double valor) {
    System.out.println("Enviando dados para pagamento ...");
    System.out.println(
      "Compra no valor de R$ " +
      valor +
      " aprovada na conta  " +
      "agência: " +
      getAgencia() +
      " número: " +
      getContaNumero()
    );
  }

  @Override
  public String toString() {
    return (
      "Conta Corrente -> " +
      "nome: " +
      getNomeConta() +
      ", agência: " +
      getAgencia() +
      ", conta: " +
      getContaNumero()
    );
  }

  public String getNomeConta() {
    return nomeConta;
  }

  public String getCpf() {
    return cpf;
  }

  public String getAgencia() {
    return agencia;
  }

  public String getContaNumero() {
    return contaNumero;
  }
}
