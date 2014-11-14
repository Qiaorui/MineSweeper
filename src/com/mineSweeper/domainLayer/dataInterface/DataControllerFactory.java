package com.mineSweeper.domainLayer.dataInterface;

/**
 * Created by qiaorui on 14-10-28.
 */
public class DataControllerFactory {
    private static volatile DataControllerFactory instance;
    private CtrlJugador ctrlJugador;
    private CtrlNivell ctrlNivell;
    private CtrlUsuariRegistrat ctrlUsuariRegistrat;
    private CtrlPuntuarPerTirades ctrlPuntuarPerTirades;

    private DataControllerFactory() {
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
