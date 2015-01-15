package com.mineSweeper.presentationLayer;

import com.mineSweeper.AdministratorShell;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class CLogin implements InterfaceLogin{

    LoginView loginView;

    /**
     * CLogin Creadora de la classe
     */
    public CLogin(){
        loginView = new LoginView(this);
    }

    public void inicializar(){
        loginView.inicializar();
    }


    @Override
    public void prOkFerAutenticacio(String username, String password) {
        try {
            AdministratorShell.getInstance().showText("Logging: " + username + "  " + password + "\n");
            loginView.tancar();
        }
        catch (RuntimeException e)
        {
            if (e.getMessage() != "") JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
        }
    }



    @Override
    public void prCancel(){
        loginView.tancar();
    }
}
