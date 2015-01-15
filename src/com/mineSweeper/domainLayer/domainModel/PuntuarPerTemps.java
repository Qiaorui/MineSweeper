package com.mineSweeper.domainLayer.domainModel;


/**
 * Created by qiaorui on 14-10-29.
 */
public class PuntuarPerTemps implements EstrategiaPuntuacio {

    private long maxSegons;
    private long tempsIni;

    public PuntuarPerTemps() {
    }

    /**
     * PuntuarPerTemps Inicialitza l'estrategia
     * @param maxSegons
     */
    public PuntuarPerTemps(int maxSegons) {
        this.maxSegons = maxSegons;
        tempsIni = System.currentTimeMillis()/1000;
    }

    /**
     * getPuntuacio
     * Getter de la puntuacio de la partida segons l'estrategia
     * @param partida La partida que vol saber la puntuacio
     * @return la puntuacio = maxTemps - tempsGastat
     */
    @Override
    public int getPuntuacio(Partida partida) {
        return (int)(maxSegons - (System.currentTimeMillis()/1000 - tempsIni));
    }

    /**
     * getMaxSegons
     * Getter del numero maxim de segons de l'estrategia
     * @return maxSegons
     */
    public long getMaxSegons() {
        return maxSegons;
    }
}
