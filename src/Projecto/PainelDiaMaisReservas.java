package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
/**
 * Classe que define o painel para saber qual o dia de um dado ano com mais reservas
 * @author Joana Ramalho
 * @author Tiago Sousa
 */
public class PainelDiaMaisReservas extends JPanel {

    Empresa empresa;
    GUI janela;
    JLabel inserirDados, anoL, mesL;

    JTextField anoT;
    JButton voltar, confirmar;


    PainelDiaMaisReservas(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inserirDados = new JLabel("Seleccione o ano sobre o qual quer a informação estatística:");
        inserirDados.setFont(new Font("Arial", 1, 15));
        c.insets = new Insets(15, 0, 15, 0);
        c.gridx = 1;
        c.gridy = 1;
        // c.gridwidth = 2;
        this.add(inserirDados, c);

        anoL = new JLabel("Ano");
        anoL.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(30, 0, 0, 10);
        c.gridx = 2;
        c.gridy = 4;
        this.add(anoL, c);

        anoT = new JTextField("xxxx");
        anoT.setFont(new Font("Arial", 1, 14));
        c.gridx = 3;
        c.gridy = 4;
        c.fill = GridBagConstraints.HORIZONTAL;
        this.add(anoT, c);
        anoT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                anoT.setText("");
            }
        });

        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", 1, 10));
        c.gridx = 4;
        c.gridy = 0;
        this.add(voltar, c);
        voltar.addActionListener(new GerirActionListener(3, janela));

        confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 3;
        c.gridy = 5;
        this.add(confirmar, c);
        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ano = anoT.getText();

                LocalDate diaMaisReservas = empresa.diaAnoMaisReservas(ano);

                if (empresa.validarAno(ano)) {

                        if (diaMaisReservas ==null ){

                        JOptionPane.showMessageDialog(new JFrame("Insucesso"), "O ano " + ano + " não teve nenhuma reserva");
                    } else{
                        JOptionPane.showMessageDialog(new JFrame("sucesso"), "O dia do ano " + ano + " com mais reservas foi " + diaMaisReservas);

                    }
                    anoT.setText("xxxx");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Reservas mensais"), "Insira um valor de ano válido");

            }

        });


    }

}
