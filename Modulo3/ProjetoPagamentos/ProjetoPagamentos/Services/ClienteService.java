package ProjetoPagamentos.Services;

import ProjetoPagamentos.Models.Cliente;
import ProjetoPagamentos.Dao.ClienteDao;

public class ClienteService {

    
    public static boolean incluir(Cliente cliente){
        return ClienteDao.incluir(cliente);
    }

    public static boolean atualizar(Cliente cliente){
        return ClienteDao.atualizar(cliente);
    }

    public static boolean excluir(Cliente cliente){
        return ClienteDao.excluir(cliente);
    }

    public static Cliente obterPeloCpf(String cpf){
        return ClienteDao.obterPeloCpf(cpf);
    }

    
}
