package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Buscamines {

    private static volatile Buscamines instance;
    private int idPartida;

    private Buscamines() {
        
    }


    public static Buscamines getInstance() {
        if (instance == null) {
            synchronized (Buscamines.class) {
                if (instance == null) {
                    instance = new Buscamines();
                }
            }
        }
        return instance;
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void incrementaId() {
        ++idPartida;
    }
    
}
