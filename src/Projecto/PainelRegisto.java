package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelRegisto extends JPanel {
    Empresa empresa;
    JLabel inserirDados, nome, nif, morada, telefone, email, palavraPasse, tipoSubscricaoL, pagamentoSubscricaoL;
    JTextField nomeT, nifT, moradaT, telefoneT, emailT;
    JPasswordField passwordF;
    JComboBox tipoSubscricaoB, pagamentoSubscricaoB;
    JButton pagInicial,guardarRegisto;

    GUI janela;

    PainelRegisto(GUI janela, Empresa empresa) {
        this.empresa = empresa;

        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        pagInicial = new JButton("Página Inicial");
        pagInicial.setFont(new Font("Arial", 1, 10));
        c.gridx = 10;
        c.gridy = 0;
        this.add(pagInicial, c);
        pagInicial.addActionListener(new GerirEventos(2, this.janela));

        inserirDados = new JLabel("Insira os seguintes dados para efectuar um novo registo:");
        inserirDados.setFont(new Font("Arial", 1, 15));
        c.insets = new Insets(15, 0, 15, 0);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        this.add(inserirDados, c);

        nome = new JLabel("Nome");
        nome.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 2;
        this.add(nome, c);

        nomeT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 2;
        this.add(nomeT, c);

        nif = new JLabel("NIF");
        nif.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 3;
        this.add(nif, c);

        nifT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 3;
        this.add(nifT, c);

        morada = new JLabel("Morada");
        morada.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 4;
        this.add(morada, c);

        moradaT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 4;
        this.add(moradaT, c);

        telefone = new JLabel("Telefone");
        telefone.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 5;
        this.add(telefone, c);

        telefoneT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 5;
        this.add(telefoneT, c);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 6;
        this.add(email, c);

        emailT = new JTextField(50);
        c.gridx = 2;
        c.gridy = 6;
        this.add(emailT, c);

        palavraPasse = new JLabel("Palavra Passe");
        palavraPasse.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 7;
        this.add(palavraPasse, c);

        passwordF = new JPasswordField(50);
        c.gridx = 2;
        c.gridy = 7;
        this.add(passwordF, c);

        tipoSubscricaoL = new JLabel("Tipo de subscrição");
        tipoSubscricaoL.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 8;
        this.add(tipoSubscricaoL, c);

        String tiposSubscricao[] = {"Normal", "Premium"};
        tipoSubscricaoB = new JComboBox<>(tiposSubscricao);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 8;
        this.add(tipoSubscricaoB, c);

        pagamentoSubscricaoL = new JLabel("Modo de pagamento da subscrição");
        pagamentoSubscricaoL.setFont(new Font("Arial", 1, 14));
        c.gridx = 1;
        c.gridy = 9;
        this.add(pagamentoSubscricaoL, c);

        String modosPagSubscricao[] = {"Paypal", "Cartão de Crédito", "Multibanco"};
        pagamentoSubscricaoB = new JComboBox<>(modosPagSubscricao);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 9;
        this.add(pagamentoSubscricaoB, c);

        guardarRegisto = new JButton("Guardar registo");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets= new Insets(40,0,0,0);
        c.gridx = 2;
        c.gridy = 11;
        this.add(guardarRegisto, c);
        guardarRegisto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String email = emailT.getText();
                String password = String.valueOf(passwordF.getPassword());
                String nome = nomeT.getText();
                String nif = nifT.getText();
                String telefone = telefoneT.getText();
                String tipoDeSubscricao = tipoSubscricaoB.getToolTipText();
                String morada = moradaT.getText();
                String modoDePagamento = pagamentoSubscricaoB.getToolTipText();


                Utilizador novoRegisto = empresa.registarCliente(email, nome, telefone, nif, morada, tipoDeSubscricao, modoDePagamento, password, empresa);

                if (empresa.validarEmail(email, empresa)) {

                    if (novoRegisto == null) {
                        JOptionPane.showMessageDialog(new JFrame("autenticação inválida"), "Autenticação inválida. Verifique se os dados estão corretos.");
                    }

                    if (novoRegisto instanceof Administrador) {
                        JOptionPane.showMessageDialog(new JFrame("Administrador loggado"), novoRegisto.nome + " autenticado com sucesso");
                        janela.mudaEcra("Login");

                    } else if (novoRegisto instanceof Cliente) {
                        JOptionPane.showMessageDialog(new JFrame("Cliente loggado"), novoRegisto.nome + " autenticado com sucesso");
                        janela.mudaEcra("Login");
                    }} else
                        JOptionPane.showMessageDialog(new JFrame("Email inválido"), "Email inválido. Verifique se os dados estão corretos.");


                    emailT.setText("");
                    passwordF.setText("");
                    nomeT.setText("");
                    nifT.setText("");
                    moradaT.setText("");
                    telefoneT.setText("");

                 }});

    }
}
