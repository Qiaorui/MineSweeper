package com.mineSweeper.domainLayer.domainModel;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.adapter.AdapterFactory;
import com.mineSweeper.domainLayer.stragedyFactory.EstrategiaPuntuacioFactory;
import com.mineSweeper.domainLayer.struct.InformacioDeCasella;
import com.mineSweeper.domainLayer.struct.Resultat;

import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.TableGenerator;

@Entity
public class Partida {

    private Nivell nivell;
    private EstrategiaPuntuacio estrategiaPuntuacio;
    private Casella[] casellas;
    private int partidaId;
    private boolean estaAcabada;
    private boolean estaguanyada;
    private int nombreTirades;
    private Jugador jugador;
    public Partida() {
	}

    /**
     * getNivell Getter de l'atribut nivell
     * @return
     */
    @OneToOne()
	@JoinColumn(name = "NivelNom",nullable = false, updatable=false)
    public Nivell getNivell() {
		return nivell;
	}

    /**
     * setNivell Setter de l'atribut nivell
     * @param nivell
     */
	public void setNivell(Nivell nivell) {
		this.nivell = nivell;
	}

    /**
     * obtenerEstrategiaPuntuacio Getter de l'estrategia de puntuacio
     * @return
     */
	public EstrategiaPuntuacio obtenerEstrategiaPuntuacio() {
		return estrategiaPuntuacio;
	}

    /**
     * setEstrategiaPuntuacio Setter de l'estrategia de puntuacio
     * @param estrategiaPuntuacio
     */
	public void setEstrategiaPuntuacio(EstrategiaPuntuacio estrategiaPuntuacio) {
		this.estrategiaPuntuacio = estrategiaPuntuacio;
	}

    /**
     * configurarCasellas Setter del conjunt de caselles del tauler de la partida
     * @param c
     */
	public void configurarCasellas(Casella[] c) {
		this.casellas = c;
	}
	/*
	@OneToMany(targetEntity=Casella.class, cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@OrderColumn
	public Casella[] getCasellas() {
		return casellas;
	}

	public void setCasellas(Casella[] casellas) {
		this.casellas = casellas;
	}
	*/

    /**
     * getPartidaId Getter de l'id de la partida
     * @return
     * @see com.mineSweeper.domainLayer.domainModel.Jugador
     * canvi respecte disseny original: separacio de taules
     * Una per l'historial i una altra per la partida actual
     */
	@Id
	@TableGenerator(name= "generatorPatidaID", table= "partidaPKtb", pkColumnName = "empkey",
					pkColumnValue = "partidaValue", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generatorPatidaID")
	public int getPartidaId() {
		return partidaId;
	}

    /**
     * setPartidaId Setter de l'id de la Partida
     * @param idPartida
     */
	public void setPartidaId(int idPartida) {
		this.partidaId = idPartida;
	}

    /**
     * isEstaAcabada Getter de estaAcabada
     * @return
     */
	public boolean isEstaAcabada() {
		return estaAcabada;
	}

    /**
     * setEstaAcabada Setter de l'atribut estaAcabada
     * @param estaAcabada
     */
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}

    /**
     * isEstaguanyada Getter de l'atribut estaguanyada
     * @return
     */
	public boolean isEstaguanyada() {
		return estaguanyada;
	}

    /**
     * setEstaguanyada Setter de l'atribut estaGuanyada
     * @param estaguanyada
     */
	public void setEstaguanyada(boolean estaguanyada) {
		this.estaguanyada = estaguanyada;
	}

    /**
     * setNombreTirades Setter del nombre de tirades
     * @param nombreTirades
     */
	public void setNombreTirades(int nombreTirades) {
		this.nombreTirades = nombreTirades;
	}

	private class Posicio {
        public int x, y;

        public Posicio(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return (x + y) * (x + y + 1) / 2 + y;
        }


        @Override
        public boolean equals(Object object) {
            Posicio posicio = (Posicio) object;
            return (this.x == posicio.x && this.y == posicio.y);
        }
    }

    /**
     * Partida Creadora de la classe Partida amb el nivell nivell i jugador jugador
     * @param nivell
     * @param jugador
     */
    public Partida(Nivell nivell, Jugador jugador) {
        this.jugador = jugador;
        this.nivell = nivell;
        estaAcabada = false;
        estaguanyada = false;
        nombreTirades = 0;
        //idPartida = Buscamines.getInstance().getIdPartida()+1;
       //Buscamines.getInstance().incrementaId();
        int fila = this.nivell.getNombreCasellaxFila();
        int columna = this.nivell.getNombreCasellaxColumna();
        casellas = new Casella[fila*columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                casellas[i*columna+j] = new Casella(i+1,j+1, this);
            }
        }
        assignarMines(nivell.getNombreMines());
        for (int i=0; i <nivell.getNombreCasellaxFila();++i) {
            for (int j=0; j<nivell.getNombreCasellaxColumna();++j){
                if (casellas[i*nivell.getNombreCasellaxColumna()+j].teMina()) AdministratorShell.getInstance().showText("1 ");
                else AdministratorShell.getInstance().showText("0 ");
            }
            AdministratorShell.getInstance().showText("\n");
        }
        estrategiaPuntuacio = EstrategiaPuntuacioFactory.getInstance().getEstrategiaPuntuacioAleatori();
    }
/*
    public void marcarPartida(int fila, int columna) {
        casellas[fila][columna].marcarCasella();
    }

    public void desmarcarPartida(int fila, int columna) {
        return casellas[fila][columna].marcarDesmarcarCasella();
    }
*/

    /**
     * obtenerCasella Getter de la casella en la posicio (fila, columna)
     * @param fila
     * @param columna
     * @return
     */
    public Casella obtenerCasella(int fila, int columna) {
    	return casellas[fila*nivell.getNombreCasellaxColumna()+columna];
    }

    /**
     * obtenerCasellas Getter del conjunt de caselles del tauler de la Partida
     * @return
     */
    public Casella[] obtenerCasellas() {
    	return casellas;
    }

    /**
     * marcarDesmarcarCasella Marca o desmarca la casella amb posicio (fila,columna), segons toqui
     * @param fila
     * @param columna
     * @return
     * @see com.mineSweeper.domainLayer.struct.Resultat
     * Canvi respecte disseny original: afegir funcions de BBDD
     */
    public boolean marcarDesmarcarCasella(int fila, int columna) {
        return casellas[fila*nivell.getNombreCasellaxColumna()+columna].marcarDesmarcarCasella();
    }

    /**
     * descobrirCasella descobreix la casella amb posicio (fila, columna) i si no te mina, descobreix els veins.
     * Si la partida es guanyada, ho mostrara per pantalla i acabara la partida
     * @param fila
     * @param columna
     * @return
     */
    public Resultat descobrirCasella(int fila, int columna) {
    	Resultat resultat = new Resultat();
        if (casellas[fila*nivell.getNombreCasellaxColumna()+columna].estaMarcada()) throw new RuntimeException("La casella ja esta Marcada");
        else if (casellas[fila*nivell.getNombreCasellaxColumna()+columna].estaDescoberta()) throw new RuntimeException("La casella ja esta descoberta");
        boolean teMina = casellas[fila*nivell.getNombreCasellaxFila()+columna].descobrirCasella();
        nombreTirades++;
        if (teMina) {
            resultat.acabada = estaAcabada = true;
            resultat.guanyada = estaguanyada = false;
        }
        else {
            if (casellas[fila*nivell.getNombreCasellaxColumna()+columna].getNumero() == 0) descobrirVeins(fila, columna,resultat);
            boolean guanyada = comprovaPartidaGuanyada();
            resultat.guanyada = estaguanyada = guanyada;
            resultat.acabada = estaAcabada = guanyada;
            if (guanyada) {
                resultat.puntuacio = estrategiaPuntuacio.getPuntuacio(this);
                AdapterFactory.getInstance().getMissatgeria().enviarMissatge(jugador.getEmail(),
                        "partida:"+partidaId+" te punt "+resultat.puntuacio);
            }
        }
        resultat.informacioDeCasellas.add(new InformacioDeCasella(fila,columna,casellas[fila*nivell.getNombreCasellaxColumna()+columna].getNumero()));
        return resultat;
    }

    /**
     * getNombreTirades Getter del nombre de tirades
     * @return
     */
    public int getNombreTirades() {
        return nombreTirades;
    }

    private void descobrirVeins(int fila, int columna, Resultat resultat) {
        for (int i = fila-1; i < fila+2; i++) {
            for (int j = columna-1; j < columna+2; j++) {
                if (i >= 0 && i < nivell.getNombreCasellaxFila() && j >= 0 && j < nivell.getNombreCasellaxColumna()) {
                    if (!casellas[i*nivell.getNombreCasellaxColumna()+j].estaDescoberta() && !casellas[i*nivell.getNombreCasellaxColumna()+j].estaMarcada()) {
                        casellas[i*nivell.getNombreCasellaxColumna()+j].descobrirCasella();
                        resultat.informacioDeCasellas.add(new InformacioDeCasella(i,j,casellas[i*nivell.getNombreCasellaxColumna()+j].getNumero()));
                        if (casellas[i*nivell.getNombreCasellaxColumna()+j].getNumero() == 0) descobrirVeins(i,j,resultat);
                    }
                }
            }
        }
    }

    /**
     * comprovaPartidaGuanyada Comprova si la partida es guanyada despres de descobrir casella
     * @return
     */
    private boolean comprovaPartidaGuanyada() {
        boolean guanyada = true;
        for (Casella casella : casellas) {
            if (!casella.teMina()) guanyada = casella.estaDescoberta();
        }
        for (int i = 0; i < nivell.getNombreCasellaxFila() && guanyada; i++) {
            for (int j = 0; j < nivell.getNombreCasellaxColumna() && guanyada; j++) {
                if (!casellas[i*nivell.getNombreCasellaxColumna()+j].teMina() && !casellas[i*nivell.getNombreCasellaxColumna()+j].estaDescoberta()) guanyada = false;
            }
        }
        return guanyada;
    }

    /**
     * assignarMines Afegeix nMines mines al tauler de la nova partida
     * @param nMines numero de mines a afegir
     */
    private void assignarMines(int nMines) {
        HashSet<Posicio> mines = new HashSet<Posicio>();
        while (mines.size() < nMines) {
            mines.add(new Posicio((int)(Math.random()*nivell.getNombreCasellaxFila()), (int)(Math.random()*nivell.getNombreCasellaxColumna())));
        }
        for (Posicio posicio : mines){
            casellas[posicio.x*nivell.getNombreCasellaxColumna()+posicio.y].assignarMina();
            for (int i = posicio.x-1; i < posicio.x+2; i++) {
                for (int j = posicio.y-1; j < posicio.y+2; j++) {
                    if (i >= 0 && i < nivell.getNombreCasellaxFila() && j >= 0 && j < nivell.getNombreCasellaxColumna()) {
                        if (!casellas[i*nivell.getNombreCasellaxColumna()+j].teMina()) casellas[i*nivell.getNombreCasellaxColumna()+j].sumNum();
                    }
                }
            }
        }
    }

    /**
     * obtenerMines Getter de les mines del tauler
     * @return
     */
    public ArrayList<InformacioDeCasella> obtenerMines() {
        ArrayList<InformacioDeCasella> informacioDeCasellas = new ArrayList<InformacioDeCasella>();
        for (int i=0; i < nivell.getNombreCasellaxFila(); ++i) {
            for (int j = 0; j < nivell.getNombreCasellaxColumna(); ++j){
                if (casellas[i*nivell.getNombreCasellaxColumna()+j].teMina()) informacioDeCasellas.add(new InformacioDeCasella(i,j,-1));
            }
        }
        return informacioDeCasellas;
    }

}
