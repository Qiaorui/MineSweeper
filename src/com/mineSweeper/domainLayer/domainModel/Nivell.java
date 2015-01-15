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
    /**
     * getNom
     * Obtiene el nombre del identificador
     */
	public String getNom() {
		return nom;
	}

    /**
     * setNom
     * Hace un set del nombre del identificador
     * @param nom
     */
	public void setNom(String nom) {
		this.nom = nom;
	}

    /**
     * setNombreCasellaxFila
     * Hace un set del numero de casillas por fila en el nivel
     * @param nombreCasellaxFila
     */
	public void setNombreCasellaxFila(int nombreCasellaxFila) {
		this.nombreCasellaxFila = nombreCasellaxFila;
	}

    /**
     * setNombreCasellaxColumna
     * Hace un set del numero de casillas por columna en el nivel
     * @param nombreCasellaxColumna
     */
	public void setNombreCasellaxColumna(int nombreCasellaxColumna) {
		this.nombreCasellaxColumna = nombreCasellaxColumna;
	}

    /**
     * setNombreMines
     * Hace un set del numero de minas en el nivel
     * @param nombreMines
     */
	public void setNombreMines(int nombreMines) {
		this.nombreMines = nombreMines;
	}

    /**
     * getNombreCasellaxFila
     * Obtiene el numero de casillas por fila en el nivel
     * @return Numero de casillas por fila
     */
	public int getNombreCasellaxFila() {
        return nombreCasellaxFila;
    }

    /**
     * getNombreCasellaxColumna
     * Obtiene el numero de casillas por columna en el nivel
     * @return Numero de casillas por columna
     */
    public int getNombreCasellaxColumna() {
        return nombreCasellaxColumna;
    }

    /**
     * getNombreMines
     * Obtiene el numero de minas en el nivel
     * @return Numero de minas
     */
    public int getNombreMines() {
        return nombreMines;
    }

    /**
     * Dades
     * Obtiene una tupla con todos los parametros del nivel
     * @return Una instancia de dades con los parametros del nivel
     */
    public Dades Dades() {
        Dades dades = new Dades();
        dades.nom = nom;
        dades.nombreCasellaxColumna = nombreCasellaxColumna;
        dades.nombreCasellaxFila = nombreCasellaxFila;
        dades.nombreMines = nombreMines;
        return dades;
    }
}
