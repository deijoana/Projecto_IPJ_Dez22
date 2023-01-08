package Projecto;

import java.io.Serializable;

/**
 *
 * Classe que define objectos do tipo Motorista
 * @author Joana Ramalho
 * @author Tiago Sousa
 */

public class Motorista implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nomeMotorista;
    private String emailMotorista;
    private String nifMotorista;


    /**
     *
     * @param nomeMotorista
     * @param emailMotorista
     * @param nifMotorista
     */
    public Motorista(String nomeMotorista, String emailMotorista, String nifMotorista) {
        this.nomeMotorista = nomeMotorista;
        this.emailMotorista = emailMotorista;
        this.nifMotorista = nifMotorista;
    }


    /**
     * Método que permite definir o nome do motorista.
     *
     * @param nomeMotorista O novo nome do motorista.
     * @return void
     */
    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
    }

    /**
     * Método que permite definir o email do motorista.
     *
     * @param emailMotorista O novo email do motorista.
     * @return void
     */
    public void setEmailMotorista(String emailMotorista) {
        this.emailMotorista = emailMotorista;
    }

    /**
     * Método que permite definir o email do motorista.
     *
     * @return void
     */
    public String getNifMotorista() {
        return nifMotorista;
    }


    /**
     * Método que retorna a representação em String do motorista.
     *
     * @return A representação em String do motorista.
     */
    @Override
    public String toString() {
        return  " " + nomeMotorista.toUpperCase() +", "+ emailMotorista + ",  NIF: "+nifMotorista + "\n\n";
    }
}