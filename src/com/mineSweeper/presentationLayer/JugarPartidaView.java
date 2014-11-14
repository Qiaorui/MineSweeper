package com.mineSweeper.presentationLayer;


import com.mineSweeper.domainLayer.struct.Dades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class JugarPartidaView {

    Login login;
    ConsultarNivell consultarNivell;
    Partida partida;

    public JugarPartidaView(ActionListener actionListener) {
        login = new Login(actionListener);
        consultarNivell = new ConsultarNivell();
        partida = new Partida();
    }

    public void inicializar() {
        login.inicializar();
        login.setVisible(true);
    }

    public void mostraDialog(String missatge) {

    }

    public void mostraNivells(Dades[] dades) {

    }

    public void mostraNoExisteixNivell() {

    }

    public void mostraMissatge(String missatge) {

    }

    public void mostraDesmarcarCasella(int fila, int columna) {

    }

    public void mostraMarcarCasella(int fila, int columna) {

    }

    public void mostraGuanyda(int punt) {

    }

    public void mostraPerdida() {

    }

    public void mostraDescobrirCasella(int fila, int columna){

    }

    public void mostraPartida(int nFila, int nColumna){

    }

    public void tancar(){
        login.dispose();

    }


    private class Login extends JFrame{

        private JButton okButton;
        private JButton cancelButton;
        private JTextArea usernameArea;
        private JTextArea passwordArea;
        private JPanel mainPanel;
        private ActionListener actionListener;

        private final int ancho = 250;
        private final int altura = 250;


        public Login(ActionListener actionListener){
            this.actionListener = actionListener;
        }

        public void inicializar(){
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension dimension = kit.getScreenSize();     //dimension es la dimension de la pantalla
            setSize(ancho, altura);    //tamany de la ventana
            setLocation(( dimension.width - ancho) / 2, (dimension.height - altura) / 2);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setTitle("Login");
            setResizable(false);

            inicializarElement();
            Box box = Box.createVerticalBox();

            JPanel tmp = new JPanel();
            tmp.add(usernameArea);
            box.add(tmp);

            box.add(Box.createVerticalStrut(5));

            JPanel tmp2 = new JPanel();
            tmp2.add(passwordArea);
            box.add(tmp2);


            box.add(Box.createVerticalStrut(5));

            JPanel tmp3 =new JPanel();
            tmp3.add(okButton);
            Box box2 = Box.createHorizontalBox();
            box2.add(tmp3);

            box2.add(Box.createHorizontalStrut(10));

            JPanel tmp4 = new JPanel();
            tmp4.add(cancelButton);
            box2.add(tmp4);

            box.add(box2);
            mainPanel = new JPanel();
            mainPanel.add(box);
            getContentPane().add(mainPanel);
        }

        private void inicializarElement(){
            okButton = new JButton("OK");
            okButton.setActionCommand("okLogin");
            okButton.addActionListener(actionListener);
            cancelButton = new JButton("Cancel");
            cancelButton.setActionCommand("cancel");
            cancelButton.addActionListener(actionListener);
            usernameArea = new JTextArea("username");
            
            passwordArea = new JTextArea("password");
        }


    }

    private class ConsultarNivell {

        public ConsultarNivell(){

        }
    }

    private class Partida {

        public Partida(){

        }
    }

}
