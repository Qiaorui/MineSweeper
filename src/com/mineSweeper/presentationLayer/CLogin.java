package com.mineSweeper.presentationLayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class CLogin implements ActionListener{

    LoginView loginView;

    public CLogin(){
        loginView = new LoginView(this);
    }

    public void inicializar(){
        loginView.inicializar();
    }

    public void prCancel(){
        loginView.tancar();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand() == "cancel") {
            prCancel();
        }
    }
}
