package Projecto;

import java.io.Serializable;

public class Administrador extends Utilizador implements Serializable {

    public Administrador(String nome, String nif, String morada, String telefone,
                         String email, String tipoUtilizador, String palavraPasse) {
        super(nome, nif, morada, telefone, email, tipoUtilizador, palavraPasse);
    }

    @Override
    public String toString() {
         return nome + ", NIF: " + nif + ", " + morada + ", " + telefone + ", " + email + "\n";
    }
}

