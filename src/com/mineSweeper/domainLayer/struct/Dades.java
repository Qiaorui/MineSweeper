package com.mineSweeper.domainLayer.struct;

/**
 * Created by qiaorui on 11/6/14.
 */
public class Dades {
    public String nom;
    public int nombreCasellaxFila;
    public int nombreCasellaxColumna;
    public int nombreMines;

    public Dades() {

    }
    public Dades(String nom, int nombreCasellaxFila, int nombreCasellaxColumna, int nombreMines) {
        this.nom = nom;
        this.nombreCasellaxFila = nombreCasellaxFila;
        this.nombreCasellaxColumna = nombreCasellaxColumna;
        this.nombreMines = nombreMines;
    }


}
