package com.mineSweeper.domainLayer.domainModel;

import com.mineSweeper.domainLayer.stragedyFactory.EstrategiaPuntuacioFactory;
import com.mineSweeper.domainLayer.struct.Resultat;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Partida {

    private Nivell nivell;
    private EstrategiaPuntuacio estrategiaPuntuacio;
    private Casella[][] casellas;
    private int idPartida;
    private boolean estaAcabada;
    private boolean estaguanyada;
    private int nombreTirades;


    private class Posicio {
        public int x, y;
        public Posicio(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Partida(Nivell nivell) {
        this.nivell = nivell;
        estaAcabada = false;
        estaguanyada = false;
        nombreTirades = 0;
        idPartida = Buscamines.getInstance().getIdPartida()+1;
        Buscamines.getInstance().incrementaId();
        int fila = this.nivell.getNombreCasellaxFila();
        int columna = this.nivell.getNombreCasellaxColumna();
        casellas = new Casella[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                casellas[i][j] = new Casella(i+1,j+1);
            }
        }
        assignarMines(nivell.getNombreMines());
        estrategiaPuntuacio = EstrategiaPuntuacioFactory.getInstance().getEstrategiaPuntuacioAleatori();
    }

    public void marcarPartida(int fila, int columna) {
        casellas[fila][columna].marcarCasella();
    }

    public void desmarcarPartida(int fila, int columna) {
        casellas[fila][columna].desmarcarCasella();
    }

    public Resultat descobrirCasella(int fila, int columna) {
        Resultat resultat = new Resultat();
        boolean teMina = casellas[fila][columna].descobrirCasella();
        nombreTirades++;
        if (teMina) {
            resultat.acabada = estaAcabada = true;
            resultat.guanyada = estaguanyada = false;
        }
        else {
            if (casellas[fila][columna].getNumero() == 0) descobrirVeins(fila, columna);
            boolean guanyada = comprovaPartidaGuanyada();
            resultat.guanyada = estaguanyada = guanyada;
            resultat.acabada = estaAcabada = guanyada;
            if (guanyada) {
                resultat.puntuacio = estrategiaPuntuacio.getPuntuacio(nombreTirades);
            }
        }
        return resultat;
    }

    private void descobrirVeins(int fila, int columna) {
        for (int i = fila-1; i < fila+2; i++) {
            for (int j = columna-1; j < columna+2; j++) {
                if (i >= 0 && i < casellas.length && j >= 0 && j < casellas[0].length) {
                    if (!casellas[i][j].estaDescoberta() && !casellas[i][j].estaMarcada()) {
                        casellas[i][j].descobrirCasella();
                        if (casellas[i][j].getNumero() == 0) descobrirVeins(i,j);
                    }
                }
            }
        }
    }

    private boolean comprovaPartidaGuanyada() {
        boolean guanyada = true;
        /*for (Casella casella : casellas) {
            if (!casella.teMina()) guanyada = casella.estaDescoberta();
        }*/
        for (int i = 0; i < casellas.length && guanyada; i++) {
            for (int j = 0; j < casellas[0].length && guanyada; j++) {
                if (!casellas[i][j].teMina()) guanyada = casellas[i][j].estaDescoberta();
            }
        }
        return guanyada;
    }

    private void assignarMines(int nMines) {
        HashSet<Posicio> mines = new HashSet<Posicio>();
        while (mines.size() < nMines) {
            mines.add(new Posicio((int)(Math.random()*casellas.length), (int)(Math.random()*casellas[0].length)));
        }
        for (Posicio posicio : mines){
            casellas[posicio.x][posicio.y].assignarMina();
            for (int i = posicio.x-1; i < posicio.x+2; i++) {
                for (int j = posicio.y-1; j < posicio.y+2; j++) {
                    if (i >= 0 && i < casellas.length && j >= 0 && j < casellas[0].length) {
                        if (!casellas[i][j].teMina()) casellas[i][j].sumNum();
                    }
                }
            }
        }
    }

}
