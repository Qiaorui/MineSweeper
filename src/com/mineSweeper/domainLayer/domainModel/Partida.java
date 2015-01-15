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
    
    @OneToOne()
	@JoinColumn(name = "NivelNom",nullable = false, updatable=false)
    public Nivell getNivell() {
		return nivell;
	}

	public void setNivell(Nivell nivell) {
		this.nivell = nivell;
	}

	public EstrategiaPuntuacio obtenerEstrategiaPuntuacio() {
		return estrategiaPuntuacio;
	}

	public void setEstrategiaPuntuacio(EstrategiaPuntuacio estrategiaPuntuacio) {
		this.estrategiaPuntuacio = estrategiaPuntuacio;
	}
	
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
	@Id
	@TableGenerator(name= "generatorPatidaID", table= "partidaPKtb", pkColumnName = "empkey",
					pkColumnValue = "partidaValue", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="generatorPatidaID")
	public int getPartidaId() {
		return partidaId;
	}
	
	public void setPartidaId(int idPartida) {
		this.partidaId = idPartida;
	}

	public boolean isEstaAcabada() {
		return estaAcabada;
	}

	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}

	public boolean isEstaguanyada() {
		return estaguanyada;
	}

	public void setEstaguanyada(boolean estaguanyada) {
		this.estaguanyada = estaguanyada;
	}

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
    public Casella obtenerCasella(int fila, int columna) {
    	return casellas[fila*nivell.getNombreCasellaxColumna()+columna];
    }
    
    public Casella[] obtenerCasellas() {
    	return casellas;
    }

    public boolean marcarDesmarcarCasella(int fila, int columna) {
        return casellas[fila*nivell.getNombreCasellaxColumna()+columna].marcarDesmarcarCasella();
    }

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
