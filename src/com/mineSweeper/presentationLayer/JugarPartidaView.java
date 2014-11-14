package com.mineSweeper.presentationLayer;


import com.mineSweeper.domainLayer.struct.Dades;

import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class JugarPartidaView {

    LoginFrame login;
    ConsultarNivell consultarNivell;
    Partida partida;

    public JugarPartidaView(ActionListener actionListener) {
        login = new LoginFrame(actionListener);
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


    private class ConsultarNivell {

        public ConsultarNivell(){

        }
    }

    private class Partida {

        public Partida(){

        }
    }

}
