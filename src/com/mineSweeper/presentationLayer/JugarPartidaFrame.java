package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/15/14.
 */
public class JugarPartidaFrame extends JFrame implements ActionListener {

    private InterfaceJugarPartida jugarPartida;

    private JButton okButton;
    private JButton sortirButton;
    private JLabel messageArea;
    private JPanel mainPanel;

    private int ancho;
    private int altura;



    public JugarPartidaFrame(InterfaceJugarPartida jugarPartida) {
        this.jugarPartida = jugarPartida;
    }

    public void inicializar(int fila, int columna){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
        ancho = columna * 25 +50;
        altura = fila * 25 + 200;
        setSize(ancho, altura);   //tamany de la ventana
        setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Partida");
        setResizable(false);

        inicializarElement();
        Box box = Box.createVerticalBox();

        box.add(Box.createVerticalStrut(30));
        JPanel map = new JPanel(new GridLayout(fila,columna,0,0));
        for (int i = 0; i < fila; ++i) {
            for (int j = 0; j < columna; ++j) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(25,25));
                button.setBackground(Color.LIGHT_GRAY);
                button.addActionListener(this);
                button.setActionCommand(i+" "+j);
                map.add(button);
            }
        }
        box.add(map);

        box.add(Box.createVerticalStrut(5));

        JPanel tmp = new JPanel();
        tmp.add(messageArea);
        box.add(tmp);


        box.add(Box.createVerticalStrut(45));


        JPanel tmp4 = new JPanel();
        tmp4.add(sortirButton);

        box.add(tmp4);
        mainPanel = new JPanel();
        mainPanel.add(box);
        getContentPane().add(mainPanel);
    }

    private void inicializarElement(){
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        sortirButton = new JButton("Sortir");
        sortirButton.addActionListener(this);
        messageArea = new JLabel();
        messageArea.setText("error");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == okButton) {
            jugarPartida.prOkMissatge();
        }
        if (event.getSource() == sortirButton) {
            jugarPartida.prSortir();
        }

    }





}
