package Projecto;

import java.io.Serializable;

/**
 * Classe que define objectos do tipo Autocarro
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Autocarro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String matricula;
    private String marca;
    private String modelo;
    private int lotacao;

    /**
     * @param matricula representa a matrícula do autocarro
     * @param marca     representa a marca do autocarro
     * @param modelo    representa o modelo do autocarro
     * @param lotacao   representa a lotação do autocarro
     */
    public Autocarro(String matricula, String marca, String modelo, int lotacao) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.lotacao = lotacao;

    }

    /**
     * Método que obtém a matrícula do autocarro
     *
     * @return String com a matrícula do autocarro
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Método que define a nova matrícula do autocarro
     *
     * @param marca String com a nova matrícula do autocarro
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método que define o novo modelo do autocarro
     *
     * @param modelo String com o novo modelo do autocarro
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Método que obtém a lotação do autocarro
     *
     * @return Variável int com o valor que representa a lotação do autocarro
     */
    public int getLotacao() {
        return lotacao;
    }

    /**
     * Método que define a nova lotação do autocarro
     *
     * @param lotacao Variável int com o valor que representa a nova lotação do autocarro
     */
    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    /**
     * Método que descreve os objectos da classe Autocarro no formato de String
     *
     * @return String com descrição detalhada, incluindo matrícula, marca, modelo e lotação do autocarro
     */
    @Override
    public String toString() {
        return "Autocarro: " + matricula + ", " + marca + ", " + modelo + ", para " + lotacao + " pessoas\n";
    }
}