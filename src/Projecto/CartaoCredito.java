package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que define objectos do tipo Cartão de Crédito
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public class CartaoCredito extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    private final  String numCartao;
    private final  String nomeCartao;
    private final  String dataValidade;
    private final  String codigoSeg;


    /**
     *
     * @param data representa a data (LocalDate), herdada da classe Pagamento, em que o pagamento é feito
     * @param numCartao representa o número do cartão de crédito
     * @param nomeCartao representa o nome associado ao carttão de crédito
     * @param dataValidade representa a data de validade do cartão de crédito
     * @param codigoSeg representa o código de segurança do cartão de crédito
     */
    public CartaoCredito(LocalDate data, String numCartao, String nomeCartao, String dataValidade, String codigoSeg) {
        super(data);
        this.numCartao = numCartao;
        this.nomeCartao = nomeCartao;
        this.dataValidade = dataValidade;
        this.codigoSeg = codigoSeg;
    }

}