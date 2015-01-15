package com.mineSweeper.domainLayer.stragedyFactory;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.domainModel.Configuracio;
import com.mineSweeper.domainLayer.domainModel.EstrategiaPuntuacio;
import com.mineSweeper.domainLayer.domainModel.PuntuarPerTemps;
import com.mineSweeper.domainLayer.domainModel.PuntuarPerTirades;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiaorui on 14-10-29.
 */
public class EstrategiaPuntuacioFactory {

    private static volatile EstrategiaPuntuacioFactory instance;
    private Map<Integer, EstrategiaPuntuacio> puntuarPerTirades; //HashMap!!
//    private Map<Integer, EstrategiaPuntuacio> puntuarPerTemps;     //HashMap!!

    /**
     * EstrategiaPuntuacioFactory
     * Crea una instancia de la clase factoria de estrategias de puntuacion
     */
    private EstrategiaPuntuacioFactory(){
        puntuarPerTirades = new HashMap<Integer, EstrategiaPuntuacio>();
//        puntuarPerTemps = new HashMap<Integer, EstrategiaPuntuacio>();

    }

    /**
     * getInstance
     * @return La instancia del factoria de estrategias de puntuacion
     */
    public static EstrategiaPuntuacioFactory getInstance() {
        if (instance == null) {
            synchronized (EstrategiaPuntuacioFactory.class) {
                if (instance == null) {
                    instance = new EstrategiaPuntuacioFactory();
                }
            }
        }
        return instance;
    }

    /**
     * getEstrategiaPuntuacioAleatori
     * @return Una de las estrategias de puntuacion disponibles, elegida
     * aleatoriamente.
     */
    public EstrategiaPuntuacio getEstrategiaPuntuacioAleatori() {
        EstrategiaPuntuacio estrategiaPuntuacio;
        Configuracio configuracio = Configuracio.getInstance();
        if (Math.random() > 0.5) estrategiaPuntuacio = getPuntuarPerTirades(configuracio.getMaxTirades());
        else estrategiaPuntuacio = getPuntuarPerTemps(configuracio.getMaxSegons());
        return estrategiaPuntuacio;
    }

    /**
     * getPuntuarPerTirades
     * @param maxTirades Define el maximo numero de tiradas permitidas
     * @return Una estrategia de puntuacion que permite maxTiradas como maximo
     */
    private EstrategiaPuntuacio getPuntuarPerTirades(int maxTirades) {
        EstrategiaPuntuacio estrategiaPuntuacio;
        if (puntuarPerTirades.containsKey(maxTirades)) {
            estrategiaPuntuacio = puntuarPerTirades.get(maxTirades);
        }
        else {
            estrategiaPuntuacio = new PuntuarPerTirades(maxTirades);
            puntuarPerTirades.put(maxTirades, estrategiaPuntuacio);
        }
        return estrategiaPuntuacio;
    }

    /**
     * getPuntuarPerTemps
     * @param maxSegons Define el maximo numero de segundos permitidos
     * @return Una estrategia de puntuacion que permite maxSegundos como maximo
     */
    private EstrategiaPuntuacio getPuntuarPerTemps(int maxSegons) {
        return new PuntuarPerTemps(maxSegons);
    }

}
