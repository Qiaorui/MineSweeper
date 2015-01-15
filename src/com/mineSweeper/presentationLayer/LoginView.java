package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CULogin;

import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class LoginView {

    LoginFrame loginFrame;
    CLogin cLogin;

    /**
     * LoginView Creadora de la vista
     * @param cLogin
     */
    public LoginView(CLogin cLogin){
        this.cLogin = cLogin;
    }

    /**
     * inicializar inicialitza la vista
     */
    public void inicializar(){
        loginFrame = new LoginFrame(cLogin);
        loginFrame.inicializar();
        loginFrame.setVisible(true);
    }

    /**
     * tancar tanca la finestra
     */
    public void tancar(){
        loginFrame.dispose();
    }
}
