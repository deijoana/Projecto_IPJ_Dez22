package Projecto;

import javax.swing.*;
import java.awt.*;

public class GUI {

    Empresa empresa;
    JFrame f;
    JPanel cardsPanel;
    CardLayout layout;
    GUI(Empresa empresa) {
        this.empresa = empresa;

        //Criar janela, torná-la visível e determinar que programa pára de executar ao fechar a janela
        f = new JFrame();
        f.setTitle("Empresa AoR Autocarros");

        f.setSize(1600, 1000);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definir o layout da janela como Card Layout e adicionar os diversos painéis a painel inicial, denominado cardsPanel
        layout = new CardLayout();
        cardsPanel = new JPanel(layout);
        cardsPanel.add(new Login(this, empresa), "Login");
        cardsPanel.add(new PainelRegisto(this, empresa), "NovoRegisto");
        cardsPanel.add(new PainelAdmin(this, empresa), "PainelAdmin");
        cardsPanel.add(new PainelCliente(this, empresa), "PainelCliente");
        cardsPanel.add(new PainelEstatisticaMensal(this, empresa),"PainelEstatistico");
        f.getContentPane().add(cardsPanel);

       layout.show(cardsPanel, "Login");



        f.setVisible(true);
    }

    // método que define que painel será visível
    public void mudaEcra(String ecra){
        layout.show (cardsPanel, ecra);
    }


}