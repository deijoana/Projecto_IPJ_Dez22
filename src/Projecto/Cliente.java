package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;


    private TipoSubscricao tipoSubscricao;
    private String modoPagamento;

    public Cliente(String nome, String nif, String morada, String telefone, String email, String tipoUtilizador,
                   String palavraPasse, TipoSubscricao tipoSubscricao, String modoPagamento) {
        super(nome, nif, morada, telefone, email, tipoUtilizador, palavraPasse);
        this.tipoSubscricao = tipoSubscricao;
        this.modoPagamento = modoPagamento;
    }

    public String getModoPagamento() {
        return modoPagamento;
    }

    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    public TipoSubscricao getTipoSubscricao() {
        return tipoSubscricao;
    }

    public void setTipoSubscricao(TipoSubscricao tipoSubscricao) {
        this.tipoSubscricao = tipoSubscricao;
    }


    @Override
    public String toString() {
        return " " + nome + ", NIF: " + nif + ", " + morada + ", " + telefone + ", " + email + ", " + tipoSubscricao + ", " + modoPagamento;
    }

    public boolean isNormal() {
        return this.tipoSubscricao == TipoSubscricao.NORMAL;
    }

    public boolean isPremium() {
        return this.tipoSubscricao == TipoSubscricao.PREMIUM;
    }

    public Reembolso calcularReenbolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamente) {
        return this.tipoSubscricao.calcularReenbolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamente);
    }
}