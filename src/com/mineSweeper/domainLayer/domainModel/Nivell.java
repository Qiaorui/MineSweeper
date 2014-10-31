package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Nivell {

    private String nom;
    private int nombreCasellaxFila;
    private int nombreCasellaxColumna;
    private int nombreMines;

    public class Dades {
        public String nom;
        public int nombreCasellaxFila;
        public int nombreCasellaxColumna;
        public int nombreMines;
    };

    public int getNombreCasellaxFila() {
        return nombreCasellaxFila;
    }

    public int getNombreCasellaxColumna() {
        return nombreCasellaxColumna;
    }

    public int getNombreMines() {
        return nombreMines;
    }

    public Dades getDades() {
        Dades dades = new Dades();
        dades.nom = nom;
        dades.nombreCasellaxColumna = nombreCasellaxColumna;
        dades.nombreCasellaxFila = nombreCasellaxFila;
        dades.nombreMines = nombreMines;
        return dades;
    }
}
