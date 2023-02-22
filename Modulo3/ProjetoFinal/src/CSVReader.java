import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {

  public static void main(String[] args) {
    // String caminho = System.getProperty("user.dir");
    List<Pagamento> pagamentos = readPagamentosfromCSV(
      "./src/folhaPagamentos.CSV"
    );
    pagamentos.forEach(System.out::println);
  }

  private static List<Pagamento> readPagamentosfromCSV(String fileName) {
    List<Pagamento> pagamentos = new ArrayList<>();
    Path pathToFile = Paths.get(fileName);

    try (
      BufferedReader br = Files.newBufferedReader(
        pathToFile,
        StandardCharsets.US_ASCII
      )
    ) {
      br.readLine(); //Lê a primeira linha de cabeçalho
      String line = br.readLine();
      while ((line) != null) {
        String[] attributes = line.split(";");
        Pagamento pagamento = createPagamento(attributes);
        pagamentos.add(pagamento);
        line = br.readLine();
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return pagamentos;
  }

  private static Pagamento createPagamento(String[] attributes) {
    String clienteNome = attributes[0];
    LocalDate dataVencimento = LocalDate.parse(
      attributes[1],
      DateTimeFormatter.ofPattern("dd/MM/yyyy")
    );
    Double valor = Double.parseDouble(attributes[2]);
    Integer classificacao = Integer.parseInt(attributes[3]);

    return new Pagamento(clienteNome, dataVencimento, valor, classificacao);
  }
}
