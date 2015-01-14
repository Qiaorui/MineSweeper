package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.struct.InformacioDeCasella;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by qiaorui on 11/15/14.
 */
public class JugarPartidaFrame extends JFrame implements ActionListener, MouseListener {

    private InterfaceJugarPartida jugarPartida;
    private LoseFrame loseFrame;
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
                //this.map[i][j].addMouseListener(new RightClicker());
                this.map[i][j].addActionListener(this);
                this.map[i][j].addMouseListener(this);
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
        if (numero != 0) {
            map[fila][columna].setText(""+numero);
            switch (numero) {
                case 1: map[fila][columna].setForeground(Color.blue); break;
                case 2: map[fila][columna].setForeground(Color.green); break;
                case 3: map[fila][columna].setForeground(Color.red); break;
                case 4: map[fila][columna].setForeground(Color.yellow); break;
                case 5: map[fila][columna].setForeground(Color.magenta); break;
                case 6: map[fila][columna].setForeground(Color.orange); break;
                case 7: map[fila][columna].setForeground(Color.pink ); break;
                case 8: map[fila][columna].setForeground(Color.black); break;
            }
            map[fila][columna].setMargin(new Insets(0,0,0,0));
            map[fila][columna].setFont(new Font("Arial",Font.BOLD,11));
        }
        map[fila][columna].setBackground(Color.lightGray);
        map[fila][columna].setIcon(null);
        AdministratorShell.getInstance().showText("mapa " + fila + " " + columna + " te numero " + numero+"\n");
        map[fila][columna].setVisible(false);
        map[fila][columna].setVisible(true);
    }

    public void marcarCasella(int fila, int columna) {
        map[fila][columna].setIcon(new ImageIcon(getClass().getResource("/image/flag.png")));
        map[fila][columna].setVisible(false);
        map[fila][columna].setVisible(true);
    }

    public void desmarcarCasella(int fila, int columna) {
        map[fila][columna].setIcon(null);
        map[fila][columna].setVisible(false);
        map[fila][columna].setVisible(true);
    }

    public void perder(ArrayList<InformacioDeCasella> informacioDeCasellas) {
        Iterator<InformacioDeCasella> nombreIterator = informacioDeCasellas.iterator();
        while(nombreIterator.hasNext()){
            InformacioDeCasella casella = nombreIterator.next();
            map[casella.numeroFila][casella.numeroColumna].setIcon(new ImageIcon(getClass().getResource("/image/v8venZS.png")));
            map[casella.numeroFila][casella.numeroColumna].setVisible(false);
            map[casella.numeroFila][casella.numeroColumna].setVisible(true);
        }

        loseFrame = new LoseFrame(okButton);
        loseFrame.setVisible(true);
    }


    public void showMessage(String message) {
        messageArea.setText(message);
        messageArea.setVisible(false);
        messageArea.setVisible(true);
    }

    private void inicializarElement(){
        okButton = new JButton("OK");
        okButton.addActionListener(this);
        sortirButton = new JButton("Sortir");
        sortirButton.addActionListener(this);
        messageArea = new JLabel();
        messageArea.setText("");
    }


    public void tancar() {
        if (loseFrame != null)loseFrame.dispose();
        dispose();
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == okButton) {
            jugarPartida.prOkMissatge();
        }
        else if (event.getSource() == sortirButton) {
            jugarPartida.prSortir();
        }
/*        else {
            for (int i=0; i < map.length; ++i){
                for (int j=0; j < map[0].length; ++j) {

                    if (event.getSource() == map[i][j]){
                        AdministratorShell.getInstance().showText("descobrir "+i+"  "+j+"\n");
                        jugarPartida.prDescobrirCasella(i,j);
                    }
                }
            }
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            for (int i = 0; i < map.length; ++i) {
                for (int j = 0; j < map[0].length; ++j) {
                    if (e.getSource() == map[i][j]) {
                        AdministratorShell.getInstance().showText("Marcar/Desmarcar " + i + "  " + j + "\n");
                        if (map[i][j].getText() == "") jugarPartida.prMarcarDesmarcarCasella(i, j);
                    }
                }
            }
        }
        else if (e.getButton() == MouseEvent.BUTTON1) {
            for (int i = 0; i < map.length; ++i) {
                for (int j = 0; j < map[0].length; ++j) {

                    if (e.getSource() == map[i][j]) {
                        AdministratorShell.getInstance().showText("Descobrir " + i + "  " + j + "\n");
                        jugarPartida.prDescobrirCasella(i, j);
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    private class LoseFrame extends JFrame {

        private LoseFrame(JButton button) {
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
            setSize(500, 500);
            setLocation((dimension.width - 500) / 2, (dimension.height - 500) / 2);
            JPanel main = new JPanel(new BorderLayout());
            main.setBorder(BorderFactory.createEmptyBorder(20,20,15,20));
            JPanel tmp2 = new JPanel();
            tmp2.add(new JLabel("Has perdut la partida"));
            main.add(tmp2,BorderLayout.NORTH);
            main.add(new JLabel(new ImageIcon(getClass().getResource("/image/boom.gif"))),BorderLayout.CENTER);
            // main.add(new JLabel(new ImageIcon("res/images/run.gif")),BorderLayout.CENTER);
            JPanel tmp = new JPanel();
            tmp.add(button);
            main.add(tmp, BorderLayout.SOUTH);
            getContentPane().add(main);
        }


    }





}
