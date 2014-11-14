package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class PuntuarPerTirades implements EstrategiaPuntuacio {

    private int maxTirades;

    public PuntuarPerTirades() {
    }

    public PuntuarPerTirades(int maxTirades) {
        this.maxTirades = maxTirades;
    }

    public int getPuntuacio(Partida partida) {
        return maxTirades - partida.getNombreTirades();
    }

    public int getMaxTirades() {
        return maxTirades;
    }
}
