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

    public String getNomeMotorista() {
        return nomeMotorista;
    }

    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    public String getEmailMotorista() {
        return emailMotorista;
    }

    public void setEmailMotorista(String emailMotorista) {
        this.emailMotorista = emailMotorista;
    }

    public String getNifMotorista() {
        return nifMotorista;
    }

    public void setNifMotorista(String nifMotorista) {
        this.nifMotorista = nifMotorista;
    }

    @Override
    public String toString() {
        return  nomeMotorista +", "+ emailMotorista + ", + NIF: "+nifMotorista + "\n";
    }
}