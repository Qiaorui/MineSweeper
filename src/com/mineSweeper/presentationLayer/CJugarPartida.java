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

    public CJugarPartida(CUJugarPartida cuJugarPartida) {
        this.cuJugarPartida = cuJugarPartida;
    }

    public void inicializar() {
        jugarPartidaView = new JugarPartidaView(this);
        jugarPartidaView.inicializar();
    }


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

    @Override
    public void prOkCrearPartida(String nivell, int fila, int columna) {
        cuJugarPartida.crearPartida(nivell);
        jugarPartidaView.mostraPartida(fila, columna);
    }

    @Override
    public void prDescobrirCasella(int fila, int columna) {
            Resultat resultat = cuJugarPartida.descobrirCasella(fila, columna);
            if (resultat.guanyada) jugarPartidaView.mostraGuanyda(resultat.puntuacio);
            else if (resultat.acabada) {
                jugarPartidaView.mostraPerdida(cuJugarPartida.getMines());
            } else jugarPartidaView.mostraDescobrirCasella(resultat.informacioDeCasellas);
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

    @Override
    public void prMarcarDesmarcarCasella(int fila, int columna) {
        boolean b =  cuJugarPartida.marcarDesmarcarCasella(fila, columna);
        jugarPartidaView.mostraMarcarDesmarcarCasella(fila, columna,b);
        AdministratorShell.getInstance().showText("fila: "+fila+" columna: "+columna+"  "+b);
    }

    @Override
    public void prOkMissatge() {
        jugarPartidaView.tancar();
    }

    @Override
    public void prCancel() {
        jugarPartidaView.tancar();
    }


    @Override
    public void prSortir() {
        jugarPartidaView.tancar();
    }




}
