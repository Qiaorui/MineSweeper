package com.mineSweeper.domainLayer.stragedyFactory;

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

    private EstrategiaPuntuacioFactory(){
        puntuarPerTirades = new HashMap<Integer, EstrategiaPuntuacio>();
//        puntuarPerTemps = new HashMap<Integer, EstrategiaPuntuacio>();

    }

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

    public EstrategiaPuntuacio getEstrategiaPuntuacioAleatori() {
        EstrategiaPuntuacio estrategiaPuntuacio;
        Configuracio configuracio = Configuracio.getInstance();
        if (Math.random() > 0.5) estrategiaPuntuacio = getPuntuarPerTirades(configuracio.getMaxTirades());
        else estrategiaPuntuacio = getPuntuarPerTemps(configuracio.getMaxSegons());
        return estrategiaPuntuacio;
    }

    private EstrategiaPuntuacio getPuntuarPerTirades(int maxTirades) {
        EstrategiaPuntuacio estrategiaPuntuacio;
        if (puntuarPerTirades.containsKey(maxTirades)) {
            estrategiaPuntuacio = puntuarPerTirades.get(maxTirades);
        }
        else {
            estrategiaPuntuacio = new PuntuarPerTirades();
            puntuarPerTirades.put(maxTirades, estrategiaPuntuacio);
        }
        return estrategiaPuntuacio;
    }

    private EstrategiaPuntuacio getPuntuarPerTemps(int maxSegons) {
        return new PuntuarPerTemps(maxSegons);
    }

}
