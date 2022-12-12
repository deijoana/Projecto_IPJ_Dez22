package Projecto;

import javax.swing.*;

public class GUI extends JFrame {
    GUI() {

        //Criar janela, torná-la visível e determinar que programa pára de executar ao fechar a janela
        setTitle("Empresa AoR Autocarros");


        setSize(450, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PainelDeBase p = new PainelDeBase();

        getContentPane().add(p);
        setVisible(true);
    }
}
