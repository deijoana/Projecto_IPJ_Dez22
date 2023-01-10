package Projecto;

import java.io.Serializable;

/**
 * Classe que define objectos do tipo Administrador
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Administrador extends Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @param nome           representa o nome do administrador
     * @param nif            representa o nif do administrador
     * @param morada         representa a morada do administrador
     * @param telefone       representa o telefone do administrador
     * @param email          representa o email do administrador
     * @param tipoUtilizador representa o tipo de utilizador, neste caso será administrador
     * @param palavraPasse   representa a palavra-passe do administrador para aceder à aplicação
     */
    public Administrador(String nome, String nif, String morada, String telefone,
                         String email, String tipoUtilizador, String palavraPasse) {
        super(nome, nif, morada, telefone, email, tipoUtilizador, palavraPasse);
    }

    /**
     * Método que descreve os objectos da classe Administrador no formato de String
     *
     * @return String com descrição detalhada, incluindo nome, NIF, morada, telefone e email do administrador
     */
    @Override
    public String toString() {
        return " " + nome + ", NIF: " + nif + ", " + morada + ", " + telefone + ", " + email + "\n";
    }
}

