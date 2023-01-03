package Projecto;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

public class PainelConfirmarReserva extends JPanel{

    Empresa empresa;

    GUI janela;

    JLabel dadosReserva, dataPartida, dataPartidaT, dataRegresso, dataRegressoT, origemPainel, origemPainelT;

    JLabel destinoPainel, destinoPainelT, numPassageiros, numPassageirosT, distPrevista, distPrevistaT;

    JButton confirmar, voltarAtras;


    PainelConfirmarReserva(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        dadosReserva = new JLabel("Os dados da sua reserva são: ");
        dadosReserva.setFont(new Font("Arial", 1, 15));
        c.insets = new Insets(15, 0, 15, 0);
        c.gridx = 1;
        c.gridy = 1;
        this.add(dadosReserva, c);

        dataPartida = new JLabel("Data de partida");
        dataPartida.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 1;
        this.add(dataPartida, c);

        dataPartidaT = new JLabel();
        dataPartidaT.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 1;
        this.add(dataPartidaT, c);

        dataRegresso =  new JLabel("Data de regresso");
        dataRegresso.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 2;
        this.add(dataRegresso, c);

        dataRegressoT = new JLabel ("");
        dataRegressoT.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 2;
        this.add(dataRegressoT, c);


        origemPainel = new JLabel("Origem");
        origemPainel.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 3;
        this.add(origemPainel, c);

        origemPainelT = new JLabel("");
        origemPainelT.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 3;
        this.add(origemPainelT, c);


        destinoPainel = new JLabel("Destino");
        destinoPainel.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 4;
        this.add(destinoPainel, c);

        destinoPainelT = new JLabel("");
        destinoPainelT.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 4;
        this.add(destinoPainelT, c);


        numPassageiros = new JLabel("Número de passageiros");
        numPassageiros.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 5;
        this.add(numPassageiros, c);

        numPassageirosT = new JLabel("");
        numPassageirosT.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 5;
        this.add(numPassageirosT, c);


        distPrevista = new JLabel("Distância prevista (km)");
        distPrevista.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 0;
        c.gridy = 6;
        this.add(distPrevista, c);

        distPrevistaT = new JLabel("");
        distPrevistaT.setFont(new Font("Arial", 1, 12));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 1;
        c.gridy = 6;
        this.add(distPrevistaT, c);


        confirmar = new JButton("Confirmar");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(40, 0, 20, 0);
        c.gridx = 1;
        c.gridy = 8;
        this.add(confirmar, c);

        voltarAtras = new JButton("Voltar atrás");
        c.fill = GridBagConstraints.CENTER;
        c.insets = new Insets(40, 0, 20, 0);
        c.gridx = 0;
        c.gridy = 8;
        this.add(voltarAtras, c);





    }


}
