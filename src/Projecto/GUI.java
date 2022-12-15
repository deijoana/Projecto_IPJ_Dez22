package Projecto;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class GUI {
    JFrame janela;

   // JPanel cardsPanel;

    CardLayout layout;
    public GUI() {

        // Criar e definir a janela

        JFrame janela = new JFrame("Empresa AoR Autocarros");

        // Define e fixa o tamanho da janela
        janela.setSize(450, 700);
        janela.setResizable(false);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layout = new CardLayout();

        Login pL = new Login();
        janela.add(pL);

        /*
        cardsPanel = new JPanel(layout);
        cal.add(new Login(),"Login");
*/

      /*  janela.getContentPane().add(cardsPanel);*/
        janela.setVisible(true);
    }



}

