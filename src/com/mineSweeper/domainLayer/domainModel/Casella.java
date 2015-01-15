package com.mineSweeper.domainLayer.domainModel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Casella  implements Serializable{
	
    private int numeroFila;
    private int numeroColumna;
    private int numero;
    private boolean estaDescoberta;
    private boolean estaMarcada;
    private boolean teMina;
    private Partida partida;
    
    Casella() {
    	
    }
    @Id
    @ManyToOne
    @JoinColumn(name="PartidaId")
    public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Id
    public int getNumeroFila() {
		return numeroFila;
	}

	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}
	@Id
	public int getNumeroColumna() {
		return numeroColumna;
	}

	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}

	public boolean isEstaDescoberta() {
		return estaDescoberta;
	}

	public void setEstaDescoberta(boolean estaDescoberta) {
		this.estaDescoberta = estaDescoberta;
	}

	public boolean isEstaMarcada() {
		return estaMarcada;
	}

	public void setEstaMarcada(boolean estaMarcada) {
		this.estaMarcada = estaMarcada;
	}

	public boolean isTeMina() {
		return teMina;
	}

	public void setTeMina(boolean teMina) {
		this.teMina = teMina;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Casella(int numeroFila, int numeroColumna, Partida partida) {
        this.numeroFila = numeroFila;
        this.partida = partida;
        this.numeroColumna = numeroColumna;
        numero = 0;
        estaDescoberta = false;
        estaMarcada = false;
        teMina = false;
    }

    public int getNumero() {
        return numero;
    }

/*
    public void marcarCasella() {
        if (estaDescoberta); //exc jaDescoberta
        else if (estaMarcada); //exc jaMarcada
        else estaMarcada = true;
    }

    public boolean desmarcarCasella() {
        //if (estaDescoberta); //exc jaDescoberta
        if (!estaMarcada) ; //exc noMarcada
        else estaMarcada = false;
    }*/

    public boolean marcarDesmarcarCasella() throws RuntimeException{
        if (estaDescoberta) {
            throw new RuntimeException("La casella esta descoberta");
        }
        else {
            if (!estaMarcada) estaMarcada = true; //exc noMarcada
            else estaMarcada = false;
        }
        return estaMarcada;
    }

    public void assignarMina() {
        teMina = true;
    }

    public boolean teMina() {
        return teMina;
    }

    public boolean estaDescoberta() {
        return estaDescoberta;
    }

    public boolean estaMarcada() {
        return estaMarcada;
    }

    public void sumNum() {
        numero++;
    }

    public boolean descobrirCasella() {
        if (estaMarcada) throw new RuntimeException("La casella esta marcada"); //exc: jaMarcada
        else if (estaDescoberta) throw new RuntimeException("La casella esta descoberta"); //exc: jaDescoberta
        else estaDescoberta = true;
        return teMina;
    }
}
