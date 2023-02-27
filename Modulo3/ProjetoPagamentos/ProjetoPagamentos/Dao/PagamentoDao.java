package ProjetoPagamentos.Dao;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import ProjetoPagamentos.Enums.SITUACAO_PAGAMENTO;
import ProjetoPagamentos.Models.Pagamento;
import ProjetoPagamentos.Services.PagamentoService;

public class PagamentoDao {

    static Path pagamentoCSV = Database.getPagamentoCSV();

    private static Integer newId() throws IOException {

        Function<String, Pagamento> functionConvertPagamento = (str) -> {
            return Pagamento.convertToObject(str);
        };
        Optional<Integer> maxId = Files.lines(pagamentoCSV)
                .skip(1)
                .map(functionConvertPagamento)
                .max(Comparator.comparing(Pagamento::getId))
                .map(pagamento -> pagamento.getId());

        if (maxId.isPresent()) {
            return maxId.get() + 1;
        } else {
            return 1;
        }
    }

    public static boolean incluir(Pagamento pagamento) {
        try {
            pagamento.setId(newId());
            String stringPagamento = pagamento.convertToCSV();
            Database.Pagamento.add(stringPagamento);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao incluir Pagamento: " + e.getMessage());
            return false;
        }
    }

    public static boolean atualizar(Pagamento pagamento) {
        try {
            // A tentativa de substituir a linha antiga pela atualizada usando o método
            // abaixo comentado) não funcionou corretamente. O replaceFirst sobrescreve uma quebra
            // de linha quando é relizada a segunda alteração no arquivo, quebrando ele.

            // String linhasAtualizadas = Files.lines(pagamentoCSV)
            // .collect(Collectors.joining(System.lineSeparator()))
            // .replaceFirst(pagamento.getId() + ";.*", pagamento.convertToCSV());
            // return true;

            List<String> listaPagamento = Files.lines(pagamentoCSV).collect(Collectors.toList());
            String pagamentoOriginal = PagamentoService.obterPeloId(pagamento.getId()).convertToCSV();
            listaPagamento.set(listaPagamento.indexOf(pagamentoOriginal), pagamento.convertToCSV());
            String linhasAtualizadas = listaPagamento.stream().collect(Collectors.joining(System.lineSeparator()));
            Database.Pagamento.persist(linhasAtualizadas);
            return true;

        } catch (IOException e) {
            throw new RuntimeException("IOException: Erro ao atualizar Pagamento: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: Erro ao atualizar Pagamento: " + e.getMessage());
        }

    }

    public static boolean excluir(Pagamento pagamento) {
        try {
            String linhasAtualizadas = Files.lines(pagamentoCSV)
                    .filter(linha -> linha.startsWith(pagamento.getId() + ";") == false)
                    .collect(Collectors.joining(System.lineSeparator()));
            Database.Pagamento.persist(linhasAtualizadas);
            return true;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao incluir Pagamento: " + e.getMessage());
        }
    }

    public static Pagamento obterPeloId(int id) {
        try {
            Optional<String> linhaPagamento = Files.lines(pagamentoCSV)
                    .filter(linha -> linha.startsWith(id + ";"))
                    .findFirst();
            if (linhaPagamento.isPresent()) {
                return Pagamento.convertToObject(linhaPagamento.get());
            } else {
                return null;
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao incluir Pagamento: " + e.getMessage());
        }
    }

    public static List<Pagamento> obterPelaSituacao(SITUACAO_PAGAMENTO situacaoPagamento) {
        try {
            List<Pagamento> pagamentos = Files.lines(pagamentoCSV)
                    .skip(1)
                    .filter(linha -> {
                        Pagamento pagamento = Pagamento.convertToObject(linha);
                        if (pagamento.getSituacaoPagamento() == situacaoPagamento) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .map(item -> Pagamento.convertToObject(item))
                    .collect(Collectors.toList());

            return pagamentos;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao obter Pagamentos pela situação: " + e.getMessage());
        }
    }

    public static Pagamento obterProximoPendente() {
        try {

            Optional<String> optionalPagamento = Files.lines(pagamentoCSV)
                    .skip(1)
                    .filter(linha -> {
                        Pagamento pagamento = Pagamento.convertToObject(linha);
                        if (pagamento.getSituacaoPagamento() == SITUACAO_PAGAMENTO.PENDENTE) {
                            return true;
                        } else {
                            return false;
                        }
                    })
                    .findFirst();

            if (optionalPagamento.isPresent()) {
                return Pagamento.convertToObject(optionalPagamento.get());
            } else {
                return null;
            }

        } catch (IOException e) {
            throw new RuntimeException("IOException: Erro ao obter próximo Pagamento pendente: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Exception: Erro ao obter próximo Pagamento pendente: " + e.getMessage());
        }
    }

}
