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

    /**
     * Jugador
     * Crea un jugador buit
     */
    public Jugador() {
    }

    /**
     * jugaPartida
     * El jugador juga la partida
     * @param partida La partida que el jugador juga
     */
    public void jugaPartida(Partida partida) {
        partidaActual = partida;
    }

    /**
     * getEmail
     * @return email del jugador
     */
    @Column(unique = true, nullable= false)
    public String getEmail() {
		return email;
	}

    /**
     * setEmail
     * @param email email del jugador
     */
	public void setEmail(String email) {
		this.email = email;
	}

    /**
     * getPartidaActual
     * @return partida que el jugador esta jugant
     */
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PartidaActualId")
	public Partida getPartidaActual() {
		return partidaActual;
	}

    /**
     * setPartidaActual
     * @param partidaActual Partida que el jugador juga
     */
	public void setPartidaActual(Partida partidaActual) {
		this.partidaActual = partidaActual;
	}

    /**
     * getPartidaJugada
     * @return Totes les partides que el jugador ha jugat
     */
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "PartidaJugada", joinColumns = {@JoinColumn(name="Jugador_Username")},
     inverseJoinColumns = {@JoinColumn(name="partida_id")} )
	public List<Partida> getPartidaJugada() {
		return partidaJugada;
	}

    /**
     * setPartidaJugada
     * @param partidaJugada Una lista de partida que el jugador ha jugat.
     */
	public void setPartidaJugada(List<Partida> partidaJugada) {
		this.partidaJugada = partidaJugada;
	}

    /**
     * acabaPartidaActual
     * El jugador acaba la partida actual, doncs la partida actual passa a ser partida jugada.
     */
	public void acabaPartidaActual() {
        partidaJugada.add(partidaActual);
        partidaActual = null;
    }


}
