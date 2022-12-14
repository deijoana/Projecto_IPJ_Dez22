package Projecto;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    GUI() {

        //Criar janela, torná-la visível e determinar que programa pára de executar ao fechar a janela
        setTitle("Empresa AoR Autocarros");
        setLayout(new CardLayout ());

        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PainelLogin p = new PainelLogin();

        getContentPane().add(p);
        setVisible(true);
    }
}
