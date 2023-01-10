package Projecto;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Classe que define o painel de cliente removido por administrador
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PainelClienteRemoved extends JPanel {
    Empresa empresa;
    GUI janela;
    final JLabel welcome = new JLabel();
    JTabbedPane painelCl;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    JButton logout;
    JLabel inserirDados, dataPartida, dataRegresso, origem, destino, n_Passageiros, distPrevista, inserirDados8;
    JLabel inserirDadosAltPass, inserirDados3, passAntiga, passNova, passNova2, inserirDados2, idReserva;
    JTextField dataPartidaT, dataRegressoT, origemT, destinoT, n_PassageirosT, distPrevistaT, idReservaT;
    JPasswordField passAntigaT, passNovaT, passNova2T;
    JList<String> listagemNotificacoes;

    /**
     * @param janela
     * @param empresa
     */
    PainelClienteRemoved(GUI janela, Empresa empresa) {
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


        dataPartidaT = new JTextField("aaaa-mm-dd", 20);
        c1.insets = new Insets(30, 0, 0, 30);
        c1.gridx = 1;
        c1.gridy = 1;
        panel1.add(dataPartidaT, c1);
        dataPartidaT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataPartidaT.setText("");
            }
        });

        dataRegresso = new JLabel("Data de regresso");
        dataRegresso.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 2;
        panel1.add(dataRegresso, c1);


        dataRegressoT = new JTextField("aaaa-mm-dd", 20);
        c1.insets = new Insets(30, 0, 0, 30);
        c1.gridx = 1;
        c1.gridy = 2;
        panel1.add(dataRegressoT, c1);
        dataRegressoT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataRegressoT.setText("");
            }
        });

        origem = new JLabel("Origem");
        origem.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 3;
        panel1.add(origem, c1);

        origemT = new JTextField(20);
        c1.insets = new Insets(30, 0, 0, 30);
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
        c1.insets = new Insets(30, 0, 0, 30);
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
        c1.insets = new Insets(30, 0, 0, 30);
        c1.gridx = 1;
        c1.gridy = 5;
        panel1.add(n_PassageirosT, c1);

        distPrevista = new JLabel("Distância prevista (km)");
        distPrevista.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 20, 0);
        c1.gridx = 0;
        c1.gridy = 6;
        panel1.add(distPrevista, c1);

        distPrevistaT = new JTextField(20);
        c1.insets = new Insets(30, 0, 20, 30);
        c1.gridx = 1;
        c1.gridy = 6;
        panel1.add(distPrevistaT, c1);


        panel2 = new JPanel();
        painelCl.addTab("Consultar Histórico", panel2);
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        inserirDados2 = new JLabel("Histórico das suas reservas");
        inserirDados2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 0;
        c2.gridy = 0;
        panel2.add(inserirDados2, c2);


        panel3 = new JPanel();
        painelCl.addTab("Consultar Reservas", panel3);


        panel3.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();

        inserirDados3 = new JLabel("Lista das suas reservas");
        inserirDados3.setFont(new Font("Arial", 1, 12));
        c3.insets = new Insets(0, 0, 0, 20);
        c3.gridx = 0;
        c3.gridy = 0;
        panel3.add(inserirDados3, c3);


        panel4 = new JPanel();
        painelCl.addTab("Cancelar Reserva", panel4);

        panel4.setLayout(new GridBagLayout());
        GridBagConstraints c4 = new GridBagConstraints();

        idReserva = new JLabel("Coloque o ID da reserva:");
        idReserva.setFont(new Font("Arial", 1, 12));
        c4.insets = new Insets(30, 0, 0, 0);
        c4.gridx = 0;
        c4.gridy = 4;
        panel4.add(idReserva, c4);

        idReservaT = new JTextField(25);
        c4.insets = new Insets(30, 0, 0, 0);
        c4.gridx = 1;
        c4.gridy = 4;
        panel4.add(idReservaT, c4);


        panel5 = new JPanel();
        painelCl.addTab("Alterar Subscrição", panel5);
        panel5.setLayout(new GridBagLayout());
        GridBagConstraints c7 = new GridBagConstraints();

        panel7 = new JPanel();
        painelCl.addTab("Notificações", panel7);
        panel7.setLayout(new GridBagLayout());
        GridBagConstraints c8 = new GridBagConstraints();

        inserirDados8 = new JLabel("Aqui encontra as suas notificações:");
        inserirDados8.setFont(new Font("Arial", 1, 12));
        c8.gridx = 1;
        c8.gridy = 1;
        panel7.add(inserirDados8, c8);

        listagemNotificacoes = new JList<String>(new Vector<String>(empresa.listaNotificacoes()));
        c8.gridx = 1;
        c8.gridy = 2;
        panel7.add(listagemNotificacoes, c8);

        panel6 = new JPanel();
        painelCl.addTab("Alterar Palavra Passe", panel6);

        panel6.setLayout(new GridBagLayout());
        GridBagConstraints c6 = new GridBagConstraints();

        inserirDadosAltPass = new JLabel("Para alterar a palavra-chave, insira os seguintes dados:");
        inserirDadosAltPass.setFont(new Font("Arial", 1, 12));
        c6.gridx = 0;
        c6.gridy = 0;
        c6.insets = new Insets(0, 0, 50, 0);
        panel6.add(inserirDadosAltPass, c6);


        passAntiga = new JLabel("Insira palavra-passe antiga:");
        passAntiga.setFont(new Font("Arial", 1, 12));
        c6.insets = new Insets(0, 0, 0, 20);
        c6.gridx = 0;
        c6.gridy = 2;
        panel6.add(passAntiga, c6);
        passAntigaT = new JPasswordField(25);
        c6.insets = new Insets(0, 0, 0, 30);
        c6.gridx = 1;
        c6.gridy = 2;
        panel6.add(passAntigaT, c6);


        passNova = new JLabel("Insira nova palavra-passe:");
        passNova.setFont(new Font("Arial", 1, 12));
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 0;
        c6.gridy = 3;
        panel6.add(passNova, c6);

        passNovaT = new JPasswordField(25);
        c6.insets = new Insets(30, 0, 0, 30);
        c6.gridx = 1;
        c6.gridy = 3;
        panel6.add(passNovaT, c6);

        passNova2 = new JLabel("Confirme a sua nova palavra-passe:");
        passNova2.setFont(new Font("Arial", 1, 12));
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 0;
        c6.gridy = 4;
        panel6.add(passNova2, c6);

        passNova2T = new JPasswordField(25);
        c6.insets = new Insets(30, 0, 0, 30);
        c6.gridx = 1;
        c6.gridy = 4;
        panel6.add(passNova2T, c6);

        c.gridx = 1;
        c.gridy = 1;
        this.add(painelCl, c);  //Adicionar o componente Tabbed Pane ao painel PainelCl

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
        logout.addActionListener(new GerirActionListener(2, this.janela));
    }

    public void refresh() {
        welcome.setText("Bem-vindo à sua área de cliente: " + empresa.getLoggeduser().getNome());
    }

}