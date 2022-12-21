package Projecto;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // cria instância da empresa, carregando os dados que estão no ficheiro de objectos
        Empresa empresa = Empresa.leFicheiro(Empresa.AUTOCARROS_AOR);

        GUI frame = new GUI(empresa);

    }
}