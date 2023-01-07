package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class PayPal extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String emailPayPal;
    private final String PalavraPassePayPal;

    public PayPal(LocalDate data, String emailPayPal, String palavraPassePayPal) {
        super(data);
        this.emailPayPal = emailPayPal;
        this.PalavraPassePayPal = palavraPassePayPal;
    }
}