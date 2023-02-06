package Pagamento;



import java.util.*;

public class MetodoPagamento   {


  private EMetodoPagamento tipoPagamento;


  static ArrayList<MetodoPagamento> listaPagamentos = new ArrayList<MetodoPagamento>();

  public void addToList(MetodoPagamento pagamento) {
    listaPagamentos.add(pagamento);
    System.out.println("Pagamento salvo na lista de pagamentos");
  }

  public static void printList() {
    System.out.println("**** LISTA DE PAGAMENTOS SALVOS ****");
    for (MetodoPagamento pag : listaPagamentos) {
      System.out.println((listaPagamentos.indexOf(pag)+1) + ". " +  pag);
    }
  }

  public static void removeFromlist(MetodoPagamento pagamento) {
    listaPagamentos.remove(pagamento);
    System.out.println(
      pagamento.toString() + " removido da lista"
    );
  }

  public EMetodoPagamento getTipoPagamento() {
    return tipoPagamento;
  }

  public void setTipoPagamento(EMetodoPagamento tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
  }
}
