package Projecto;

import java.util.*;
/**
 *
 * Classe que define um objecto do tipo List que guarda informação dos autocarros mais utilizados
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class AutocarrosMaisUtilizadosStats implements Formattable {
    private int numeroUtilizacoes;
    private List<Autocarro> autocarros;

    /**
     *
     * @param numeroUtilizacoes representa o número de utilizações do autocarro
     * @param autocarros representa a lista do(s) autocarro(s) com maior número de utilizações
     */
    public AutocarrosMaisUtilizadosStats(int numeroUtilizacoes, List<Autocarro> autocarros) {
        this.numeroUtilizacoes = numeroUtilizacoes;
        this.autocarros = new ArrayList<>();
    }

    /**
     * Método que descreve os objectos da classe Autocarro que possam estar na lista, de acordo com o formato selecionado
     * @return String com informação do número máximo de utilizações e a matrícula do(s) autocarro(s)
     */
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        StringJoiner matriculas = new StringJoiner(", ");
        for (Autocarro autocarro : this.autocarros) {
            matriculas.add(autocarro.getMatricula());
        }
        formatter.format("Número de utilizações: " + this.numeroUtilizacoes + "\n MATRICULAS: " + matriculas);
    }
}
