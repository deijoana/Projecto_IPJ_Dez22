package Projecto;

import javax.swing.*;
import java.awt.*;

public class PainelLogin extends JPanel {

    JLabel welcome, pagInicial, iniciarSessao, email, palavraPasse;

    PainelLogin(){
        setLayout(new BorderLayout());
        setBackground(Color.white);

        welcome = new JLabel("Bem-vindo a AoR-Autocarros");
        welcome.setFont(new Font("Arial", 1, 20));
        this.add(welcome, "Center");

        pagInicial = new JLabel("Página Inicial");
        pagInicial.setFont(new Font("Arial", 1, 8));
        this.add(pagInicial, "North");

        iniciarSessao = new JLabel("Inicie a sua  sessão:");
        iniciarSessao.setFont(new Font ("Arial", 1, 10));
        this.add(iniciarSessao);

        email = new JLabel("Email");
        email.setFont(new Font("Arial", 1, 10));
        this.add(email);

        palavraPasse = new JLabel("Palavra-Passe:");
        palavraPasse.setFont(new Font("Arial", 1, 10));
        this.add(palavraPasse, "South");


    }

}

