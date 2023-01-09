package Projecto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * Classe que define objectos do tipo Cliente
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Cliente extends Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;

    private TipoSubscricao tipoSubscricao;
    private String modoPagamento;
    private final Set<String> listaNotificacoes = new LinkedHashSet<>();

    /**
     *
     * @param nome representa o nome do cliente, que herda de utilizador
     * @param nif representa o nif do cliente, que herda de utilizador
     * @param morada representa a morada do cliente, que herda de utilizador
     * @param telefone representa o telefone do cliente, que herda de utilizador
     * @param email representa o email do cliente, que herda de utilizador
     * @param tipoUtilizador representa o tipo de utilizador, neste caso será cliente, que herda de utilizador
     * @param palavraPasse representa a palavra-passe do cliente para aceder à aplicação, que herda de utilizador
     * @param tipoSubscricao representa o tipo de subscrição que o cliente tem: normal ou premium
     * @param modoPagamento representa o método escolhido pelo cliente para pagar a subscrição do pacote premium: paypal, cartão de crédito ou multibanco
     */
    public Cliente(String nome, String nif, String morada, String telefone, String email, String tipoUtilizador,
                   String palavraPasse, TipoSubscricao tipoSubscricao, String modoPagamento) {
        super(nome, nif, morada, telefone, email, tipoUtilizador, palavraPasse);
        this.tipoSubscricao = tipoSubscricao;
        this.modoPagamento = modoPagamento;
    }

    /**
     * Método que verifica se o tipo de subscrição do cliente é NORMAL
     * @return true se o cliente tiver uma subscrição do tipo NORMAL
     */
    public boolean isNormal() {
        return this.tipoSubscricao == TipoSubscricao.NORMAL;
    }

    /**
     * Método que verifica se o tipo de subscrição do cliente é PREMIUM
     * @return true se o cliente tiver uma subscrição do tipo PREMIUM
     */
    public boolean isPremium() {
        return this.tipoSubscricao == TipoSubscricao.PREMIUM;
    }
    /**
     * Método que define o novo método escolhido pelo cliente para pagar a subscrição do pacote premium
     * @param modoPagamento String que representa o novo método para pagar a subscrição do pacote premium
     */
    public void setModoPagamento(String modoPagamento) {
        this.modoPagamento = modoPagamento;
    }

    /**
     * Método que obtém o tipo de subscrição que o cliente tem
     * @return Objecto TipoSubscricao com a informação do tipo de subscrição que o cliente tem
     */
    public TipoSubscricao getTipoSubscricao() {
        return tipoSubscricao;
    }

    /**
     * Método que define o novo tipo de subscrição que o cliente escolhe ter
     * @param tipoSubscricao Objecto TipoSubscricao com a informação do novo tipo de subscrição que o cliente escolhe ter
     */
    public void setTipoSubscricao(TipoSubscricao tipoSubscricao) {
        this.tipoSubscricao = tipoSubscricao;
    }

    /**
     * Método que descreve os objectos da classe Cliente no formato de String
     * @return String com descrição detalhada, incluindo nome, NIF, morada, telefone, email e tipo de subscrição do cliente
     */
    @Override
    public String toString() {
        return " " + nome.toUpperCase() + ", NIF: " + nif +  ", " + email + ", " + tipoSubscricao;
    }

    /**
     * Método que adiciona uma String que descreve uma notificação à lista de notificações do cliente
     * @param notificacao String que representa uma notificação

     */
    public boolean addNotificacao (String notificacao){
        return this.listaNotificacoes.add(notificacao);
    }

    /**
     * Método que obtém a lista de notificações do cliente
     * @return Objecto do tipo List que guarda no formato String informação das notificações
     */
    public List<String> getListaNotificacoes() {
        return List.copyOf(this.listaNotificacoes);
    }

    /**
     * Método que calcula o reembolso devido a um cliente por cancelamento de reserva, de acordo com o tipo de subscrição que o cliente tem
     * @param custo representa o preço pago no momento da reserva
     * @param dataPartida representa a data de partida da reserva
     * @param dataDeCancelamente representa a data em que a reserva foi cancelada
     * @return Objecto do tipo Reembolso que representa o reembolso devido ao cliente
     */
    public Reembolso calcularReenbolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamente) {
        return this.tipoSubscricao.calcularReembolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamente);
    }

    /**
     * Método que verifica se o cliente tem alguma notificação por ler na lista de notificações
     * @return true se houver alguma notificação na lista
     */
    @Override
    public boolean temNovaNotificacoesPorLer() {
        return getNotificacoesNaoVazias().findAny().isPresent();
    }

    /**
     * Método que junta todas as Strings de notificações que estão na lista de notificações numa única String
     * @return String que inclui a(s) notificação (ões) que existem na lista de notificações
     */
    public String getSumarioDeNotificacoes() {
        return getNotificacoesNaoVazias().collect(Collectors.joining("\n\t-"));
    }

    /**
     * Método que filtra a lista de notificações, apresentando as notificações existentes na lista.
     * @return Stream de strings que representa uma cópia das notificações existentes na lista
     */
    private Stream<String> getNotificacoesNaoVazias() {
        return this.listaNotificacoes.stream().filter(Objects::nonNull).filter(s -> !s.isBlank());
    }

    /**
     * Método que limpa todas as notificações que estejam guardadas na lista de notificações
     */
    public void marcarNotificacoesComoLidas() {
        this.listaNotificacoes.clear();
    }
}