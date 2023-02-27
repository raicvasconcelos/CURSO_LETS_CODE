package ProjetoPagamentos.Dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

import ProjetoPagamentos.Models.Cliente;

public class ClienteDao {

    static Path clienteCSV = Database.getClienteCSV();

    public static boolean incluir(Cliente cliente) {
        try {
            String stringCliente = cliente.convertToCSV();
            Database.Cliente.add(stringCliente);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao incluir Cliente: " + e.getMessage());
            return false;
        }
    }

    public static boolean atualizar(Cliente cliente) {
        try {
            String linhasAtualizadas = Files.lines(clienteCSV)
                    .collect(Collectors.joining(System.lineSeparator()))
                    .replaceFirst(cliente.getCpf()+";.*",cliente.convertToCSV());
            
            Database.Cliente.persist(linhasAtualizadas);
            return true;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao incluir Cliente: " + e.getMessage());
        }
    }

    public static boolean excluir(Cliente cliente) {
        try {
            String linhasAtualizadas = Files.lines(clienteCSV)
                    .filter(linha -> linha.startsWith(cliente.getCpf() + ";") == false)
                    .collect(Collectors.joining(System.lineSeparator()));
            Database.Cliente.persist(linhasAtualizadas);
            return true;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao incluir Cliente: " + e.getMessage());
        }
    }

    public static Cliente obterPeloCpf(String cpf) {
        try {
            Optional<String> linhaCliente = Files.lines(clienteCSV).filter(linha -> linha.startsWith(cpf + ";"))
                    .findFirst();
            if (linhaCliente.isPresent()) {
                return Cliente.convertToObject(linhaCliente.get());
            } else {
                return null;
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao incluir Cliente: " + e.getMessage());
        }
    }

}
