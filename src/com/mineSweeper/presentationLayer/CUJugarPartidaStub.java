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

    @Override
    public void ferAutenticaicio(String username, String password) {

        if (this.username != username);

    }

    @Override
    public Dades[] obtenirNivells() {
        return dades;
    }

    @Override
    public void crearPartida(String nivellNom) {
        if (nivellNom == "principante") {
            map = new int[9][9];
            descobrit = new boolean[9][9];
            mina =  new boolean[9][9];
            assignarMines(10);
        }

        if (nivellNom == "intermedio") {
            map = new int[16][16];
            descobrit = new boolean[16][16];
            mina =  new boolean[16][16];
            assignarMines(40);
        }

        if (nivellNom == "avanzado") {
            map = new int[16][30];
            descobrit = new boolean[16][30];
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

    @Override
    public void marcarCasella(int fila, int columna) {

    }

    @Override
    public void desmarcarCasella(int fila, int columna) {

    }

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
