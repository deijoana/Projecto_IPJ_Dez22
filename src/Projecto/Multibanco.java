package Projecto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Multibanco extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private long entidade;
    private long referencia;

    /**
     *
     * @param data
     * @param valor
     * @param confirmacaoPag
     * @param entidade
     * @param referencia
     */
    public Multibanco(LocalDate data, double valor, boolean confirmacaoPag, long entidade, long referencia) {
        super(data, valor, confirmacaoPag);
        this.entidade = entidade;
        this.referencia = referencia;
    }
}