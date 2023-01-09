package Projecto;

import java.io.Serializable;
import java.util.UUID;

/**
 *
 * Classe que define objectos do tipo Utilizador
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String nome;
    protected String nif;
    protected String morada;
    protected String telefone;
    protected String email;
    protected String tipoUtilizador;
    protected String palavraPasse;
    protected String id;

    /**
     *
     * @param nome representa o nome do utilizador
     * @param nif representa o nif do utilizador
     * @param morada representa a morada do utilizador
     * @param telefone representa o telefone do utilizador
     * @param email representa o email do utilizador
     * @param tipoUtilizador representa o tipo de utilizador
     * @param palavraPasse representa a palavra-passe do utilizador
     */
    public Utilizador(String nome, String nif, String morada,
                      String telefone, String email, String tipoUtilizador, String palavraPasse) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.tipoUtilizador = tipoUtilizador;
        this.palavraPasse = palavraPasse;
        this.id = UUID.randomUUID().toString(); // define um valor único para ID de cada utilizador
    }



    /**
     * Método que retorna o nome do utilizador.
     *
     * @return O nome do utilizador.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que permite definir o nome do utilizador.
     *
     * @param nome O novo nome do utilizador.
     * @return void
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o NIF do utilizador.
     *
     * @return O NIF do utilizador.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Método que permite definir a morada do utilizador.
     *
     * @param morada A nova morada do utilizador.
     * @return void
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Método que permite definir o telefone do utilizador.
     *
     * @param telefone O novo telefone do utilizador.
     * @return void
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método que retorna o email do utilizador.
     *
     * @return O email do utilizador.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Método que permite definir o email do utilizador.
     *
     * @param email O novo email do utilizador.
     * @return void
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPalavraPasse() {
        return palavraPasse;
    }

    /**
     * Método que permite definir a palavra-passe do utilizador.
     *
     * @param palavraPasse A nova palavra-passe do utilizador.
     * @return void
     */
    public void setPalavraPasse(String palavraPasse) {
        this.palavraPasse = palavraPasse;
    }


    /**
     * Método que retorna a representação em String do cliente
     *
     * @return A representação em String do cliente.
     */
    @Override
    public String toString() {
        return " " + nome.toUpperCase() + ", NIF: " + nif + " + email \n";
    }

    /**
     * Método que retorna sempre <code>false</code>, pois esta implementação não permite a criação de notificações para os utilizadores.
     *
     * @return Sempre <code>false</code>.
     */
    public boolean temNovaNotificacoesPorLer() {
        return false;
    }
}