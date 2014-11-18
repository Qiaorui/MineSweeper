package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.struct.Dades;

/**
 * Created by qiaorui on 11/18/14.
 */
public class ConsultarNivellView {

    CConsultarNivell cConsultarNivell;
    ConsultarNivellFrame consultarNivellFrame;

    public ConsultarNivellView(CConsultarNivell cConsultarNivell){
        this.cConsultarNivell = cConsultarNivell;
    }

    public void inicializar(Dades[] dades){
        consultarNivellFrame = new ConsultarNivellFrame(cConsultarNivell);
        consultarNivellFrame.inicializar(dades);
        consultarNivellFrame.setVisible(true);
    }


    public void tancar(){
        consultarNivellFrame.dispose();
    }
}
