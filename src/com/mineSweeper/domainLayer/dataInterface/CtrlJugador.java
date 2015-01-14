package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.domainLayer.domainModel.Jugador;

/**
 * Created by qiaorui on 14-10-28.
 */
public interface CtrlJugador {

    public Jugador getJugador(String username);
    public void createJugador(Jugador j);
    public void updateJugador(Jugador j);
}
