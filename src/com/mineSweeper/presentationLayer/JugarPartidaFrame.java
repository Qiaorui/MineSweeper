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
    private JButton[][] map;

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
        this.map = new JButton[fila][columna];
        for (int i = 0; i < fila; ++i) {
            for (int j = 0; j < columna; ++j) {
                this.map[i][j] = new JButton();
                this.map[i][j].setPreferredSize(new Dimension(25,25));
              //  this.map[i][j].setBackground(Color.LIGHT_GRAY);
                this.map[i][j].addActionListener(this);
                map.add(this.map[i][j]);
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

    public void descobrirCasella(int fila, int columna, int numero) {
        map[fila][columna].setText(""+numero);
        map[fila][columna].setMargin(new Insets(0,0,0,0));
        map[fila][columna].setFont(new Font("Arial",0,11));
        AdministratorShell.getInstance().showText("mapa " + fila + " " + columna + " te numero " + numero);
        map[fila][columna].setVisible(false);
        map[fila][columna].setVisible(true);
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
        else if (event.getSource() == sortirButton) {
            jugarPartida.prSortir();
        }
        else {
            for (int i=0; i < map.length; ++i){
                for (int j=0; j < map[0].length; ++j) {

                    if (event.getSource() == map[i][j]){
                        AdministratorShell.getInstance().showText("descobrir "+i+"  "+j+"\n");
                        jugarPartida.prDescobrirCasella(i,j);
                    }
                }
            }
        }
    }





}
