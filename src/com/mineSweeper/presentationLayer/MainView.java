package com.mineSweeper.presentationLayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by qiaorui on 11/14/14.
 */
public class MainView extends JFrame implements ActionListener{

    private Box menu;
    private JPanel mainPanel;
    private JButton jugarPartidaButton;
    private JButton loginButton;
    private JButton consultarNivellButton;
    private JButton sortirButton;

    private final int ancho = 350;
    private final int altura = 550;
    public MainView () {
        /*try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName()) ;
        }
        catch (Exception e) {

        }*/
    }


    public void inicializar() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
        setSize(ancho, altura);    //tamany de la ventana
        setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setResizable(false);

        inicializarButton();
        menu = Box.createVerticalBox();

        Image image = kit.getImage("res/unnamed.png");
        setIconImage(image);

        JPanel tmp1 = new JPanel();
        tmp1.add(new JLabel("Mine Sweeper"));
        menu.add(tmp1);

        JPanel tmp5 = new JPanel();
        tmp5.add(new JLabel(new ImageIcon("res/unnamed.png")));
        menu.add(tmp5);

        JPanel tmp = new JPanel();
        tmp.add(loginButton);
        menu.add(tmp);

        menu.add(Box.createVerticalStrut(5));

        JPanel tmp2 = new JPanel();
        tmp2.add(consultarNivellButton);
        menu.add(tmp2);


        menu.add(Box.createVerticalStrut(5));

        JPanel tmp3 = new JPanel();
        tmp3.add(jugarPartidaButton);
        menu.add(tmp3);


        menu.add(Box.createVerticalStrut(5));

        JPanel tmp4 = new JPanel();
        tmp4.add(sortirButton);
        menu.add(tmp4);

        mainPanel = new JPanel();
        mainPanel.add(menu);
        setContentPane(mainPanel);
        setVisible(true);
    }

    private void inicializarButton() {
        jugarPartidaButton = new JButton("Jugar partida");
        jugarPartidaButton.addActionListener(this);
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        consultarNivellButton = new JButton("Consultar nivell");
        consultarNivellButton.addActionListener(this);
        sortirButton = new JButton("Sortir");
        sortirButton.addActionListener(this);
    }


    public void actionPerformed (ActionEvent event) {

    }

}
