package Projecto;

import java.io.Serializable;

public class Motorista implements Serializable {

    private String nomeMotorista;
    private String emailMotorista;
    private long nifMotorista;

    public Motorista(String nomeMotorista, String emailMotorista, long nifMotorista) {
        this.nomeMotorista = nomeMotorista;
        this.emailMotorista = emailMotorista;
        this.nifMotorista = nifMotorista;
    }

}
