package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.dataLayer.CtrlCasellaBD;
import com.mineSweeper.dataLayer.CtrlJugadorBD;
import com.mineSweeper.dataLayer.CtrlNivellBD;
import com.mineSweeper.dataLayer.CtrlPartidaBD;
import com.mineSweeper.dataLayer.CtrlUsuariRegistratBD;


public class DataControllerFactory {
    private static volatile DataControllerFactory instance;
    private CtrlJugador ctrlJugador;
    private CtrlNivell ctrlNivell;
    private CtrlUsuariRegistrat ctrlUsuariRegistrat;
    private CtrlPuntuarPerTirades ctrlPuntuarPerTirades;
    private CtrlPartida ctrlPartida;
    private CtrlCasella ctrlCasella;
    



	private DataControllerFactory(){
    	
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
    	if(ctrlJugador == null )ctrlJugador = new CtrlJugadorBD();
        return ctrlJugador;
    }

    public CtrlNivell getCtrlNivell() {
    	if(ctrlNivell == null )ctrlNivell = new CtrlNivellBD();
        return ctrlNivell;
    }
    
    public CtrlPartida getCtrlPartida() {
    	if(ctrlPartida == null )ctrlPartida = new CtrlPartidaBD();
		return ctrlPartida;
	}

    public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
    	if(ctrlUsuariRegistrat == null )ctrlUsuariRegistrat = new CtrlUsuariRegistratBD();
        return ctrlUsuariRegistrat;
    }

    public CtrlPuntuarPerTirades getCtrlPuntuarPerTirades() {
        return ctrlPuntuarPerTirades;
    }
    
    public CtrlCasella getCtrlCasella() {
    	if(ctrlCasella == null )ctrlCasella = new CtrlCasellaBD();
        return ctrlCasella;
	}

    
}
