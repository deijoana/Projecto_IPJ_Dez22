package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que define objectos do tipo PayPal
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PayPal extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String emailPayPal;
    private final String PalavraPassePayPal;


    /**
     *
     * @param data
     * @param emailPayPal
     * @param palavraPassePayPal
     */
    public PayPal(LocalDate data, String emailPayPal, String palavraPassePayPal) {
        super(data);
        this.emailPayPal = emailPayPal;
        this.PalavraPassePayPal = palavraPassePayPal;
    }
}