package Projecto;

import javax.swing.*;
import java.awt.*;

public class GUI{

    JFrame f;

    JPanel cardsPanel;

    CardLayout layout;
    GUI() {
        f = new JFrame();
        //Criar janela, torná-la visível e determinar que programa pára de executar ao fechar a janela
        f.setTitle("Empresa AoR Autocarros");

        f.setSize(800, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();
        cardsPanel = new JPanel(layout);
        cardsPanel.add(new Login1(this), "Login");
        cardsPanel.add(new PainelLogin(this), "Painel");
        f.getContentPane().add(cardsPanel);

        layout.show(cardsPanel, "Login");

        f.setVisible(true);
    }

    public void mudaEcra(String ecra){
        layout.show (cardsPanel, ecra);
    }


}

