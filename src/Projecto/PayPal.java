package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que define objectos do tipo PayPal
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PayPal extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String emailPayPal;
    private final String PalavraPassePayPal;


    /**
     * @param data               representa a data (LocalDate), herdada da classe Pagamento, em que o pagamento é feito
     * @param emailPayPal        representa o email da conta Paypal usada para fazer o pagamento
     * @param palavraPassePayPal representa a palavra-passe da conta Paypal usada para fazer o pagamento
     */
    public PayPal(LocalDate data, String emailPayPal, String palavraPassePayPal) {
        super(data);
        this.emailPayPal = emailPayPal;
        this.PalavraPassePayPal = palavraPassePayPal;
    }
}