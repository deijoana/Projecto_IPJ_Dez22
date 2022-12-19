package Projecto;

import javax.swing.*;
import java.awt.*;

public class PainelAdmin extends JPanel {
    JLabel welcome;
    JTabbedPane painelAd, painelM;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, addM, editM, removeM;
    JButton logout, guardarRegisto;
    GUI janela;

    JLabel inserirDados, nome, nif, morada, telefone, email, palavraPasse;
    JTextField nomeT, nifT, moradaT, telefoneT, emailT;
    JPasswordField passwordF;


    PainelAdmin(GUI janela) {
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        painelAd = new JTabbedPane();
        painelAd.setFont(new Font("Arial", 1, 12));

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(1000, 800));
        painelAd.addTab("Adicionar Administrador", panel1);

        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();

        inserirDados = new JLabel("Insira os dados do novo administrador:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c1.gridx = 0;
        c1.gridy = 0;
        panel1.add(inserirDados, c1);

        nome = new JLabel("Nome");
        nome.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 1;
        panel1.add(nome, c1);

        nomeT = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 1;
        panel1.add(nomeT, c1);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 2;
        panel1.add(nif, c1);

        nifT = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 2;
        panel1.add(nifT, c1);

        morada = new JLabel("Morada");
        morada.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 3;
        panel1.add(morada, c1);

        moradaT = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 3;
        panel1.add(moradaT, c1);

        telefone = new JLabel("Telefone");
        telefone.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 4;
        panel1.add(telefone, c1);

        telefoneT = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 4;
        panel1.add(telefoneT, c1);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 5;
        panel1.add(email, c1);

        emailT = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 5;
        panel1.add(emailT, c1);

        palavraPasse = new JLabel("Palavra Passe");
        palavraPasse.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 6;
        panel1.add(palavraPasse, c1);

        passwordF = new JPasswordField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 6;
        panel1.add(passwordF, c1);

        guardarRegisto = new JButton("Guardar registo de novo administrador");
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = new Insets(40, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 8;
        panel1.add(guardarRegisto, c1);


        panel2 = new JPanel();
        painelAd.addTab("Motoristas", panel2);
        panel2.setLayout(new GridLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        painelM = new JTabbedPane();
        painelM.setFont(new Font("Arial", 1, 12));

        addM = new JPanel();
        painelM.addTab("Adicionar", addM);

        editM = new JPanel();
        painelM.addTab("Editar", editM);

        removeM = new JPanel();
        painelM.addTab("Remover", removeM);
        panel2.add(painelM, c2);

        panel3 = new JPanel();
        painelAd.addTab("Autocarros", panel3);

        panel4 = new JPanel();
        painelAd.addTab("Clientes", panel4);

        panel5 = new JPanel();
        painelAd.addTab("Listar Motoristas", panel5);

        panel6 = new JPanel();
        painelAd.addTab("Listar Clientes", panel6);

        panel7 = new JPanel();
        painelAd.addTab("Estatísticas", panel7);

        panel8 = new JPanel();
        painelAd.addTab("Alterar Palavra Passe", panel8);

        c.gridx = 1;
        c.gridy = 1;
        this.add(painelAd, c);  //Adicionar o componente Tabbed Pane ao painel PainelAd

        welcome = new JLabel("Bem-vindo à sua área de administrador");
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
    }


}
