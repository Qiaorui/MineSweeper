package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.struct.Dades;

/**
 * Created by qiaorui on 11/18/14.
 */
public class ConsultarNivellView {

    CConsultarNivell cConsultarNivell;
    ConsultarNivellFrame consultarNivellFrame;

    /**
     * ConsultarNivellView Creadora de la classe
     * @param cConsultarNivell
     */
    public ConsultarNivellView(CConsultarNivell cConsultarNivell){
        this.cConsultarNivell = cConsultarNivell;
    }

    /**
     * inicializar inicialitza la pantalla de consulta de nivell amb les dades de tots els nivells
     * @param dades
     */
    public void inicializar(Dades[] dades){
    	AdministratorShell.getInstance().showText("Dades : " +dades.length);
        consultarNivellFrame = new ConsultarNivellFrame(cConsultarNivell);
        consultarNivellFrame.inicializar(dades);
        consultarNivellFrame.setVisible(true);
    }

    /**
     * tancar tanca la finestra
     */
    public void tancar(){
        consultarNivellFrame.dispose();
    }
}
