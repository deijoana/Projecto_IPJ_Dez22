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
     * @param data
     * @param numCartao
     * @param nomeCartao
     * @param dataValidade
     * @param codigoSeg
     */
    public CartaoCredito(LocalDate data, String numCartao, String nomeCartao, String dataValidade, String codigoSeg) {
        super(data);
        this.numCartao = numCartao;
        this.nomeCartao = nomeCartao;
        this.dataValidade = dataValidade;
        this.codigoSeg = codigoSeg;
    }

}