package Projecto;

import javax.swing.*;
import java.awt.*;

public class PainelAdmin extends JPanel {
    JLabel welcome;
    JTabbedPane painelAd, painelM, painelAutocarro;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, addM, editM, removeM, addBus, editBus, removeBus;
    JButton logout, guardarRegisto;
    GUI janela;

    JLabel inserirDados, nome, nif, morada, telefone, email, palavraPasse, matricula, marca, modelo, lotacao;
    JTextField nomeT, nifT, moradaT, telefoneT, emailT, matriculaT, marcaT, modeloT, lotacaoT;
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
        panel2.setPreferredSize(new Dimension(1000, 800));
        painelAd.addTab("Motoristas", panel2);
        panel2.setLayout(new GridLayout());

        painelM = new JTabbedPane();
        painelM.setFont(new Font("Arial", 1, 12));

        addM = new JPanel();
        painelM.addTab("Adicionar", addM);
        addM.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        inserirDados = new JLabel("Insira as seguintes informações para adicionar um novo motorista:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c2.gridx = 0;
        c2.gridy = 0;
        c2.gridwidth = 2;
        c2.insets = new Insets(0, 0, 10, 0);
        addM.add(inserirDados, c2);

        nome = new JLabel("Nome");
        nome.setFont(new Font("Arial", 1, 12));
        c2.gridx = 1;
        c2.gridy = 1;
        addM.add(nome, c2);

        nomeT = new JTextField(50);
        c2.gridx = 2;
        c2.gridy = 1;
        addM.add(nomeT, c2);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 12));
        c2.gridx = 1;
        c2.gridy = 2;
        addM.add(email, c2);

        emailT = new JTextField(50);
        c2.gridx = 2;
        c2.gridy = 2;
        addM.add(emailT, c2);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c2.gridx = 1;
        c2.gridy = 3;
        addM.add(nif, c2);

        nifT = new JTextField(50);
        c2.gridx = 2;
        c2.gridy = 3;
        addM.add(nifT, c2);

        guardarRegisto = new JButton("Guardar registo");
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(20, 0, 0, 0);
        c2.gridx = 2;
        c2.gridy = 5;
        addM.add(guardarRegisto, c2);

        editM = new JPanel();
        painelM.addTab("Editar", editM);
        editM.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();

        inserirDados = new JLabel("Edite os dados pessoais do motorista:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c3.gridx = 0;
        c3.gridy = 0;
        c3.gridwidth = 2;
        c3.insets = new Insets(0, 0, 10, 0);
        editM.add(inserirDados, c3);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c3.gridx = 1;
        c3.gridy = 1;
        editM.add(nif, c3);

        nifT = new JTextField(50);
        c3.gridx = 2;
        c3.gridy = 1;
        editM.add(nifT, c3);

        nome = new JLabel("Nome");
        nome.setFont(new Font("Arial", 1, 12));
        c3.gridx = 1;
        c3.gridy = 2;
        editM.add(nome, c3);

        nomeT = new JTextField(50);
        c3.gridx = 2;
        c3.gridy = 2;
        editM.add(nomeT, c3);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 12));
        c3.gridx = 1;
        c3.gridy = 3;
        editM.add(email, c3);

        emailT = new JTextField(50);
        c3.gridx = 2;
        c3.gridy = 3;
        editM.add(emailT, c3);

        guardarRegisto = new JButton("Guardar alterações");
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.insets = new Insets(20, 0, 0, 0);
        c3.gridx = 2;
        c3.gridy = 5;
        editM.add(guardarRegisto, c3);

        removeM = new JPanel();
        painelM.addTab("Remover", removeM);
        removeM.setLayout(new GridBagLayout());
        GridBagConstraints c4 = new GridBagConstraints();

        inserirDados = new JLabel("Indique o NIF do motorista cujas informações pretende remover:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c4.gridx = 0;
        c4.gridy = 0;
        c4.insets = new Insets(0, 0, 20, 0);
        removeM.add(inserirDados, c4);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c4.gridx = 2;
        c4.gridy = 2;
        c4.insets = new Insets(0, 0, 0, 10);
        removeM.add(nif, c4);

        nifT = new JTextField(50);
        c4.gridx = 3;
        c4.gridy = 2;
        removeM.add(nifT, c4);

        guardarRegisto = new JButton("Remover motorista");
        c4.insets = new Insets(20, 0, 0, 0);
        c4.gridx = 3;
        c4.gridy = 5;
        removeM.add(guardarRegisto, c4);

        panel2.add(painelM);


        panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension(1000, 800));
        painelAd.addTab("Autocarros", panel3);
        panel3.setLayout(new GridLayout());

        painelAutocarro = new JTabbedPane();
        painelAutocarro.setFont(new Font("Arial", 1, 12));

        addBus = new JPanel();
        painelAutocarro.addTab("Adicionar", addBus);
        addBus.setLayout(new GridBagLayout());
        GridBagConstraints c5 = new GridBagConstraints();

        inserirDados = new JLabel("Insira as seguintes informações para adicionar um novo autocarro:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c5.gridx = 0;
        c5.gridy = 0;
        c5.gridwidth = 2;
        c5.insets = new Insets(0, 0, 10, 0);
        addBus.add(inserirDados, c5);

        matricula = new JLabel("Matrícula");
        matricula.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy=1;
        addBus.add (matricula, c5);

        matriculaT = new JTextField("Formato ##-##-##",50);
        matriculaT.setFont(new Font("Arial", 1, 12));
        c5.gridx = 2;
        c5.gridy=1;
        addBus.add (matriculaT, c5);

        marca = new JLabel("Marca");
        marca.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy=2;
        addBus.add (marca, c5);

        marcaT = new JTextField(50);
        c5.gridx = 2;
        c5.gridy=2;
        addBus.add (marcaT, c5);

        modelo = new JLabel("Modelo");
        modelo.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy=3;
        addBus.add (modelo, c5);

        modeloT = new JTextField(50);
        c5.gridx = 2;
        c5.gridy=3;
        addBus.add (modeloT, c5);

        lotacao = new JLabel("Lotação");
        lotacao.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy=4;
        addBus.add (lotacao, c5);

        lotacaoT = new JTextField(50);
        c5.gridx = 2;
        c5.gridy=4;
        addBus.add (lotacaoT, c5);

        guardarRegisto = new JButton("Guardar registo");
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.insets = new Insets(20, 0, 0, 0);
        c5.gridx = 2;
        c5.gridy = 6;
        addBus.add(guardarRegisto, c5);

        editBus = new JPanel();
        painelAutocarro.addTab("Editar", editBus);
        editBus.setLayout(new GridBagLayout());
        GridBagConstraints c6 = new GridBagConstraints();

        inserirDados = new JLabel("Edite as informações do autocarro:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c6.gridx = 0;
        c6.gridy = 0;
        c6.gridwidth = 2;
        c6.insets = new Insets(0, 0, 10, 0);
        editBus.add(inserirDados, c6);

        matricula = new JLabel("Matrícula");
        matricula.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy=1;
        editBus.add (matricula, c6);

        matriculaT = new JTextField("Formato ##-##-##",50);
        matriculaT.setFont(new Font("Arial", 1, 12));
        c6.gridx = 2;
        c6.gridy=1;
        editBus.add (matriculaT, c6);

        marca = new JLabel("Marca");
        marca.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy=2;
        editBus.add (marca, c6);

        marcaT = new JTextField(50);
        c6.gridx = 2;
        c6.gridy=2;
        editBus.add (marcaT, c6);

        modelo = new JLabel("Modelo");
        modelo.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy=3;
        editBus.add (modelo, c6);

        modeloT = new JTextField(50);
        c6.gridx = 2;
        c6.gridy=3;
        editBus.add (modeloT, c6);

        lotacao = new JLabel("Lotação");
        lotacao.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy=4;
        editBus.add (lotacao, c6);

        lotacaoT = new JTextField(50);
        c6.gridx = 2;
        c6.gridy=4;
        editBus.add (lotacaoT, c6);

        guardarRegisto = new JButton("Guardar alterações");
        c6.fill = GridBagConstraints.HORIZONTAL;
        c6.insets = new Insets(20, 0, 0, 0);
        c6.gridx = 2;
        c6.gridy = 6;
        editBus.add(guardarRegisto, c6);

        removeBus = new JPanel();
        painelAutocarro.addTab("Remover", removeBus);
        removeBus.setLayout(new GridBagLayout());
        GridBagConstraints c7 = new GridBagConstraints();

        inserirDados = new JLabel("Indique a matrícula (formato ##-##-##) do autocarro cujas informações pretende remover:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c7.gridx = 0;
        c7.gridy = 0;
        c7.gridwidth=3;
        c7.insets = new Insets(0, 0, 20, 0);
        removeBus.add(inserirDados, c7);

        matricula = new JLabel("Matrícula");
        matricula.setFont(new Font("Arial", 1, 12));
        c7.gridx = 2;
        c7.gridy = 2;
        c7.insets = new Insets(0, 0, 0, 10);
        removeBus.add(matricula, c7);

        matriculaT = new JTextField(50);
        c7.gridx = 3;
        c7.gridy = 2;
        removeBus.add(matriculaT, c7);

        guardarRegisto = new JButton("Remover autocarro");
        c7.insets = new Insets(20, 0, 0, 0);
        c7.gridx = 3;
        c7.gridy = 4;
        removeBus.add(guardarRegisto, c7);

        panel3.add(painelAutocarro);

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
