package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Buscamines {

    private static volatile Buscamines instance;
    private int idPartida;

    /**
     * Buscamines
     * Crea una instancia de la clase buscaminas
     */
    private Buscamines() {
        
    }

    /**
     * getInstance
     * @return La instancia de la clase buscaminas
     */
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

    /**
     * getIdPartida
     * @return El identificador de la partida
     */
    public int getIdPartida() {
        return idPartida;
    }

    /**
     * incrementaId
     * Incrementa el identificador de la partida en una unidad
     */
    public void incrementaId() {
        ++idPartida;
    }
    
}
