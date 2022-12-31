package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelPremium extends JPanel {

    Empresa empresa;
    GUI janela;

    JTextArea condicoesGerais;

    JButton confirmar, voltar;
    JComboBox modoPagamento;

    PainelPremium(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        String texto = "Neste momento tem um plano PREMIUM de subscrição. Ao cancelar e voltar ao plano normal deixa de ter acesso a vários privilégios: \n - poder cancelar as suas reservas sem qualquer custo até 2 dias consecutivos antes da data de partida da reserva\n - ter prioridade no momento da reserva \n - ao cancelar uma reserva terá sempre uma penalização: 50% se cancelar até 7 dias consecutivos antes da data de partida ou sem direito a reembolso se cancelar a 6 dias ou menos da data de partida \n\n Ao cancelar não tem direito a devolução de dinheiro";
        condicoesGerais = new JTextArea(texto);
        condicoesGerais.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 1;
        this.add(condicoesGerais, c);

        confirmar = new JButton("Cancelar PREMIUM");
        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 3;
        this.add(confirmar, c);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Cliente client = (Cliente) empresa.getLoggeduser();
                client.setTipoSubscricao(TipoSubscricao.NORMAL);
                client.setModoPagamento("");
                JOptionPane.showMessageDialog(new JFrame("Sucesso"), "A sua subscrição Premium está cancelada. Para voltar a aceder aos benefícios pode voltar a subscrever o plano PREMIUM a qualquer momento");
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
