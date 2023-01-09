package Projecto;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * Classe que define objectos do tipo Multibanco
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public class Multibanco extends Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entidade;
    private String referencia;

    /**
     *
     * @param data representa a data (LocalDate), herdada da classe Pagamento, em que o pagamento é feito
     * @param entidade representa a entidade / empresa que receberá o pagamento
     * @param referencia representa a referência de multibanco usada para o pagamento por multibanco
     */
    public Multibanco(LocalDate data, String entidade, String referencia) {
        super(data);
        this.entidade = entidade;
        this.referencia = referencia;
    }

    /**
     * Método que retorna sempre <code>true</code>, pois esta implementação de pagamento na sub-classe Multibanco requer o fornecimento de um IBAN para efetuar o reembolso de uma reserva cancelada.
     *
     * @return Sempre <code>true</code>
     */
    @Override
    public boolean devePedirIBAN() {
        return true;
    }
}