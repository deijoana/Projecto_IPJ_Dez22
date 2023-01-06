package Projecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PainelReservaMensal extends JPanel {

    Empresa empresa;
    GUI janela;
    JLabel inserirDados, anoL, mesL;
    JComboBox mesC;
    JTextField anoT;
    JButton voltar, confirmar;

    PainelReservaMensal(GUI janela, Empresa empresa) {

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
                String ano = anoT.getText();

                String dados[] = {empresa.avaliarReservaMensal(ano, 1), empresa.avaliarReservaMensal(ano, 2), empresa.avaliarReservaMensal(ano, 3),
                        empresa.avaliarReservaMensal(ano, 4),empresa.avaliarReservaMensal(ano, 5),empresa.avaliarReservaMensal(ano, 6),empresa.avaliarReservaMensal(ano ,7),
                        empresa.avaliarReservaMensal(ano, 8),empresa.avaliarReservaMensal(ano, 9),empresa.avaliarReservaMensal(ano, 10),empresa.avaliarReservaMensal(ano, 11),empresa.avaliarReservaMensal(ano, 12)};

                JList<String> resultado = new JList<String>(dados);
                ListModel model = resultado.getModel();  // resultado.isEmpty() não estava a ser aceite. Uso de ListModel e método getModel() permitiu verificar se a lista está vazia ou não

                if (empresa.validarAno(ano)) {
                    if (model.getSize()==0){
                        JOptionPane.showMessageDialog(new JFrame("Insucesso"), "O ano " + ano + " não teve nenhuma reserva" );
                    } else {
                        //JOptionPane.showMessageDialog(new JFrame("sucesso"), "Mostrar lista");
                        JFrame local = new JFrame("Volume de reservas mensais (número e facturação) no ano " + ano);
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
                    JOptionPane.showMessageDialog(new JFrame("Reservas mensais"), "Insira um valor de ano válido");
            }
        });



    }

}
