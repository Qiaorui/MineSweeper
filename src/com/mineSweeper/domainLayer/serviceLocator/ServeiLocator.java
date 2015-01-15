package com.mineSweeper.domainLayer.serviceLocator;

import com.mineSweeper.domainLayer.service.SvEmail;

import java.util.Objects;

/**
 * Created by qiaorui on 14-10-29.
 */
public class ServeiLocator {

    private static volatile ServeiLocator instance;

    /**
     * ServeiLocator
     * Crea una instancia del localizador de servicios
     */
    private ServeiLocator() {

    }

    /**
     * getInstance
     * @return La instancia del localizador de servicios
     */
    public static ServeiLocator getInstance() {
        if (instance == null) {
            synchronized (ServeiLocator.class) {
                if (instance == null) {
                    instance = new ServeiLocator();
                }
            }
        }
        return instance;
    }

    /**
     * obtenirServei
     * @param servei El nombre del servicio que se quiere localizar
     * @return Una instancia del servicio que se quiere localizar, si existe y se encuentra.
     */
    public SvEmail obtenirServei(String servei) {
        if (servei == "SvEmail") return new SvEmail();
        else return null;
    }

}
