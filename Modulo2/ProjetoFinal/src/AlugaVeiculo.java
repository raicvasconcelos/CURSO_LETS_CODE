import Cliente.Cliente;
import Funcionario.Funcionario;
// import AlugaVeiculo.AlugaVeiculo;
import Pagamento.MetodoPagamento;
import Veiculo.Veiculo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AlugaVeiculo {

  private Cliente cliente;
  private Veiculo veiculo;
  private Funcionario funcionario;
  private MetodoPagamento pagamento;
  private LocalDate dataAluguel;
  private int numeroDias;
  private LocalDate dataEntrega;

  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(
    "dd/MM/yyyy"
  );

  static ArrayList<AlugaVeiculo> listaAluguel = new ArrayList<AlugaVeiculo>();

  public AlugaVeiculo(
    Funcionario funcionario,
    Cliente cliente,
    Veiculo veiculo,
    MetodoPagamento pagamento,
    int numeroDias
  ) {
    this.funcionario = funcionario;
    this.cliente = cliente;
    this.veiculo = veiculo;
    this.pagamento = pagamento;
    this.dataAluguel = LocalDate.now();
    this.numeroDias = numeroDias;
    this.dataEntrega = LocalDate.now().plusDays(numeroDias);
    System.out.println("aluguel registrado com sucesso");
  }

  public static void addToList(AlugaVeiculo aluguel) {
    listaAluguel.add(aluguel);
    System.out.println("Aluguel salvo na lista");
  }

  public static void printList() {
    System.out.println("**** LISTA DE ALUGUEIS ****");
    for (AlugaVeiculo aluguel : listaAluguel) {
      System.out.println((listaAluguel.indexOf(aluguel) + 1) + ". " + aluguel);
      // index++;
    }
  }

  public static void removeFromlist(AlugaVeiculo aluguel) {
    listaAluguel.remove(aluguel);
    System.out.println("Aluguel removido da lista");
  }

  @Override
  public String toString() {
    return (
      "Funcionário: " +
      getFuncionario().getNome() +
      ", Veiculo: " +
      getVeiculo().getTipo() +
      ", Placa: " +
      getVeiculo().getPlaca() +
      ", Cliente: " +
      getCliente().getNome() +
      ", Forma de pagamento: " +
      getPagamento().getTipoPagamento() +
      ", Data: " +
      formattedDate(getDataAluguel()) +
      ", Data de entrega: " +
     formattedDate(getDataEntrega())
    );
  }

  public static String formattedDate(LocalDate date) {
    if (date == null) return "TBA";
    return DATE_FORMATTER.format(date);
  }

  public LocalDate getDataEntrega() {
    return dataEntrega;
  }

  public MetodoPagamento getPagamento() {
    return pagamento;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public int getNumeroDias() {
    return numeroDias;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public Funcionario getFuncionario() {
    return funcionario;
  }

  public void setFuncionario(Funcionario funcionario) {
    this.funcionario = funcionario;
  }

  public void setNumeroDias(int numeroDias) {
    this.numeroDias = numeroDias;
  }

  public LocalDate getDataAluguel() {
    return dataAluguel;
  }
}
