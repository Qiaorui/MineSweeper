package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CUConsultarNivells;

import javax.swing.*;

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
        try {
            consultarNivellView.inicializar(cuConsultarNivells.consultarNivells());
        }
        catch (RuntimeException e)
        {
            if (e.getMessage() != null) JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }

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
