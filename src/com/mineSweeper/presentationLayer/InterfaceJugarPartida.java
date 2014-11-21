package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.struct.InformacioDeCasella;
import com.mineSweeper.domainLayer.struct.Resultat;

import java.util.ArrayList;

/**
 * Created by qiaorui on 11/18/14.
 */
public interface InterfaceJugarPartida {

    public void prDescobrirCasella(int fila, int columna);

    public void prMarcarCasella(int fila, int columna);

    public void prDesmarcarCasella(int fila, int columna);

    public void prOkMissatge();

    public void prSortir();
}
