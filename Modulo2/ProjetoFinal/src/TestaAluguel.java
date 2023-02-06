import Funcionario.ECargo;
import Funcionario.Funcionario;
import Funcionario.*;
import Pagamento.*;
import Veiculo.Veiculo;
import Funcionario.Gerente;
import Veiculo.Carro;

import java.time.LocalDateTime;

import Cliente.Cliente;

// import java.*;

// import Vei
public class TestaAluguel {

  public static void main(String[] args) {
    Veiculo fusca = new Carro("fusca", "JFL-8513", 1978);

    Funcionario g1 = new Gerente("Gerilson", "012354684", "1254");

    Funcionario v1 = new Vendedor(
      "Vendenildo Ofertas da Silva",
      "32154654",
      "3213"
    );

    Cliente cliente = new Cliente("Clielton", "019956231", "alameda");

    // Funcionario g1 = new Gerente("Gerilson", "558116l", "123", ECargo.GERENTE);

    MetodoPagamento c1 = new CartaoCredito(
      "Carton de Credilson",
      "254664131",
      "02/2029",
      5885
    );

    // MetodoPagamento p1 = new CartaoCredito();
    // c1.coletaDetalhesPagamento();
    c1.addToList(c1);
    MetodoPagamento pix1 = new Pix("Pixidilson", "65asd4fd8s48");
    // pix1.coletaDetalhesPagamento();
    pix1.addToList(pix1);

    MetodoPagamento pix2 = new Pix("Pixângela", "65asd42752758");
    pix2.addToList(pix2);

    MetodoPagamento t1 = new Transferencia(
      "Transferilda",
      "8521369745",
      "5567-4",
      "52159-9"
    );
    t1.addToList(t1);

    Veiculo celta = new Carro("Celta", "lfr-856", 2010);


    Veiculo.addToList(fusca);

    AlugaVeiculo aluguel1 = new AlugaVeiculo(g1, cliente, celta, pix1, 5);
    

    AlugaVeiculo aluguel2 = new AlugaVeiculo(v1, cliente, fusca, c1, 6);
    AlugaVeiculo.addToList(aluguel2);

    AlugaVeiculo aluguel3 = new AlugaVeiculo(v1, cliente, celta, t1, 2);
    AlugaVeiculo.addToList(aluguel3);
    AlugaVeiculo.addToList(aluguel1);

    


    
    // AlugaVeiculo.printList();
    
    MetodoPagamento.printList();

    // AlugaVeiculo.removeFromlist(aluguel1);
    AlugaVeiculo.printList();

    // CRUD.addToList(aluguel3);

    // CRUD.addToList(t1);

    // CRUD.printList();

  }
}
