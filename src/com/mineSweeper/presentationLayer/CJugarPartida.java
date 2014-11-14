package com.mineSweeper.presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class CJugarPartida implements ActionListener{

    JugarPartidaView jugarPartidaView;

    public CJugarPartida() {
        jugarPartidaView = new JugarPartidaView(this);
    }

    public void inicializar() {
        jugarPartidaView.inicializar();
    }

    public void prOkFerAutenticacio(String username, String password) {


    }

    public void prOkCrearPartida(String nivell, int fila, int columna) {

    }

    public void prDescobrirCasella(int fila, int columna) {

    }

    public void prMarcarCasella(int fila, int columna) {

    }

    public void prDesmarcarCasella(int fila, int columna) {


    }

    public void prOkMissatge() {

    }

    public void prCancel() {
        jugarPartidaView.tancar();
    }

    public void prSortir() {

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == "cancel") {
            prCancel();
        }

    }


}
