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

    /**
     * Casella
     * Crea una nueva instancia de la clase casilla
     */
    Casella() {
    	
    }
    @Id
    @ManyToOne
    @JoinColumn(name="PartidaId")
    /**
     * getPartida
     * Devuelve la partida a la que pertenece la casilla
     * @return La partida actual
     */
    public Partida getPartida() {
		return partida;
	}

    /**
     * setPartida
     * Define la partida a la que pertenece la casilla
     * @param partida La partida a la que pertenece la casilla
     */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Id
    /**
     * getNumeroFila
     * @return El numero de la fila en la que esta la casilla
     */
    public int getNumeroFila() {
		return numeroFila;
	}

    /**
     * setNumeroFila
     * Define la fila a la que pertenece la casilla
     * @param numeroFila Numero de la fila donde se situa la casilla
     */
	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}
	@Id
    /**
     * getNumeroColumna
     * @return El numero de la columna en la que esta la casilla
     */
	public int getNumeroColumna() {
		return numeroColumna;
	}
    /**
     * setNumeroFila
     * Define la fila a la que pertenece la casilla
     * @param numeroColumna Numero de la columna donde se situa la casilla
     */
	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}

    /**
     * isEstaDescoberta
     * @return Cierto si la casilla esta descubierta, falso de lo contrario
     */
	public boolean isEstaDescoberta() {
		return estaDescoberta;
	}

    /**
     * setEstaDescoberta
     * Cubre o descubre la casilla en funcion del parametro
     * @param estaDescoberta Cierto para descubrir la casilla, falso para cubrirla
     */
	public void setEstaDescoberta(boolean estaDescoberta) {
		this.estaDescoberta = estaDescoberta;
	}

    /**
     * isEstaMarcada
     * @return Cierto si la casilla esta marcada, falso de lo contrario
     */
	public boolean isEstaMarcada() {
		return estaMarcada;
	}

    /**
     * setEstaMarcada
     * Marca o desmarca la casilla en funcion del parametro
     * @param estaMarcada Cierto para marcar la casilla, falso para desmarcarla
     */
	public void setEstaMarcada(boolean estaMarcada) {
		this.estaMarcada = estaMarcada;
	}

    /**
     * isTeMina
     * @return Cierto si hay una mina en la casilla, falso de lo contrario
     */
	public boolean isTeMina() {
		return teMina;
	}

    /**
     * teMina
     * @param teMina Cierto si hay una mina en la casilla, falso si no la hay
     */
	public void setTeMina(boolean teMina) {
		this.teMina = teMina;
	}

    /**
     * setNumero
     * Asigna el numero de minas adyacentes a la casilla
     * @param numero Numero de minas adyacentes a la casilla
     */
	public void setNumero(int numero) {
		this.numero = numero;
	}

    /**
     * Casella
     * Crea una instancia de la clase casilla con los parametros pasados
     * @param numeroFila El numero de la fila de la casilla
     * @param numeroColumna El numero de la columna de la casilla
     * @param partida La partida a la que pertenece la casilla
     */
	public Casella(int numeroFila, int numeroColumna, Partida partida) {
        this.numeroFila = numeroFila;
        this.partida = partida;
        this.numeroColumna = numeroColumna;
        numero = 0;
        estaDescoberta = false;
        estaMarcada = false;
        teMina = false;
    }

    /**
     * getNumero
     * @return El numero de minas adyacentes a la casilla
     */
    public int getNumero() {
        return numero;
    }

    /**
     * marcarDesmarcarCasella
     * Si la casilla esta marcada se desmarca, y viceversa. Si la casilla esta descubierta
     * no se puede ni marcar ni desmarcar.
     * @return Cierto si la casilla esta marcada, falso si esta desmarcada
     * @throws RuntimeException Si la casilla esta descubierta
     */
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

    /**
     * assignarMina
     * Pone una mina en la casilla
     */
    public void assignarMina() {
        teMina = true;
    }

    /**
     * teMina
     * @return Cierto si hay una mina en la casilla, falso de lo contrario
     */
    public boolean teMina() {
        return teMina;
    }

    /**
     * estaMarcada
     * @return Cierto si la casilla esta descubierta, falso de lo contrario
     */
    public boolean estaDescoberta() {
        return estaDescoberta;
    }

    /**
     * estaMarcada
     * @return Cierto si la casilla esta marcada, falso de lo contrario
     */
    public boolean estaMarcada() {
        return estaMarcada;
    }

    /**
     * sumNum
     * Aumenta en uno el numero de minas adyacentes a la casilla
     */
    public void sumNum() {
        numero++;
    }

    /**
     * descobrirCasella
     * Desubre la casilla, a no ser que la casilla ya esté descubierta o marcada
     * @return Cierto si hay una mina en la casilla, falso de lo contrario
     * @throws RuntimeException Si la casilla esta marcada o descubierta
     */
    public boolean descobrirCasella() {
        if (estaMarcada) throw new RuntimeException("La casella esta marcada"); //exc: jaMarcada
        else if (estaDescoberta) throw new RuntimeException("La casella esta descoberta"); //exc: jaDescoberta
        else estaDescoberta = true;
        return teMina;
    }
}
