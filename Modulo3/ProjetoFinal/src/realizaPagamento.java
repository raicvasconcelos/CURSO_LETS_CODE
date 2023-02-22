import java.util.List;

import java.time.LocalDate;
import java.time.Period;

public class realizaPagamento {

  //   private Pagamento pag;
  //   private static CSVReader read;

  public static void main(String[] args) {
    List<Pagamento> pagamentos = CSVReader.readPagamentosfromCSV(
      "./src/folhaPagamentos.CSV"
    );
System.out.println(LocalDate.now());
 
System.out.println(findPagamento("Natasha Caldeirão", pagamentos).getDataVencimento());

// VerificaPrazo(findPagamento("Natasha Caldeirão", pagamentos));
  calculaSemanas(findPagamento("Natasha Caldeirão", pagamentos));
  }

  public static Pagamento findPagamento(
    String name,
    List<Pagamento> pagamentos
  ) {
    return pagamentos
      .stream()
      .filter(pagamento -> name.equals(pagamento.getClienteNome()))
      .findAny()
      .orElse(null);
  }

public static void Pagar(Pagamento pagamento) {






  
}

public static void VerificaPrazo(Pagamento pagamento) {
  if (pagamento.getDataVencimento().isBefore(LocalDate.now()) ) {

    System.out.println("Semanas de atraso = " + pagamento.getDataVencimento().datesUntil(LocalDate.now()));
    System.out.println("pagamento atrasado");
    System.out.println("O valor inicial era: " + pagamento.getValor());
    System.out.println("Multa inicial de R$ 50");
    System.out.println("1% de juros para cada semana de atraso = " );

    pagamento.setValor(pagamento.getValor() + 50.0 + pagamento.getValor()*1.01);
    
  }else{
    System.out.println("pagamento dentro do Prazo");
    // pagamento.getDataVencimento().datesUntil(LocalDate.now())
    // System.out.println("Semanas de atraso = " + LocalDate.now().datesUntil(pagamento.getDataVencimento()).toString());
    Period atraso = Period.between(LocalDate.now(), pagamento.getDataVencimento());
    System.out.println("pagamento atrasado " + atraso.getDays() + " dias, " +  atraso.getMonths() + " meses");

    System.out.println("O valor inicial era: " + pagamento.getValor());
    System.out.println("Multa inicial de R$ 50");
    System.out.println("1% de juros para cada semana de atraso = " );

    pagamento.setValor(pagamento.getValor() + 50.0 + pagamento.getValor()*1.01);


  }
  
}

public static int calculaSemanas(Pagamento pagamento) {
  Period atraso = Period.between(LocalDate.now(), pagamento.getDataVencimento());
  System.out.println("pagamento atrasado " + atraso.getDays() + " dias, " +  atraso.getMonths() + " meses");

  // if (atraso.getDays() !=0) {
  //   return atraso.getDays() + atraso.getMonths()*30;
    
  // }
  System.out.println("Dias de atraso " + atraso.getDays() + atraso.getMonths()*30);
  System.out.println("Semanas " + (atraso.getDays() + atraso.getMonths()*30)/7);

  return atraso.getDays() + atraso.getMonths()*30;
  
}

}
