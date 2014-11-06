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

    public int getPuntuacio(int nombreTirades) {
        return maxTirades - nombreTirades;
    }

    public int getMaxTirades() {
        return maxTirades;
    }
}
