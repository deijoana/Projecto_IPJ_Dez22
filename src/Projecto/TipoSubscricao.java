package Projecto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * Enum que define qual o tipo de subscrição que um cliente pode ter associada à sua conta: Normal ou Premium
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public enum TipoSubscricao {
    NORMAL("Normal") {

    /**
     * Método que calcula o reembolso a ser feito em caso de cancelamento de reserva, tendo em conta o custo da reserva, a data de partida e a data de cancelamento.
     * Se a data de cancelamento for mais de 7 dias antes da data de partida, o reembolso será de 50% do custo da reserva.
     * Caso contrário, o cálculo do reembolso é delegado ao método da superclasse.
     *
     * @param custo O custo da reserva
     * @param dataPartida A data de partida da reserva
     * @param dataDeCancelamento A data de cancelamento da reserva
     * @return O reembolso a ser feito em caso de cancelamento da reserva
     */
        @Override
        public Reembolso calcularReembolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamento) {
            if (ChronoUnit.DAYS.between(dataDeCancelamento, dataPartida) > 7) {
                return new Reembolso(custo * 0.5);
            }

            return super.calcularReembolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamento);
        }
    },

    PREMIUM("Premium") {

    /**
     * Método que calcula o reembolso a ser feito em caso de cancelamento de reserva, tendo em conta o custo da reserva, a data de partida e a data de cancelamento.
     * Se a data de cancelamento for mais de 2 dias antes da data de partida, o reembolso será de 100% do custo da reserva.
     * Caso contrário, o cálculo do reembolso é delegado ao método da superclasse.
     *
     * @param custo O custo da reserva
     * @param dataPartida A data de partida da reserva
     * @param dataDeCancelamento A data de cancelamento da reserva
     * @return O reembolso a ser feito em caso de cancelamento da reserva
     */
        @Override
        public Reembolso calcularReembolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamento) {
            if (ChronoUnit.DAYS.between(dataDeCancelamento, dataPartida) > 2) {
                return new Reembolso(custo);
            }
            return super.calcularReembolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamento);
        }
    },
    ;

    private final String title;

    /**
     * Método que cria um novo tipo de assinatura com o título dado.
     *
     * @param title O título a ser usado para criar o tipo de assinatura
     */
    TipoSubscricao(String title) {
        this.title = title;
    }


    /**
     * Método que obtém o tipo de assinatura correspondente ao título dado.
     *
     * @param title O título a ser usado para obter o tipo de assinatura
     * @return O tipo de assinatura correspondente ao título dado
     * @throws IllegalArgumentException Se o título não corresponder a nenhum tipo de assinatura válido
     */
    public static TipoSubscricao parse(String title) {
        for (TipoSubscricao value : values()) {
            if (value.title.equalsIgnoreCase(title))
                return value;
        }
        throw new IllegalArgumentException("O valor " + title + " não é um tipo de subscricao valido!");
    }


    /**
     * Calcula o reembolso a ser feito em caso de cancelamento de reserva, tendo em conta o custo da reserva, a data de partida e a data de cancelamento.
     * Neste tipo de assinatura, não é efetuado qualquer reembolso em caso de cancelamento de reserva.
     *
     * @param custo O custo da reserva
     * @param dataPartida A data de partida da reserva
     * @param dataDeCancelamento A data de cancelamento da reserva
     * @return O reembolso a ser feito em caso de cancelamento da reserva
     */
    public Reembolso calcularReembolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamento) {
        return Reembolso.NO_REEMBOLSO;
    }
}
