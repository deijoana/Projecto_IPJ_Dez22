package Projecto;

public class Cliente extends Utilizador{

    private String palavraPasse;
    private String tipoSubscricao;
    private String modoPagamento;

    public Cliente(String nomeUtilizador, long nif, String morada, int telefone, String emailUtilizador, int id, String palavraPasse, String tipoSubscricao, String modoPagamento) {
        super(nomeUtilizador, nif, morada, telefone, emailUtilizador, id);
        this.palavraPasse = palavraPasse;
        this.tipoSubscricao = tipoSubscricao;
        this.modoPagamento = modoPagamento;
    }

    public void setTipoSubscricao(String tipoSubscricao) {
        this.tipoSubscricao = tipoSubscricao;
    }
}
