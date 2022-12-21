package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelAdmin extends JPanel {
    Empresa empresa;

    JLabel welcome;
    JTabbedPane painelAd, painelM, painelAutocarro, painelC;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, addM, editM, removeM, addBus, editBus, removeBus, addC, editC, removeC;
    JButton logout, guardarRegisto, totalCliente, totalMotorista, totalAutocarro, autocarroMReq, clienteMViagens, listaBusReservado, listaReservaCanc, listaReservaEmEspera, volumeReservaMensal, diaAnoMReserva;
    GUI janela;

    JLabel inserirDados, nome, nif, morada, telefone, email, palavraPasse, matricula, marca, modelo, lotacao, tipoSubscricaoL, pagamentoSubscricaoL, passwordNova1L, passwordNova2L;
    JTextField nomeT, nifT, moradaT, telefoneT, emailT, matriculaT, marcaT, modeloT, lotacaoT;
    JPasswordField passwordF, passwordNova1, passwordNova2;

    JComboBox tipoSubscricaoB, pagamentoSubscricaoB;


    PainelAdmin(GUI janela, Empresa empresa) {
        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        painelAd = new JTabbedPane();
        painelAd.setFont(new Font("Arial", 1, 12));

        panel1 = new JPanel();
        painelAd.addTab("Adicionar Administrador", panel1);

        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();

        inserirDados = new JLabel("Insira os dados do novo administrador:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(20, 0, 0, 0);
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
        c1.insets = new Insets(30, 0, 20, 0);
        c1.gridx = 2;
        c1.gridy = 8;
        panel1.add(guardarRegisto, c1);
       /* guardarRegisto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailT.getText();
                String password = String.valueOf(passwordF.getPassword());
                String nome = nomeT.getText();
                String nif = nifT.getText();
                String telefone = telefoneT.getText();
                String morada = moradaT.getText();


                Utilizador novoAdmin = empresa.registarAdministrador(email, nome, telefone, nif, morada, password);

                if (empresa.validarEmail(email)) {

                    if (novoAdmin == null) {

                        JOptionPane.showMessageDialog(new JFrame("autenticação inválida"), "Autenticação inválida. Verifique se os dados estão corretos.");
                    }

                    else if (novoAdmin instanceof Administrador) {
                        JOptionPane.showMessageDialog(new JFrame("Administrador loggado"), novoAdmin.nome + " autenticado com sucesso");
                        janela.mudaEcra("Login");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Email inválido"), "Email inválido. Verifique se os dados estão corretos.");

                emailT.setText("");
                passwordF.setText("");
                nomeT.setText("");
                nifT.setText("");
                moradaT.setText("");
                telefoneT.setText("");


            }}

        });

*/
        panel2 = new JPanel(); //2º painel -> Motoristas, até à linha 269
        painelAd.addTab("Motoristas", panel2);
        panel2.setLayout(new GridLayout());

        painelM = new JTabbedPane(); //adiciona-se tabpane dentro de um painel que já está num tabpane
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


        panel3 = new JPanel(); //novo painel
        painelAd.addTab("Autocarros", panel3);
        panel3.setLayout(new GridLayout());

        painelAutocarro = new JTabbedPane(); //tabbpane
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
        c5.gridy = 1;
        addBus.add(matricula, c5);

        matriculaT = new JTextField("Formato ##-##-##", 50);
        matriculaT.setFont(new Font("Arial", 1, 12));
        c5.gridx = 2;
        c5.gridy = 1;
        addBus.add(matriculaT, c5);

        marca = new JLabel("Marca");
        marca.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 2;
        addBus.add(marca, c5);

        marcaT = new JTextField(50);
        c5.gridx = 2;
        c5.gridy = 2;
        addBus.add(marcaT, c5);

        modelo = new JLabel("Modelo");
        modelo.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 3;
        addBus.add(modelo, c5);

        modeloT = new JTextField(50);
        c5.gridx = 2;
        c5.gridy = 3;
        addBus.add(modeloT, c5);

        lotacao = new JLabel("Lotação");
        lotacao.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 4;
        addBus.add(lotacao, c5);

        lotacaoT = new JTextField(50);
        c5.gridx = 2;
        c5.gridy = 4;
        addBus.add(lotacaoT, c5);

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
        c6.gridy = 1;
        editBus.add(matricula, c6);

        matriculaT = new JTextField("Formato ##-##-##", 50);
        matriculaT.setFont(new Font("Arial", 1, 12));
        c6.gridx = 2;
        c6.gridy = 1;
        editBus.add(matriculaT, c6);

        marca = new JLabel("Marca");
        marca.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 2;
        editBus.add(marca, c6);

        marcaT = new JTextField(50);
        c6.gridx = 2;
        c6.gridy = 2;
        editBus.add(marcaT, c6);

        modelo = new JLabel("Modelo");
        modelo.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 3;
        editBus.add(modelo, c6);

        modeloT = new JTextField(50);
        c6.gridx = 2;
        c6.gridy = 3;
        editBus.add(modeloT, c6);

        lotacao = new JLabel("Lotação");
        lotacao.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 4;
        editBus.add(lotacao, c6);

        lotacaoT = new JTextField(50);
        c6.gridx = 2;
        c6.gridy = 4;
        editBus.add(lotacaoT, c6);

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

        inserirDados = new JLabel("Indique a matrícula do autocarro cujas informações pretende remover:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c7.gridx = 0;
        c7.gridy = 0;
        c7.insets = new Insets(0, 20, 20, 0);
        removeBus.add(inserirDados, c7);

        matricula = new JLabel("Matrícula");
        matricula.setFont(new Font("Arial", 1, 12));
        c7.gridx = 2;
        c7.gridy = 2;
        removeBus.add(matricula, c7);

        matriculaT = new JTextField("Formato ##-##-##", 50);
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
        panel4.setLayout(new GridLayout());

        painelC = new JTabbedPane();
        painelC.setFont(new Font("Arial", 1, 12));

        addC = new JPanel();
        painelC.addTab("Adicionar", addC);
        addC.setLayout(new GridBagLayout());
        GridBagConstraints c8 = new GridBagConstraints();

        inserirDados = new JLabel("Insira as seguintes informações para adicionar um novo cliente:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(20, 10, 0, 0);
        c8.gridx = 0;
        c8.gridy = 0;
        addC.add(inserirDados, c8);

        nome = new JLabel("Nome");
        nome.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 1;
        addC.add(nome, c8);

        nomeT = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 1;
        addC.add(nomeT, c8);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 2;
        addC.add(nif, c8);

        nifT = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 2;
        addC.add(nifT, c8);

        morada = new JLabel("Morada");
        morada.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 3;
        addC.add(morada, c8);

        moradaT = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 3;
        addC.add(moradaT, c8);

        telefone = new JLabel("Telefone");
        telefone.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 4;
        addC.add(telefone, c8);

        telefoneT = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 4;
        addC.add(telefoneT, c8);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 5;
        addC.add(email, c8);

        emailT = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 5;
        addC.add(emailT, c8);

        palavraPasse = new JLabel("Palavra Passe Inicial");
        palavraPasse.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 6;
        addC.add(palavraPasse, c8);

        passwordF = new JPasswordField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 6;
        addC.add(passwordF, c8);

        tipoSubscricaoL = new JLabel("Tipo de subscrição");
        tipoSubscricaoL.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 7;
        addC.add(tipoSubscricaoL, c8);

        String tiposSubscricao[] = {"Normal", "Premium"};
        tipoSubscricaoB = new JComboBox<>(tiposSubscricao);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.fill = GridBagConstraints.HORIZONTAL;
        c8.gridx = 2;
        c8.gridy = 7;
        addC.add(tipoSubscricaoB, c8);

        pagamentoSubscricaoL = new JLabel("Modo de pagamento da subscrição");
        pagamentoSubscricaoL.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 10);
        c8.gridx = 1;
        c8.gridy = 8;
        addC.add(pagamentoSubscricaoL, c8);

        String modosPagSubscricao[] = {"Paypal", "Cartão de Crédito", "Multibanco"};
        pagamentoSubscricaoB = new JComboBox<>(modosPagSubscricao);
        c8.fill = GridBagConstraints.HORIZONTAL;
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 8;
        addC.add(pagamentoSubscricaoB, c8);

        guardarRegisto = new JButton("Guardar registo de novo cliente");
        c8.fill = GridBagConstraints.HORIZONTAL;
        c8.insets = new Insets(20, 0, 20, 20);
        c8.gridx = 2;
        c8.gridy = 10;
        addC.add(guardarRegisto, c8);

        editC = new JPanel();
        painelC.addTab("Editar", editC);
        editC.setLayout(new GridBagLayout());
        GridBagConstraints c9 = new GridBagConstraints();

        inserirDados = new JLabel("Edite os dados pessoais do cliente:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(30, 0, 0, 0);
        c9.gridx = 0;
        c9.gridy = 0;
        editC.add(inserirDados, c9);

        nome = new JLabel("Nome");
        nome.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 1;
        editC.add(nome, c9);

        nomeT = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 1;
        editC.add(nomeT, c9);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 2;
        editC.add(nif, c9);

        nifT = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 2;
        editC.add(nifT, c9);

        morada = new JLabel("Morada");
        morada.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 3;
        editC.add(morada, c9);

        moradaT = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 3;
        editC.add(moradaT, c9);

        telefone = new JLabel("Telefone");
        telefone.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 4;
        editC.add(telefone, c9);

        telefoneT = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 4;
        editC.add(telefoneT, c9);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 5;
        editC.add(email, c9);

        emailT = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 5;
        editC.add(emailT, c9);

        palavraPasse = new JLabel("Palavra Passe Inicial");
        palavraPasse.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 6;
        editC.add(palavraPasse, c9);

        passwordF = new JPasswordField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 6;
        editC.add(passwordF, c9);

        tipoSubscricaoL = new JLabel("Tipo de subscrição");
        tipoSubscricaoL.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 7;
        editC.add(tipoSubscricaoL, c9);

        tipoSubscricaoB = new JComboBox<>(tiposSubscricao);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.fill = GridBagConstraints.HORIZONTAL;
        c9.gridx = 2;
        c9.gridy = 7;
        editC.add(tipoSubscricaoB, c9);

        pagamentoSubscricaoL = new JLabel("Modo de pagamento da subscrição");
        pagamentoSubscricaoL.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 10);
        c9.gridx = 1;
        c9.gridy = 8;
        editC.add(pagamentoSubscricaoL, c9);

        pagamentoSubscricaoB = new JComboBox<>(modosPagSubscricao);
        c9.fill = GridBagConstraints.HORIZONTAL;
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 8;
        editC.add(pagamentoSubscricaoB, c9);

        guardarRegisto = new JButton("Guardar alterações");
        c9.fill = GridBagConstraints.HORIZONTAL;
        c9.insets = new Insets(20, 0, 20, 0);
        c9.gridx = 2;
        c9.gridy = 10;
        editC.add(guardarRegisto, c9);

        removeC = new JPanel();
        painelC.addTab("Remover", removeC);
        removeC.setLayout(new GridBagLayout());
        GridBagConstraints c10 = new GridBagConstraints();

        inserirDados = new JLabel("Indique o NIF do cliente cujas informações pretende remover:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c10.gridx = 0;
        c10.gridy = 0;
        c10.insets = new Insets(0, 0, 20, 0);
        removeC.add(inserirDados, c10);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 12));
        c10.gridx = 2;
        c10.gridy = 2;
        c10.insets = new Insets(0, 0, 0, 10);
        removeC.add(nif, c10);

        nifT = new JTextField(50);
        c10.gridx = 3;
        c10.gridy = 2;
        removeC.add(nifT, c10);

        guardarRegisto = new JButton("Remover cliente");
        c10.insets = new Insets(20, 0, 0, 0);
        c10.gridx = 3;
        c10.gridy = 5;
        removeC.add(guardarRegisto, c10);

        panel4.add(painelC);

        panel5 = new JPanel();
        painelAd.addTab("Lista de Motoristas", panel5);

        panel6 = new JPanel();
        painelAd.addTab("Lista de Clientes", panel6);

        panel7 = new JPanel();
        painelAd.addTab("Estatísticas", panel7);
        panel7.setLayout(new GridBagLayout());
        GridBagConstraints c11 = new GridBagConstraints();

        inserirDados = new JLabel("Selecione o botão adequado para ver a respectiva informação estatística:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c11.insets = new Insets(20, 0, 0, 0);
        c11.gridx = 0;
        c11.gridy = 0;
        c11.gridwidth = 3;
        panel7.add(inserirDados, c11);

        totalCliente = new JButton("Total de clientes");
        totalCliente.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 1;
        panel7.add(totalCliente, c11);

        totalMotorista = new JButton("Total de motoristas");
        totalMotorista.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 2;
        panel7.add(totalMotorista, c11);

        totalAutocarro = new JButton("Total de autocarros");
        totalAutocarro.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 3;
        panel7.add(totalAutocarro, c11);

        autocarroMReq = new JButton("Autocarro mais requisitado");
        autocarroMReq.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 4;
        panel7.add(autocarroMReq, c11);

        clienteMViagens = new JButton("Cliente com mais reservas");
        clienteMViagens.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 5;
        panel7.add(clienteMViagens, c11);

        listaBusReservado = new JButton("Lista de autocarros reservados para um dado mês");
        listaBusReservado.setFont(new Font("Arial", 1, 12));
        c11.insets = new Insets(20, 20, 0, 0);
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 3;
        c11.gridy = 1;
        panel7.add(listaBusReservado, c11);

        listaReservaCanc = new JButton("Lista de reservas canceladas para um dado mês");
        listaReservaCanc.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.insets = new Insets(20, 20, 0, 0);
        c11.gridx = 3;
        c11.gridy = 2;
        panel7.add(listaReservaCanc, c11);

        listaReservaEmEspera = new JButton("Lista de reservas / clientes em espera");
        listaReservaEmEspera.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.insets = new Insets(20, 20, 0, 0);
        c11.gridx = 3;
        c11.gridy = 3;
        panel7.add(listaReservaEmEspera, c11);

        volumeReservaMensal = new JButton("Volume de reservas mensais para um dado ano");
        volumeReservaMensal.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.insets = new Insets(20, 20, 0, 0);
        c11.gridx = 3;
        c11.gridy = 4;
        panel7.add(volumeReservaMensal, c11);

        diaAnoMReserva = new JButton("Dia do ano com mais reservas");
        diaAnoMReserva.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.insets = new Insets(20, 20, 0, 0);
        c11.gridx = 3;
        c11.gridy = 5;
        panel7.add(diaAnoMReserva, c11);

        panel8 = new JPanel();
        painelAd.addTab("Alterar Palavra-Passe", panel8);
        panel8.setLayout(new GridBagLayout());
        GridBagConstraints c12 = new GridBagConstraints();

        inserirDados = new JLabel("Insira os dados pedidos para alerar a palavra-passe:");
        inserirDados.setFont(new Font("Arial", 1, 12));
        // c12.insets = new Insets(20, 0, 0, 0);
        c12.gridx = 0;
        c12.gridy = 0;
        c12.gridwidth = 2;
        panel8.add(inserirDados, c12);

        palavraPasse = new JLabel("Palavra-passe antiga");
        palavraPasse.setFont(new Font("Arial", 1, 12));
        c12.gridx = 1;
        c12.gridy = 1;
        panel8.add(palavraPasse, c12);

        passwordF = new JPasswordField(50);
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 1;
        panel8.add(passwordF, c12);

        passwordNova1L = new JLabel("Insira nova palavra-passe");
        passwordNova1L.setFont(new Font("Arial", 1, 12));
        c12.gridx = 1;
        c12.gridy = 2;
        panel8.add(passwordNova1L, c12);

        passwordNova1 = new JPasswordField(50);
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 2;
        panel8.add(passwordNova1, c12);

        passwordNova2L = new JLabel("Insira novamente a nova palavra-passe");
        passwordNova2L.setFont(new Font("Arial", 1, 12));
        c12.gridx = 1;
        c12.gridy = 3;
        panel8.add(passwordNova2L, c12);

        passwordNova2 = new JPasswordField(50);
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 3;
        panel8.add(passwordNova2, c12);

        guardarRegisto = new JButton("Guardar alterações");
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 5;
        panel8.add(guardarRegisto, c12);



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
        logout.addActionListener(new GerirEventos(2, this.janela));
    }


}
