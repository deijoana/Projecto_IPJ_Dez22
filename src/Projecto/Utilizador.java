package Projecto;

public class Utilizador {

    protected String nomeUtilizador;
    protected long nif;
    protected String morada;
    protected int telefone;
    protected String emailUtilizador;
    protected int id;

    public Utilizador(String nomeUtilizador, long nif, String morada, int telefone, String emailUtilizador, int id) {
        this.nomeUtilizador = nomeUtilizador;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        this.emailUtilizador = emailUtilizador;
        this.id = id;
    }
}
