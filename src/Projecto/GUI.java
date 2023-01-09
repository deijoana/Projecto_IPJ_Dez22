package Projecto;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

/**
 * Classe que gere a Interface gráfica
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class GUI {

    Empresa empresa;
    JFrame f;
    JPanel cardsPanel;
    CardLayout layout;

    PainelCliente painelCliente;
    Login painelLogin;

    /**
     * @param empresa representa o objecto empresa que guarda toda a informação para a execução do programa
     */
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


        painelLogin = new Login(this, empresa);
        painelCliente = new PainelCliente(this, empresa);

        cardsPanel.add(painelLogin, "Login"); //
        cardsPanel.add(new PainelRegisto(this, empresa), "NovoRegisto");
        cardsPanel.add(new PainelAdmin(this, empresa), "PainelAdmin");
        cardsPanel.add(painelCliente, "PainelCliente"); //
        cardsPanel.add(new PainelSelecaoBus(this, empresa), "PainelSelecaoBus");
        cardsPanel.add(new PainelReservaMensal(this, empresa), "PainelReservaMensal");
        cardsPanel.add(new PainelDiaMaisReservas(this, empresa), "PainelDiaMaisReservas");
        cardsPanel.add(new PainelNormal(this, empresa), "PainelNormal");
        cardsPanel.add(new PainelPremium(this, empresa), "PainelPremium");
        cardsPanel.add(new PainelPaypal(this, empresa), "PainelPaypal");
        cardsPanel.add(new PainelCC(this, empresa), "PainelCC");
        cardsPanel.add(new PainelMB(this, empresa), "PainelMB");
        cardsPanel.add(new PainelSelecaoReservasCanceladas(this, empresa), "PainelSelecaoReservasCanceladas");
        cardsPanel.add(new PainelClienteRemoved(this, empresa), "PainelClienteRemoved");

        f.getContentPane().add(cardsPanel);

        layout.show(cardsPanel, "Login");


        f.setVisible(true);
    }

    // método que define que painel será visível
    public void mudaEcra(String ecra) {

        if ("PainelCliente".equals(ecra)) {
            painelCliente.refresh();
        }

        layout.show(cardsPanel, ecra);
    }


}