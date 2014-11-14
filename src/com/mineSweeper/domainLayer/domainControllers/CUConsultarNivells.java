package com.mineSweeper.domainLayer.domainControllers;


import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.struct.Dades;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by qiaorui on 14-10-28.
 */
public class CUConsultarNivells {

    public CUConsultarNivells() {

    }

    public Dades[] consultarNivells() {
        DataControllerFactory dataControllerFactory = DataControllerFactory.getInstance();
        Nivell[] nivells = dataControllerFactory.getCtrlNivell().getAll();
        if (nivells.length == 0);
        Dades[] dades = new Dades[nivells.length];
        for (int i = 0; i < nivells.length; ++i) {
            dades[i] = nivells[i].getDades();
        }
        return dades;
    }

}
