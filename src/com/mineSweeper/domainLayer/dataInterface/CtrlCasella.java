package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.domainLayer.domainModel.Casella;
import com.mineSweeper.domainLayer.domainModel.Partida;

import java.util.List;

/**
 * Interfaz para las casillas en la capa de datos
 */
public interface CtrlCasella {

    public Casella getCasella(Partida p, int numeroFila, int numeroColumna);
    public void createCasella(Casella a);
    public void updateCasellas(Casella a);
    public List<Casella> getCasellas(Partida P);
}
