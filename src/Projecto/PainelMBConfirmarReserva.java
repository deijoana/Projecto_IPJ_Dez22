package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class PainelMBConfirmarReserva extends JPanel {

    Empresa empresa;
    GUI janela;

    private static final String numEntidade = "11100";
    private int numReferencia;
    JLabel inserirDados, entidade, entidadeL, referencia, referenciaL;

    JButton voltar, confirmar;

    PainelMBConfirmarReserva(GUI janela, Empresa empresa, String dataPartidaT, String dataRegressoT, String origemT, String destinoT, String n_PassageirosT, String distPrevistaT) {

        numReferencia = (int) (111111111 + Math.random() * ((999999999 - 111111111) + 1));

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

        entidade = new JLabel("Entidade");
        entidade.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 1;
        this.add(entidade, c);

        entidadeL = new JLabel(numEntidade);
        entidadeL.setFont(new Font("Arial", 1, 14));
        c.gridx = 2;
        c.gridy = 1;
        this.add(entidadeL, c);

        referencia = new JLabel("Referência");
        referencia.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 2;
        this.add(referencia, c);

        referenciaL = new JLabel(String.valueOf(numReferencia));
        referenciaL.setFont(new Font("Arial", 1, 14));
        c.gridx = 2;
        c.gridy = 2;
        this.add(referenciaL, c);

        confirmar = new JButton("Confirmar");
        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 4;
        this.add(confirmar, c);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Cliente clienteO = (Cliente) empresa.getLoggeduser();
                    Reserva r = empresa.fazerReserva(clienteO, LocalDate.parse(dataPartidaT), LocalDate.parse(dataRegressoT),
                            Integer.valueOf(n_PassageirosT), origemT, destinoT, Double.valueOf(distPrevistaT));

                    JOptionPane.showMessageDialog(new JFrame("Reserva confirmada"),
                            "Reserva confirmada. O autocarro disponível é " + r.getBus());


                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame("Reserva inválida"), ex.getMessage());
                }
            }
        });

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janela.mudaEcra("PainelCliente");
            }
        });


        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", 1, 10));
        c.insets = new Insets(0, 20, 0, 0);
        c.gridx = 4;
        c.gridy = 0;
        this.add(voltar, c);
        voltar.addActionListener(new GerirEventos(7, janela));


    }
}
