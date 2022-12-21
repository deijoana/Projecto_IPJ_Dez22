package Projecto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerirEventos implements ActionListener {
    private int num;
    private GUI janela;

    GerirEventos(int n, GUI janela) {
        this.num = n;
        this.janela = janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        switch (num) {
            case 1:
                janela.mudaEcra("NovoRegisto");
                break;
            case 2:
                janela.mudaEcra("Login");
                break;


        }

    }
}