package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CUConsultarNivells;

/**
 * Created by qiaorui on 11/18/14.
 */
public class CConsultarNivell implements InterfaceConsultarNivell{

    private ConsultarNivellView consultarNivellView;
    private CUConsultarNivells cuConsultarNivells;

    public CConsultarNivell(CUConsultarNivells cuConsultarNivells) {
    	this.cuConsultarNivells = cuConsultarNivells;
        consultarNivellView = new ConsultarNivellView(this);
    }

    public void inicializar() {
        consultarNivellView.inicializar(cuConsultarNivells.consultarNivells());

    }

    @Override
    public void prOkCrearPartida(String nivell, int fila, int columna) {
        consultarNivellView.tancar();
    }

    @Override
    public void prCancel() {
        consultarNivellView.tancar();
    }
}
