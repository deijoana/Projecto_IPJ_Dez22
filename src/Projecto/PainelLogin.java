package Projecto;

import javax.swing.*;
import java.awt.*;

public class PainelLogin extends JPanel {

    JLabel welcome, pagInicial, iniciarSessao, email, palavraPasse;
    protected JPanel p;

    PainelLogin(){
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);

        p = new JPanel();
        p.setLayout(new BorderLayout());

        pagInicial = new JLabel("Página Inicial", JLabel.RIGHT);
        pagInicial.setFont(new Font("Arial", 1, 12));
        p.add(pagInicial,"North");

        welcome = new JLabel("Bem-vindo a AoR-Autocarros", JLabel.CENTER);
        welcome.setFont(new Font("Arial", 1, 30));
        p.add(welcome,"South");

        iniciarSessao = new JLabel("Inicie a sua  sessão:", JLabel.LEFT);
        iniciarSessao.setFont(new Font ("Arial", 1, 10));
        this.add(iniciarSessao,"South");

        this.add(p,"North");
        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 10));
        this.add(email,"Center");

        palavraPasse = new JLabel("Palavra-Passe:");
        palavraPasse.setFont(new Font("Arial", 1, 10));
        this.add(palavraPasse, "South");

    }

}

