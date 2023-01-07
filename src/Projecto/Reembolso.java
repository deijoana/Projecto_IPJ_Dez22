package Projecto;

import java.io.Serializable;
import java.util.Objects;


/**
 * Classe que define objectos do tipo Reembolso
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public class Reembolso implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final Reembolso NO_REEMBOLSO = new Reembolso(0.0);
    private final Double valor;


    /**
     * Método que constrói uma nova instância de reembolso, com o valor passado como parâmetro.
     *
     * @param value O valor do reembolso
     */
    public Reembolso(Double value) {
        this.valor = value;
    }

    /**
     * Método que retorna o valor do reembolso.
     *
     * @return O valor do reembolso
     */
    public Double getValue() {
        return valor;
    }


    /**
     * Método que retorna uma representação em forma de texto do valor do reembolso.
     *
     * @return Uma representação em forma de texto do valor do reembolso
     */
    @Override
    public String toString() {
        return "%.2f".formatted(valor);
    }

    /**
     * Método que verifica se o objeto passado como parâmetro é igual ao objeto atual. Dois objetos são considerados iguais se tiverem o mesmo valor de reembolso.
     *
     * @param o O objeto a ser comparado com o objeto atual
     * @return <code>true</code> se os objetos forem iguais, <code>false</code> caso contrário
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reembolso reembolso = (Reembolso) o;
        return Objects.equals(valor, reembolso.valor);
    }

    /**
     * Método que retorna um código de hash para o objeto atual, baseado no seu valor de reembolso.
     *
     * @return O código de hash do objeto atual
     */
    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
