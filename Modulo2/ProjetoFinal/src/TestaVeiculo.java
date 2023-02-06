// import Veiculo.Veiculo.*;
import Veiculo.*;
import java.beans.VetoableChangeListener;

public class TestaVeiculo {

  public static void main(String[] args) {
    Veiculo celta = new Carro("celta", "RLV-865", 2010);

    Veiculo fusca = new Carro("fusca", "JTB - 962", 1982);

    Veiculo.addToList(celta);
    Veiculo.addToList(fusca);

    Veiculo Cg150 = new Moto( "Cg 150", "qwe-753", 2017);
    Veiculo.addToList(Cg150);

    Veiculo Caminhao1 = new Caminhao("FH 540", "tyu - 962", 2020);
    Veiculo.addToList(Caminhao1);
    
    Veiculo.printList();

    Veiculo.removeFromlist(fusca);
    Veiculo.printList();
  }
}
