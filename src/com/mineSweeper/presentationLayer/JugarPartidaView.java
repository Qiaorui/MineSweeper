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

    public JugarPartidaView(CJugarPartida cJugarPartida) {
        this.cJugarPartida = cJugarPartida;
    }

    public void inicializar() {
        loginFrame = new LoginFrame(cJugarPartida);


        loginFrame.inicializar();
        loginFrame.setVisible(true);
    }


    public void mostraDialog(String missatge) {

    }

    public void mostraNivells(Dades[] dades) {
        loginFrame.dispose();
        consultarNivellFrame = new ConsultarNivellFrame(cJugarPartida);
        consultarNivellFrame.inicializar(dades);
        consultarNivellFrame.setVisible(true);
    }

    public void mostraNoExisteixNivell() {

    }

    public void mostraMissatge(String missatge) {
        jugarPartidaFrame.showMessage(missatge);
    }

    /*public void mostraDesmarcarCasella(int fila, int columna) {
        jugarPartidaFrame.desmarcarCasella(fila,columna);
    }*/

    public void mostraMarcarDesmarcarCasella(int fila, int columna, boolean marcat) {

            if (marcat) jugarPartidaFrame.marcarCasella(fila, columna);
            else jugarPartidaFrame.desmarcarCasella(fila, columna);
    }

    public void mostraGuanyda(int punt) {
        JOptionPane.showMessageDialog(new JFrame(),"Ha guanyat la partida amb punt "+punt);
        jugarPartidaFrame.dispose();
    }

    public void mostraPerdida(ArrayList<InformacioDeCasella> informacioDeCasellas) {
        jugarPartidaFrame.perder(informacioDeCasellas);
    }

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

    public void mostraPartida(int nFila, int nColumna){
        consultarNivellFrame.dispose();
        jugarPartidaFrame = new JugarPartidaFrame(cJugarPartida);
        jugarPartidaFrame.inicializar(nFila,nColumna);
        jugarPartidaFrame.setVisible(true);
    }

    public void tancar(){
        if (loginFrame != null)loginFrame.dispose();
        if (consultarNivellFrame != null)consultarNivellFrame.dispose();
        if (jugarPartidaFrame != null) jugarPartidaFrame.tancar();
    }


}
