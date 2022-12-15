package Projecto;

import java.time.LocalDate;

public class Multibanco extends Pagamento{

    private long entidade;
    private long referencia;

    public Multibanco(LocalDate data, double valor, boolean confirmacaoPag, long entidade, long referencia) {
        super(data, valor, confirmacaoPag);
        this.entidade = entidade;
        this.referencia = referencia;
    }
}
