package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class PreReserva implements Serializable {
    private static final long serialVersionUID = 1L;
    private final Cliente cliente;

    private final LocalDate dataPartida;
    private final LocalDate dataRegresso;
    private final int numPassageiros;

    public PreReserva(Cliente cliente, LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros) {
        this.cliente = cliente;
        this.dataRegresso = dataRegresso;
        this.numPassageiros = numPassageiros;
        this.dataPartida = dataPartida;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataRegresso() {
        return dataRegresso;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public boolean notificaCliente() {
        String s =  "Existe a possibilidade de criar uma reserva para as data %s e %s".formatted(dataPartida, dataRegresso);
        return this.cliente.addNotificacao(s);
    }
}
