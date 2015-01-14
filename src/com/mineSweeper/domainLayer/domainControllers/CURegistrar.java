package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;

/**
 * Created by qiaorui on 1/14/15.
 */
public class CURegistrar {

    public CURegistrar(){

    }

    public void registrarJugador(String username, String pwd, String nom, String cognom, String email){
        DataControllerFactory.getInstance().getCtrlJugador().crear(username,pwd,nom,cognom,email);
    }


}
