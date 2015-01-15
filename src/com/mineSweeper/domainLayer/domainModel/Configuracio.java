package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Configuracio {

    private static volatile Configuracio instance;
    private int maxTirades;
    private int maxSegons;

    /**
     * Configuracio
     * Crea una instancia de la clase de configuracion
     */
    private Configuracio() {
    	maxTirades = 1000;
        maxSegons = 1800;
    }

    /**
     * getInstance
     * Ontiene la instancia de la clase de configuracion
     * @return La instancia de la clase de configuracion
     */
    public static Configuracio getInstance() {
        if (instance == null) {
            synchronized (Configuracio.class) {
                if (instance == null) {
                    instance = new Configuracio();
                }
            }
        }
        return instance;
    }

    /**
     * getMaxTirades
     * @return Numero maximo de tiradas permitidas
     */
    public int getMaxTirades() {
        return maxTirades;
    }

    /**
     * getMaxSegons
     * @return Numero maximo de segundos permitidos
     */
    public int getMaxSegons() {
        return maxSegons;
    }
}
