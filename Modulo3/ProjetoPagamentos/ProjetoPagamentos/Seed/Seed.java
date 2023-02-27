package ProjetoPagamentos.Seed;

import ProjetoPagamentos.Models.Pagamento;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import ProjetoPagamentos.Services.ClienteService;
import ProjetoPagamentos.Services.PagamentoService;
import ProjetoPagamentos.Dao.Database;
import ProjetoPagamentos.Models.Cliente;

public class Seed {

    public static void run() {

        limparArquivosCSV();

        Cliente cliente1 = new Cliente("111", "João");
        Cliente cliente2 = new Cliente("222", "Pedro");
        Cliente cliente3 = new Cliente("333", "Paulo");

        Pagamento pagamento11 = new Pagamento(cliente1.getCpf(), LocalDate.of(2023, 02, 01), 100d);
        Pagamento pagamento12 = new Pagamento(cliente1.getCpf(), LocalDate.of(2023, 03, 01), 100d);
        Pagamento pagamento21 = new Pagamento(cliente2.getCpf(), LocalDate.of(2023, 01, 10), 100d);
        Pagamento pagamento31 = new Pagamento(cliente3.getCpf(), LocalDate.of(2023, 03, 10), 100d);

        ClienteService.incluir(cliente1);
        ClienteService.incluir(cliente2);
        ClienteService.incluir(cliente3);

        PagamentoService.incluir(pagamento11);
        PagamentoService.incluir(pagamento12);
        PagamentoService.incluir(pagamento21);
        PagamentoService.incluir(pagamento31);

    }

    private static void limparArquivosCSV() {
        try {

            Path pathClienteCSV = Database.getClienteCSV();
            Path pathPagamentoCSV = Database.getPagamentoCSV();
            
            Files.delete(pathClienteCSV);
            Files.delete(pathPagamentoCSV);
            
            Database.getClienteCSV();
            Database.getPagamentoCSV();

        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
