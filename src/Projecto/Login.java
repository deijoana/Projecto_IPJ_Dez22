package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener{

    JLabel welcome, pagInicial, iniciarSessao, email, palavraPasse;
    JTextField emailt;
    JPasswordField passwordF;
    JButton criarRegisto, entrar;

    GUI janela;

    //final static boolean shouldFill = true;


    Login(GUI janela){
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        welcome = new JLabel("Bem-vindo a AoR Autocarros");
        welcome.setFont(new Font("Arial", 1, 20));
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 2;
        this.add(welcome, c);


        pagInicial = new JLabel("Página inicial");
        pagInicial.setFont(new Font("Arial", 1, 10));
        //c.fill = GridBagConstraints.HORIZONTAL;
        //c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 4;
        c.gridy = 0;
        this.add(pagInicial, c);

        iniciarSessao = new JLabel("Iniciar sessão");
        iniciarSessao.setFont(new Font("Arial", 1, 12));
        c.gridx = 0;
        c.gridy = 2;
        this.add(iniciarSessao, c);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 14));
        c.gridx = 2;
        c.gridy = 3;
        this.add(email, c);

        palavraPasse = new JLabel("Palavra-passe");
        palavraPasse.setFont(new Font("Arial", 1,14));
        c.gridx = 2;
        c.gridy = 4;
        this.add(palavraPasse, c);

        emailt = new JTextField(50);
        c.gridx = 3;
        c.gridy = 3;
        //emailt.setColumns(50);
        this.add(emailt, c);

        passwordF = new JPasswordField(50);
        c.gridx = 3;
        c.gridy = 4;
        this.add(passwordF, c);

        criarRegisto = new JButton("Criar Registo");
        c.gridx = 3;
        c.gridy = 7;
        this.add(criarRegisto, c);

        entrar = new JButton("Entrar");
        c.gridx = 3;
        c.gridy = 5;
        this.add(entrar, c);

        entrar.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        janela.mudaEcra("Painel");

    }
}