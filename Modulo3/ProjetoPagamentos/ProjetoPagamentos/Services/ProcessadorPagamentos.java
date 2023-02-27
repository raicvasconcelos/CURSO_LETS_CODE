package ProjetoPagamentos.Services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import ProjetoPagamentos.Enums.SITUACAO_PAGAMENTO;
import ProjetoPagamentos.Models.Cliente;
import ProjetoPagamentos.Models.Pagamento;

public class ProcessadorPagamentos implements Runnable {

    private static final Double MULTA_INICIAL = 50.0;
    private static final Double JUROS_SEMANAL = 0.01;
    private static final Double MAX_DESCONTO = 500.0;
    private Pagamento pagamento;

    public ProcessadorPagamentos(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public static void Processar(Pagamento pagamento) {
        pagamento.setValor(calcularValorPagamento(pagamento));
        pagamento.setSituacaoPagamento(SITUACAO_PAGAMENTO.PAGO);
        PagamentoService.atualizar(pagamento);

        atualizarClassificacaoCliente(pagamento);
    }

    private static Double calcularValorPagamento(Pagamento pagamento) {
        if (pagamento.getDataVencimento().isBefore(LocalDate.now())) {
            return pagamento.getValor() + calcularMultaInicial(pagamento) + calcularJurosSemanal(pagamento);
        } else {
            return pagamento.getValor() - calcularDesconto(pagamento);
        }
    }

    private static Double calcularMultaInicial(Pagamento pagamento) {
        long diasAtraso = ChronoUnit.DAYS.between(pagamento.getDataVencimento(), LocalDate.now());
        if (diasAtraso >= 1) {
            return MULTA_INICIAL;
        } else {
            return 0.0;
        }
    }

    private static Double calcularJurosSemanal(Pagamento pagamento) {
        long semanasAtraso = ChronoUnit.WEEKS.between(pagamento.getDataVencimento(), LocalDate.now());
        if (semanasAtraso >= 1) {
            return pagamento.getValor() * (semanasAtraso * JUROS_SEMANAL);
        } else {
            return 0.0;
        }
    }

    private static Double calcularDesconto(Pagamento pagamento) {

        Integer classificacaoCliente = ClienteService.obterPeloCpf(pagamento.getCpf()).getClassificacao();
        Double desconto = pagamento.getValor() * classificacaoCliente / 100;
        if (desconto < MAX_DESCONTO) {
            return desconto;
        } else {
            return MAX_DESCONTO;
        }
    }

    private static void atualizarClassificacaoCliente(Pagamento pagamento) {

        Cliente cliente = ClienteService.obterPeloCpf(pagamento.getCpf());
        Integer classificacao = cliente.getClassificacao();
        Integer mesesAtraso = (int) ChronoUnit.MONTHS.between(pagamento.getDataVencimento(), LocalDate.now());

        if (mesesAtraso >= 1 && classificacao > 0) {
            cliente.setClassificacao(cliente.getClassificacao() - mesesAtraso);
            ClienteService.atualizar(cliente);
        }
    }

    @Override
    public void run() {

        try {
            System.out.println("INI " + Thread.currentThread().getName() + " -> " + pagamento.getId());
            Processar(pagamento);
            Thread.sleep(new Random().nextInt(3) * 1000);
            System.out.println("FIM " + Thread.currentThread().getName() + " -> " + pagamento.getId());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}