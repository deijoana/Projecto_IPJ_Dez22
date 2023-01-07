package Projecto;

import java.io.Serializable;
import java.time.LocalDate;

/**
* Classe que define objectos do tipo Reserva
* @author Joana Ramalho
* @author Tiago Sousa
*/
public class Reserva implements Serializable {


    private static final long serialVersionUID = 1L;
    private Autocarro bus;
    private Motorista driver;
    private Cliente client;
    private double custo;

    private LocalDate dataPartida;
    private LocalDate dataRegresso;
    private int numPassageiros;
    private String localOrigem;
    private String localDestino;
    private double distancia;
    private String id;

    private final Pagamento pagamento;

    /**
     * @param id
     * @param bus
     * @param driver
     * @param client
     * @param dataPartida
     * @param dataRegresso
     * @param numPassageiros
     * @param localOrigem
     * @param localDestino
     * @param distancia
     */
    public Reserva(String id,
                   Autocarro bus,
                   Motorista driver,
                   Cliente client,
                   LocalDate dataPartida,
                   LocalDate dataRegresso,
                   int numPassageiros,
                   String localOrigem,
                   String localDestino,
                   double distancia,
                   Pagamento pagamento) {

        this.id = id;
        this.bus = bus;
        this.driver = driver;
        this.client = client;
        this.dataPartida = dataPartida;
        this.dataRegresso = dataRegresso;
        this.numPassageiros = numPassageiros;
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
        this.distancia = distancia;
        this.pagamento = pagamento;
        calcularCustoViagem();
    }

    /**
     * Método que retorna o autocarro da reserva.
     *
     * @return O autocarro da reserva.
     */
    public Autocarro getBus() {
        return bus;
    }

    /**
     * Método que retorna o motorista da reserva.
     *
     * @return O motorista da reserva.
     */
    public Motorista getDriver() {
        return driver;
    }

    /**
     * Método que retorna o cliente da reserva.
     *
     * @return O cliente da reserva.
     */
    public Cliente getClient() {
        return client;
    }

    /**
     * Método que retorna a data de partida da reserva.
     *
     * @return a data de partida da reserva.
     */
    public LocalDate getDataPartida() {
        return dataPartida;
    }

    /**
     * Método que retorna a data de regresso da reserva.
     *
     * @return a data de regresso da reserva.
     */
    public LocalDate getDataRegresso() {
        return dataRegresso;
    }

    /**
     * Método que retorna o número de passageiros da reserva.
     *
     * @return o número de passageiros da reserva.
     */
    public int getNumPassageiros() {
        return numPassageiros;
    }

    /**
     * Método que retorna a distância da reserva.
     *
     * @return a distância da reserva.
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * Método que retorna o custo da reserva.
     *
     * @return o custo da reserva.
     */
    public double getCusto() {
        return custo;
    }

    /**
     * Método que calcula o custo da viagem.
     *
     * @return void
     */
    public void calcularCustoViagem() {
        this.custo = this.getDistancia() * 0.55 + 1.2 * this.getNumPassageiros();
    }

    /**
     * Método que retorna a representação em String da reserva.
     *
     * @return A representação em String da reserva.
     */
    @Override
    public String toString() {
        return "Reserva: " + id + " de " + dataPartida + " a " + dataRegresso + " desde " + localOrigem + " até " + localDestino + " para " + numPassageiros + " pessoas. Custo total: " + custo + "€\n";

    }

    /**
     * Método que retorna o Id da reserva.
     *
     * @return o Id da reserva.
     */
    public String getId() {
        return id;
    }

    /**
     * Método que cancela uma reserva e retorna um objeto de reembolso.
     *
     * @param dataDeCancelamente A data de cancelamento da reserva.
     * @return O objeto de reembolso.
     * @throws IllegalArgumentException Se a data de cancelamento for posterior à data de partida da reserva.
     */
    public Reembolso cancelar(LocalDate dataDeCancelamente) {
        if (dataDeCancelamente.isAfter(this.dataPartida)) {
            throw new IllegalArgumentException("A data de partida tem de ser depois da data de cancelamento!");
        }

        Reembolso reembolso = client.calcularReenbolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamente);

        client.addNotificacao(gerarNotificacaoDeCancelamento(reembolso));

        return reembolso;
    }

    /**
     * Método que gera uma notificação de cancelamento de reserva, a ser enviada ao cliente, com base no reembolso associado.
     *
     * @param reembolso O reembolso associado ao cancelamento de reserva
     * @return A notificação de cancelamento de reserva a ser enviada ao cliente
     */
    private String gerarNotificacaoDeCancelamento(Reembolso reembolso) {
        if (reembolso.getValue() > 0.0 && pagamento != null) {
            if (pagamento.devePedirIBAN())
                return "Foi-lhe enviado um email a solicitar IBAN para efeitos de reembolso no valor de %.2f, no contexto de cancelamento da sua reserva '%s'.".formatted(reembolso.getValue(), id);
            else
                return "A sua reserva '%s' foi cancelada, e consequentemente foi-lhe reembolsado o valor de'%.2f'.".formatted(id, reembolso.getValue());
        } else
            return "A sua reserva '%s' foi cancelada.".formatted(id);
    }

    /**
     * Método que verifica se uma reserva se sobrepõe a um intervalo de datas.
     *
     * @param dataPartida  O início do intervalo de datas.
     * @param dataRegresso O fim do intervalo de datas.
     * @return true se a reserva se sobrepõe ao intervalo de datas, false caso contrário.
     */
    public boolean isBetween(LocalDate dataPartida, LocalDate dataRegresso) {
        return (this.dataPartida.isBefore(dataPartida) && this.dataRegresso.isAfter(dataPartida)) ||
                (dataPartida.isBefore(getDataPartida()) && dataRegresso.isAfter(getDataRegresso())) ||
                (dataRegresso.isAfter(getDataPartida()) && dataRegresso.isBefore(getDataRegresso())) ||
                (getDataPartida().isEqual(dataPartida) || getDataRegresso().isEqual(dataRegresso));
    }

    /**
     * Móetodo que retorna a lotação máxima do autocarro associado à reserva.
     *
     * @return A lotação máxima do autocarro associado à reserva.
     */
    int getLotacaoMax() {
        return bus.getLotacao();
    }

}