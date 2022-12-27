package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {

    private Autocarro bus;
    private Motorista driver;
    private Cliente client;
    private double custo;

    private LocalDate dataPartida;
    private LocalDate dataRegresso;
    private int numPassageiros;
    private String localOrigem;
    private String localDestino;
    private double distancia;


    public Reserva(Autocarro bus, Motorista driver, Cliente client, LocalDate dataPartida, LocalDate dataRegresso, int numPassageiros, String localOrigem, String localDestino, double distancia) {
        this.bus = bus;
        this.driver = driver;
        this.client = client;
        this.dataPartida = dataPartida;
        this.dataRegresso = dataRegresso;
        this.numPassageiros = numPassageiros;
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
        this.distancia = distancia;
        calcularCustoViagem();
    }

    public Autocarro getBus() {
        return bus;
    }

    public void setBus(Autocarro bus) {
        this.bus = bus;
    }

    public Motorista getDriver() {
        return driver;
    }

    public void setDriver(Motorista driver) {
        this.driver = driver;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }


    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }

    public LocalDate getDataRegresso() {
        return dataRegresso;
    }

    public void setDataRegresso(LocalDate dataRegresso) {
        this.dataRegresso = dataRegresso;
    }

    public int getNumPassageiros() {
        return numPassageiros;
    }

    public void setNumPassageiros(int numPassageiros) {
        this.numPassageiros = numPassageiros;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }


    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    // este metodo pode ficar na reserva
    public void calcularCustoViagem(){
        this.custo = this.getDistancia()*0.55 + 1.2*this.getNumPassageiros();
    }

    @Override
    public String toString() {
        return "Reserva: de " + dataPartida + " a " + dataRegresso +" desde " +localOrigem + " até " + localDestino + " para " + numPassageiros + " pessoas. Custo total: " + custo + "€\n";

    }
}