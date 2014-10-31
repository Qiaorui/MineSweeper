package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Casella {

    private int numeroFila;
    private int numeroColumna;
    private int numero;
    private boolean estaDescoberta;
    private boolean estaMarcada;
    private boolean teMina;

    public Casella(int numeroFila, int numeroColumna) {

    }

    public int getNumero() {
        return numero;
    }

    public void marcarCasella() {

    }

    public void desmarcarCasella() {

    }

    public void assignarMina() {

    }

    public boolean teMina() {
        return teMina;
    }

    public boolean estaDescoberta() {
        return estaDescoberta;
    }

    public boolean estaMarcada() {
        return estaMarcada;
    }

    public void sumNum() {

    }

    public boolean descobrirCasella() {
        return teMina;
    }
}
