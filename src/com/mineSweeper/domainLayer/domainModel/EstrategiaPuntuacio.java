package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */

/**
 * Interfaz que representa una estrategia de puntuacion usada para el
 * patron estrategia.
 */
public interface EstrategiaPuntuacio {

    public int getPuntuacio(Partida partida);
}
