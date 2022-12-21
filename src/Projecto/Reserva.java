package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {

    private Autocarro bus;
    private Motorista driver;
    private Cliente client;
    private Pagamento pagamento;
    private LocalDate dataPartida;
    private LocalDate dataRegresso;
    private int numPassageiros;
    private String localOrigem;
    private String localDestino;
    private double distancia;


    public Reserva(Autocarro bus, Motorista driver, Cliente client, Pagamento pagamento, LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros, String localOrigem, String localDestino, double distancia) {
        this.bus = bus;
        this.driver = driver;
        this.client = client;
        this.pagamento = pagamento;
        this.dataPartida = dataPartida;
        this.dataRegresso = dataRegresso;
        this.numPassageiros = numPassageiros;
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
        this.distancia = distancia;
    }
}