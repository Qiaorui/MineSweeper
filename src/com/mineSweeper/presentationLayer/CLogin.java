package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class CLogin implements InterfaceLogin{

    LoginView loginView;

    public CLogin(){
        loginView = new LoginView(this);
    }

    public void inicializar(){
        loginView.inicializar();
    }


    @Override
    public void prOkFerAutenticacio(String username, String password) {
        AdministratorShell.getInstance().showText("Logging: "+username+"  "+password+"\n");
        loginView.tancar();
    }

    @Override
    public void prCancel(){
        loginView.tancar();
    }


}
