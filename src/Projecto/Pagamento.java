package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    protected LocalDate data;
    protected double valor;
    protected boolean confirmacaoPag;

    public Pagamento(LocalDate data, double valor, boolean confirmacaoPag) {
        this.data = data;
        this.valor = valor;
        this.confirmacaoPag = confirmacaoPag;
    }

}