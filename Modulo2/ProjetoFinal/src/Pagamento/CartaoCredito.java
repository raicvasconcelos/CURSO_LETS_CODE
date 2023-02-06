package Pagamento;


public class CartaoCredito extends MetodoPagamento implements IPagamento {

  private String nomeCartao;
  private String numeroCartao;
  private String expDate;
  private int cvv;
  private EMetodoPagamento tipoPagamento;

  public CartaoCredito(
    String nomeCartao,
    String numeroCartao,
    String expDate,
    int cvv
  ) {
    this.nomeCartao = nomeCartao;
    this.numeroCartao = numeroCartao;
    this.expDate = expDate;
    this.cvv = cvv;
    this.tipoPagamento = EMetodoPagamento.CARTAO;
    super.setTipoPagamento(tipoPagamento);
  }

  @Override
  public void paga(Double valor) {
    System.out.println("Enviando dados para pagamento ...");
    System.out.println(
      "Compra no valor de R$ " +
      valor +
      " aprovada no cartão com final " +
      getNumeroCartao().substring(getNumeroCartao().length() - 4)
    );
  }

  @Override
  public boolean validaPagamento() {
    if (
      getNomeCartao().length() >= 3 && String.valueOf(getCvv()).length() == 3
    ) {
      System.out.println("O dados do cartão foram validados");
      return true;
    } else System.out.println("Dados invalidos");
    return false;
  }

  
  @Override
  public String toString() {
       return (
      "Cartão de Crédito -> " +
      "nome: " +
      getNomeCartao() +
      ", cartão com final: " +
      getNumeroCartao().substring(getNumeroCartao().length() - 4)
    );
  }

  public String getNomeCartao() {
    return nomeCartao;
  }

  public String getNumeroCartao() {
    return numeroCartao;
  }

  public String getExpDate() {
    return expDate;
  }

  public int getCvv() {
    return cvv;
  }
}
