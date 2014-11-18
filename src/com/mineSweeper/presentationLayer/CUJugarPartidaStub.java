package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CUJugarPartida;
import com.mineSweeper.domainLayer.struct.Dades;
import com.mineSweeper.domainLayer.struct.Resultat;

/**
 * Created by qiaorui on 11/17/14.
 */
public class CUJugarPartidaStub extends CUJugarPartida{

    private String username = "admin";
    private String password = "admin";
    private Dades[] dades;


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

    }

    @Override
    public Resultat descobrirCasella(int fila, int columna) {
        return new Resultat();
    }

    @Override
    public void marcarCasella(int fila, int columna) {

    }

    @Override
    public void desmarcarCasella(int fila, int columna) {

    }
}
