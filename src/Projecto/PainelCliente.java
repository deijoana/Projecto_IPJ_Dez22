package Projecto;


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

/**
 * Classe que define o painel de cliente
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */


public class PainelCliente extends JPanel {

    Empresa empresa;
    GUI janela;
    final JLabel welcome = new JLabel("");
    JTabbedPane painelCl;
    JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
    JButton logout, pesquisar, guardarAlt, alterarSubs, cancelarReserva, calcularCustoReserva;
    JLabel inserirDados, dataPartida, dataRegresso, origem, destino, n_Passageiros, distPrevista, modoPagamentoL, inserirDados8;
    JLabel inserirDadosAltPass, inserirDados3, passAntiga, passNova, passNova2, inserirDados2, idReserva;
    JTextField idReservaT, dataPartidaT, dataRegressoT, origemT, destinoT, n_PassageirosT, distPrevistaT;
    JPasswordField passAntigaT, passNovaT, passNova2T;
    JComboBox modoPagamentoC;

    final JList<String> listagemReservas = new JList<>();
    final JList<ReservaDetails> listagemHistoricoReservas = new JList<>();

    private final JList<String> listagemNotificacoes = new JList<>();


    /**
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

        inserirDados = new JLabel("Indique os seguintes dados para verificar a disponiblidade dos nossos servi??os:");
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


        dataPartidaT = new JTextField("aaaa-mm-dd", 20);
        c1.insets = new Insets(30, 0, 0, 0);
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
        c1.insets = new Insets(30, 0, 0, 0);
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

        n_Passageiros = new JLabel("N??mero de passageiros");
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

        distPrevista = new JLabel("Dist??ncia prevista (km)");
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

        String dados[] = {"", "Paypal", "Cart??o de Cr??dito", "Multibanco"};
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

                java.util.List<String> validationError = validateNovaReservaInputFields();
                if (!validationError.isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame("Dados incorrectos"), String.join("\n", validationError));
                    return;
                }

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
                    dataPartidaT.setText("aaaa-mm-dd");
                    dataRegressoT.setText("aaaa-mm-dd");
                    origemT.setText("");
                    destinoT.setText("");
                    n_PassageirosT.setText("");
                    distPrevistaT.setText("");
                    modoPagamentoC.setSelectedIndex(0);

                } else
                    JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Seleccione uma das op????es dispon??veis para o modo de pagamento");


            }
        });


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

                    double custo = empresa.calcularCustoViagem(n_Passageiros, distanciaPrevista);

                    JOptionPane.showMessageDialog(new JFrame("Simula????o de pre??o"),
                            "Para os dados inseridos o custo da sua viagem ser?? de: " + custo + "???");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Reserva inv??lida"), ex.getMessage());
                }

            }
        });


        panel2 = new JPanel();
        painelCl.addTab("Consultar Hist??rico", panel2);
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c2 = new GridBagConstraints();

        inserirDados2 = new JLabel("Hist??rico das suas reservas");
        inserirDados2.setFont(new Font("Arial", 1, 12));
        c2.gridx = 0;
        c2.gridy = 0;
        panel2.add(inserirDados2, c2);

        c2.gridx = 1;
        c2.gridy = 1;
        panel2.add(listagemHistoricoReservas, c2);

        panel3 = new JPanel();
        painelCl.addTab("Consultar Reservas", panel3);


       // listagemReservas = new JList<String>(new Vector<String>(empresa.listaReservasCliente()));
        painelCl.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                listagemReservas.setListData(new Vector<>(empresa.listaReservasCliente()));
                listagemHistoricoReservas.setListData(getReservaHistoricoDetails().toArray(new ReservaDetails[0]));
                listagemNotificacoes.setListData(new Vector<String>(empresa.listaNotificacoes()));
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
                        Reembolso reembolso = empresa.cancelarReservaFromView(text.trim(), LocalDate.now());
                        JOptionPane.showMessageDialog(panel4,
                                "Reserva cancelada '%s', com sucesso! \n Tem direito a %s ??? de reembolso".formatted(text, reembolso),
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
                            "Por favor insira um id de reserva v??lido!",
                            "Aviso", JOptionPane.WARNING_MESSAGE);

                }

            }
        });
        panel4.add(cancelarReserva, c4);


        panel5 = new JPanel();
        painelCl.addTab("Alterar Subscri????o", panel5);
        panel5.setLayout(new GridBagLayout());
        GridBagConstraints c7 = new GridBagConstraints();

        alterarSubs = new JButton("Quero alterar a minha subscri????o");
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

        panel7 = new JPanel();
        painelCl.addTab("Notifica????es", panel7);
        panel7.setLayout(new GridBagLayout());
        GridBagConstraints c8 = new GridBagConstraints();

        inserirDados8 = new JLabel("Aqui encontra as suas notifica????es:");
        inserirDados8.setFont(new Font("Arial", 1, 14));
        c8.insets = new Insets(0, 0, 20, 0);
        c8.gridx = 1;
        c8.gridy = 1;
        panel7.add(inserirDados8, c8);

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

        guardarAlt = new JButton("Guardar altera????es");
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


                if (empresa.validarDados(passAntiga) && empresa.validarDados(passNova) && empresa.validarDados(passNova2)) {

                    int resultado = empresa.alterarPassword(passAntiga, passNova, passNova2);

                    if (resultado == 5) {
                        JOptionPane.showMessageDialog(new JFrame("Sucesso"), "A sua password foi alterada com sucesso");
                        passAntigaT.setText("");
                        passNovaT.setText("");
                        passNova2T.setText("");
                        janela.mudaEcra("Login");
                    } else if (resultado == 1) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password antiga est?? incorreta. Por favor, tente novamente.");
                    } else if (resultado == 2) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password nova e a password de confirma????o n??o s??o iguais. Por favor, tente novamente.");
                    } else if (resultado == 3) {
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"),
                                "A password nova n??o pode ser igual ?? password antiga. Por favor, escolha uma password diferente.");
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

        painelCl.setSelectedIndex(6);
    }

    /**
     * M??todo que valida os dados inseridos nas JTextField da tab de "Fazer reserva de autocarro"
     *
     * @return lista de strings
     */
    private List<String> validateNovaReservaInputFields() {
        java.util.List<String> validationError = new ArrayList<>();
        if (dataPartidaT.getText() == null || dataPartidaT.getText().isBlank() ||
                !dataPartidaT.getText().trim().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            validationError.add("Data de partida n??o pode ser vazia e tem de estar no formato 'YYYY-MM-DD'");
        }
        if (dataRegressoT.getText() == null || dataRegressoT.getText().isBlank() ||
                !dataRegressoT.getText().trim().matches("^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$")) {
            validationError.add("Data de regresso n??o pode ser vazia e tem de estar no formato 'YYYY-MM-DD'");
        }
        if (origemT.getText() == null || origemT.getText().isBlank()) {
            validationError.add("Origem n??o pode ser vazia");
        }
        if (destinoT.getText() == null || destinoT.getText().isBlank())
            validationError.add("Destino n??o pode ser vazia");
        if (distPrevistaT.getText() == null || distPrevistaT.getText().isBlank())
            validationError.add("Dist??ncia n??o pode ser vazia");
        if (n_PassageirosT.getText() == null || n_PassageirosT.getText().isBlank())
            validationError.add("N??mero de passageiros n??o pode ser vazia");

        return validationError;
    }

    /**
     * M??todo respons??vel por actualizar a informa????o do painel sempre que volta a estar vis??vel, permitindo mostrar o nome do utilizador
     */
    public void refresh() {
        welcome.setText("Bem-vindo ?? sua ??rea de cliente: " + empresa.getLoggeduser().getNome());

        listagemNotificacoes.setListData(empresa.listaNotificacoes().toArray(new String[0]));
        listagemReservas.setListData(empresa.listaReservasCliente().toArray(new String[0]));
        List<ReservaDetails> reservaDetails = getReservaHistoricoDetails();
        listagemHistoricoReservas.setListData(reservaDetails.toArray(new ReservaDetails[0]));
        listagemHistoricoReservas.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> new ReservaJListItem(value));


        //  listagemReservas.setListData((String[]) empresa.listaReservasCliente().<String>toArray());
    }

    private List<ReservaDetails> getReservaHistoricoDetails() {
        List<ReservaDetails> reservaCancelada = empresa.listagemHistoricoReservasCanceladas().stream().map(it -> new ReservaDetails(it, ReservaDetails.Tipo.C)).toList();
        List<ReservaDetails> reservas = empresa.listagemHistoricoReservas().stream().map(it -> new ReservaDetails(it, ReservaDetails.Tipo.E)).toList();
        List<ReservaDetails> reservaDetails = Stream.concat(reservas.stream(), reservaCancelada.stream())
                .sorted(Comparator.comparing(it -> it.reserva.getDataPartida())).toList();
        return reservaDetails;
    }
}

class ReservaDetails {
    final Reserva reserva;
    final Tipo tipo;

    ReservaDetails(Reserva reserva, Tipo tipo) {
        this.reserva = reserva;
        this.tipo = tipo;
    }

    enum Tipo {
        C("Cancelada", Color.orange),
        E("Efectuada", Color.green);

        final String label;
        final Color color;

        Tipo(String label, Color color) {
            this.label = label;
            this.color = color;
        }
    }
}

class ReservaJListItem extends JPanel {

    private final JLabel lbName = new JLabel();
    private final JLabel lbEstado = new JLabel();

    public ReservaJListItem(ReservaDetails reservaDetails) {
        setLayout(new BorderLayout(5, 5));

        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(lbName);
        panelText.add(lbEstado);
        add(panelText, BorderLayout.CENTER);

        lbName.setText(reservaDetails.reserva.toString());
        lbEstado.setText("Estado: " + reservaDetails.tipo.label);


        panelText.setForeground(reservaDetails.tipo.color);
        panelText.setBackground(reservaDetails.tipo.color);
        setBackground(reservaDetails.tipo.color);
        setForeground(reservaDetails.tipo.color);
    }
}
