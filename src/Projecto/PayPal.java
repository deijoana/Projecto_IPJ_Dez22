package Projecto;

import java.time.LocalDate;

public class PayPal extends Pagamento{

    private String emailPayPal;
    private String PalavraPassePayPal;

    public PayPal(LocalDate data, double valor, boolean confirmacaoPag, String emailPayPal, String palavraPassePayPal) {
        super(data, valor, confirmacaoPag);
        this.emailPayPal = emailPayPal;
        PalavraPassePayPal = palavraPassePayPal;
    }
}
