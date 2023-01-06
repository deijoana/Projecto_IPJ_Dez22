package Projecto;

import Projecto.utils.Validations;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

public class PainelCliente extends JPanel {

    Empresa empresa;

    JLabel welcome;
    JTabbedPane painelCl;

    JPanel panel1, panel2, panel3, panel4, panel5, panel6;

    JButton logout, pesquisar, guardarAlt, alterarSubs;

    GUI janela;

    JLabel inserirDados, dataPartida, dataRegresso, origem, destino, n_Passageiros, distPrevista, modoPagamentoL;


    JLabel inserirDadosAltPass, inserirDados3, passAntiga, passNova, passNova2, inserirDados2;

    JLabel idReserva;

    JTextField idReservaT, dataPartidaT, dataRegressoT, origemT, destinoT, n_PassageirosT, distPrevistaT;

    JButton cancelarReserva, calcularCustoReserva;

    JPasswordField passAntigaT, passNovaT, passNova2T;

    JComboBox modoPagamentoC;

    JList<Reserva> listagemReservas, listagemHistoricoReservas;


    /**
     *
     * @param janela
     * @param empresa
     */
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
        c1.insets = new Insets(10, 10, 0, 0);
        c1.gridx = 0;
        c1.gridy = 0;
        panel1.add(inserirDados, c1);

        dataPartida = new JLabel("Data de partida");
        dataPartida.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 1;
        panel1.add(dataPartida, c1);


        dataPartidaT = new JTextField("Formato aaaa-mm-dd", 20);
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


        dataRegressoT = new JTextField("Formato aaaa-mm-dd", 20);
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

        modoPagamentoL = new JLabel("Modo de Pagamento");
        modoPagamentoL.setFont(new Font("Arial", 1, 12));
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 0;
        c1.gridy = 7;
        panel1.add(modoPagamentoL, c1);

        String dados[] = {"", "Paypal", "Cartão de Crédito", "Multibanco"};
        modoPagamentoC = new JComboBox<>(dados);
        c1.insets = new Insets(30, 0, 0, 0);
        c1.gridx = 1;
        c1.gridy = 7;
        panel1.add(modoPagamentoC, c1);

        pesquisar = new JButton("Pagamento");
        c1.fill = GridBagConstraints.CENTER;
        c1.insets = new Insets(20, 20, 20, 20);
        c1.gridx = 1;
        c1.gridy = 9;
        panel1.add(pesquisar, c1);


        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteO = (Cliente) empresa.getLoggeduser();

                java.util.List<String> validationError = validateNovaReservaInputFields();
                if (!validationError.isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame("Dados incorrectos"), String.join("\n", validationError));
                    return;
                }

                String modoPagam = modoPagamentoC.getSelectedItem().toString();
                int indiceSubscricao = modoPagamentoC.getSelectedIndex();

                if (empresa.validarComboBoxIndex(indiceSubscricao) == 1) {

                    switch (indiceSubscricao) {
                        case 1:
                            janela.cardsPanel.add(new PainelPaypalConfirmarReserva(
                                    janela,
                                    empresa,
                                    dataPartidaT.getText(),
                                    dataRegressoT.getText(),
                                    origemT.getText(),
                                    destinoT.getText(),
                                    n_PassageirosT.getText(),
                                    distPrevistaT.getText()
                            ), "PagamentoReservaPaypal");
                            janela.mudaEcra("PagamentoReservaPaypal");
                            break;
                        case 2:
                            janela.cardsPanel.add(new PainelCCConfirmarReserva(
                                    janela,
                                    empresa,
                                    dataPartidaT.getText(),
                                    dataRegressoT.getText(),
                                    origemT.getText(),
                                    destinoT.getText(),
                                    n_PassageirosT.getText(),
                                    distPrevistaT.getText()
                            ), "PagamentoReservaCC");
                            janela.mudaEcra("PagamentoReservaCC");
                            break;
                        case 3:
                            janela.cardsPanel.add(new PainelMBConfirmarReserva(
                                    janela,
                                    empresa,
                                    dataPartidaT.getText(),
                                    dataRegressoT.getText(),
                                    origemT.getText(),
                                    destinoT.getText(),
                                    n_PassageirosT.getText(),
                                    distPrevistaT.getText()
                            ), "PagamentoReservaMultibanco");
                            janela.mudaEcra("PagamentoReservaMultibanco");
                            break;
                    }
                    dataPartidaT.setText("Formato aaaa-mm-dd");
                    dataRegressoT.setText("Formato aaaa-mm-dd");
                    origemT.setText("");
                    destinoT.setText("");
                    n_PassageirosT.setText("");
                    distPrevistaT.setText("");
                    modoPagamentoC.setSelectedIndex(0);

                } else
                    JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Seleccione uma das opções disponíveis para o modo de pagamento");



            /*    if (clienteO.getModoPagamento().equals("Paypal")) {
                    janela.mudaEcra("PainelPaypal");
                } else if (clienteO.getModoPagamento().equals("Multibanco")) {
                    janela.cardsPanel.add(new PainelMBConfirmarReserva(
                            janela,
                            empresa,
                            dataPartidaT.getText(),
                            dataRegressoT.getText(),
                            origemT.getText(),
                            destinoT.getText(),
                            n_PassageirosT.getText(),
                            distPrevistaT.getText()
                    ), "PagamentoReservaMultibanco");


                } else if (clienteO.getModoPagamento().equals("Cartao de credito")) {
                    janela.mudaEcra("PainelCC");
                } else {
                    JOptionPane.showMessageDialog(new JFrame("Método de pagamento inválido"), "Método de pagamento inválido");
                }*/

            }
        });


/*        pesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                try {
                    java.util.List<String> validationError = validateNovaReservaInputFields();
                    if (!validationError.isEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame("Dados incorrectos"), String.join("\n", validationError));
                        return;
                    }


                    LocalDate dataPartida = LocalDate.parse(dataPartidaT.getText());
                    LocalDate dataRegresso = LocalDate.parse(dataRegressoT.getText());
                    String origem = origemT.getText();
                    String destino = destinoT.getText();
                    int n_Passageiros = Integer.parseInt(n_PassageirosT.getText());
                    double distanciaPrevista = Double.parseDouble(distPrevistaT.getText());


                    Cliente clienteO = (Cliente) empresa.getLoggeduser();
                    Reserva r = empresa.fazerReserva(clienteO, dataPartida, dataRegresso, n_Passageiros, origem, destino, distanciaPrevista);

                    JOptionPane.showMessageDialog(new JFrame("Reserva confirmada"),
                            "Reserva confirmada. O autocarro disponível é " + r.getBus());

                    dataPartidaT.setText("Formato aaaa-mm-dd");
                    dataRegressoT.setText("Formato aaaa-mm-dd");
                    origemT.setText("");
                    destinoT.setText("");
                    n_PassageirosT.setText("");
                    distPrevistaT.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Reserva inválida"), ex.getMessage());
                }

            }

        });*/

        calcularCustoReserva = new JButton("Simular custo da viagem");
        c1.fill = GridBagConstraints.CENTER;
        c1.insets = new Insets(20, 0, 20, 0);
        c1.gridx = 0;
        c1.gridy = 9;
        panel1.add(calcularCustoReserva, c1);

        calcularCustoReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    java.util.List<String> validationError = validateNovaReservaInputFields();
                    if (!validationError.isEmpty()) {
                        JOptionPane.showMessageDialog(new JFrame("Dados incorrectos"), String.join("\n", validationError));
                        return;
                    }

                    int n_Passageiros = Integer.parseInt(n_PassageirosT.getText());
                    double distanciaPrevista = Double.parseDouble(distPrevistaT.getText());


                    //Cliente clienteO = (Cliente) empresa.getLoggeduser();

                    double custo = empresa.calcularCustoViagem(n_Passageiros, distanciaPrevista);

                    JOptionPane.showMessageDialog(new JFrame("Simulação de preço"),
                            "Para os dados inseridos o custo da sua viagem será de: " + custo + " €");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Reserva inválida"), ex.getMessage());
                }

            }
        });


        panel2 = new JPanel();
        painelCl.addTab("Consultar Histórico", panel2);
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        inserirDados2 = new JLabel("Histórico das suas reservas");
        inserirDados2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 0;
        c2.gridy = 0;
        panel2.add(inserirDados2, c2);

        listagemHistoricoReservas = new JList<Reserva>(new Vector<Reserva>(empresa.listagemHistoricoReservas().stream().toList()));
        c2.gridx = 1;
        c2.gridy = 1;
        panel2.add(listagemHistoricoReservas, c2);

        panel3 = new JPanel();
        painelCl.addTab("Consultar Reservas", panel3);


        listagemReservas = new JList<Reserva>(new Vector<Reserva>(empresa.listaReservasCliente()));
        painelCl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                listagemReservas.setListData(new Vector<>(empresa.listaReservasCliente()));
                listagemHistoricoReservas.setListData(new Vector<>(empresa.listagemHistoricoReservas()));
            }
        });

        panel3.setLayout(new GridBagLayout());
        GridBagConstraints c3 = new GridBagConstraints();

        inserirDados3 = new JLabel("Lista das suas reservas");
        inserirDados3.setFont(new Font("Arial", 1, 12));
        c3.insets = new Insets(0, 0, 0, 20);
        c3.gridx = 0;
        c3.gridy = 0;
        panel3.add(inserirDados3, c3);

        // listagemReservas = new JList<Reserva>(new Vector<Reserva>(empresa.listaReservasCliente(empresa)));
        c3.gridx = 1;
        c3.gridy = 1;
        panel3.add(listagemReservas, c3);


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

        c4.insets = new Insets(30, 0, 0, 0);
        c4.gridx = 1;
        c4.gridy = 5;
        cancelarReserva = new JButton("Cancelar");
        cancelarReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = idReservaT.getText();
                if (text != null && !text.trim().isBlank()) {

                    try {
                        empresa.addReservaCancelada(text);
                        Reembolso reembolso = empresa.cancelarReservaFromView(text.trim(), LocalDate.now());


                        JOptionPane.showMessageDialog(panel4,
                                "Reserva cancelada '%s', com sucesso! \n Tem direito a %s € de reembolso".formatted(text, reembolso),
                                "Success", JOptionPane.INFORMATION_MESSAGE);

                        idReservaT.setText("");
                    } catch (Exception ex) {
                        ex.printStackTrace();

                        JOptionPane.showMessageDialog(panel4,
                                ex.getMessage(),
                                "Error!!", JOptionPane.ERROR_MESSAGE);
                    }


                } else {
                    JOptionPane.showMessageDialog(panel4,
                            "Por favor insira um id de reserva valido!",
                            "Aviso", JOptionPane.WARNING_MESSAGE);

                }

            }
        });
        panel4.add(cancelarReserva, c4);


        panel5 = new JPanel();
        painelCl.addTab("Alterar Subscrição", panel5);
        panel5.setLayout(new GridBagLayout());
        GridBagConstraints c7 = new GridBagConstraints();

        alterarSubs = new JButton("Quero alterar a minha subscrição");
        c7.gridx = 1;
        c7.gridy = 1;
        c7.fill = GridBagConstraints.HORIZONTAL;
        panel5.add(alterarSubs, c7);

        alterarSubs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente client = (Cliente) empresa.getLoggeduser();

                if (client.getTipoSubscricao().equals(TipoSubscricao.NORMAL)) {
                    janela.mudaEcra("PainelNormal");
                } else janela.mudaEcra("PainelPremium");
            }
        });


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
        passAntigaT = new JPasswordField(25);
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

        passNovaT = new JPasswordField(25);
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

        passNova2T = new JPasswordField(25);
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 1;
        c6.gridy = 4;
        panel6.add(passNova2T, c6);

        guardarAlt = new JButton("Guardar alterações");
        c6.insets = new Insets(30, 0, 0, 0);
        c6.gridx = 1;
        c6.gridy = 5;
        panel6.add(guardarAlt, c6);


        guardarAlt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String passAntiga = String.valueOf(passAntigaT.getPassword());
                String passNova = String.valueOf(passNovaT.getPassword());
                String passNova2 = String.valueOf(passNova2T.getPassword());

                int resultado = empresa.alterarPassword(passAntiga, passNova, passNova2);

                if (empresa.validarDados(passAntiga) && empresa.validarDados(passNova) && empresa.validarDados(passNova2)) {

                    if (resultado == 5) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"), "A sua password foi alterada com sucesso");
                        passAntigaT.setText("");
                        passNovaT.setText("");
                        passNova2T.setText("");
                        janela.mudaEcra("Login");
                    } else if (resultado == 1) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password antiga está incorreta. Por favor, tente novamente.");
                    } else if (resultado == 2) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password nova e a password de confirmação não são iguais. Por favor, tente novamente.");
                    } else if (resultado == 3) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password nova não pode ser igual à password antiga. Por favor, escolha uma password diferente.");
                    } else if (resultado == 4) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A nova password e a confirmação da nova password não coincidem.");

                    }

                } else {
                    JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                            "Preencha os campos vazios");
                }
            }
        });


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

    private List<String> validateNovaReservaInputFields() {
        java.util.List<String> validationError = new ArrayList<>();
        if (!Validations.isValidateIsoDate(dataPartidaT.getText())) {
            validationError.add("Data de partida não pode ser vazia e tem de estar no formato 'YYYY-MM-DD'");
        }
        if (!Validations.isValidateIsoDate(dataRegressoT.getText())) {
            validationError.add("Data de regresso não pode ser vazia e tem de estar no formato 'YYYY-MM-DD'");
        }
        if (Validations.isNotBlank(origemT.getText())) {
            validationError.add("Origem não pode ser vazia");
        }
        if (destinoT.getText() == null || destinoT.getText().isBlank())
            validationError.add("Destino não pode ser vazia");
        if (distPrevistaT.getText() == null || distPrevistaT.getText().isBlank())
            validationError.add("Distância não pode ser vazia");
        if (n_PassageirosT.getText() == null || n_PassageirosT.getText().isBlank())
            validationError.add("Número de passageiros não pode ser vazia");

        return validationError;
    }

}