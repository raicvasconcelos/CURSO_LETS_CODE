package ProjetoPagamentos.Services;

import java.util.List;

import ProjetoPagamentos.Dao.PagamentoDao;
import ProjetoPagamentos.Enums.SITUACAO_PAGAMENTO;
import ProjetoPagamentos.Models.Pagamento;

public class PagamentoService {

    public static boolean incluir(Pagamento pagamento){
        return PagamentoDao.incluir(pagamento);
    }

    public static boolean atualizar(Pagamento pagamento){
        return PagamentoDao.atualizar(pagamento);
    }

    public static boolean excluir(Pagamento pagamento){
        return PagamentoDao.excluir(pagamento);
    }

    public static Pagamento obterPeloId(int id){
        return PagamentoDao.obterPeloId(id);
    }

    public static List<Pagamento> obterPelaSituacao(SITUACAO_PAGAMENTO situacaoPagamento){
        return PagamentoDao.obterPelaSituacao(situacaoPagamento);
    }

    public static Pagamento obterProximoPendente(){
        return PagamentoDao.obterProximoPendente();
    }

}
