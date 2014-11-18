package com.mineSweeper.presentationLayer;

/**
 * Created by qiaorui on 11/18/14.
 */
public class CConsultarNivell implements InterfaceConsultarNivell{

    private ConsultarNivellView consultarNivellView;

    public CConsultarNivell() {
        consultarNivellView = new ConsultarNivellView(this);
    }

    public void inicializar() {
        consultarNivellView.inicializar(null);

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
