package Projecto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum TipoSubscricao {
    NORMAL("Normal") {
        @Override
        public Reembolso calcularReenbolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamente) {
            if (ChronoUnit.DAYS.between(dataDeCancelamente, dataPartida) > 7) {
                return new Reembolso(custo * 0.5);
            }

            return super.calcularReenbolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamente);
        }
    },
    PREMIUM("Premium") {
        @Override
        public Reembolso calcularReenbolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamente) {
            if (ChronoUnit.DAYS.between(dataDeCancelamente, dataPartida) > 2) {
                return new Reembolso(custo);
            }
            return super.calcularReenbolsoDeCancelamentoDeReserva(custo, dataPartida, dataDeCancelamente);
        }
    },
    ;


    private final String title;

    TipoSubscricao(String title) {
        this.title = title;
    }

    public static TipoSubscricao parse(String title) {
        for (TipoSubscricao value : values()) {
            if (value.title.equalsIgnoreCase(title))
                return value;
        }
        throw new IllegalArgumentException("O valor " + title + " não é um tipo de subscricao valido!");
    }

    public String getTitle() {
        return title;
    }

    public Reembolso calcularReenbolsoDeCancelamentoDeReserva(double custo, LocalDate dataPartida, LocalDate dataDeCancelamente) {
        return Reembolso.NO_REEMBOLSO;
    }
}
