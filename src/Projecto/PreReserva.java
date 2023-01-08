package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe que define objectos do tipo PreReserva
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PreReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Cliente cliente;

    private final LocalDate dataPartida;
    private final LocalDate dataRegresso;
    private final int numPassageiros;

    /**
     *
     * @param cliente
     * @param dataPartida
     * @param dataRegresso
     * @param numPassageiros
     */
    public PreReserva(Cliente cliente, LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros) {
        this.cliente = cliente;
        this.dataRegresso = dataRegresso;
        this.numPassageiros = numPassageiros;
        this.dataPartida = dataPartida;
    }

    /**
     * Método que retorna o cliente da pré reserva.
     *
     * @return O cliente da  pré reserva.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método que retorna a data de regresso da pré reserva.
     *
     * @return a data de regresso da pré reserva.
     */
    public LocalDate getDataRegresso() {
        return dataRegresso;
    }

    /**
     * Método que retorna o número de passageiros da pré reserva.
     *
     * @return o número de passageiros da pré reserva.
     */
    public int getNumPassageiros() {
        return numPassageiros;
    }

    /**
     * Método que retorna a data de partida da pré reserva.
     *
     * @return a data de regresso da pré reserva.
     */
    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public boolean notificaCliente() {
        String s =  "Existe a possibilidade de criar uma reserva para as data %s e %s".formatted(dataPartida, dataRegresso);
        return this.cliente.addNotificacao(s);
    }

    @Override
    public String toString() {
        return "Pré-reserva em nome de " +cliente.getNome().toUpperCase() +
                " de " + dataPartida +
                " a " + dataRegresso;
    }
}
