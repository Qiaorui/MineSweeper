package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Configuracio {

    private static volatile Configuracio instance;
    private int maxTirades;
    private int maxSegons;

    private Configuracio() {
    	maxTirades = 1000;
        maxSegons = 1800;
    }

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

    public int getMaxTirades() {
        return maxTirades;
    }

    public int getMaxSegons() {
        return maxSegons;
    }
}
