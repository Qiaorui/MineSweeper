package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Jugador;

/**
 * Created by qiaorui on 1/14/15.
 */
public class CURegistrar {

    /**
     * CURegistrar
     * Crea una instancia del caso de uso Registrar
     */
    public CURegistrar(){

    }

    /**
     * registrarJugador
     * Registra un jugador en el sistema
     * @param username El username del usuario a registrar
     * @param pwd La contrasena del usuario a registrar
     * @param nom Nombre del usuario
     * @param cognom Apellido del usuario
     * @param email Email del usuario
     */
    public void registrarJugador(String username, String pwd, String nom, String cognom, String email){
        Jugador jugador = new Jugador();
        jugador.setEmail(email);
        jugador.setCognom(cognom);
        jugador.setNom(nom);
        jugador.setPwd(pwd);
        jugador.setUsername(username);
        DataControllerFactory.getInstance().getCtrlJugador().createJugador(jugador);
    }


}
