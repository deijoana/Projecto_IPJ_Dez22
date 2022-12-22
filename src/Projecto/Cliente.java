package Projecto;

import java.io.Serializable;

public class Cliente extends Utilizador implements Serializable {
    private String tipoSubscricao;
    private String modoPagamento;

    public Cliente(String nome, String nif, String morada, String telefone, String email, String tipoUtilizador,
                   String palavraPasse, String tipoSubscricao, String modoPagamento) {
        super(nome, nif, morada, telefone, email, tipoUtilizador, palavraPasse);
        this.tipoSubscricao = tipoSubscricao;
        this.modoPagamento = modoPagamento;
    }

    public String getTipoSubscricao() {
        return tipoSubscricao;
    }

    public void setTipoSubscricao(String tipoSubscricao) {
        this.tipoSubscricao = tipoSubscricao;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    @Override
    public String toString() {
        return nome + ", NIF: " + nif + ", " + morada + ", " + telefone + ", " + email + ", " + tipoSubscricao + ", " + modoPagamento;
    }
}