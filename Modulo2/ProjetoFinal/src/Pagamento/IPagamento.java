package Pagamento;

public interface IPagamento {
  // void coletaDetalhesPagamento();
  boolean validaPagamento();
  void paga(Double valor);
  // void addToList(MetodoPagamento pagamento);
}
