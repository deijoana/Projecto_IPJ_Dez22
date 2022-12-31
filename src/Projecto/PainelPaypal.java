package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelPaypal extends JPanel {
    Empresa empresa;
    GUI janela;

    JLabel inserirDados, email, palavraPasse;
    JButton voltar, confirmar;
    JTextField emailT;
    JPasswordField passwordF;

    PainelPaypal(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inserirDados = new JLabel("Indique os seguintes dados da sua conta PayPal para confirmar o pagamento da subscrição PREMIUM:");
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
                Cliente client = (Cliente) empresa.getLoggeduser();

                if (empresa.validarEmail(email, empresa) && empresa.validarDados(password, empresa)) {
                    client.setTipoSubscricao(TipoSubscricao.PREMIUM);
                    client.setModoPagamento("Paypal");
                    JOptionPane.showMessageDialog(new JFrame("sucesso"), "Subscreveu o plano Premium com sucesso. O valor da mensalidade (10€) será debitado da sua conta PayPal");

                    emailT.setText("");
                    passwordF.setText("");

                    janela.mudaEcra("PainelCliente");
                } else
                    JOptionPane.showMessageDialog(new JFrame("insucesso"), "Insira um email e/ou password válidos para concluir a subscrição do plano Premium");
            }
        });

        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", 1, 10));
        c.insets = new Insets(0, 20, 0, 0);
        c.gridx = 4;
        c.gridy = 0;
        this.add(voltar, c);
        voltar.addActionListener(new GerirEventos(8, janela));
    }

}
