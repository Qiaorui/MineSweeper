package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.dataLayer.CtrlNivellBD;


public class DataControllerFactory {
    private static volatile DataControllerFactory instance;
    private CtrlJugador ctrlJugador;
    private CtrlNivell ctrlNivell;
    private CtrlUsuariRegistrat ctrlUsuariRegistrat;
    private CtrlPuntuarPerTirades ctrlPuntuarPerTirades;

    private DataControllerFactory() {
    	ctrlNivell = (CtrlNivell) new CtrlNivellBD();
    }

    public static DataControllerFactory getInstance() {
        if (instance == null) {
            synchronized (DataControllerFactory.class) {
                if (instance == null) {
                    instance = new DataControllerFactory();
                }
            }
        }
        return instance;
    }

    public CtrlJugador getCtrlJugador() {
        return ctrlJugador;
    }

    public CtrlNivell getCtrlNivell() {
        return ctrlNivell;
    }

    public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
        return ctrlUsuariRegistrat;
    }

    public CtrlPuntuarPerTirades getCtrlPuntuarPerTirades() {
        return ctrlPuntuarPerTirades;
    }
}
