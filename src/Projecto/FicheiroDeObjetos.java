package Projecto;

import java.io.*;

/**
 * Breve descrição do código
 *
 */
public class FicheiroDeObjetos {

    // Atributos

    private ObjectInputStream iS;
    private ObjectOutputStream oS;

    // Método para abrir um ficheiro para leitura
    // Recebe:
    // nomeDoFicheiro - nome do ficheiro
    // Devolve:
    // true se o ficheiro já existir, false no caso contrário

    public boolean abreLeitura(String nomeDoFicheiro) {

        try {

            iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            return true;
        }

        catch (IOException e) {

            return false;
        }
    }

    /**
     * Método boolean para verificar se um ficheiro existe.
     * Recebe uma String com o nome do ficheiro.
     * @param nomeDoFicheiro nome do ficheiro.
     * @return true se existir, false se não existir
     */
    public boolean ficheiroExiste(String nomeDoFicheiro){
        return new File(nomeDoFicheiro).exists();
    }

    // Método para abrir um ficheiro para escrita
    // Recebe:
    // nomeDoFicheiro - nome do ficheiro

    public void abreEscrita(String nomeDoFicheiro) throws IOException {

        oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));

    }

    // Método para ler um objecto de um ficheiro
    // Devolve:
    // objecto lido

    public Object leObjecto() throws IOException, ClassNotFoundException {

        return iS.readObject();

    }

    // Método para escrever um objecto num ficheiro
    // Recebe:
    // o - objecto a escrever

    public void escreveObjecto(Object o) throws IOException {

        oS.writeObject(o);

    }

    // Método para fechar um ficheiro aberto em modo leitura

    public void fechaLeitura() throws IOException {

        iS.close();

    }

    // Método para fechar um ficheiro aberto em modo escrita

    public void fechaEscrita() throws IOException {

        oS.close();

    }

}