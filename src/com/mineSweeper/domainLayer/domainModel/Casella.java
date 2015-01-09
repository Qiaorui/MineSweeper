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
        this.numeroFila = numeroFila;
        this.numeroColumna = numeroColumna;
        numero = 0;
        estaDescoberta = false;
        estaMarcada = false;
        teMina = false;
    }

    public int getNumero() {
        return numero;
    }

/*
    public void marcarCasella() {
        if (estaDescoberta); //exc jaDescoberta
        else if (estaMarcada); //exc jaMarcada
        else estaMarcada = true;
    }

    public boolean desmarcarCasella() {
        //if (estaDescoberta); //exc jaDescoberta
        if (!estaMarcada) ; //exc noMarcada
        else estaMarcada = false;
    }*/

    public boolean marcarDesmarcarCasella() throws RuntimeException{
       /* if (estaDescoberta) {
            throw new RuntimeException("La casella està descoberta");
        }
        else */
        if (!estaMarcada) estaMarcada = true; //exc noMarcada
        else estaMarcada = false;
        return estaMarcada;
    }

    public void assignarMina() {
        teMina = true;
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
        numero++;
    }

    public boolean descobrirCasella() {
        if (estaMarcada); //exc: jaMarcada
        else if (estaDescoberta); //exc: jaDescoberta
        else estaDescoberta = true;
        return teMina;
    }
}
