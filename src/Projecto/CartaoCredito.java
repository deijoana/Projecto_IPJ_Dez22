package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class CartaoCredito extends Pagamento implements Serializable {

    private long numCartao;
    private String nomeCartao;
    private LocalDate dataValidade;
    private int codigoSeg;

    public CartaoCredito(LocalDate data, double valor, boolean confirmacaoPag, long numCartao, String nomeCartao, LocalDate dataValidade, int codigoSeg) {
        super(data, valor, confirmacaoPag);
        this.numCartao = numCartao;
        this.nomeCartao = nomeCartao;
        this.dataValidade = dataValidade;
        this.codigoSeg = codigoSeg;
    }

}
