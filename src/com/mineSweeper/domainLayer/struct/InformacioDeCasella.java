package com.mineSweeper.domainLayer.struct;

/**
 * Created by qiaorui on 11/18/14.
 */
public class InformacioDeCasella {
    public int numeroFila;
    public int numeroColumna;
    public int numero;

    public InformacioDeCasella(){

    }
    public InformacioDeCasella(int numeroFila, int numeroColumna, int numero) {
        this.numeroFila = numeroFila;
        this.numeroColumna = numeroColumna;
        this.numero = numero;
    }
}
