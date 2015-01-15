package com.mineSweeper.domainLayer.struct;

/**
 * Created by qiaorui on 11/18/14.
 */
public class InformacioDeCasella {
    public int numeroFila;
    public int numeroColumna;
    public int numero;

    /**
     * InformacioDeCasella
     * Crea una instancia de la clase de informacion asociada a una casilla
     */
    public InformacioDeCasella(){

    }

    /**
     * InformacioDeCasella
     * Crea una instancia de la clase de informacion asociada a una casilla y hace
     * un set de los parametros pasados
     * @param numeroFila
     * @param numeroColumna
     * @param numero
     */
    public InformacioDeCasella(int numeroFila, int numeroColumna, int numero) {
        this.numeroFila = numeroFila;
        this.numeroColumna = numeroColumna;
        this.numero = numero;
    }

}
