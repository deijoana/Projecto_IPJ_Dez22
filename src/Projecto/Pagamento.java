package Projecto;

import java.time.LocalDate;

public class Pagamento {

    protected LocalDate data;
    protected double valor;
    protected boolean confirmacaoPag;

    public Pagamento(LocalDate data, double valor, boolean confirmacaoPag) {
        this.data = data;
        this.valor = valor;
        this.confirmacaoPag = confirmacaoPag;
    }

}
