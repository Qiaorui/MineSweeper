package com.mineSweeper.domainLayer.dataInterface;

import com.mineSweeper.domainLayer.domainModel.UsuariRegistrat;

/**
 * Created by qiaorui on 14-10-28.
 */

/**
 * Interfaz para los usuarios registrados en la capa de datos
 */
public interface CtrlUsuariRegistrat {

    public UsuariRegistrat getUsuariRegistrat(String username);
}
