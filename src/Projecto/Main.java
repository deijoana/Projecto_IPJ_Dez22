package Projecto;

import javax.swing.*;
import java.io.IOException;

/**
 * Classe responsável por arrancar a execução do programa
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Empresa empresa = Empresa.leFicheiro("autocarros_aor");

        SwingUtilities.invokeLater(() -> new GUI(empresa));

    }
}