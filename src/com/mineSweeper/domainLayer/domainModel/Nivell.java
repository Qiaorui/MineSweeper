package com.mineSweeper.domainLayer.domainModel;

import com.mineSweeper.domainLayer.struct.Dades;

/**
 * Created by qiaorui on 14-10-29.
 */
public class Nivell {

    private String nom;
    private int nombreCasellaxFila;
    private int nombreCasellaxColumna;
    private int nombreMines;



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
