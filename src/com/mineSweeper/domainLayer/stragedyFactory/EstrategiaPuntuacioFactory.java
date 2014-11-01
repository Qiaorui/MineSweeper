package com.mineSweeper.domainLayer.stragedyFactory;

import com.mineSweeper.domainLayer.domainModel.EstrategiaPuntuacio;
import com.mineSweeper.domainLayer.domainModel.PuntuarPerTemps;
import com.mineSweeper.domainLayer.domainModel.PuntuarPerTirades;

/**
 * Created by qiaorui on 14-10-29.
 */
public class EstrategiaPuntuacioFactory {

    private static volatile EstrategiaPuntuacioFactory instance;


    private EstrategiaPuntuacioFactory(){

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
        if (Math.random() > 0.5) estrategiaPuntuacio = new PuntuarPerTirades();
        else estrategiaPuntuacio = new PuntuarPerTemps();
        return estrategiaPuntuacio;
    }

}
