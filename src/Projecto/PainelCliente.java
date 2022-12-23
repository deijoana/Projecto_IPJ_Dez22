package Projecto;

import javax.swing.*;
import java.awt.*;

public class PainelCliente extends JPanel {

    Empresa empresa;

    JLabel welcome;
    JTabbedPane painelCl;

    JPanel panel1, panel2, panel3, panel4, panel5, panel6;

    JButton logout, pesquisar, guardarAlt;

    GUI janela;

    JLabel inserirDados, dataPartida, dataRegresso, origem, destino, n_Passageiros, distPrevista;


    JLabel inserirDadosAltPass, passAntiga, passNova, passNova2;

    JTextField dataPartidaT, dataRegressoT, origemT, destinoT, n_PassageirosT, distPrevistaT;

    JTextField passAntigaT, passNovaT, passNova2T;


    PainelCliente(GUI janela, Empresa empresa) {
        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        painelCl = new JTabbedPane();
        painelCl.setFont(new Font("Arial", 1, 12));


        panel1 = new JPanel();
        painelCl.addTab("Fazer reserva de autocarro", panel1);

        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();

        inserirDados = new JLabel("Indique os seguintes dados para verificar a disponiblidade dos nossos serviços:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(10, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 0;
        panel1.add(inserirDados, c1);

        dataPartida = new JLabel("Data de partida");
        dataPartida.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 1;
        panel1.add(dataPartida, c1);


        dataPartidaT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 1;
        panel1.add(dataPartidaT, c1);

        dataRegresso = new JLabel("Data de regresso");
        dataRegresso.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 2;
        panel1.add(dataRegresso, c1);


        dataRegressoT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 2;
        panel1.add(dataRegressoT, c1);

        origem = new JLabel("Origem");
        origem.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 3;
        panel1.add(origem, c1);

        origemT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 3;
        panel1.add(origemT, c1);


        destino = new JLabel("Destino");
        destino.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 4;
        panel1.add(destino, c1);

        destinoT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 4;
        panel1.add(destinoT, c1);

        n_Passageiros = new JLabel("Número de passageiros");
        n_Passageiros.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 5;
        panel1.add(n_Passageiros, c1);

        n_PassageirosT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 5;
        panel1.add(n_PassageirosT, c1);

        distPrevista = new JLabel("Distância prevista (km)");
        distPrevista.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 6;
        panel1.add(distPrevista, c1);

        distPrevistaT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 6;
        panel1.add(distPrevistaT, c1);

        pesquisar = new JButton("Pesquisar");
        c1.fill = GridBagConstraints.CENTER;
        c1.insets = new Insets(40, 0, 20, 0);
        c1.gridx = 1;
        c1.gridy = 8;
        panel1.add(pesquisar, c1);


        panel2 = new JPanel();
        painelCl.addTab("Consultar Histórico", panel2);


        panel3 = new JPanel();
        painelCl.addTab("Consultar Reservas", panel3);


        panel4 = new JPanel();
        painelCl.addTab("Cancelar Reserva", panel4);


        panel5 = new JPanel();
        painelCl.addTab("Alterar Subscrição", panel5);


        panel6 = new JPanel();
        painelCl.addTab("Alterar Palavra Passe", panel6);

        panel6.setLayout(new GridBagLayout());
        GridBagConstraints c6 = new GridBagConstraints();

        inserirDadosAltPass = new JLabel("Para alterar a palavra-chave, insira os seguintes dados:");
        inserirDadosAltPass.setFont(new Font("Arial", 1, 12));
        c6.gridx = 0;
        c6.gridy = 0;
        c6.insets = new Insets(0, 0, 50, 0);
        //c6.gridwidth = 2;
        panel6.add(inserirDadosAltPass, c6);

        passAntiga = new JLabel("Insira palavra-passe antiga:");
        passAntiga.setFont(new Font("Arial", 1, 12));
        c6.insets = new Insets(0, 0, 0, 20);
        c6.gridx = 0;
        c6.gridy = 2;
        panel6.add(passAntiga, c6);

        passAntigaT = new JTextField(20);
        c6.insets = new Insets(0, 0, 0, 0);
        c6.gridx = 1;
        c6.gridy = 2;
        panel6.add(passAntigaT, c6);

        passNova = new JLabel("Insira nova palavra-passe:");
        passNova.setFont(new Font("Arial", 1, 12));
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 0;
        c6.gridy = 3;
        panel6.add(passNova, c6);

        passNovaT = new JTextField(20);
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 1;
        c6.gridy = 3;
        panel6.add(passNovaT, c6);

        passNova2 = new JLabel("Confirme a sua nova palavra-passe:");
        passNova2.setFont(new Font("Arial", 1, 12));
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 0;
        c6.gridy = 4;
        panel6.add(passNova2, c6);

        passNova2T = new JTextField(20);
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 1;
        c6.gridy = 4;
        panel6.add(passNova2T, c6);

        guardarAlt = new JButton("Guardar alterações");
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 1;
        c6.gridy = 5;
        panel6.add(guardarAlt, c6);


        c.gridx = 1;
        c.gridy = 1;
        this.add(painelCl, c);  //Adicionar o componente Tabbed Pane ao painel PainelCl

        welcome = new JLabel("Bem-vindo à sua área de cliente");
        c.gridx = 0;
        c.gridy = 0;
        this.add(welcome, c);

        logout = new JButton("Logout");
        c.anchor = GridBagConstraints.PAGE_START;
        c.insets = new Insets(0, 10, 0, 0);
        logout.setFont(new Font("Arial", 1, 10));
        c.gridx = 2;
        c.gridy = 0;
        this.add(logout, c);
        logout.addActionListener(new GerirEventos(2, this.janela));

    }

}