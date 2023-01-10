package Projecto;

import java.io.*;

/**
 * Classe que define objectos do tipo Cliente
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class FicheiroDeObjetos {

    // Atributos

    private ObjectInputStream iS;
    private ObjectOutputStream oS;


    /**
     * Método que abre leitura de um ficheiro de objectos cujo nome corresponde à string usada como parâmetro
     *
     * @param nomeDoFicheiro representa o nome do ficheiro de objectos
     * @return true se o ficheiro já existir; false se ocorrer uma IOException
     */
    public boolean abreLeitura(String nomeDoFicheiro) {

        try {

            iS = new ObjectInputStream(new FileInputStream(nomeDoFicheiro));
            return true;
        } catch (IOException e) {

            return false;
        }
    }

    /**
     * Método boolean para verificar se um ficheiro existe.
     * Recebe uma String com o nome do ficheiro.
     *
     * @param nomeDoFicheiro nome do ficheiro.
     * @return true se existir, false se não existir
     */
    public boolean ficheiroExiste(String nomeDoFicheiro) {
        return new File(nomeDoFicheiro).exists();
    }

    public void abreEscrita(String nomeDoFicheiro) throws IOException {

        oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));

    }


    /**
     * Método que lê o objecto do ficheiro de objectos
     *
     * @return o objecto lido
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object leObjecto() throws IOException, ClassNotFoundException {

        return iS.readObject();

    }


    /**
     * Método que escreve o objecto do ficheiro de objectos
     *
     * @param o representa o objecto cujas informações são guardadas no ficheiro de objectos
     * @throws IOException
     */
    public void escreveObjecto(Object o) throws IOException {

        oS.writeObject(o);

    }


    /**
     * Método que fecha a leitura de um ficheiro de objectos aberto em modo leitura
     *
     * @throws IOException
     */
    public void fechaLeitura() throws IOException {

        iS.close();

    }


    /**
     * Método que fecha a escrita de um ficheiro de objectos aberto em modo escrita
     *
     * @throws IOException
     */
    public void fechaEscrita() throws IOException {

        oS.close();

    }

}