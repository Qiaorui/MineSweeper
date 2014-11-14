package com.mineSweeper.domainLayer.domainModel;


/**
 * Created by qiaorui on 14-10-29.
 */
public class PuntuarPerTemps implements EstrategiaPuntuacio {

    private long maxSegons;
    private long tempsIni;

    public PuntuarPerTemps() {
    }


    public PuntuarPerTemps(int maxSegons) {
        this.maxSegons = maxSegons;
        tempsIni = System.currentTimeMillis()/1000;
    }

    @Override
    public int getPuntuacio(Partida partida) {
        return (int)(maxSegons - (System.currentTimeMillis()/1000 - tempsIni));
    }

    public long getMaxSegons() {
        return maxSegons;
    }
}
