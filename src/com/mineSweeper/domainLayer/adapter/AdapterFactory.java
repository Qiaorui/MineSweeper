package com.mineSweeper.domainLayer.adapter;

/**
 * Created by qiaorui on 11/13/14.
 */
public class AdapterFactory {

    private static volatile AdapterFactory instance;
    private InterfaceMissatgeriaAdapter interfacemissatgeriaAdapter;

    private AdapterFactory(){
        interfacemissatgeriaAdapter = new MissatgeriaAdapter();
    }


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

    public InterfaceMissatgeriaAdapter getMissatgeria() {
        return interfacemissatgeriaAdapter;
    }
}
