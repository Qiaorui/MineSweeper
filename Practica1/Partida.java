package codigo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Partida {
	private int nombreTirades;
	private int idPartida;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private Nivel niv;
	
	@OneToOne()
	@JoinColumn(name = "NivelNom",nullable = false, updatable=false)
	public Nivel getNiv() {
		return niv;
	}
	
	public void setNiv(Nivel niv) {
		this.niv = niv;
	}
	
	@Id
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	public int getNombreTirades() {
		return nombreTirades;
	}
	public void setNombreTirades(int nombreTirades) {
		this.nombreTirades = nombreTirades;
	}
	public boolean getEstaAcabada() {
		return estaAcabada;
	}
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	public boolean getEstaGuanyada() {
		return estaGuanyada;
	}
	public void setEstaGuanyada(boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}
	
	
	
	
	
}
