package Projecto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class Multibanco extends Pagamento implements Serializable {

    private long entidade;
    private long referencia;

    public Multibanco(LocalDate data, double valor, boolean confirmacaoPag, long entidade, long referencia) {
        super(data, valor, confirmacaoPag);
        this.entidade = entidade;
        this.referencia = referencia;
    }
}
