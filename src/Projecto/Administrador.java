package Projecto;

public class Administrador extends Utilizador{

    private String palavraPasseAdmin;

    public Administrador(String nomeUtilizador, long nif, String morada, int telefone, String emailUtilizador, int id, String palavraPasseAdmin) {
        super(nomeUtilizador, nif, morada, telefone, emailUtilizador, id);
        this.palavraPasseAdmin = palavraPasseAdmin;
    }

}
