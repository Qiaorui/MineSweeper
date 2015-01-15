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

    /** Canvi respecte disseny original: Ara partida te navegavilitat al jugador, per poder enviar el email amb
     * la direccio del email del jugador*/
    private Jugador jugador;


    /**
     * Class template per generar posicions de mines de forma random i no repetits
     */
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


    public Partida() {
	}

    /**
     * Partida Creadora de la classe Partida amb el nivell nivell i jugador jugador
     * @param nivell El ivell que tindra la partida
     * @param jugador El jugador que juga aquesta partida
     * Canvi respecte disseny original: Ara partida te navegavilitat al jugador, per poder enviar el email amb
     * la direccio del email del jugador
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
        /*for (int i=0; i <nivell.getNombreCasellaxFila();++i) {
            for (int j=0; j<nivell.getNombreCasellaxColumna();++j){
                if (casellas[i*nivell.getNombreCasellaxColumna()+j].teMina()) AdministratorShell.getInstance().showText("1 ");
                else AdministratorShell.getInstance().showText("0 ");
            }
            AdministratorShell.getInstance().showText("\n");
        }*/
        estrategiaPuntuacio = EstrategiaPuntuacioFactory.getInstance().getEstrategiaPuntuacioAleatori();
    }


    /**
     * getNivell
     * Getter de l'atribut nivell
     * @return El nivell de la partida
     */
    @OneToOne()
	@JoinColumn(name = "NivelNom",nullable = false, updatable=false)
    public Nivell getNivell() {
		return nivell;
	}

    /**
     * setNivell
     * Setter de l'atribut nivell
     * @param nivell El nivell de la partida
     */
	public void setNivell(Nivell nivell) {
		this.nivell = nivell;
	}

    /**
     * obtenerEstrategiaPuntuacio
     * Getter de l'estrategia de puntuacio
     * @return Estrategia de puntuacio
     */
	public EstrategiaPuntuacio obtenerEstrategiaPuntuacio() {
		return estrategiaPuntuacio;
	}

    /**
     * setEstrategiaPuntuacio
     * Setter de l'estrategia de puntuacio
     * @param estrategiaPuntuacio Estrategia de puntuacio que usara la partida
     */
	public void setEstrategiaPuntuacio(EstrategiaPuntuacio estrategiaPuntuacio) {
		this.estrategiaPuntuacio = estrategiaPuntuacio;
	}

    /**
     * configurarCasellas
     * Setter del conjunt de caselles del tauler de la partida
     * @param c Casellas que tendra la partida
     */
	public void configurarCasellas(Casella[] c) {
		this.casellas = c;
	}


    /**
     * getPartidaId
     * Getter de l'id de la partida
     * @return id de partida
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
     * setPartidaId
     * Setter de l'id de la Partida
     * @param idPartida id de la partida
     */
	public void setPartidaId(int idPartida) {
		this.partidaId = idPartida;
	}

    /**
     * isEstaAcabada
     * Getter de estaAcabada
     * @return cert si esta acabada
     */
	public boolean isEstaAcabada() {
		return estaAcabada;
	}

    /**
     * setEstaAcabada
     * Setter de l'atribut estaAcabada
     * @param estaAcabada la partida esta acabada o no
     */
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}

    /**
     * isEstaguanyada
     * Getter de l'atribut estaguanyada
     * @return cert si la partida ha guanyat
     */
	public boolean isEstaguanyada() {
		return estaguanyada;
	}

    /**
     * setEstaguanyada
     * Setter de l'atribut estaGuanyada
     * @param estaguanyada si la partida es guanyada o no
     */
	public void setEstaguanyada(boolean estaguanyada) {
		this.estaguanyada = estaguanyada;
	}

    /**
     * setNombreTirades
     * Setter del nombre de tirades
     * @param nombreTirades nombre de tirades ha jugat
     */
	public void setNombreTirades(int nombreTirades) {
		this.nombreTirades = nombreTirades;
	}



    /**
     * obtenerCasella
     * Getter de la casella en la posicio (fila, columna)
     * @param fila La fila de la casella que volem obtenir
     * @param columna La columna de la casella que volem obtenir
     * @return Casella de la fila i columna indicat.
     */
    public Casella obtenerCasella(int fila, int columna) {
    	return casellas[fila*nivell.getNombreCasellaxColumna()+columna];
    }

    /**
     * obtenerCasellas
     * Getter del conjunt de caselles del tauler de la Partida
     * @return conjunt de caselles del tauler de la Partida
     */
    public Casella[] obtenerCasellas() {
    	return casellas;
    }

    /**
     * marcarDesmarcarCasella
     * Marca o desmarca la casella amb posicio (fila,columna), segons toqui
     * @param fila La fila de la casella que volem marcar o desmarcar
     * @param columna La columna de la casella que volem marcar o desmarcar
     * @return cert es la casella quedarà marcada
     * Canvi respecte disseny original: Combinar la funcion de marcarCasella i desmarcarCasella
     */
    public boolean marcarDesmarcarCasella(int fila, int columna) {
        return casellas[fila*nivell.getNombreCasellaxColumna()+columna].marcarDesmarcarCasella();
    }

    /**
     * descobrirCasella
     * descobreix la casella amb posicio (fila, columna) i si no te mina, descobreix els veins.
     * Si la partida es guanyada, ho mostrara per pantalla i acabara la partida
     * @param fila La fila de la casella que volem descobrir
     * @param columna La columna de la casella que volem descobrir
     * @return Resultat
     * @exception java.lang.RuntimeException La casella ja esta descoberta
     * @exception java.lang.RuntimeException La casella esta marcada
     * @see com.mineSweeper.domainLayer.struct.Resultat
     * Canvi respecte disseny original: Ara resultat es guarda informacions de un conjunt de caselles descobertes,
     * per tal poder informar a la capa de presentacio
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
     * getNombreTirades
     * Getter del nombre de tirades
     * @return
     */
    public int getNombreTirades() {
        return nombreTirades;
    }


    /**
     * descobrirVeins
     * Descobrir las caselles veins de la casella indicat, i posar les informacions de les caselles descoberts en
     * resultat
     * @param fila La fila de la casella central
     * @param columna La columna de la casella central
     * @param resultat Resultat que guarda les informacions de les caselles descoberts
     * @see com.mineSweeper.domainLayer.struct.Resultat
     * @see com.mineSweeper.domainLayer.struct.InformacioDeCasella
     * Canvi respecte disseny original: resultat guarda les informacions de les caselles descoberts per poder presentrar
     * en la capa de presentacio
     */
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
     * comprovaPartidaGuanyada
     * Comprova si la partida es guanyada despres de descobrir casella
     * @return cert si les caselles que no tenen mines estan totes descobiertes
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
     * assignarMines
     * Afegeix nMines mines al tauler de la nova partida
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
     * obtenerMines
     * Getter de les mines del tauler
     * @return una lista de posicions de totes les caselles que tenen mines
     * Canvi respecte disseny original: Nova funcio, per mostrar totes mines quan es perdi la partida
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
