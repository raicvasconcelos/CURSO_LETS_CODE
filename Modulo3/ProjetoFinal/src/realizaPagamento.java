import java.util.List;

import java.time.LocalDate;
import java.time.Period;

public class realizaPagamento {


  public static void main(String[] args) {
    List<Pagamento> pagamentos = CSVReader.readPagamentosfromCSV(
      "./src/folhaPagamentos.CSV"
    );
// System.out.println(LocalDate.now());
 
// System.out.println(findPagamento("Natasha Caldeirão", pagamentos).getDataVencimento());

// VerificaPrazo(findPagamento("Natasha Caldeirão", pagamentos));
  // calculaSemanas(findPagamento("Natasha Caldeirão", pagamentos));
  Pagar(findPagamento("Natasha Caldeirão", pagamentos));
  }

  public static Pagamento findPagamento(String name,List<Pagamento> pagamentos) {
    return pagamentos
      .stream()
      .filter(pagamento -> name.equals(pagamento.getClienteNome()))
      .findAny()
      .orElse(null);
  }

public static void Pagar(Pagamento pagamento) {
  System.out.println("Verificando pagamento ... " );
  VerificaPrazo(pagamento);
  System.out.println("Confirmar pagamento?");
 
}

public static void VerificaPrazo(Pagamento pagamento) {
  if (pagamento.getDataVencimento().isBefore(LocalDate.now()) ) {

    System.out.println("Pagamento Atrasado!");
    System.out.println("Semanas de atraso = " + calculaSemanas(pagamento));
    System.out.println("O valor inicial era: " + pagamento.getValor());
    System.out.println("Multa inicial é de R$ 50");
    System.out.println("1% de juros para cada semana de atraso = " + pagamento.getValor()*0.01*calculaSemanas(pagamento));

    Double totalAtraso = pagamento.getValor() + pagamento.getValor()*0.01*calculaSemanas(pagamento) + 50.0;
    System.out.println("O total a ser pago é: " + totalAtraso);
    // return totalAtraso;
    
  }else{
    System.out.println("Pagamento dentro do Prazo!");
    Double totalDesconto = pagamento.getValor() - calculaDesconto(pagamento);
    System.out.println("O valor inicial era: " + pagamento.getValor());
    System.out.println("Sua classificação "+ pagamento.getClassificacao() + " rendeu um desconto de R$" + calculaDesconto(pagamento));
    System.out.println("O total a ser pago é: "  + totalDesconto);
    // return totalDesconto;
  }
  
}

public static int calculaSemanas(Pagamento pagamento) {
  Period atraso = Period.between(LocalDate.now(), pagamento.getDataVencimento());
  // System.out.println("pagamento atrasado " + atraso.getDays() + " dias, " +  atraso.getMonths() + " meses");
  Double atrasoDouble = Double.valueOf(atraso.getDays()/7.0) + Double.valueOf((atraso.getMonths()*30)/7.0);
  int atrasoSemanas = (int) (Math.floor(atrasoDouble));

  return Math.abs(atrasoSemanas);
  
}

public static Double calculaDesconto(Pagamento pagamento) {
  Double desconto = pagamento.getValor()*(pagamento.getClassificacao()/100.0);
  if (desconto > 500.0) {
    return 500.0;
  }return desconto;
}





}
