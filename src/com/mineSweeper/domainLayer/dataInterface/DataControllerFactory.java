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


    /**
     * DataControllerFactory
     * Crea una instancia de la clase DataControllerFactory
     */
	private DataControllerFactory(){
    	
    }


    /**
     * getInstance
     * @return La instancia de DataControllerFactory
     */
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

    /**
     * getCtrlJugador
     * @return El controlador de datos de jugador
     */
    public CtrlJugador getCtrlJugador() {
    	if(ctrlJugador == null )ctrlJugador = new CtrlJugadorBD();
        return ctrlJugador;
    }

    /**
     * getCtrlNivell
     * @return El controlador de datos de nivel
     */
    public CtrlNivell getCtrlNivell() {
    	if(ctrlNivell == null )ctrlNivell = new CtrlNivellBD();
        return ctrlNivell;
    }

    /**
     * getCtrlPartida
     * @return El controlador de datos de partida
     */
    public CtrlPartida getCtrlPartida() {
    	if(ctrlPartida == null )ctrlPartida = new CtrlPartidaBD();
		return ctrlPartida;
	}

    /**
     * getCtrlUsuariRegistrat
     * @return El controlador de datos de usuario registrado
     */
    public CtrlUsuariRegistrat getCtrlUsuariRegistrat() {
    	if(ctrlUsuariRegistrat == null )ctrlUsuariRegistrat = new CtrlUsuariRegistratBD();
        return ctrlUsuariRegistrat;
    }

    /**
     * getCtrlUsuariRegistrat
     * @return El controlador de datos para puntuar por tiradas
     */
    public CtrlPuntuarPerTirades getCtrlPuntuarPerTirades() {
        return ctrlPuntuarPerTirades;
    }

    /**
     * getCtrlCasella
     * @return El controlador de datos de casilla
     */
    public CtrlCasella getCtrlCasella() {
    	if(ctrlCasella == null )ctrlCasella = new CtrlCasellaBD();
        return ctrlCasella;
	}

    
}
