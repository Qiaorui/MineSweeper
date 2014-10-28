package codigo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Nivel {
	private String nom;
	private int nombreCasellesxFila;
	private int nombreCasellesxColumna;
	private int nombreMines;
	
	@Id
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNombreCasellesxFila() {
		return nombreCasellesxFila;
	}
	public void setNombreCasellesxFila(int nombreCasellesxFila) {
		this.nombreCasellesxFila = nombreCasellesxFila;
	}
	public int getNombreCasellesxColumna() {
		return nombreCasellesxColumna;
	}
	public void setNombreCasellesxColumna(int nombreCasellesxColumna) {
		this.nombreCasellesxColumna = nombreCasellesxColumna;
	}
	public int getNombreMines() {
		return nombreMines;
	}
	public void setNombreMines(int nombreMines) {
		this.nombreMines = nombreMines;
	}
}
