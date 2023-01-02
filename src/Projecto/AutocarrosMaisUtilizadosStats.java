package Projecto;

import java.util.*;

public class AutocarrosMaisUtilizadosStats implements Formattable {
    private int numeroUtilizacoes;
    private List<Autocarro> autocarros = new ArrayList<>();

    public AutocarrosMaisUtilizadosStats(int numeroUtilizacoes, List<Autocarro> autocarros) {
        this.numeroUtilizacoes = numeroUtilizacoes;
        this.autocarros = autocarros;
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        StringJoiner matriculas = new StringJoiner(", ");
        for (Autocarro autocarro : this.autocarros) {
            matriculas.add(autocarro.getMatricula());
        }
        formatter.format("MAX: " + this.numeroUtilizacoes + "\n MATRICULAS: " + matriculas);
    }
}
