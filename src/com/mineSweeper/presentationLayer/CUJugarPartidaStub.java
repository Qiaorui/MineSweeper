package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.domainControllers.CUJugarPartida;
import com.mineSweeper.domainLayer.domainModel.Administrator;
import com.mineSweeper.domainLayer.struct.Dades;
import com.mineSweeper.domainLayer.struct.InformacioDeCasella;
import com.mineSweeper.domainLayer.struct.Resultat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/**
 * Created by qiaorui on 11/17/14.
 */
public class CUJugarPartidaStub extends CUJugarPartida{

    private String username = "admin";
    private String password = "admin";
    private Dades[] dades;
    private int[][] map;
    private boolean[][] descobrit;
    private boolean[][] mina;
    private boolean[][] marcat;

    private class Posicio {
        public int x, y;
        public Posicio(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode(){
            return (x + y)*(x + y + 1)/2 + y;
        }


        @Override
        public boolean equals(Object object){
            Posicio posicio = (Posicio)object;
            return (this.x == posicio.x && this.y == posicio.y);
        }
    }

    public CUJugarPartidaStub() {
        dades = new Dades[3];
        dades[0] = new Dades();
        dades[0].nom = "principante";
        dades[0].nombreCasellaxColumna = 9;
        dades[0].nombreCasellaxFila = 9;
        dades[0].nombreMines = 10;
        dades[1] = new Dades();
        dades[1].nom = "intermedio";
        dades[1].nombreCasellaxColumna = 16;
        dades[1].nombreCasellaxFila = 16;
        dades[1].nombreMines = 40;
        dades[2] = new Dades();
        dades[2].nom = "avanzado";
        dades[2].nombreCasellaxColumna = 30;
        dades[2].nombreCasellaxFila = 16;
        dades[2].nombreMines = 99;
    }

    /**
     * ferAutenticacio
     * @param username El username del jugador que autenticara.
     * @param password El password del jugador que autenticara.
     */
    @Override
    public void ferAutenticacio(String username, String password) {

        if (this.username != username);

    }


    /**
     * Dades Obte les dades de tots els nivells
     * @return
     */
    @Override
    public Dades[] obtenirNivells() {
        return dades;
    }

    /**
     * crearPartida crea la partida amb el nivell nivellNom
     * @param nivellNom El nom del nivell.
     */
    @Override
    public void crearPartida(String nivellNom) {
        if (nivellNom == "principante") {
            map = new int[9][9];
            descobrit = new boolean[9][9];
            marcat = new boolean [9][9];
            mina =  new boolean[9][9];
            assignarMines(10);
        }

        if (nivellNom == "intermedio") {
            map = new int[16][16];
            descobrit = new boolean[16][16];
            marcat = new boolean[16][16];
            mina =  new boolean[16][16];
            assignarMines(40);
        }

        if (nivellNom == "avanzado") {
            map = new int[16][30];
            descobrit = new boolean[16][30];
            marcat = new boolean[16][30];
            mina =  new boolean[16][30];
            assignarMines(99);
        }
        for (int i=0; i <map.length;++i) {
            for (int j=0; j<map[0].length;++j){
                if (mina[i][j])AdministratorShell.getInstance().showText("1 ");
                else AdministratorShell.getInstance().showText("0 ");
            }
            AdministratorShell.getInstance().showText("\n");
        }
    }

    /**
     * descobrirCasella Actualitza la taula i la retorna
     * @param fila La fila de la casella que vol descobrir.
     * @param columna La columna de la casella que vol descobrir.
     * @return
     */
    @Override
    public Resultat descobrirCasella(int fila, int columna) {
        Resultat resultat = new Resultat();
        descobrit[fila][columna] =true;
        if (mina[fila][columna]) {
            resultat.acabada = true;
            resultat.guanyada = false;
        }
        else {
            resultat.informacioDeCasellas.add(new InformacioDeCasella(fila, columna, map[fila][columna]));
            if (map[fila][columna] == 0) descobrirVeins(fila,columna,resultat);
            if (comprovaPartidaGuanyada()) {
                AdministratorShell.getInstance().showText("Guanyat!!\n");
                resultat.acabada = resultat.guanyada = true;
                resultat.puntuacio = 999;
            }
        }

        return resultat;
    }
/*
    @Override
    public void marcarCasella(int fila, int columna) throws RuntimeException{
        if (marcat[fila][columna]) throw new RuntimeException("La casella ja està marcada");
        else marcat[fila][columna] = true;
    }

    @Override
    public void desmarcarCasella(int fila, int columna) {
        if (!marcat[fila][columna]) throw new RuntimeException("La casella no està marcada");
        else marcat[fila][columna] = false;
    }*/

    /**
     * marcarDesmarcarCasella Marca o desmarca la casella en la posicio (fila,columa)
     * @param fila La fila de la casella que vol marcar o desmarcar.
     * @param columna La columna de la casella que vol marcar o desmarcar.
     * @return
     */
    @Override
    public boolean marcarDesmarcarCasella(int fila, int columna) {
        marcat[fila][columna] = !marcat[fila][columna];
        return marcat[fila][columna];
    }

    /**
     * getMines Retorna la informacio de les caselles
     * @return
     */
    @Override
    public ArrayList<InformacioDeCasella> getMines() {
        ArrayList<InformacioDeCasella> informacioDeCasellas = new ArrayList<InformacioDeCasella>();
        for (int i=0; i < map.length; ++i) {
            for (int j = 0; j < map[0].length; ++j){
                if (mina[i][j]) informacioDeCasellas.add(new InformacioDeCasella(i,j,-1));
            }
        }
        return informacioDeCasellas;
    }

    /**
     * descobrirVeins Descobreix els veins de la casella en la posicio (fila,columa) i actualitza el resultat de la taula
     * @param fila fila de la casella descoberta
     * @param columna columna de la casella descoberta
     * @param resultat estat de la taula
     */
    private void descobrirVeins(int fila, int columna, Resultat resultat) {
        for (int i = fila-1; i < fila+2; i++) {
            for (int j = columna-1; j < columna+2; j++) {
                if (i >= 0 && i < map.length && j >= 0 && j < map[0].length) {
                    if (!descobrit[i][j]) {
                        descobrit[i][j]= true;
                        resultat.informacioDeCasellas.add(new InformacioDeCasella(i,j,map[i][j]));
                        if (map[i][j] == 0) descobrirVeins(i,j,resultat);
                    }
                }
            }
        }
    }

    /**
     * assignarMines Assigna les mines segons nMines dins el tauler aleatoriament
     * @param nMines Numero de mines del nivell
     */
    private void assignarMines(int nMines) {


        HashSet<Posicio> mines = new HashSet<Posicio>();
        while (mines.size() < nMines) {
            mines.add(new Posicio((int)(Math.random()*map.length), (int)(Math.random()*map[0].length)));
        }
        for (Posicio posicio : mines){
            mina[posicio.x][posicio.y] = true;
            for (int i = posicio.x-1; i < posicio.x+2; i++) {
                for (int j = posicio.y-1; j < posicio.y+2; j++) {
                    if (i >= 0 && i < map.length && j >= 0 && j < map[0].length) {
                        if (!mina[i][j]) map[i][j]++;
                    }
                }
            }
        }
    }

    /**
     * comprovaPartidaGuanyada Comprova si despres de descobrir casella s'ha guanyat la partida
     * @return retorna un boolea indicant si ha estat guanyada
     */
    private boolean comprovaPartidaGuanyada() {
        boolean guanyada = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                //AdministratorShell.getInstance().showText("casella "+i+" "+j+" comprova :"+descobrit[i][j]+"\n");
                if (!mina[i][j] && !descobrit[i][j]) guanyada = false;
            }
        }
        return guanyada;
    }

}
