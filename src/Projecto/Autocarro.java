package Projecto;

import java.io.Serializable;

public class Autocarro implements Serializable {

    private String matricula;
    private String marca;
    private String modelo;
    private int lotacao;

    public Autocarro(String matricula, String marca, String modelo, int lotacao) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.lotacao = lotacao;

    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
}