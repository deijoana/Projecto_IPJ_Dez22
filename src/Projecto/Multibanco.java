package Projecto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Multibanco extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entidade;
    private String referencia;

    /**
     *
     * @param data

     * @param entidade
     * @param referencia
     */
    public Multibanco(LocalDate data, String entidade, String referencia) {
        super(data);
        this.entidade = entidade;
        this.referencia = referencia;
    }
}