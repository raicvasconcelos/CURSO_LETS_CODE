package ProjetoPagamentos;

import ProjetoPagamentos.Services.PagamentoService;
import ProjetoPagamentos.Services.ProcessadorPagamentos;
import ProjetoPagamentos.Models.Pagamento;

import java.util.List;

import ProjetoPagamentos.Enums.SITUACAO_PAGAMENTO;
import ProjetoPagamentos.Seed.Seed;
import ProjetoPagamentos.Utils.Console;

public class Main {
    public static void main(String[] args) {

        Console.limpar();

        Seed.run();

        List<Pagamento> pagamentosPendentes = PagamentoService.obterPelaSituacao(SITUACAO_PAGAMENTO.PENDENTE);

        for (Pagamento pagamento : pagamentosPendentes) {
            Thread thread = new Thread(new ProcessadorPagamentos(pagamento));
            thread.start();
            
            boolean useJoin = true;
            // Se não usar o thread.join(), cada thread lê os arquivos em momentos diferentes,
            // podendo acontecer de uma thread alterar o conteúdo do arquivo sobrescrevendo a 
            // alteração da outra, dando a impressão de que um ou mais pagamentos não foram 
            // processados. Usar o thread.join resolve o problema, porque enfileira as threads,
            // porém, o elas não são executadas simultâneamente, perdendo o sentido do multi-thread.
            
            if (useJoin) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
