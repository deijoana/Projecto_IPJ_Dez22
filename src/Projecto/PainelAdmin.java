package Projecto;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class PainelAdmin extends JPanel {
    Empresa empresa;
    GUI janela;
    JLabel welcome;
    JTabbedPane painelAd, painelM, painelAutocarro, painelC;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, addM, editM, removeM, addBus, editBus, removeBus, addC, editC, removeC, listaClientes, listaMotoristas;
    JButton logout, guardarRegisto, guardarRegisto1, guardarRegisto2, guardarRegisto3, guardarRegisto4, guardarRegisto5, guardarRegisto6, guardarRegisto7, guardarRegisto8, guardarRegisto9, guardarRegisto10, guardarRegisto12, totalCliente, totalMotorista, totalAutocarro, autocarroMReq, clienteMViagens, listaBusReservado, listaReservaCanc, listaReservaEmEspera, volumeReservaMensal, diaAnoMReserva;

    JList<Motorista> listagemMotoristas;
    JList<Utilizador> listagemClientes;

    JList<Autocarro> listagemAutocarros;

    JScrollPane scrollPane1, scrollPane2;

    JLabel inserirDados, nome, nif, morada, telefone, email, palavraPasse, matricula, marca, modelo, lotacao, tipoSubscricaoL, pagamentoSubscricaoL, passwordNova1L, passwordNova2L;
    JLabel inserirDados1, nome1, nif1, morada1, telefone1, email1, palavraPasse1;
    JLabel inserirDados2, nome2, nif2, email2;
    JLabel inserirDados3, nome3, nif3, email3;
    JLabel inserirDados4, nif4;
    JLabel inserirDados5, matricula5, marca5, modelo5, lotacao5;
    JLabel inserirDados6, matricula6, marca6, modelo6, lotacao6;
    JLabel inserirDados7, matricula7;
    JLabel inserirDados8, nome8, nif8, telefone8, morada8, email8, palavraPasse8, pagamentoSubscricaoL8, tipoSubscricaoL8;

    JLabel inserirDados9, nome9, nif9, telefone9, morada9, email9, palavraPasse9, pagamentoSubscricaoL9, tipoSubscricaoL9;

    JLabel inserirDados10, nif10;

    JLabel inserirDados12;

    JTextField nomeT, nifT, moradaT, telefoneT, emailT, emailT1;
    JTextField nomeT1, nifT1, moradaT1, telefoneT1;
    JTextField nomeT2, nifT2, emailT2;
    JTextField nomeT3, nifT3, emailT3;
    JTextField nifT4;
    JTextField matriculaT5, marcaT5, modeloT5, lotacaoT5;
    JTextField matriculaT6, marcaT6, modeloT6, lotacaoT6;
    JTextField matriculaT7;

    JTextField nomeT8, nifT8, telefoneT8, moradaT8, emailT8;
    JTextField nomeT9, nifT9, telefoneT9, moradaT9, emailT9;

    JTextField nifT10;
    JPasswordField passwordF8, passwordF9, passwordF, passwordF1, passwordNova1, passwordNova2;

    JComboBox tipoSubscricaoB8, pagamentoSubscricaoB8, tipoSubscricaoB9, pagamentoSubscricaoB9, tipoSubscricaoB, pagamentoSubscricaoB;

    HashMap<Autocarro, Reserva> autocarroReservado;


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

                Utilizador novoAdministrador = empresa.registarAdministrador(email1, nome1, telefone1, nif1, morada1, password1);


                if (empresa.validarEmail(email1) && empresa.validarDados(nome1) && empresa.validarNIF(nif1) && empresa.validarDados(password1) && empresa.validarTelefone(telefone1)) {

                    if (novoAdministrador == null) {
                        JOptionPane.showMessageDialog(new JFrame("autenticação inválida"), "Autenticação inválida. Já existe um registo para este email.");
                    }

                    if (novoAdministrador instanceof Administrador) {
                        JOptionPane.showMessageDialog(new JFrame("Administrador criado"), "Registo de " + novoAdministrador.nome + " criado com sucesso");
                        janela.mudaEcra("Login");

                    } else if (novoAdministrador instanceof Cliente) {
                        JOptionPane.showMessageDialog(new JFrame("Cliente criado"), "Registo de " + novoAdministrador.nome + " criado com sucesso");
                        janela.mudaEcra("Login");
                    }
                    emailT1.setText("");
                    passwordF1.setText("");
                    nomeT1.setText("");
                    nifT1.setText("");
                    moradaT1.setText("");
                    telefoneT1.setText("");

                } else if (!empresa.validarEmail(email1)) {
                    JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Insira um email válido");
                } else if (!empresa.validarNIF(nif1)) {
                    JOptionPane.showMessageDialog(new Frame("Falta dados"), "Insira um NIF válido (9 dígitos)");
                } else if (!empresa.validarTelefone(telefone1))
                    JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Insira um telefone válido segundo o formato: 003519xxxxxxxx");
                else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um nome e/ou password válidos");


            }
        });


        panel2 = new JPanel();
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

                Motorista novoMotorista = empresa.adicionarMotorista(email2, nome2, nif2);

                if (empresa.validarEmail(email2) && empresa.validarNIF(nif2) && empresa.validarDados(nome2)) {

                    if (novoMotorista == null) {
                        JOptionPane.showMessageDialog(new JFrame("Já existe um motorista com este NIF"),
                                "Já existe um motorista com este NIF: " + nif2);
                    } else if (novoMotorista != null) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"), "Um novo motorista foi registado com sucesso");
                    }
                    nomeT2.setText("");
                    nifT2.setText("");
                    emailT2.setText("");

                } else if (!empresa.validarEmail(email2)) {
                    JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Insira um email válido");
                } else if (!empresa.validarNIF(nif2)) {
                    JOptionPane.showMessageDialog(new Frame("Falta dados"), "Insira um NIF válido (9 dígitos)");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Preencha o nome");

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

                boolean resultado1 = empresa.editarMotorista(email3, nome3, nif3);

                if (empresa.validarEmail(email3) && empresa.validarNIF(nif3) && empresa.validarDados(nome3)) {

                    if (resultado1) {
                        JOptionPane.showMessageDialog(new JFrame("As informações do motorista associado ao nif indicado foram alteradas com sucesso"),
                                "As informações do motorista associado ao nif " + nif3 + " foram alteradas com sucesso");
                    } else
                        JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum registo de motorista com o nif indicado"),
                                "Não foi encontrado nenhum registo de motorista com o nif indicado");
                    nomeT3.setText("");
                    nifT3.setText("");
                    emailT3.setText("");

                } else if (!empresa.validarEmail(email3)) {
                    JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Insira um email válido");
                } else if (!empresa.validarNIF(nif3)) {
                    JOptionPane.showMessageDialog(new Frame("Falta dados"), "Insira um NIF válido (9 dígitos)");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Preencha o nome");

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

                boolean resultado2 = empresa.removerMotorista(nif4);

                if (empresa.validarNIF(nif4)) {

                    if (resultado2) {
                        JOptionPane.showMessageDialog(new JFrame("O motorista foi removido"), "O motorista foi removido");

                    } else
                        JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum registo de motorista com o nif indicado"), "Não foi encontrado nenhum registo de motorista com o nif indicado");
                    nifT4.setText("");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um NIF válido (9 dígitos)");


            }
        });

        painelM.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                listagemMotoristas.setListData(new Vector<>(empresa.getListaMotoristas()));
            }
        });

        listaMotoristas = new JPanel();
        painelM.addTab("Lista de Motoristas", listaMotoristas);
        listaMotoristas.setLayout(new GridBagLayout());
        GridBagConstraints c13 = new GridBagConstraints();

        inserirDados = new JLabel("Lista dos motoristas da empresa");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c13.insets = new Insets(0, 0, 0, 20);
        c13.gridx = 0;
        c13.gridy = 0;
        listaMotoristas.add(inserirDados, c13);

        listagemMotoristas = new JList<Motorista>(new Vector<Motorista>(empresa.getListaMotoristas()));

    /*   if (empresa.getListaMotoristas().size()==0)
           JOptionPane.showMessageDialog(new JFrame("Não há motoristas"), "Não há motoristas para listar");
*/
        c13.gridx = 1;
        c13.gridy = 1;
        //listagemMotoristas.setSelectedIndex(0);
        listaMotoristas.add(listagemMotoristas, c13);

        scrollPane1 = new JScrollPane(listagemMotoristas);
        listaMotoristas.add(scrollPane1, c13);

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

        matriculaT5 = new JTextField("##-##-##", 50);
        matriculaT5.setFont(new Font("Arial", 1, 12));
        c5.gridx = 2;
        c5.gridy = 1;
        addBus.add(matriculaT5, c5);
        matriculaT5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                matriculaT5.setText("##-##-##");
            }
        });

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

                Autocarro autocarro = empresa.adicionarAutocarro(matricula5, marca5, modelo5, lotacao5);
                if (empresa.validarMatricula(matricula5) && empresa.validarDados(modelo5) && empresa.validarDados(marca5) && empresa.validarDados(String.valueOf(lotacao5))) {
                    if (autocarro == null) {
                        JOptionPane.showMessageDialog(new JFrame("Matricula ja existe"), "A matrícula " + matricula5 + " já existe");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"), "A matrícula " + matricula5 + " foi registada com sucesso.");
                    }
                    marcaT5.setText("");
                    modeloT5.setText("");
                    matriculaT5.setText("##-##-##");
                    lotacaoT5.setText("");

                } else if (!empresa.validarMatricula(matricula5))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira uma matrícula válida: ##-##-##");
                else if (!empresa.validarDados(String.valueOf(lotacao5)))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um valor numérico válido para lotação do autocarro");
                else JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira modelo e/ou marca válidos");


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

        matriculaT6 = new JTextField("##-##-##", 50);
        matriculaT6.setFont(new Font("Arial", 1, 12));
        c6.gridx = 2;
        c6.gridy = 1;
        editBus.add(matriculaT6, c6);
        matriculaT6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                matriculaT6.setText("##-##-##");
            }
        });

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

                boolean resultado3 = empresa.editarAutocarro(matricula6, marca6, modelo6, lotacao6);
                if (empresa.validarMatricula(matricula6) && empresa.validarDados(modelo6) && empresa.validarDados(marca6) && empresa.validarDados(String.valueOf(lotacao6))) {
                    if (resultado3) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"),
                                "As informações do autocarro associado à matrícula " + matricula6 + " foram alteradas com sucesso");

                    } else
                        JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum registo com a matrícula inserida"),
                                "Não foi encontrado nenhum registo de matrícula com os dados inseridos. Insira novamente os dados:");
                    marcaT6.setText("");
                    modeloT6.setText("");
                    matriculaT6.setText("##-##-##");
                    lotacaoT6.setText("");

                } else if (!empresa.validarMatricula(matricula6))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira uma matrícula válida: ##-##-##");
                else if (!empresa.validarDados(String.valueOf(lotacao6)))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um valor numérico válido para lotação do autocarro");
                else JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira modelo e/ou marca válidos");

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

        matriculaT7 = new JTextField("##-##-##", 50);
        c7.gridx = 3;
        c7.gridy = 2;
        removeBus.add(matriculaT7, c7);
        matriculaT7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                matriculaT7.setText("");
            }
        });

        guardarRegisto7 = new JButton("Remover autocarro");
        c7.insets = new Insets(20, 0, 0, 0);
        c7.gridx = 3;
        c7.gridy = 4;
        removeBus.add(guardarRegisto7, c7);

        guardarRegisto7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String matricula7 = matriculaT7.getText();
                boolean resultado4 = empresa.removerAutocarro(matricula7);
                if (empresa.validarMatricula(matricula7)) {
                    if (resultado4) {
                        empresa.cancelarReservaSemBus(matricula7);
                        JOptionPane.showMessageDialog(new JFrame("O autocarro foi removido"), "O autocarro foi removido");
                    } else
                        JOptionPane.showMessageDialog(new JFrame("Não foi encontrado nenhum autocarro com a matrícula indicada"),
                                "Não foi encontrado nenhum autocarro com a matrícula indicada, insira novamente os dados");
                    matriculaT7.setText("##-##-##");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira uma matrícula válida: ##-##-##");


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

        inserirDados8 = new JLabel("Insira as seguintes informações para adicionar um novo cliente:");
        inserirDados8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(20, 10, 0, 0);
        c8.gridx = 0;
        c8.gridy = 0;
        addC.add(inserirDados8, c8);

        nome8 = new JLabel("Nome");
        nome8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 1;
        addC.add(nome8, c8);

        nomeT8 = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 1;
        addC.add(nomeT8, c8);

        nif8 = new JLabel("NIF");
        nif8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 2;
        addC.add(nif8, c8);

        nifT8 = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 2;
        addC.add(nifT8, c8);

        morada8 = new JLabel("Morada");
        morada8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 3;
        addC.add(morada8, c8);

        moradaT8 = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 3;
        addC.add(moradaT8, c8);

        telefone8 = new JLabel("Telefone");
        telefone8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 4;
        addC.add(telefone8, c8);

        telefoneT8 = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 4;
        addC.add(telefoneT8, c8);

        email8 = new JLabel("Email");
        email8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 5;
        addC.add(email8, c8);

        emailT8 = new JTextField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 5;
        addC.add(emailT8, c8);

        palavraPasse8 = new JLabel("Palavra Passe Inicial");
        palavraPasse8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 6;
        addC.add(palavraPasse8, c8);

        passwordF8 = new JPasswordField(50);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 6;
        addC.add(passwordF8, c8);

        tipoSubscricaoL8 = new JLabel("Tipo de subscrição");
        tipoSubscricaoL8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 0);
        c8.gridx = 1;
        c8.gridy = 7;
        addC.add(tipoSubscricaoL8, c8);

        String tiposSubscricao[] = {"Normal"};   // By default, o cliente adicionado por administrador será sempre normal
        // String modosPagSubscricao[] = {"Paypal", "Cartão de Crédito", "Multibanco"};
        tipoSubscricaoB8 = new JComboBox<>(tiposSubscricao);
        c8.insets = new Insets(10, 0, 0, 20);
        c8.fill = GridBagConstraints.HORIZONTAL;
        c8.gridx = 2;
        c8.gridy = 7;
        addC.add(tipoSubscricaoB8, c8);

       /* pagamentoSubscricaoL8 = new JLabel("Modo de pagamento da subscrição");
        pagamentoSubscricaoL8.setFont(new Font("Arial", 1, 12));
        c8.insets = new Insets(10, 0, 0, 10);
        c8.gridx = 1;
        c8.gridy = 8;
        addC.add(pagamentoSubscricaoL8, c8);
        pagamentoSubscricaoB8 = new JComboBox<>(modosPagSubscricao);
        c8.fill = GridBagConstraints.HORIZONTAL;
        c8.insets = new Insets(10, 0, 0, 20);
        c8.gridx = 2;
        c8.gridy = 8;
        addC.add(pagamentoSubscricaoB8, c8);
*/
        guardarRegisto8 = new JButton("Guardar registo de novo cliente");
        c8.fill = GridBagConstraints.HORIZONTAL;
        c8.insets = new Insets(20, 0, 20, 20);
        c8.gridx = 2;
        c8.gridy = 10;
        addC.add(guardarRegisto8, c8);
        guardarRegisto8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email8 = emailT8.getText();
                String password8 = String.valueOf(passwordF8.getPassword());
                String nome8 = nomeT8.getText();
                String nif8 = nifT8.getText();
                String telefone8 = telefoneT8.getText();
                String morada8 = moradaT8.getText();
                String tipoSubscricao8 = tipoSubscricaoB8.getSelectedItem().toString();
                String pagamentoSubscricao8 = null;  // O cliente adicionado por administrador é definido como normal, by default logo n tem modo de pagamento associado
                // String pagamentoSubscricao8 = pagamentoSubscricaoB8.getSelectedItem().toString();

                TipoSubscricao tipoSubscricao = TipoSubscricao.parse(tipoSubscricao8);

                // System.out.println(tipoSubscricao8 + " , " + pagamentoSubscricao8);

                Utilizador novoCliente = empresa.registarCliente(email8, nome8, telefone8, nif8, morada8, tipoSubscricao, pagamentoSubscricao8, password8);

                if (empresa.validarEmail(email8) && empresa.validarDados(nome8) && empresa.validarNIF(nif8) && empresa.validarDados(password8) && empresa.validarTelefone(telefone8)) {

                    if (novoCliente == null) {
                        JOptionPane.showMessageDialog(new JFrame("autenticação inválida"), "Autenticação inválida. Já existe um registo para este email.");
                    }

                    if (novoCliente instanceof Administrador) {
                        JOptionPane.showMessageDialog(new JFrame("Administrador criado"), "Registo de " + novoCliente.nome + " criado com sucesso");


                    } else if (novoCliente instanceof Cliente) {
                        JOptionPane.showMessageDialog(new JFrame("Cliente criado"), "Registo de " + novoCliente.nome + " criado com sucesso");

                    }
                    emailT8.setText("");
                    passwordF8.setText("");
                    nomeT8.setText("");
                    nifT8.setText("");
                    moradaT8.setText("");
                    telefoneT8.setText("");

                } else if (!empresa.validarEmail(email8))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um email válido");

                else if (!empresa.validarNIF(nif8))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um NIF válido (9 dígitos)");
                else if (!empresa.validarTelefone(telefone8))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um telefone válido segundo o formato: 003519xxxxxxxx)");
                else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira nome e/ou password válidos");


            }
        });


        editC = new JPanel();
        painelC.addTab("Editar", editC);
        editC.setLayout(new GridBagLayout());
        GridBagConstraints c9 = new GridBagConstraints();

        inserirDados9 = new JLabel("Edite os dados pessoais do cliente:");
        inserirDados9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(30, 0, 0, 0);
        c9.gridx = 0;
        c9.gridy = 0;
        editC.add(inserirDados9, c9);

        nome9 = new JLabel("Nome");
        nome9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 1;
        editC.add(nome9, c9);

        nomeT9 = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 1;
        editC.add(nomeT9, c9);

        nif9 = new JLabel("NIF");
        nif9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 2;
        editC.add(nif9, c9);

        nifT9 = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 2;
        editC.add(nifT9, c9);

        morada9 = new JLabel("Morada");
        morada9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 3;
        editC.add(morada9, c9);

        moradaT9 = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 3;
        editC.add(moradaT9, c9);

        telefone9 = new JLabel("Telefone");
        telefone9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 4;
        editC.add(telefone9, c9);

        telefoneT9 = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 4;
        editC.add(telefoneT9, c9);

        email9 = new JLabel("Email");
        email9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 5;
        editC.add(email9, c9);

        emailT9 = new JTextField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 5;
        editC.add(emailT9, c9);

      /*  palavraPasse9 = new JLabel("Palavra Passe Inicial");
        palavraPasse9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 6;
        editC.add(palavraPasse9, c9);
        passwordF9 = new JPasswordField(50);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 6;
        editC.add(passwordF9, c9);
        tipoSubscricaoL9 = new JLabel("Tipo de subscrição");
        tipoSubscricaoL9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 1;
        c9.gridy = 7;
        editC.add(tipoSubscricaoL9, c9);
        tipoSubscricaoB9 = new JComboBox<>(tiposSubscricao);
        c9.insets = new Insets(10, 0, 0, 0);
        c9.fill = GridBagConstraints.HORIZONTAL;
        c9.gridx = 2;
        c9.gridy = 7;
        editC.add(tipoSubscricaoB9, c9);
        pagamentoSubscricaoL9 = new JLabel("Modo de pagamento da subscrição");
        pagamentoSubscricaoL9.setFont(new Font("Arial", 1, 12));
        c9.insets = new Insets(10, 0, 0, 10);
        c9.gridx = 1;
        c9.gridy = 8;
        editC.add(pagamentoSubscricaoL9, c9);
        pagamentoSubscricaoB9 = new JComboBox<>(modosPagSubscricao);
        c9.fill = GridBagConstraints.HORIZONTAL;
        c9.insets = new Insets(10, 0, 0, 0);
        c9.gridx = 2;
        c9.gridy = 8;
        editC.add(pagamentoSubscricaoB9, c9);
*/
        guardarRegisto9 = new JButton("Guardar alterações");
        c9.fill = GridBagConstraints.HORIZONTAL;
        c9.insets = new Insets(20, 0, 20, 0);
        c9.gridx = 2;
        c9.gridy = 10;
        editC.add(guardarRegisto9, c9);
        guardarRegisto9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email9 = emailT9.getText();
                // String password9 = String.valueOf(passwordF9.getPassword());
                String nome9 = nomeT9.getText();
                String nif9 = nifT9.getText();
                String telefone9 = telefoneT9.getText();
                String morada9 = moradaT9.getText();
                // String tipoSubscricao9 = tipoSubscricaoB9.getSelectedItem().toString();
                // String pagamentoSubscricao9 = pagamentoSubscricaoB9.getSelectedItem().toString();

                boolean resultado5 = empresa.editarCliente(email9, nome9, telefone9, nif9, morada9);

                if (empresa.validarEmail(email9) && empresa.validarDados(nome9) && empresa.validarNIF(nif9) && empresa.validarTelefone(telefone9)) {

                    if (resultado5) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"),
                                "As informações do cliente associado ao nif " + nif9 + " foram alteradas com sucesso");
                    } else
                        JOptionPane.showMessageDialog(new JFrame("Cliente não encontrado"),
                                "Nenhum registo de cliente encontrado associado ao nif " + nif9);

                    emailT9.setText("");
                    //  passwordF9.setText("");
                    nomeT9.setText("");
                    nifT9.setText("");
                    moradaT9.setText("");
                    telefoneT9.setText("");

                } else if (!empresa.validarEmail(email9))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um email válido");

                else if (!empresa.validarNIF(nif9))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um NIF válido (9 dígitos)");
                else if (!empresa.validarTelefone(telefone9))
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um telefone válido segundo o formato: 003519xxxxxxxx)");
                else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um nome válido");

            }
        });


        removeC = new JPanel();
        painelC.addTab("Remover", removeC);
        removeC.setLayout(new GridBagLayout());
        GridBagConstraints c10 = new GridBagConstraints();

        inserirDados10 = new JLabel("Indique o NIF do cliente cujas informações pretende remover:");
        inserirDados10.setFont(new Font("Arial", 1, 12));
        c10.gridx = 0;
        c10.gridy = 0;
        c10.insets = new Insets(0, 0, 20, 0);
        removeC.add(inserirDados10, c10);

        nif10 = new JLabel("NIF");
        nif10.setFont(new Font("Arial", 1, 12));
        c10.gridx = 2;
        c10.gridy = 2;
        c10.insets = new Insets(0, 0, 0, 10);
        removeC.add(nif10, c10);

        nifT10 = new JTextField(50);
        c10.gridx = 3;
        c10.gridy = 2;
        removeC.add(nifT10, c10);

        guardarRegisto10 = new JButton("Remover cliente");
        c10.insets = new Insets(20, 0, 0, 0);
        c10.gridx = 3;
        c10.gridy = 5;
        removeC.add(guardarRegisto10, c10);

        guardarRegisto10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nif10 = nifT10.getText();


                if (empresa.validarNIF(nif10)) {
                     boolean clienteFoiRemovidoComSucesso = empresa.removerCliente(nif10);
                    if (clienteFoiRemovidoComSucesso) {

                        JOptionPane.showMessageDialog(new JFrame("Cliente removido com sucesso"),
                                "O cliente associado ao nif " + nif10 + " foi removido com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame("Cliente não encontrado"),
                                "Nenhum registo de cliente encontrado associado ao nif " + nif10);
                    }
                    nifT10.setText("");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Dados inválidos"), "Insira um NIF válido (9 dígitos)");
            }
        });

        listaClientes = new JPanel();
        painelC.addTab("Lista de Clientes", listaClientes);
        listaClientes.setLayout(new GridBagLayout());
        GridBagConstraints c14 = new GridBagConstraints();

        inserirDados = new JLabel("Lista dos clientes da empresa");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c14.insets = new Insets(0, 0, 0, 20);
        c14.gridx = 0;
        c14.gridy = 0;
        listaClientes.add(inserirDados, c14);

        painelC.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                listagemClientes.setListData(new Vector<>(empresa.listaDeClientes()));
            }
        });

        listagemClientes = new JList<Utilizador>(new Vector<Utilizador>(empresa.listaDeClientes()));
        c14.gridx = 1;
        c14.gridy = 1;
        //listagemClientes.setSelectedIndex(0);
        listaClientes.add(listagemClientes, c14);

        scrollPane2 = new JScrollPane(listagemClientes);
        listaClientes.add(scrollPane2, c14);

        panel4.add(painelC);

     /*   panel5 = new JPanel();
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
   /*     c13.gridx = 1;
        c13.gridy = 1;
        //listagemMotoristas.setSelectedIndex(0);
        panel5.add(listagemMotoristas, c13);
*/

   /*     panel6 = new JPanel();
        painelAd.addTab("Lista de Clientes", panel6);
        panel6.setLayout(new GridBagLayout());
        GridBagConstraints c14 = new GridBagConstraints();
        inserirDados = new JLabel("Lista dos clientes da empresa");
        inserirDados.setFont(new Font("Arial", 1, 12));
        c14.insets = new Insets(0, 0, 0, 20);
        c14.gridx = 0;
        c14.gridy = 0;
        panel6.add(inserirDados, c14);
        listagemClientes = new JList<Utilizador>(new Vector<Utilizador>(empresa.listaDeClientes(empresa)));
        c14.gridx = 1;
        c14.gridy = 1;
        //listagemClientes.setSelectedIndex(0);
        panel6.add(listagemClientes, c14);
*/

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

        totalCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalClientes = 0;

                totalClientes = empresa.totalClientes();

                JOptionPane.showMessageDialog(new JFrame("Número de Clientes"), "Total de Clientes: " + totalClientes);

            }
        });

        totalMotorista = new JButton("Total de motoristas");
        totalMotorista.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 2;
        panel7.add(totalMotorista, c11);

        totalMotorista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int totalMotoristas = 0;

                totalMotoristas = empresa.totalMotoristas();

                JOptionPane.showMessageDialog(new JFrame("Número de Motoristas"), "Total de Motoristas: " + totalMotoristas);

            }
        });

        totalAutocarro = new JButton("Total de autocarros");
        totalAutocarro.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 3;
        panel7.add(totalAutocarro, c11);

        totalAutocarro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int totalAutocarros = 0;
                totalAutocarros = empresa.totalAutocarros();

                JOptionPane.showMessageDialog(new JFrame("Número de Autocarros"), "Total de Autocarros: " + totalAutocarros);

            }
        });

        autocarroMReq = new JButton("Autocarro mais requisitado");
        autocarroMReq.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 4;
        panel7.add(autocarroMReq, c11);

        autocarroMReq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AutocarrosMaisUtilizadosStats autocarrosMaisUtilizadosStats = empresa.encontrarAutocarroMaisReq();

                JOptionPane.showMessageDialog(new JFrame("Autocarro mais requisitado"),
                        "O autocarro mais requisitado é o autocarro referente à matrícula: \n %s ".formatted(autocarrosMaisUtilizadosStats));
            }
        });


        clienteMViagens = new JButton("Cliente com mais reservas");
        clienteMViagens.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 1;
        c11.gridy = 5;
        panel7.add(clienteMViagens, c11);

        clienteMViagens.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //   clienteMaxReservas=null;

                List<Utilizador> clienteMaxReservas = empresa.clienteComMaisReservasStats();
                JOptionPane.showMessageDialog(new JFrame("Cliente com mais reservas"),
                        "O cliente com mais reservas é: \n %s ".formatted(clienteMaxReservas));
            }
        });


        listaBusReservado = new JButton("Lista de autocarros reservados para um dado mês");
        listaBusReservado.setFont(new Font("Arial", 1, 12));
        c11.insets = new Insets(20, 20, 0, 0);
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.gridx = 3;
        c11.gridy = 1;
        panel7.add(listaBusReservado, c11);
        listaBusReservado.addActionListener(new GerirActionListener(4, janela));


        listaReservaCanc = new JButton("Lista de reservas canceladas para um dado mês");
        listaReservaCanc.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.insets = new Insets(20, 20, 0, 0);
        c11.gridx = 3;
        c11.gridy = 2;
        panel7.add(listaReservaCanc, c11);
        listaReservaCanc.addActionListener(new GerirActionListener(9, janela));

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
        volumeReservaMensal.addActionListener(new GerirActionListener(5, janela));

        diaAnoMReserva = new JButton("Dia do ano com mais reservas");
        diaAnoMReserva.setFont(new Font("Arial", 1, 12));
        c11.fill = GridBagConstraints.HORIZONTAL;
        c11.insets = new Insets(20, 20, 0, 0);
        c11.gridx = 3;
        c11.gridy = 5;
        panel7.add(diaAnoMReserva, c11);
        diaAnoMReserva.addActionListener(new GerirActionListener(6, janela));

        panel8 = new JPanel();
        painelAd.addTab("Alterar Palavra-Passe", panel8);
        panel8.setLayout(new GridBagLayout());
        GridBagConstraints c12 = new GridBagConstraints();

        inserirDados12 = new JLabel("Insira os dados pedidos para alterar a palavra-passe:");
        inserirDados12.setFont(new Font("Arial", 1, 12));
        // c12.insets = new Insets(20, 0, 0, 0);
        c12.gridx = 0;
        c12.gridy = 0;
        c12.gridwidth = 2;
        panel8.add(inserirDados12, c12);

        palavraPasse = new JLabel("Palavra-passe antiga");
        palavraPasse.setFont(new Font("Arial", 1, 12));
        c12.gridx = 1;
        c12.gridy = 1;

        panel8.add(palavraPasse, c12);
        passwordF = new JPasswordField(25);
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 1;
        panel8.add(passwordF, c12);

        passwordNova1L = new JLabel("Insira nova palavra-passe");
        passwordNova1L.setFont(new Font("Arial", 1, 12));
        c12.gridx = 1;
        c12.gridy = 2;
        panel8.add(passwordNova1L, c12);

        passwordNova1 = new JPasswordField(25);
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 2;
        panel8.add(passwordNova1, c12);

        passwordNova2L = new JLabel("Insira novamente a nova palavra-passe");
        passwordNova2L.setFont(new Font("Arial", 1, 12));
        c12.gridx = 1;
        c12.gridy = 3;
        panel8.add(passwordNova2L, c12);

        passwordNova2 = new JPasswordField(25);
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 3;
        panel8.add(passwordNova2, c12);

        guardarRegisto12 = new JButton("Guardar alterações");
        c12.insets = new Insets(10, 10, 0, 0);
        c12.gridx = 2;
        c12.gridy = 5;
        panel8.add(guardarRegisto12, c12);
        guardarRegisto12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palavraPasse = String.valueOf(passwordF.getPassword());
                String passwordNova1L = String.valueOf(passwordNova1.getPassword());
                String passwordNova2L = String.valueOf(passwordNova2.getPassword());

                if (empresa.validarDados(palavraPasse) && empresa.validarDados(passwordNova1L) && empresa.validarDados(passwordNova2L)) {
                    int resultado12 = empresa.alterarPassword(palavraPasse, passwordNova1L, passwordNova2L);

                    if (resultado12 == 5) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"), "A sua password foi alterada com sucesso");
                        passwordF.setText("");
                        passwordNova1.setText("");
                        passwordNova2.setText("");
                        janela.mudaEcra("Login");
                    } else if (resultado12 == 1) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password antiga está incorreta. Por favor, tente novamente.");
                    } else if (resultado12 == 2) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password nova e a password de confirmação não são iguais. Por favor, tente novamente.");
                    } else if (resultado12 == 3) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password nova não pode ser igual à password antiga. Por favor, escolha uma password diferente.");
                    }

                } else {
                    JOptionPane.showMessageDialog(new JFrame("Insucesso"), "Preencha os campos vazios");
                }
            }
        });

        c.gridx = 1;
        c.gridy = 1;
        this.add(painelAd, c);  //Adicionar o componente Tabbed Pane ao painel PainelAd

        welcome = new JLabel("Bem-vindo à sua área de administrador ");
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


}