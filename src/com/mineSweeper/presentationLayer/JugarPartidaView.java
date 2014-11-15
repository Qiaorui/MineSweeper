package com.mineSweeper.presentationLayer;


import com.mineSweeper.domainLayer.struct.Dades;

import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class JugarPartidaView {

    LoginFrame loginFrame;
    ConsultarNivellFrame consultarNivellFrame;
    JugarPartidaFrame jugarPartidaFrame;

    public JugarPartidaView(ActionListener actionListener) {
        loginFrame = new LoginFrame(actionListener);
        consultarNivellFrame = new ConsultarNivellFrame();
        jugarPartidaFrame = new JugarPartidaFrame();
    }

    public void inicializar() {
        loginFrame.inicializar();
        loginFrame.setVisible(true);
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
        loginFrame.dispose();

    }


}
