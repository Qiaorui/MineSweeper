package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.Jugador;

/**
 * Created by qiaorui on 1/14/15.
 */
public class CURegistrar {

    public CURegistrar(){

    }

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
