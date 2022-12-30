package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class PayPal extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String emailPayPal;
    private String PalavraPassePayPal;

    public PayPal(LocalDate data, double valor, boolean confirmacaoPag, String emailPayPal, String palavraPassePayPal) {
        super(data, valor, confirmacaoPag);
        this.emailPayPal = emailPayPal;
        this.PalavraPassePayPal = palavraPassePayPal;
    }
}