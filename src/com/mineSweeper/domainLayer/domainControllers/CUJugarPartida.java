package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.dataInterface.CtrlCasella;
import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Casella;
import com.mineSweeper.domainLayer.domainModel.Jugador;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.domainModel.Partida;
import com.mineSweeper.domainLayer.struct.Dades;
import com.mineSweeper.domainLayer.struct.InformacioDeCasella;
import com.mineSweeper.domainLayer.struct.Resultat;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by qiaorui on 14-10-28.
 */
public class CUJugarPartida {

    private Partida partida;
    private Jugador jugador;

    /**
     * CUJugarPartida
     * Crea una instrancia de Caso de uso de Jugar Partida.
     */
    public CUJugarPartida() {

    }

    /**
     * ferAutenticacio
     * Autenticar un jugador, y guarda al sistema.
     * @param username El username del jugador que autenticara.
     * @param password El password del jugador que autenticara.
     * @exception java.lang.RuntimeException usuario no es jugador
     */
    public void ferAutenticacio(String username, String password) {
        CULogin cuLogin = new CULogin();
        cuLogin.Login(username, password);
        jugador = DataControllerFactory.getInstance().getCtrlJugador().getJugador(username);
        if (jugador == null) throw new RuntimeException("L'usuari no es jugador");
    }

    /**
     * obtenirNivells
     * Obtenir tot nivells que hi ha al sistema
     * @return Dades dades de tots nivells
     * @see com.mineSweeper.domainLayer.struct.Dades
     */
    public Dades[] obtenirNivells() {
        CUConsultarNivells cuConsultarNivells = new CUConsultarNivells();
        return cuConsultarNivells.consultarNivells();
    }

    /**
     * creaPartida
     * crea una partida nueva amb nivel donat
     * @param nivellNom El nom del nivell.
     * Canvi respecte disseny original: afegir funcions de BBDD
     */
    public void crearPartida(String nivellNom) {
	        Nivell nivell = DataControllerFactory.getInstance().getCtrlNivell().getNivell(nivellNom);
	        partida = new Partida(nivell, jugador);
	        DataControllerFactory.getInstance().getCtrlPartida().createPartida(partida);
	        jugador.jugaPartida(partida);
	        DataControllerFactory.getInstance().getCtrlJugador().updateJugador(jugador);
	        Casella[] c = partida.obtenerCasellas();
	        for(int i = 0; i < c.length; i++) {
	        	DataControllerFactory.getInstance().getCtrlCasella().createCasella(c[i]);
	        }
    }

    /**
     * descobrirCasella
     * El usuario descobre una casella.
     * @param fila La fila de la casella que vol descobrir.
     * @param columna La columna de la casella que vol descobrir.
     * @return Resultat resultat del descobrir.
     * @see com.mineSweeper.domainLayer.struct.Resultat
     * Canvi respecte disseny original: afegir funcions de BBDD
     */
    public Resultat descobrirCasella(int fila, int columna) {

        Resultat resultat = partida.descobrirCasella(fila, columna);
        if(resultat.informacioDeCasellas.size() > 0) {
        	for(int i = 0; i < resultat.informacioDeCasellas.size(); i++) {
        		CtrlCasella cc = DataControllerFactory.getInstance().getCtrlCasella();
        		cc.updateCasellas(
        				partida.obtenerCasella(resultat.informacioDeCasellas.get(i).numeroFila, 
        				resultat.informacioDeCasellas.get(i).numeroColumna));
        		
                AdministratorShell.getInstance().showText("updating casella "
                        +resultat.informacioDeCasellas.get(i).numeroFila+"X"
                        +resultat.informacioDeCasellas.get(i).numeroColumna+"\n");
        	}
        }
        if (resultat.acabada)  {
        	jugador.acabaPartidaActual();
        	DataControllerFactory.getInstance().getCtrlPartida().updatePartida(partida);
        	DataControllerFactory.getInstance().getCtrlJugador().updateJugador(jugador);
        }
        return resultat;
    }

    /**
     * getMines
     * Retorna totes les posicions de totes mines de la partida actual.
     * @return una lista de posicions de totes les caselles que tenen mines.
     * @see com.mineSweeper.domainLayer.struct.InformacioDeCasella
     * Canvi respecte disseny original: aquest es un nova función, per mostrar les mines en la partida.
     */
    public ArrayList<InformacioDeCasella> getMines(){
        return partida.obtenerMines();
    }

    /**
     * marcarDesmarcarCasella
     * Marcar o demarcar una casella.
     * @param fila La fila de la casella que vol marcar o desmarcar.
     * @param columna La columna de la casella que vol marcar o desmarcar.
     * @return cert
     * Canvi respecte disseny original: combinar marcarCasella y desmarcarCasella del disseny original per
     * estalviar excepcions i facilitar el caso de uso.
     */
    public boolean marcarDesmarcarCasella(int fila, int columna) {
    	boolean aux = partida.marcarDesmarcarCasella(fila, columna);
    	CtrlCasella cc = DataControllerFactory.getInstance().getCtrlCasella();
		cc.updateCasellas(partida.obtenerCasella(fila, columna));
    	return aux;
    }
}
