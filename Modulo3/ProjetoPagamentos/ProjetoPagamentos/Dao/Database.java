package ProjetoPagamentos.Dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;

public class Database {

    private static final String dirRaiz = "ProjetoPagamentos";
    private static final String dirCSV = "CSV";
    private static final String fileClienteCSV = "clientes.csv";
    private static final String filePagamentoCSV = "pagamento.csv";

    private static void writeCSV(Path pathCSV, String content) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        BufferedWriter writer = Files.newBufferedWriter(pathCSV, charset);
        writer.write(content);
        writer.flush();
        writer.close();
    }

    public static class Cliente {
        public static void persist(String content) throws IOException {
            writeCSV(getClienteCSV(), content);
        }

        public static void add(String content) throws IOException {
            Files.writeString(getClienteCSV(), System.lineSeparator() + content, StandardOpenOption.APPEND);
        }
    }

    public static class Pagamento {
        public static void persist(String content) throws IOException {
            writeCSV(getPagamentoCSV(), content);
        }
        public static void add(String content) throws IOException {
            Files.writeString(getPagamentoCSV(), System.lineSeparator() + content, StandardOpenOption.APPEND);
        }
    }

    public static Path getClienteCSV() {
        Path pathCliente = Paths.get(dirRaiz, dirCSV, fileClienteCSV);
        try {
            validarPathClienteCSV(pathCliente);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao validar path " + pathCliente);
        }
        return pathCliente;
    }

    public static Path getPagamentoCSV() {
        Path pathPagamento = Paths.get(dirRaiz, dirCSV, filePagamentoCSV);
        try {
            validarPathPagamentoCSV(pathPagamento);
        } catch (

        IOException e) {
            throw new RuntimeException("Erro ao validar path " + pathPagamento);
        }
        return pathPagamento;
    }

    private static void validarPathClienteCSV(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.write(path, "cpf;nome;classificacao".getBytes());
        }
    }

    private static void validarPathPagamentoCSV(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.write(path, "id;cpf;dataVencimento;valor;situacaoPagamento".getBytes());
        }
    }

    @SuppressWarnings("rawtypes")
    public static String getValue(Class classe, String linha, String propriedade) {

        try {

            String value = null;
            Path path = null;

            switch (classe.getSimpleName()) {
                case "Cliente":
                    path = Database.getClienteCSV();
                    break;
                case "Pagamento":
                    path = Database.getPagamentoCSV();
                    break;
                default:
                    throw new RuntimeException("Classe não suportada pelo método getValue");
            }

            Optional<String> cabecalho = Files.lines(path).findFirst();

            if (cabecalho.isPresent()) {
                String[] arrCabecalho = cabecalho.get().split(";");
                String[] arrValores = linha.split(";");

                for (int i = 0; i < arrCabecalho.length; i++) {
                    if (arrCabecalho[i].equals(propriedade)) {
                        value = arrValores[i];
                        break;
                    }
                }

            }

            return value;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao obter valor da propriedade " + propriedade
                    + " do objeto pertencente à classe " + classe.getSimpleName());
        }

    }

}
