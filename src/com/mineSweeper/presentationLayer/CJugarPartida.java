package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.domainControllers.CUJugarPartida;
import com.mineSweeper.domainLayer.struct.Dades;
import com.mineSweeper.domainLayer.struct.Resultat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class CJugarPartida implements InterfaceLogin, InterfaceConsultarNivell, InterfaceJugarPartida{

    JugarPartidaView jugarPartidaView;
    CUJugarPartida cuJugarPartida;

    /**
     * CJugarPartida Creadora de la classe
     * @param cuJugarPartida Classe cas d'us de jugarPartida
     */
    public CJugarPartida(CUJugarPartida cuJugarPartida) {
        this.cuJugarPartida = cuJugarPartida;
    }

    /**
     * inicializar inicialitza la pantalla de jugar partida
     */
    public void inicializar() {
        jugarPartidaView = new JugarPartidaView(this);
        jugarPartidaView.inicializar();
    }

    /**
     * prOkFerAutenticacio Crida al cas d'us per a fer lautenticacio i si tot va be mostra les nivells
     * @param username nom d'usuari introduit
     * @param password constrasenya introduida
     */
    @Override
    public void prOkFerAutenticacio(String username, String password) {
        try {
            cuJugarPartida.ferAutenticacio(username, password);
            jugarPartidaView.mostraNivells(cuJugarPartida.obtenirNivells());
        }
        catch (RuntimeException e)
        {
            if (e.getMessage() != "") JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }

    /**
     * prOkCrearPartida Crea la partida amb el nivell escollit
     * @param nivell nom del nivell escollit
     * @param fila nombre de files del nivell
     * @param columna nombre de columnes del nivell
     */
    @Override
    public void prOkCrearPartida(String nivell, int fila, int columna) {
        cuJugarPartida.crearPartida(nivell);
        jugarPartidaView.mostraPartida(fila, columna);
    }

    /**
     * prDescobrirCasella Crida a descobrir Casella del cas d'us i en cas que la partida s'acabi
     * mostra la informacio corresponent i sino, actualitza la pantalla amb el nou tauler
     * @param fila fila del boto clicat
     * @param columna columa del boto clicat
     */
    @Override
    public void prDescobrirCasella(int fila, int columna) {

        try {
            Resultat resultat = cuJugarPartida.descobrirCasella(fila, columna);
            if (resultat.guanyada) jugarPartidaView.mostraGuanyda(resultat.puntuacio);
            else if (resultat.acabada) {
                jugarPartidaView.mostraPerdida(cuJugarPartida.getMines());
            } else jugarPartidaView.mostraDescobrirCasella(resultat.informacioDeCasellas);
        }
        catch (RuntimeException e)
        {
            if (e.getMessage() != "") jugarPartidaView.mostraMissatge(e.getMessage());
        }

    }
/*
    @Override
    public void prMarcarCasella(int fila, int columna) {
        jugarPartidaView.mostraMarcarCasella(fila, columna);
    }

    @Override
    public void prDesmarcarCasella(int fila, int columna) {
        jugarPartidaView.mostraDesmarcarCasella(fila, columna);
    }
*/

    /**
     * prMarcarDesmarcarCasella Crida a marcarDesmarcar casella del cas d'us i actualitza el tauler
     * @param fila
     * @param columna
     * @Exception En cas que es faci un moviment invalid, es mostra per pantalla
     */
    @Override
    public void prMarcarDesmarcarCasella(int fila, int columna) {

        try {
            boolean b =  cuJugarPartida.marcarDesmarcarCasella(fila, columna);
            jugarPartidaView.mostraMarcarDesmarcarCasella(fila, columna,b);
            AdministratorShell.getInstance().showText("fila: "+fila+" columna: "+columna+"  "+b);
        }
        catch (RuntimeException e)
        {
            if (e.getMessage() != "") jugarPartidaView.mostraMissatge(e.getMessage());
        }

    }

    /**
     * prOkMissatge prOkMissatge Tanca la finestra
     */
    @Override
    public void prOkMissatge() {
        jugarPartidaView.tancar();
    }

    /**
     * prCancel Tanca la finestra
     */
    @Override
    public void prCancel() {
        jugarPartidaView.tancar();
    }

    /**
     * prSortir Tanca la finestra
     */
    @Override
    public void prSortir() {
        jugarPartidaView.tancar();
    }




}
