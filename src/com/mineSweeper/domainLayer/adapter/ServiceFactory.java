package com.mineSweeper.domainLayer.adapter;

/**
 * Created by qiaorui on 11/7/14.
 */
public class ServiceFactory {
    
    private static volatile ServiceFactory instance;
    private MissatgeriaAdapter missatgeriaAdapter;

    private ServiceFactory(){
        missatgeriaAdapter = new ServeiMissatgeria();
    }


    public static ServiceFactory getInstance() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }

    public MissatgeriaAdapter getMissatgeria() {
        return missatgeriaAdapter;
    }
}
