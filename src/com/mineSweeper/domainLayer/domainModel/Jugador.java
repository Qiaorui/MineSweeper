package com.mineSweeper.domainLayer.domainModel;

import java.util.ArrayList;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Jugador extends UsuariRegistrat {

    private String email;
    private Partida partidaActual;
    private ArrayList<Partida> partidaJugada;

    public Jugador() {

    }

    public void jugaParida(Partida partida) {
        partidaActual = partida;
    }

    public void acabaPartidaAcutual() {
        partidaJugada.add(partidaActual);
        partidaActual = null;
    }


}
