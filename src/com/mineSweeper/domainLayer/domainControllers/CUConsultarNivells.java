package com.mineSweeper.domainLayer.domainControllers;



import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.struct.Dades;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by qiaorui on 14-10-28.
 */
public class CUConsultarNivells {
    /**
     * CUConsultarNivells
     * Crea una instancia del caso de uso ConsultarNivells
     */
    public CUConsultarNivells() {

    }

    /**
     * consultarNivells
     * Consulta informacion sobre los niveles guardados en el sistema
     * @return dades Los datos de los niveles guardados
     * @exception java.lang.RuntimeException Si no hi ha cap nivel
     */
    public Dades[] consultarNivells() {
        DataControllerFactory dataControllerFactory = DataControllerFactory.getInstance();
        List nivells = dataControllerFactory.getCtrlNivell().getAll();
        
        if (nivells.size() == 0) throw new RuntimeException("No hi ha nivells"); //throw an exception
        
        Dades[] dades = new Dades[nivells.size()];
        
        int i = 0;
        for (Iterator iterator1 = nivells.iterator(); iterator1.hasNext();)
        	{
        	Nivell nivell = (Nivell) iterator1.next();
        	dades[i] = nivell.Dades();
        	i++;
        }
        
        return dades;
    }

}
