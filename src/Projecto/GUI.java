package Projecto;

import javax.swing.*;

public class GUI extends JFrame {
    GUI() {

        //Criar janela, torná-la visível e determinar que programa pára de executar ao fechar a janela
        JFrame janela = new JFrame("Empresa AoR-Autocarros");
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
