package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que define objectos do tipo Pagamento
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public abstract class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    protected LocalDate data;


    /**
     * @param data representa a data (LocalDate) em que o pagamento é feito
     */
    public Pagamento(LocalDate data) {
        this.data = data;
    }


    /**
     * Método que retorna sempre falso, excepto quando chamado na sub-classe Multibanco
     *
     * @return false
     */
    public boolean devePedirIBAN() {
        return false;
    }
}