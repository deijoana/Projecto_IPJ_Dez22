package Projecto;

import java.io.Serializable;
import java.util.UUID;

public class Utilizador implements Serializable {

    protected String nome;
    protected String nif;
    protected String morada;
    protected String telefone;
    protected String email;
    protected String tipoUtilizador;
    protected String palavraPasse;
    protected String id;

    public Utilizador(String nome, String nif, String morada,
                      String telefone, String email, String tipoUtilizador, String palavraPasse) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.telefone = telefone;
        this.email = email;
        this.tipoUtilizador = tipoUtilizador;
        this.palavraPasse = palavraPasse;
        this.id = UUID.randomUUID().toString(); // define um valor único para ID de cada utilizador
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoUtilizador() {
        return tipoUtilizador;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }

    public String getPalavraPasse() {
        return palavraPasse;
    }

    public void setPalavraPasse(String palavraPasse) {
        this.palavraPasse = palavraPasse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nome + ", NIF: " + nif + ", " + morada + ", " + telefone + ", " + email + "\n";
    }
}