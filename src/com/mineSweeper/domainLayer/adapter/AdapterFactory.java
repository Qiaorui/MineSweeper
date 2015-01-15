package com.mineSweeper.domainLayer.adapter;

/**
 * Created by qiaorui on 11/13/14.
 */
public class AdapterFactory {

    private static volatile AdapterFactory instance;
    private InterfaceMissatgeriaAdapter interfacemissatgeriaAdapter;

    /**
     * AdapterFactory
     * Crea una instancia de AdapterFactory
     */
    private AdapterFactory(){
        interfacemissatgeriaAdapter = new MissatgeriaAdapter();
    }

    /**
     * getInstance
     * @return La instancia del adaptador
     */
    public static AdapterFactory getInstance() {
        if (instance == null) {
            synchronized (AdapterFactory.class) {
                if (instance == null) {
                    instance = new AdapterFactory();
                }
            }
        }
        return instance;
    }

    /**
     * getMissatgeria
     * @return El adaptador de mensajeria
     */
    public InterfaceMissatgeriaAdapter getMissatgeria() {
        return interfacemissatgeriaAdapter;
    }
}
