package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PainelAdmin extends JPanel {
    Empresa empresa;

    GUI janela;
    JLabel welcome;
    JTabbedPane painelAd, painelM, painelAutocarro, painelC;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, addM, editM, removeM, addBus, editBus, removeBus, addC, editC, removeC;
    JButton logout, guardarRegisto, guardarRegisto1,guardarRegisto2, guardarRegisto3, guardarRegisto4,guardarRegisto5, guardarRegisto6, guardarRegisto7, totalCliente, totalMotorista, totalAutocarro, autocarroMReq, clienteMViagens, listaBusReservado, listaReservaCanc, listaReservaEmEspera, volumeReservaMensal, diaAnoMReserva;

    JList<Motorista> listagemMotoristas;
    JList<Utilizador> listagemClientes;

    JList<Autocarro> listagemAutocarros;

    JLabel inserirDados, nome, nif, morada, telefone, email, palavraPasse, matricula, marca, modelo, lotacao, tipoSubscricaoL, pagamentoSubscricaoL, passwordNova1L, passwordNova2L;
    JLabel inserirDados1, nome1, nif1, morada1, telefone1, email1, palavraPasse1;
    JLabel inserirDados2, nome2, nif2, email2;
    JLabel inserirDados3, nome3, nif3, email3;
    JLabel inserirDados4, nif4;
    JLabel inserirDados5, matricula5, marca5, modelo5, lotacao5;
    JLabel inserirDados6, matricula6, marca6, modelo6, lotacao6;
    JLabel inserirDados7, matricula7;
    JTextField nomeT, nifT, moradaT, telefoneT, emailT, emailT1;
    JTextField nomeT1, nifT1, moradaT1, telefoneT1;
    JTextField nomeT2, nifT2, emailT2;
    JTextField nomeT3, nifT3, emailT3;
    JTextField nifT4;
    JTextField matriculaT5, marcaT5, modeloT5, lotacaoT5;
    JTextField matriculaT6, marcaT6, modeloT6, lotacaoT6;
    JTextField matriculaT7;
    JPasswordField passwordF, passwordF1, passwordNova1, passwordNova2;

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

        inserirDados1 = new JLabel("Insira os dados do novo administrador:");
        inserirDados1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(20, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 0;
        panel1.add(inserirDados1, c1);

        nome1 = new JLabel("Nome");
        nome1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 1;
        panel1.add(nome1, c1);

        nomeT1 = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 1;
        panel1.add(nomeT1, c1);

        nif1 = new JLabel("NIF");
        nif1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 2;
        panel1.add(nif1, c1);

        nifT1 = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 2;
        panel1.add(nifT1, c1);

        morada1 = new JLabel("Morada");
        morada1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 3;
        panel1.add(morada1, c1);

        moradaT1 = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 3;
        panel1.add(moradaT1, c1);

        telefone1 = new JLabel("Telefone");
        telefone1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 4;
        panel1.add(telefone1, c1);

        telefoneT1 = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 4;
        panel1.add(telefoneT1, c1);

        email1 = new JLabel("Email");
        email1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 5;
        panel1.add(email1, c1);

        emailT1 = new JTextField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 5;
        panel1.add(emailT1, c1);

        palavraPasse1 = new JLabel("Palavra Passe");
        palavraPasse1.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 6;
        panel1.add(palavraPasse1, c1);

        passwordF1 = new JPasswordField(50);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 2;
        c1.gridy = 6;
        panel1.add(passwordF1, c1);

        guardarRegisto1 = new JButton("Guardar registo de novo administrador");
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.insets = new Insets(30, 0, 20, 0);
        c1.gridx = 2;
        c1.gridy = 8;
        panel1.add(guardarRegisto1, c1);

        guardarRegisto1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email1 = emailT1.getText();
                String password1 = String.valueOf(passwordF1.getPassword());
                String nome1 = nomeT1.getText();
                String nif1 = nifT1.getText();
                String telefone1 = telefoneT1.getText();
                String morada1 = moradaT1.getText();

             //   JOptionPane.showMessageDialog(new JFrame("Dados inválidos"),("*********" + emailT1.getText()));

                Utilizador novoAdministrador = empresa.registarAdministrador(email1, nome1, telefone1, nif1, morada1, password1, empresa);


                if (empresa.validarEmail(email1, empresa) && empresa.validarDados(nome1, empresa) && empresa.validarDados(nif1, empresa) && empresa.validarDados(password1, empresa)) {

                    if (novoAdministrador == null) {
                        JOptionPane.showMessageDialog(new JFrame("autenticação inválida"), "Autenticação inválida. Já existe um registo para este email.");
                    }

                    if (novoAdministrador instanceof Administrador) {
                        JOptionPane.showMessageDialog(new JFrame("Administrador loggado"), novoAdministrador.nome + " autenticado com sucesso");
                        janela.mudaEcra("Login");

                    } else if (novoAdministrador instanceof Cliente) {
                        JOptionPane.showMessageDialog(new JFrame("Cliente loggado"), novoAdministrador.nome + " autenticado com sucesso");
                        janela.mudaEcra("Login");
                    }
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Dados inválidos. Insira os dados pedidos");

                emailT1.setText("");
                passwordF1.setText("");
                nomeT1.setText("");
                nifT1.setText("");
                moradaT1.setText("");
                telefoneT1.setText("");

            }
        });


        panel2 = new JPanel(); //2º painel -> Motoristas, até à linha 269
        painelAd.addTab("Motoristas", panel2);
        panel2.setLayout(new GridLayout());

        painelM = new JTabbedPane(); //adiciona-se tabpane dentro de um painel que já está num tabpane
        painelM.setFont(new Font("Arial", 1, 12));

        addM = new JPanel();
        painelM.addTab("Adicionar", addM);
        addM.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        inserirDados2 = new JLabel("Insira as seguintes informações para adicionar um novo motorista:");
        inserirDados2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 0;
        c2.gridy = 0;
        c2.gridwidth = 2;
        c2.insets = new Insets(0, 0, 10, 0);
        addM.add(inserirDados2, c2);

        nome2 = new JLabel("Nome");
        nome2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 1;
        c2.gridy = 1;
        addM.add(nome2, c2);

        nomeT2 = new JTextField(50);
        c2.gridx = 2;
        c2.gridy = 1;
        addM.add(nomeT2, c2);

        email2 = new JLabel("Email");
        email2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 1;
        c2.gridy = 2;
        addM.add(email2, c2);

        emailT2 = new JTextField(50);
        c2.gridx = 2;
        c2.gridy = 2;
        addM.add(emailT2, c2);

        nif2 = new JLabel("NIF");
        nif2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 1;
        c2.gridy = 3;
        addM.add(nif2, c2);

        nifT2 = new JTextField(50);
        c2.gridx = 2;
        c2.gridy = 3;
        addM.add(nifT2, c2);

        guardarRegisto2 = new JButton("Guardar registo");
        c2.fill = GridBagConstraints.HORIZONTAL;
        c2.insets = new Insets(20, 0, 0, 0);
        c2.gridx = 2;
        c2.gridy = 5;
        addM.add(guardarRegisto2, c2);
        guardarRegisto2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome2 = nomeT2.getText();
                String nif2 = nifT2.getText();
                String email2 = emailT2.getText();

                Motorista novoMotorista = empresa.adicionarMotorista(email2, nome2, nif2, empresa);

                if (empresa.validarEmail(email2, empresa) && empresa.validarDados(nif2, empresa) && empresa.validarDados(nome2, empresa)) {

                    if (novoMotorista == null) {
                        JOptionPane.showMessageDialog(new JFrame("Já existe um motorista com este NIF"), "Já existe um motorista com este NIF: " + nif);
                    } else if (novoMotorista != null) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"), "Um novo motorista foi registado com sucesso");
                    }
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Dados inválidos. Insira os dados pedidos");


                nomeT2.setText("");
                nifT2.setText("");
                emailT2.setText("");
            }
        });


        editM = new JPanel();
        painelM.addTab("Editar", editM);
        editM.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();

        inserirDados3 = new JLabel("Edite os dados pessoais do motorista (use o NIF como identificador único do motorista):");
        inserirDados3.setFont(new Font("Arial", 1, 12));
        c3.gridx = 0;
        c3.gridy = 0;
        c3.gridwidth = 2;
        c3.insets = new Insets(0, 0, 10, 0);
        editM.add(inserirDados3, c3);

        nif3 = new JLabel("NIF");
        nif3.setFont(new Font("Arial", 1, 12));
        c3.gridx = 1;
        c3.gridy = 1;
        editM.add(nif3, c3);

        nifT3 = new JTextField(50);
        c3.gridx = 2;
        c3.gridy = 1;
        editM.add(nifT3, c3);

        nome3 = new JLabel("Nome");
        nome3.setFont(new Font("Arial", 1, 12));
        c3.gridx = 1;
        c3.gridy = 2;
        editM.add(nome3, c3);

        nomeT3 = new JTextField(50);
        c3.gridx = 2;
        c3.gridy = 2;
        editM.add(nomeT3, c3);

        email3 = new JLabel("Email");
        email3.setFont(new Font("Arial", 1, 12));
        c3.gridx = 1;
        c3.gridy = 3;
        editM.add(email3, c3);

        emailT3 = new JTextField(50);
        c3.gridx = 2;
        c3.gridy = 3;
        editM.add(emailT3, c3);

        guardarRegisto3 = new JButton("Guardar alterações");
        c3.fill = GridBagConstraints.HORIZONTAL;
        c3.insets = new Insets(20, 0, 0, 0);
        c3.gridx = 2;
        c3.gridy = 5;
        editM.add(guardarRegisto3, c3);

        guardarRegisto3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome3 = nomeT3.getText();
                String nif3 = nifT3.getText();
                String email3 = emailT3.getText();

                boolean resultado = empresa.editarMotorista(email3, nome3, nif3, empresa);

                if (empresa.validarEmail(email3, empresa) && empresa.validarDados(nif3, empresa) && empresa.validarDados(nome3, empresa)) {

                    if (resultado) {
                        JOptionPane.showMessageDialog(new JFrame("As informações do motorista associado ao nif indicado foram alteradas com sucesso"), "As informações do motorista associado ao nif " + nif + " foram alteradas com sucesso");
                    } else
                        JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum registo de motorista com o nif indicado"), "Não foi encontrado nenhum registo de motorista com o nif indicado");
                } else                     JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Dados inválidos. Insira os dados pedidos");


                nomeT3.setText("");
                nifT3.setText("");
                emailT3.setText("");
            }
        });


        removeM = new JPanel();
        painelM.addTab("Remover", removeM);
        removeM.setLayout(new GridBagLayout());
        GridBagConstraints c4 = new GridBagConstraints();

        inserirDados4 = new JLabel("Indique o NIF do motorista cujas informações pretende remover:");
        inserirDados4.setFont(new Font("Arial", 1, 12));
        c4.gridx = 0;
        c4.gridy = 0;
        c4.insets = new Insets(0, 0, 20, 0);
        removeM.add(inserirDados4, c4);

        nif4 = new JLabel("NIF");
        nif4.setFont(new Font("Arial", 1, 12));
        c4.gridx = 2;
        c4.gridy = 2;
        c4.insets = new Insets(0, 0, 0, 10);
        removeM.add(nif4, c4);

        nifT4 = new JTextField(50);
        c4.gridx = 3;
        c4.gridy = 2;
        removeM.add(nifT4, c4);

        guardarRegisto4 = new JButton("Remover motorista");
        c4.insets = new Insets(20, 0, 0, 0);
        c4.gridx = 3;
        c4.gridy = 5;
        removeM.add(guardarRegisto4, c4);
        guardarRegisto4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nif4 = nifT4.getText();

                boolean resultado = empresa.removerMotorista(nif4, empresa);

                if ( empresa.validarDados(nif4, empresa) ) {

                    if (resultado) {
                        JOptionPane.showMessageDialog(new JFrame("O motorista foi removido"), "O motorista foi removido");

                    } else
                        JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum registo de motorista com o nif indicado"), "Não foi encontrado nenhum registo de motorista com o nif indicado");

                } else JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Dados inválidos. Insira os dados pedidos");


                nifT4.setText("");
            }
        });


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

        inserirDados5 = new JLabel("Insira as seguintes informações para adicionar um novo autocarro:");
        inserirDados5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 0;
        c5.gridy = 0;
        c5.gridwidth = 2;
        c5.insets = new Insets(0, 0, 10, 0);
        addBus.add(inserirDados5, c5);

        matricula5 = new JLabel("Matrícula");
        matricula5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 1;
        addBus.add(matricula5, c5);

        matriculaT5 = new JTextField("Formato ##-##-##", 50);
        matriculaT5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 2;
        c5.gridy = 1;
        addBus.add(matriculaT5, c5);

        marca5 = new JLabel("Marca");
        marca5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 2;
        addBus.add(marca5, c5);

        marcaT5 = new JTextField(50);
        c5.gridx = 2;
        c5.gridy = 2;
        addBus.add(marcaT5, c5);

        modelo5 = new JLabel("Modelo");
        modelo5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 3;
        addBus.add(modelo5, c5);

        modeloT5 = new JTextField(50);
        c5.gridx = 2;
        c5.gridy = 3;
        addBus.add(modeloT5, c5);

        lotacao5 = new JLabel("Lotação");
        lotacao5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 1;
        c5.gridy = 4;
        addBus.add(lotacao5, c5);

        lotacaoT5 = new JTextField(50);
        c5.gridx = 2;
        c5.gridy = 4;
        addBus.add(lotacaoT5, c5);

        guardarRegisto5 = new JButton("Guardar registo");
        c5.fill = GridBagConstraints.HORIZONTAL;
        c5.insets = new Insets(20, 0, 0, 0);
        c5.gridx = 2;
        c5.gridy = 6;
        addBus.add(guardarRegisto5, c5);
        guardarRegisto5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca5 = marcaT5.getText();
                String modelo5 = modeloT5.getText();
                String matricula5 = matriculaT5.getText();
                int lotacao5 = Integer.parseInt(lotacaoT5.getText());

                Autocarro autocarro = empresa.adicionarAutocarro(matricula5, marca5, modelo5, lotacao5, empresa);

                if (autocarro == null) {
                    JOptionPane.showMessageDialog(new JFrame("Matricula ja existe"), "A matrícula " + matricula + " já existe");
                } else {
                    JOptionPane.showMessageDialog(new JFrame("Sucesso"), "A matrícula " + matricula + " foi registada com sucesso.");
                }

                marcaT5.setText("");
                modeloT5.setText("");
                matriculaT5.setText("");
                lotacaoT5.setText("");

            }
        });

        editBus = new JPanel();
        painelAutocarro.addTab("Editar", editBus);
        editBus.setLayout(new GridBagLayout());
        GridBagConstraints c6 = new GridBagConstraints();

        inserirDados6 = new JLabel("Edite as informações do autocarro:");
        inserirDados6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 0;
        c6.gridy = 0;
        c6.gridwidth = 2;
        c6.insets = new Insets(0, 0, 10, 0);
        editBus.add(inserirDados6, c6);

        matricula6 = new JLabel("Matrícula");
        matricula6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 1;
        editBus.add(matricula6, c6);

        matriculaT6 = new JTextField("Formato ##-##-##", 50);
        matriculaT6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 2;
        c6.gridy = 1;
        editBus.add(matriculaT6, c6);

        marca6 = new JLabel("Marca");
        marca6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 2;
        editBus.add(marca6, c6);

        marcaT6 = new JTextField(50);
        c6.gridx = 2;
        c6.gridy = 2;
        editBus.add(marcaT6, c6);

        modelo6 = new JLabel("Modelo");
        modelo6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 3;
        editBus.add(modelo6, c6);

        modeloT6 = new JTextField(50);
        c6.gridx = 2;
        c6.gridy = 3;
        editBus.add(modeloT6, c6);

        lotacao6 = new JLabel("Lotação");
        lotacao6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 1;
        c6.gridy = 4;
        editBus.add(lotacao6, c6);

        lotacaoT6 = new JTextField(50);
        c6.gridx = 2;
        c6.gridy = 4;
        editBus.add(lotacaoT6, c6);

        guardarRegisto6 = new JButton("Guardar alterações");
        c6.fill = GridBagConstraints.HORIZONTAL;
        c6.insets = new Insets(20, 0, 0, 0);
        c6.gridx = 2;
        c6.gridy = 6;
        editBus.add(guardarRegisto6, c6);

        guardarRegisto6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca6 = marcaT6.getText();
                String modelo6 = modeloT6.getText();
                String matricula6 = matriculaT6.getText();
                int lotacao6 = Integer.parseInt(lotacaoT6.getText());

                boolean resultado = empresa.editarAutocarro(matricula6, marca6, modelo6, lotacao6, empresa);

                if (resultado) {
                    JOptionPane.showMessageDialog(new JFrame("Sucesso"), "As informações do autocarro associado à matrícula " + matricula6 + " foram alteradas com sucesso");

                } else
                    JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum registo com a matrícula inserida"),
                            "Não foi encontrado nenhum registo de matrícula com os dados inseridos, insira novamente os dados:");

                marcaT6.setText("");
                modeloT6.setText("");
                matriculaT6.setText("");
                lotacaoT6.setText("");

            }
        });


        removeBus = new JPanel();
        painelAutocarro.addTab("Remover", removeBus);
        removeBus.setLayout(new GridBagLayout());
        GridBagConstraints c7 = new GridBagConstraints();

        inserirDados7 = new JLabel("Indique a matrícula do autocarro cujas informações pretende remover:");
        inserirDados7.setFont(new Font("Arial", 1, 12));
        c7.gridx = 0;
        c7.gridy = 0;
        c7.insets = new Insets(0, 20, 20, 0);
        removeBus.add(inserirDados7, c7);

        matricula7 = new JLabel("Matrícula");
        matricula7.setFont(new Font("Arial", 1, 12));
        c7.gridx = 2;
        c7.gridy = 2;
        removeBus.add(matricula7, c7);

        matriculaT7 = new JTextField("Formato ##-##-##", 50);
        c7.gridx = 3;
        c7.gridy = 2;
        removeBus.add(matriculaT7, c7);

        guardarRegisto7 = new JButton("Remover autocarro");
        c7.insets = new Insets(20, 0, 0, 0);
        c7.gridx = 3;
        c7.gridy = 4;
        removeBus.add(guardarRegisto7, c7);

        guardarRegisto7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String matricula = matriculaT7.getText();
                boolean resultado = empresa.removerAutocarro(matricula, empresa);

                if (resultado) {
                    JOptionPane.showMessageDialog(new JFrame("O autocarro foi removido"), "O autocarro foi removido");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum autocarro com a matrícula indicada"),
                            "Não foi encontrado nenhum autocarro com a matrícula indicada, insira novamente os dados");

                matriculaT7.setText("");
            }
        });


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
        panel5.setLayout(new GridBagLayout());
        GridBagConstraints c13 = new GridBagConstraints();

        inserirDados = new JLabel("Lista dos motoristas da empresa");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c13.insets = new Insets(0, 0, 0, 20);
        c13.gridx = 0;
        c13.gridy = 0;
        panel5.add(inserirDados, c13);

        listagemMotoristas = new JList<Motorista>(new Vector<Motorista>(empresa.getListaMotoristas()));

    /*   if (empresa.getListaMotoristas().size()==0)
           JOptionPane.showMessageDialog(new JFrame("Não há motoristas"), "Não há motoristas para listar");
*/
        c13.gridx = 1;
        c13.gridy = 1;
        //listagemMotoristas.setSelectedIndex(0);
        panel5.add(listagemMotoristas, c13);


        panel6 = new JPanel();
        painelAd.addTab("Lista de Clientes", panel6);
        panel6.setLayout(new GridBagLayout());
        GridBagConstraints c14 = new GridBagConstraints();

        inserirDados = new JLabel("Lista dos clientes da empresa");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c14.insets = new Insets(0, 0, 0, 20);
        c14.gridx = 0;
        c14.gridy = 0;
        panel6.add(inserirDados, c14);

        listagemClientes = new JList<Utilizador>(new Vector<Utilizador>(empresa.getListaUtilizadores()));
        c14.gridx = 1;
        c14.gridy = 1;
        //listagemClientes.setSelectedIndex(0);
        panel6.add(listagemClientes, c14);


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

        inserirDados = new JLabel("Insira os dados pedidos para alterar a palavra-passe:");
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