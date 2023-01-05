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
            case 3:
                janela.mudaEcra("PainelAdmin");
                break;
            case 4:
                janela.mudaEcra("PainelSelecaoBus");
                break;
            case 5:
                janela.mudaEcra("PainelReservaMensal");
                break;
            case 6:
                janela.mudaEcra("PainelDiaMaisReservas");
                break;
            case 7:
                janela.mudaEcra("PainelCliente");
                break;
            case 8:
                janela.mudaEcra("PainelNormal");
                break;
            case 9:
                janela.mudaEcra("PainelSelecaoReservasCanceladas");
                break;
        }

    }
}