package com.mineSweeper.domainLayer.domainModel;

import com.mineSweeper.AdministratorShell;

/**
 * Created by qiaorui on 14-10-29.
 */
public class PuntuarPerTirades implements EstrategiaPuntuacio {

    private int maxTirades;

    public PuntuarPerTirades() {
    }

    /**
     * PuntuarPerTirades inicialitza l'estrategia de puntuacio per tirades
     * @param maxTirades
     */
    public PuntuarPerTirades(int maxTirades) {
    	
    	this.maxTirades = maxTirades;
    }

    /**
     * getPuntuacio
     * Getter de la puntuacio de la partida segons l'estrategia
     * @param partida La partida que vol saber la puntuacio
     * @return La puntuacio = maxTirades - tiradesUsades
     */
    @Override
    public int getPuntuacio(Partida partida) {
        return maxTirades - partida.getNombreTirades();
    }

    /**
     * getMaxTirades
     * Getter del numero maxim de tirades de l'estrategia
     * @return maxTirades
     */
    public int getMaxTirades() {
        return maxTirades;
    }
}
