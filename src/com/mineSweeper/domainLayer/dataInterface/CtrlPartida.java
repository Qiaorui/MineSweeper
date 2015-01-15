package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.domainLayer.domainModel.Partida;

/**
 * Created by qiaorui on 14-10-28.
 */

/**
 * Interfaz para las partidas en la capa de datos
 */
public interface CtrlPartida {

    public Partida getPartida(int partidaid);
    public void createPartida(Partida partida);
    public void updatePartida(Partida partida);
}
