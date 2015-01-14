package com.mineSweeper.domainLayer.serviceLocator;

import java.util.Objects;

/**
 * Created by qiaorui on 14-10-29.
 */
public class ServeiLocator {

    private static volatile ServeiLocator instance;

    private ServeiLocator() {

    }

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

    public Objects obtenirServei(String servei) {
        return null;
    }

}
