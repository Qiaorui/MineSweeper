package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CUConsultarNivells;

import javax.swing.*;


public class CConsultarNivell implements InterfaceConsultarNivell{

    private ConsultarNivellView consultarNivellView;
    private CUConsultarNivells cuConsultarNivells;

    /**
     * CConsultarNivell Creadora de la clase que implementa la interfície ConsultaNivell
     * @param cuConsultarNivells
     */
    public CConsultarNivell(CUConsultarNivells cuConsultarNivells) {
    	this.cuConsultarNivells = cuConsultarNivells;
        consultarNivellView = new ConsultarNivellView(this);
    }


    /**
     * inicializar inicialitza la finestra corresponent a la consulta
     * @Exception Agafa les excepcions i les mostra en un nou JDialog
     */
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
