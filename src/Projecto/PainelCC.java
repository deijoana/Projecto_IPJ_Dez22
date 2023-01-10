package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Classe que define o painel de pagamento por cartão de crédito ao subscrever Premium
 *
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PainelCC extends JPanel {
    Empresa empresa;
    GUI janela;

    JLabel inserirDados, numCC, nomeCC, dataExpiracaoCC, cvc;
    JButton voltar, confirmar;
    JTextField numCCT, nomeCCT, dataExpiracaoCCT, cvcT;


    /**
     * @param janela
     * @param empresa
     */
    PainelCC(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inserirDados = new JLabel("Indique os seguintes dados do seu cartão de crédito para confirmar o pagamento da subscrição PREMIUM:");
        inserirDados.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(10, 0, 0, 0);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        this.add(inserirDados, c);

        numCC = new JLabel("Número do cartão de crédito");
        numCC.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 1;
        this.add(numCC, c);

        numCCT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 1;
        this.add(numCCT, c);

        nomeCC = new JLabel("Nome associado ao cartão de crédito");
        nomeCC.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 2;
        this.add(nomeCC, c);

        nomeCCT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 2;
        this.add(nomeCCT, c);

        dataExpiracaoCC = new JLabel("Data de validade do cartão de  crédito");
        dataExpiracaoCC.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 3;
        this.add(dataExpiracaoCC, c);

        dataExpiracaoCCT = new JTextField("aaaa-mm-dd", 50);
        c.gridx = 2;
        c.gridy = 3;
        this.add(dataExpiracaoCCT, c);
        dataExpiracaoCCT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dataExpiracaoCCT.setText("aaaa-mm-dd");
            }
        });


        cvc = new JLabel("CVC - código de segurança do cartao de crédito");
        cvc.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 4;
        this.add(cvc, c);

        cvcT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 4;
        this.add(cvcT, c);

        confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(20, 0, 0, 0);
        c.gridx = 2;
        c.gridy = 6;
        this.add(confirmar, c);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String numCC = numCCT.getText();
                String nomeCC = nomeCCT.getText();
                String dataExpiracaoCC = dataExpiracaoCCT.getText();
                String cvc = cvcT.getText();

                Cliente client = (Cliente) empresa.getLoggeduser();

                if (empresa.validarDados(nomeCC) && empresa.validarCVC(cvc) && empresa.validarnumCC(numCC) && empresa.validarLocalDate(dataExpiracaoCC)) {
                    client.setTipoSubscricao(TipoSubscricao.PREMIUM);
                    client.setModoPagamento("Cartão de Crédito");
                    JOptionPane.showMessageDialog(new JFrame("sucesso"), "Subscreveu o plano Premium com sucesso. O valor da mensalidade (10€) será debitado da conta associada ao cartão de crédito inserido");
                    empresa.escreveFicheiro();
                    janela.mudaEcra("PainelCliente");
                    numCCT.setText("");
                    nomeCCT.setText("");
                    dataExpiracaoCCT.setText("aaaa-mm-dd");
                    cvcT.setText("");

                } else if (!empresa.validarDados(nomeCC))
                    JOptionPane.showMessageDialog(new JFrame("insucesso"), "Insira um nome válido para concluir a subscrição do plano Premium");
                else if (!empresa.validarCVC(cvc))
                    JOptionPane.showMessageDialog(new JFrame("insucesso"), "Insira um CVC válido para concluir a subscrição do plano Premium");
                else if (!empresa.validarnumCC(numCC))
                    JOptionPane.showMessageDialog(new JFrame("insucesso"), "Insira um número de cartão de crédito válido para concluir a subscrição do plano Premium");
                else
                    JOptionPane.showMessageDialog(new JFrame("insucesso"), "Insira uma data válida (aaaa-mm-dd) para concluir a subscrição do plano Premium");
            }
        });

        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", 1, 10));
        c.insets = new Insets(0, 20, 0, 0);
        c.gridx = 4;
        c.gridy = 0;
        this.add(voltar, c);
        voltar.addActionListener(new GerirActionListener(8, janela));
    }

}
