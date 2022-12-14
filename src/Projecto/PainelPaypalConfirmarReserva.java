package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Classe que define o painel de pagamento por Paypal ao fazer uma reserva
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PainelPaypalConfirmarReserva extends JPanel {
    Empresa empresa;
    GUI janela;
    private String dataPartida, dataRegresso, origem, destino, n_Passageiros, distPrevista;
    JLabel inserirDados, email, palavraPasse;
    JButton voltar, confirmar, preReserva;
    JTextField emailT;
    JPasswordField passwordF;

    PainelPaypalConfirmarReserva(GUI janela, Empresa empresa, String dataPartida, String dataRegresso, String origem, String destino, String n_Passageiros, String distPrevista) {

        this.dataPartida = dataPartida;
        this.dataRegresso = dataRegresso;
        this.origem = origem;
        this.destino = destino;
        this.n_Passageiros = n_Passageiros;
        this.distPrevista = distPrevista;

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inserirDados = new JLabel("Use os seguintes dados para pagar a sua reserva. Carregue em confirmar depois de concluir o pagamento:");
        inserirDados.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(10, 0, 0, 0);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        this.add(inserirDados, c);

        email = new JLabel("Email da conta PayPal");
        email.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 1;
        this.add(email, c);

        emailT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 1;
        this.add(emailT, c);

        palavraPasse = new JLabel("Palavra Passe da conta PayPal");
        palavraPasse.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 2;
        this.add(palavraPasse, c);

        passwordF = new JPasswordField(50);
        c.gridx = 2;
        c.gridy = 2;
        this.add(passwordF, c);

        confirmar = new JButton("Confirmar");
        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 4;
        this.add(confirmar, c);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailT.getText();
                String password = String.valueOf(passwordF.getPassword());

                if (empresa.validarEmail(email) && empresa.validarDados(password)) {
                    try {
                        Cliente clienteO = (Cliente) empresa.getLoggeduser();
                        Pagamento pagamentoPaypal = new PayPal(LocalDate.now(), email, password);
                        Reserva r = empresa.fazerReserva(clienteO, LocalDate.parse(dataPartida), LocalDate.parse(dataRegresso),
                                Integer.valueOf(n_Passageiros), origem, destino, Double.valueOf(distPrevista), pagamentoPaypal);

                        JOptionPane.showMessageDialog(new JFrame("Reserva confirmada"),
                                "Reserva confirmada. O autocarro dispon??vel ?? " + r.getBus());

                        emailT.setText("");
                        passwordF.setText("");

                        janela.mudaEcra("PainelCliente");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame("Reserva inv??lida"), ex.getMessage());
                    }
                } else
                    JOptionPane.showMessageDialog(new JFrame("insucesso"), "Insira um email e/ou password v??lidos para concluir a reserva");
            }
        });

        preReserva = new JButton("Fazer Pr??-reserva");
        preReserva.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 4;
        this.add(preReserva, c);
        preReserva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Cliente clienteO = (Cliente) empresa.getLoggeduser();
                    PreReserva p = empresa.fazerPreReserva(clienteO, LocalDate.parse(dataPartida), LocalDate.parse(dataRegresso),
                            Integer.valueOf(n_Passageiros));
                    JOptionPane.showMessageDialog(new JFrame("Pr??-reserva confirmada"),
                            "Pr??-reserva confirmada. Se surgir alguma desist??ncia ser?? notificado(a) e poder?? confirmar a reserva");
                    janela.mudaEcra("PainelCliente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Pr??-reserva inv??lida"), ex.getMessage());
                }

            }
        });


        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", 1, 10));
        c.insets = new Insets(0, 20, 0, 0);
        c.gridx = 4;
        c.gridy = 0;
        this.add(voltar, c);
        voltar.addActionListener(new GerirActionListener(7, janela));
    }

}
