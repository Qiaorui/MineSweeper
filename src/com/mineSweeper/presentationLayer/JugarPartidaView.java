package com.mineSweeper.presentationLayer;


import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.struct.Dades;
import com.mineSweeper.domainLayer.struct.InformacioDeCasella;
import com.mineSweeper.domainLayer.struct.Resultat;

import javax.sound.midi.MidiDevice;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by qiaorui on 11/14/14.
 */
public class JugarPartidaView {

    private LoginFrame loginFrame;
    private ConsultarNivellFrame consultarNivellFrame;
    private JugarPartidaFrame jugarPartidaFrame;
    private CJugarPartida cJugarPartida;

    /**
     * JugarPartidaView Creadora de la vista
     * @param cJugarPartida
     */
    public JugarPartidaView(CJugarPartida cJugarPartida) {
        this.cJugarPartida = cJugarPartida;
    }

    /**
     * inicializar Inicialitza la vista
     */
    public void inicializar() {
        loginFrame = new LoginFrame(cJugarPartida);


        loginFrame.inicializar();
        loginFrame.setVisible(true);
    }


    public void mostraDialog(String missatge) {

    }

    /**
     * mostraNivells inicialitza el frame amb les dades de tots els nivells
     * @param dades
     */
    public void mostraNivells(Dades[] dades) {
        loginFrame.dispose();
        consultarNivellFrame = new ConsultarNivellFrame(cJugarPartida);
        consultarNivellFrame.inicializar(dades);
        consultarNivellFrame.setVisible(true);
    }

    public void mostraNoExisteixNivell() {

    }

    /**
     * mostraMissatge Mostra el missatge missatge
     * @param missatge
     */
    public void mostraMissatge(String missatge) {
        jugarPartidaFrame.showMessage(missatge);
    }

    /*public void mostraDesmarcarCasella(int fila, int columna) {
        jugarPartidaFrame.desmarcarCasella(fila,columna);
    }*/

    /**
     * mostraMarcarDesmarcarCasella actualitza el tauler despres de marcar o desmarcar
     * @param fila fila de la casella
     * @param columna columna de la casella
     * @param marcat boolea que indica si la casella esta marcada
     */
    public void mostraMarcarDesmarcarCasella(int fila, int columna, boolean marcat) {

            if (marcat) jugarPartidaFrame.marcarCasella(fila, columna);
            else jugarPartidaFrame.desmarcarCasella(fila, columna);
    }

    /**
     * mostraGuanyda mostra el missatge de partida guanyada
     * @param punt
     */
    public void mostraGuanyda(int punt) {
        JOptionPane.showMessageDialog(new JFrame(),"Ha guanyat la partida amb punt "+punt);
        jugarPartidaFrame.dispose();
    }

    /**
     * mostraPerdida mostra el missatge de partida perduda
     * @param informacioDeCasellas
     */
    public void mostraPerdida(ArrayList<InformacioDeCasella> informacioDeCasellas) {
        jugarPartidaFrame.perder(informacioDeCasellas);
    }

    /**
     * mostraDescobrirCasella actualitza el tauler despres de descobrir casella
     * @param informacioDeCasellas informacio de l'estat del tauler
     */
    public void mostraDescobrirCasella(ArrayList<InformacioDeCasella> informacioDeCasellas) {
        try {
            Iterator<InformacioDeCasella> nombreIterator = informacioDeCasellas.iterator();
            while (nombreIterator.hasNext()) {
                InformacioDeCasella casella = nombreIterator.next();
                jugarPartidaFrame.descobrirCasella(casella.numeroFila, casella.numeroColumna, casella.numero);
            }
        }
        catch (RuntimeException e)
        {
            if (e.getMessage() != "") mostraMissatge(e.getMessage());
        }
    }

    /**
     * mostraPartida mostra el tauler d'una nova partida
     * @param nFila nombre de files del tauler
     * @param nColumna nombre de columnes del tauler
     */
    public void mostraPartida(int nFila, int nColumna){
        consultarNivellFrame.dispose();
        jugarPartidaFrame = new JugarPartidaFrame(cJugarPartida);
        jugarPartidaFrame.inicializar(nFila,nColumna);
        jugarPartidaFrame.setVisible(true);
    }

    /**
     * tancar tanca la finestra de jugar partida
     */
    public void tancar(){
        if (loginFrame != null)loginFrame.dispose();
        if (consultarNivellFrame != null)consultarNivellFrame.dispose();
        if (jugarPartidaFrame != null) jugarPartidaFrame.tancar();
    }


}
