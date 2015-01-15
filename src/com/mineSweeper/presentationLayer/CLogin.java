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

    /**
     * inicializar inicialitza la pantalla de Login
     */
    public void inicializar(){
        loginView.inicializar();
    }

    /**
     * prOkFerAutenticacio Fa l'autenticacio del nom i contrasenya introduits
     * @param username nom de l'usuari
     * @param password contrasenya de l'usuari
     */
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

    /**
     * prCancel Tanca la finestra
     */
    @Override
    public void prCancel(){
        loginView.tancar();
    }
}
