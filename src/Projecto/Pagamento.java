package Projecto;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Classe que define objectos do tipo Pagamento
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    protected LocalDate data;


    /**
     *
     * @param data

     */
    public Pagamento(LocalDate data) {
        this.data = data;
    }


    /**
     * Método que retorna sempre <code>true</code>, pois esta implementação de pagamento requer o fornecimento de um IBAN para efetuar o reembolso.
     *
     * @return Sempre <code>true</code>
     */
    public boolean devePedirIBAN() {
        return false;
    }
}