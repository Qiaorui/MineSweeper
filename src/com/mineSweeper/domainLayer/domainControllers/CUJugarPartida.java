package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Jugador;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.domainModel.Partida;
import com.mineSweeper.domainLayer.struct.Dades;
import com.mineSweeper.domainLayer.struct.Resultat;

import java.util.Set;

/**
 * Created by qiaorui on 14-10-28.
 */
public class CUJugarPartida {

    private Partida partida;
    private Jugador jugador;

    public CUJugarPartida() {

    }

    public void ferAutenticaicio(String username, String password) {
        CULogin cuLogin = new CULogin();
        cuLogin.Login(username, password);
        DataControllerFactory dataControllerFactory = DataControllerFactory.getInstance();
        jugador = dataControllerFactory.getCtrlJugador().getJugador(username);
    }

    public Set<Dades> obtenirNivells() {

        return null;
    }

    public void crearPartida(String nivell) {

    }

    public Resultat descobrirCasella(int fila, int columna) {
        return null;
    }

    public void marcarCasella(int fila, int columna) {

    }

    public void desmarcarCasella(int fila, int columna) {

    }
}
