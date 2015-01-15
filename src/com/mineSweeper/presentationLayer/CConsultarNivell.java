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

    /**
     * prOkCrearPartida tanca la finestra de Consulta Nivell
     * @param nivell nom del nivell escollit
     * @param fila nombre de files del nivell
     * @param columna nombre de columnes del nivell
     */
    @Override
    public void prOkCrearPartida(String nivell, int fila, int columna) {
        consultarNivellView.tancar();
    }

    /**
     * prCancel tanca la finestra de Consulta Nivell
     */
    @Override
    public void prCancel() {
        consultarNivellView.tancar();
    }
}
