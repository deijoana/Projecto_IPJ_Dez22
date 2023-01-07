package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

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

    public boolean devePedirIBAN() {
        return false;
    }
}