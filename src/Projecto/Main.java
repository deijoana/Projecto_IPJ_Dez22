package Projecto;

import java.io.IOException;

/**
 *
 * Classe responsável por arrancar a execução do programa
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // cria instância da empresa, carregando os dados que estão no ficheiro de objectos
        Empresa empresa = Empresa.leFicheiro("autocarros_aor");


        GUI frame = new GUI(empresa);

    }
}