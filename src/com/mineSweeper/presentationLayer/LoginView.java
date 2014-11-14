package com.mineSweeper.presentationLayer;

import java.awt.event.ActionListener;

/**
 * Created by qiaorui on 11/14/14.
 */
public class LoginView {

    LoginFrame loginFrame;

    public LoginView(ActionListener actionListener){
        loginFrame = new LoginFrame(actionListener);
    }

    public void inicializar(){
        loginFrame.inicializar();
        loginFrame.setVisible(true);
    }

    public void tancar(){
        loginFrame.dispose();
    }
}
