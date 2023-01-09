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
     * @param cliente representa o cliente ao qual está associada a pré-reserva
     * @param dataPartida representa a data de partida escolhida
     * @param dataRegresso representa a data de regresso escolhida
     * @param numPassageiros representa o número de passageiros
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

    /**
     * Método que adiciona uma notificação à lista de notificações do cliente associado à pré-reserva
     * @return true
     */
    public boolean notificaCliente() {
        String s =  "Existe a possibilidade de criar uma reserva para as data %s e %s".formatted(dataPartida, dataRegresso);
        return this.cliente.addNotificacao(s);
    }

    /**
     * Método que descreve os objectos da classe PreReserva no formato de String
     * @return string com informação detalhada da pré-reserva: o nome do cliente, a data de partida e a data de regresso
     */
    @Override
    public String toString() {
        return "Pré-reserva em nome de " +cliente.getNome().toUpperCase() +
                " de " + dataPartida +
                " a " + dataRegresso;
    }


}
