package com.mineSweeper.presentationLayer;

/**
 * Created by qiaorui on 11/18/14.
 */
public interface InterfaceConsultarNivell {


    /**
     * prOkCrearPartida
     * Crea la partida amb el nivell nivell i una quadrícula de fila files, columna columnes
     * @param nivell nom del nivell escollit
     * @param fila nombre de files del nivell
     * @param columna nombre de columnes del nivell
     */
    public void prOkCrearPartida(String nivell, int fila, int columna);

    /**
     * prCancel
     * Tanca la finestra per a tornar enrere.
     */
    public void prCancel();
}
