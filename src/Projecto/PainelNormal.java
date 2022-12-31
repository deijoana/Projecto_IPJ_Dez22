package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelNormal extends JPanel {

    Empresa empresa;
    GUI janela;

    JTextArea condicoesGerais;

    JButton confirmar, voltar;
    JComboBox modoPagamento;

    PainelNormal(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        String texto = "Neste momento tem um plano NORMAL de subscrição. Ao subscrever o plano PREMIUM tem acesso a vários privilégios: \n\n - pode cancelar as suas reservas sem qualquer custo até 2 dias consecutivos antes da data de partida da reserva\n\n - tem prioridade no momento da reserva \n\n A subscrição Premium tem um custo mensal de 10€, podendo escolher o modo de pagamento que melhor se adequa às suas preferências.\n\n Pode cancelar a subscrição a qualquer momento. ";
        condicoesGerais = new JTextArea(texto);
        condicoesGerais.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 1;
        this.add(condicoesGerais, c);

        String dados[] = {"", "Paypal", "Cartão de Crédito", "Multibanco"};
        modoPagamento = new JComboBox<>(dados);
        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        this.add(modoPagamento, c);

        confirmar = new JButton("Subscrever PREMIUM");
        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 3;
        this.add(confirmar, c);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String modoPagam = modoPagamento.getSelectedItem().toString();
                int indiceSubscricao = modoPagamento.getSelectedIndex();

                if (empresa.validarComboBoxIndex(indiceSubscricao, empresa) == 1) {

                    switch (indiceSubscricao) {
                        case 1:
                            janela.mudaEcra("PainelPaypal");
                            break;
                        case 2:
                            janela.mudaEcra("PainelCC");
                            break;
                        case 3:
                            janela.mudaEcra("PainelMB");
                            break;
                    }
                } else
                JOptionPane.showMessageDialog(new JFrame("Falta dados"), "Seleccione uma das opções disponíveis para o modo de pagamento");

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
