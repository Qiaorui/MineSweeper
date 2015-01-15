package com.mineSweeper.domainLayer.domainModel;

import java.util.List;









import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
@DiscriminatorValue("Jugador")
public class Jugador extends UsuariRegistrat {

    private String email;
	/**
	 * partidaActual historial de partides jugades
	 */
    private Partida partidaActual;
    private List<Partida> partidaJugada;

    public Jugador() {
    }

    public void jugaParida(Partida partida) {
        partidaActual = partida;
    }
    
    @Column(unique = true, nullable= false)
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PartidaActualId")
	public Partida getPartidaActual() {
		return partidaActual;
	}

	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "PartidaJugada", joinColumns = {@JoinColumn(name="Jugador_Username")},
     inverseJoinColumns = {@JoinColumn(name="partida_id")} )
	public List<Partida> getPartidaJugada() {
		return partidaJugada;
	}

	public void setPartidaJugada(List<Partida> partidaJugada) {
		this.partidaJugada = partidaJugada;
	}

	public void acabaPartidaAcutual() {
        partidaJugada.add(partidaActual);
        partidaActual = null;
    }


}
