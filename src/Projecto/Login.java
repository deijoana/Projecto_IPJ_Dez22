package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {

    Empresa empresa;

    JLabel welcome, pagInicial, iniciarSessao, email, palavraPasse;

    JTextField emailT;
    JPasswordField passwordF;
    JButton criarRegisto, entrar;
    GUI janela;


    Login(GUI janela, Empresa empresa) {
        this.empresa = empresa;

        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        welcome = new JLabel("Bem-vindo a AoR Autocarros");
        welcome.setFont(new Font("Arial", 1, 25));
        c.ipady = 40;
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 2;
        this.add(welcome, c);

        pagInicial = new JLabel("Página inicial");
        pagInicial.setFont(new Font("Arial", 1, 10));
        c.gridx = 5;
        c.gridy = 0;
        this.add(pagInicial, c);

        iniciarSessao = new JLabel("Iniciar sessão");
        iniciarSessao.setFont(new Font("Arial", 1, 15));
        c.gridx = 0;
        c.gridy = 3;
        this.add(iniciarSessao, c);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(0, 0, 0, 10);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 4;
        this.add(email, c);

        palavraPasse = new JLabel("Palavra-passe");
        palavraPasse.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(10, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 5;
        this.add(palavraPasse, c);

        emailT = new JTextField(50);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 4;
        this.add(emailT, c);

        passwordF = new JPasswordField(50);
        c.insets = new Insets(10, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 5;
        this.add(passwordF, c);

        entrar = new JButton("Entrar");
        c.insets = new Insets(10, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 7;
        this.add(entrar, c);
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailT.getText();
                String password = String.valueOf(passwordF.getPassword());

                Utilizador loggado = empresa.login(email, password);

                if (loggado == null) {
                    emailT.setText("");
                    passwordF.setText("");
                    JOptionPane.showMessageDialog(new JFrame("Autenticação inválida"), "Autenticação inválida. Verifique se os dados estão corretos.");
                }

                if (loggado instanceof Administrador) {
                    JOptionPane.showMessageDialog(new JFrame("Administrador loggado"), loggado.nome + " autenticado com sucesso");
                    emailT.setText("");
                    passwordF.setText("");
                    janela.mudaEcra("PainelAdmin");
                } else if (loggado instanceof Cliente) {
                    emailT.setText("");
                    passwordF.setText("");
                    JOptionPane.showMessageDialog(new JFrame("Cliente loggado"), loggado.nome + " autenticado com sucesso");
                    janela.mudaEcra("PainelCliente");
                }
            }
        });

        criarRegisto = new JButton("Criar Registo");
        c.insets = new Insets(40, 0, 0, 0);
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 9;
        this.add(criarRegisto, c);

        criarRegisto.addActionListener(new GerirEventos(1, this.janela));

    }
}