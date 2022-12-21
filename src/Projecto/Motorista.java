package Projecto;

import java.io.Serializable;

public class Motorista implements Serializable {

    private String nomeMotorista;
    private String emailMotorista;
    private String nifMotorista;

    public Motorista(String nomeMotorista, String emailMotorista, String nifMotorista) {
        this.nomeMotorista = nomeMotorista;
        this.emailMotorista = emailMotorista;
        this.nifMotorista = nifMotorista;
    }

}