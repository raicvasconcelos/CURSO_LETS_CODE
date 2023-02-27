package ProjetoPagamentos.Enums;

public enum SITUACAO_PAGAMENTO {
    PENDENTE,
    PAGO,
    PROCESSANDO;

    public static SITUACAO_PAGAMENTO getEnum(String string){
        switch(string){
            case "PENDENTE": return SITUACAO_PAGAMENTO.PENDENTE; 
            case "PAGO": return SITUACAO_PAGAMENTO.PAGO;
            case "PROCESSANDO": return SITUACAO_PAGAMENTO.PROCESSANDO; 
            default: throw new RuntimeException(string+ " Não é um valor válido");
        }
    }
}
