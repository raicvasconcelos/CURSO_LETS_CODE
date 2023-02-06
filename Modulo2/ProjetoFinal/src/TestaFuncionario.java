import Funcionario.*;
import Funcionario.*;
import Funcionario.ECargo;
import Funcionario.Funcionario;
import Funcionario.Vendedor;
import Pagamento.*;
import Veiculo.Veiculo;
import java.lang.reflect.GenericSignatureFormatError;

public class TestaFuncionario {

  public static void main(String[] args) {
    Funcionario g1 = new Gerente(
      "Gerilson",
      "654613213",
      "6532"
    );

    Funcionario v1 = new Vendedor(
      "Vendenildo Ofertas da Silva",
      "32154654",
      "3213"
    );

    Funcionario c1 = new Contador(
      "Contadouglas Contagem Certa",
      "653213",
      "54621"
    );

    g1.addToList(g1);
    v1.addToList(v1);
    c1.addToList(c1);

    Funcionario.printList();
    Funcionario.removeFromlist(g1);
    Funcionario.printList();
    // System.out.println(g1.getSalario());
  }
}
