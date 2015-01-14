package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.domainLayer.domainModel.Partida;

/**
 * Created by qiaorui on 14-10-28.
 */
public interface CtrlPartida {

    public Partida getPartida(int partidaid);
    public void createPartida(Partida partida);
    public void updatePatida(Partida partida);
}
