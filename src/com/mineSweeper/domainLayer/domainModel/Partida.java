package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Partida {

    private Nivell nivell;
    private EstrategiaPuntuacio estrategiaPuntuacio;
    private Casella[][] casella;
    private int idPartida;
    private boolean estaAcabada;
    private boolean estaguanyada;
    private int nombreTirades;

    public class Resultat {
        public boolean acabada;
        public boolean guanyada;
        public int puntuacio;
    }

    public Partida(Nivell nivell) {

    }

    public void marcarPartida(int fila, int columna) {

    }

    public void desmarcarPartida(int fila, int columna) {

    }

    public Resultat descobrirCasella(int fila, int columna) {
        return null;
    }

    public void descobrirVeins(int fila, int columna) {

    }

    public boolean comprovaPartidaGuanyada() {
        return false;
    }

    public void assignarMines(int nMines) {

    }
}