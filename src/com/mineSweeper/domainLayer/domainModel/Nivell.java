package com.mineSweeper.domainLayer.domainModel;




import javax.persistence.Id;
import javax.persistence.Entity;

import com.mineSweeper.domainLayer.struct.Dades;

@Entity
public class Nivell {

    private String nom;
    private int nombreCasellaxFila;
    private int nombreCasellaxColumna;
    private int nombreMines;

    @Id
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNombreCasellaxFila(int nombreCasellaxFila) {
		this.nombreCasellaxFila = nombreCasellaxFila;
	}

	public void setNombreCasellaxColumna(int nombreCasellaxColumna) {
		this.nombreCasellaxColumna = nombreCasellaxColumna;
	}

	public void setNombreMines(int nombreMines) {
		this.nombreMines = nombreMines;
	}

	public int getNombreCasellaxFila() {
        return nombreCasellaxFila;
    }

    public int getNombreCasellaxColumna() {
        return nombreCasellaxColumna;
    }

    public int getNombreMines() {
        return nombreMines;
    }

    public Dades Dades() {
        Dades dades = new Dades();
        dades.nom = nom;
        dades.nombreCasellaxColumna = nombreCasellaxColumna;
        dades.nombreCasellaxFila = nombreCasellaxFila;
        dades.nombreMines = nombreMines;
        return dades;
    }
}
