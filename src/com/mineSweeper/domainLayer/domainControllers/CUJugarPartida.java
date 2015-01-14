package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
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

    public CUJugarPartida() {

    }

    public void ferAutenticacio(String username, String password) {
        CULogin cuLogin = new CULogin();
        cuLogin.Login(username, password);
        jugador = DataControllerFactory.getInstance().getCtrlJugador().getJugador(username);
        if (jugador == null) throw new RuntimeException("L'usuari no es jugador");
    }

    public Dades[] obtenirNivells() {
        CUConsultarNivells cuConsultarNivells = new CUConsultarNivells();
        return cuConsultarNivells.consultarNivells();
    }

    public void crearPartida(String nivellNom) {
        Nivell nivell = DataControllerFactory.getInstance().getCtrlNivell().getNivell(nivellNom);
        
        
        partida = new Partida(nivell, jugador);
        DataControllerFactory.getInstance().getCtrlPartida().createPartida(partida);
        jugador.jugaParida(partida);
        DataControllerFactory.getInstance().getCtrlJugador().updateJugador(jugador);
    }

    public Resultat descobrirCasella(int fila, int columna) {
        Resultat resultat = partida.descobrirCasella(fila, columna);
        if (resultat.acabada)  {
        	jugador.acabaPartidaAcutual();
        	DataControllerFactory.getInstance().getCtrlPartida().createPartida(partida);
        	DataControllerFactory.getInstance().getCtrlJugador().updateJugador(jugador);
        }
        if(resultat.informacioDeCasellas.size() > 0) {
        	for(int i = 0; i < resultat.informacioDeCasellas.size(); i++) {
        		DataControllerFactory.getInstance().getCtrlCasella().updateCasellas
        		(partida.obtenercasella(resultat.informacioDeCasellas.get(i).numeroFila, 
        				resultat.informacioDeCasellas.get(i).numeroColumna));
        	}
        }
        return resultat;
    }

    public ArrayList<InformacioDeCasella> getMines(){
        return null;
    }
/*
    public void marcarCasella(int fila, int columna) {
        partida.marcarPartida(fila, columna);
    }

    public boolean desmarcarCasella(int fila, int columna) {
        return partida.desmarcarPartida(fila, columna);
    }
    */

    public boolean marcarDesmarcarCasella(int fila, int columna) {
        return partida.marcarDesmarcarCasella(fila, columna);
    }
}
