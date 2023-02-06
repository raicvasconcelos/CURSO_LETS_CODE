package Pagamento;


public class Pix extends MetodoPagamento implements IPagamento {

  private String nomeConta;
  private String chavePix;
  private EMetodoPagamento tipoPagamento;

  public Pix(String nomeConta, String chavePix) {
    this.nomeConta = nomeConta;
    this.chavePix = chavePix;
    this.tipoPagamento = EMetodoPagamento.PIX;
    super.setTipoPagamento(tipoPagamento);
    
  }

  @Override
  public boolean validaPagamento() {
    if (
      getNomeConta().length() >= 3 && getChavePix().length() >= 8
    ) {
      System.out.println("Os dados da conta foram validados");
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
      " aprovada pelo Pix na conta do portador  " +
      getNomeConta()
    );
  }


  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return (
      "Pix -> " +
      "nome: " +
      getNomeConta() +
      ", chave pix com final: " +
      getChavePix().substring(getChavePix().length() - 4)
    );
  }

  public String getNomeConta() {
    return nomeConta;
  }

  public String getChavePix() {
    return chavePix;
  }
}
