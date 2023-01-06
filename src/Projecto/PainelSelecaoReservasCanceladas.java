package Projecto;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PainelSelecaoReservasCanceladas extends JPanel {

    Empresa empresa;
    GUI janela;
    JLabel inserirDados, anoL, mesL;
    JComboBox mesC;
    JTextField anoT;
    JButton voltar, confirmar;

    PainelSelecaoReservasCanceladas(GUI janela, Empresa empresa) {

        this.empresa = empresa;
        this.janela = janela;
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        inserirDados = new JLabel("Seleccione o mês e o ano sobre o qual quer a informação estatística:");
        inserirDados.setFont(new Font("Arial", 1, 15));
        c.insets = new Insets(15, 0, 15, 0);
        c.gridx = 1;
        c.gridy = 1;
        // c.gridwidth = 2;
        this.add(inserirDados, c);

        mesL = new JLabel("Mês");
        mesL.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(30, 0, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        this.add(mesL, c);

        String meses[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        mesC = new JComboBox<>(meses);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        this.add(mesC, c);

        anoL = new JLabel("Ano");
        anoL.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(30, 0, 0, 10);
        c.gridx = 2;
        c.gridy = 4;
        this.add(anoL, c);

        anoT = new JTextField("Formato: xxxx");
        anoT.setFont(new Font("Arial", 1, 14));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 4;
        this.add(anoT, c);

        voltar = new JButton("Voltar");
        voltar.setFont(new Font("Arial", 1, 10));
        c.gridx = 4;
        c.gridy = 0;
        this.add(voltar, c);
        voltar.addActionListener(new GerirEventos(3, janela));

        confirmar = new JButton("Confirmar");
        confirmar.setFont(new Font("Arial", 1, 14));
        c.insets = new Insets(30, 0, 0, 0);
        c.gridx = 3;
        c.gridy = 5;
        this.add(confirmar, c);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mes = mesC.getSelectedItem().toString();
                String ano = anoT.getText();

                JList<Reserva> resultado = new JList<>(new Vector<>(empresa.listarReservasCanceladas(ano, mes)));
               ListModel model = resultado.getModel();  // resultado.isEmpty() não estava a ser aceite. Uso de ListModel e método getModel() permitiu verificar se a lista está vazia ou não
                if (empresa.validarAno(ano)) {
                   if (model.getSize()==0){
                   // if(resultado==null){
                        JOptionPane.showMessageDialog(new JFrame("Lista de reservas canceladas"), "Não há nenhuma reserva cancelada no mês seleccionado");
                    } else {
                        JFrame local = new JFrame("Lista de Reservas Canceladas");
                        local.setSize(800, 600);

                        local.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

                        JPanel painelLocal = new JPanel();
                        // painelLocal.setBackground(Color.red);
                        painelLocal.setLayout(new GridBagLayout());
                        GridBagConstraints c1 = new GridBagConstraints();

                        c1.gridx = 1;
                        c1.gridy = 1;
                        painelLocal.add(resultado, c1);
                        local.add(painelLocal);
                        local.setVisible(true);
                    }
                    anoT.setText("Formato: xxxx");
                } else
                    JOptionPane.showMessageDialog(new JFrame("Lista de reservas canceladas"), "Insira um valor de ano válido");
            }
        });



    }

}
