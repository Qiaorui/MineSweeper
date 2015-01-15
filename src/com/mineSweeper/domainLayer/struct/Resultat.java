package com.mineSweeper.domainLayer.struct;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by qiaorui on 11/6/14.
 */
public class Resultat {

    public boolean acabada;
    public boolean guanyada;
    public int puntuacio;
    public ArrayList<InformacioDeCasella> informacioDeCasellas;

    /**
     * Resultat
     * Crea una instancia de la clase de resultado
     */
    public Resultat() {
        acabada = false;
        guanyada = false;
        informacioDeCasellas = new ArrayList<InformacioDeCasella>();
    }
}
