package com.mineSweeper.presentationLayer;

/**
 * Created by qiaorui on 1/14/15.
 */
public class RegistrarView {
    private RegistrarFrame registrarFrame;
    private CRegistrar cRegistrar;


    public RegistrarView(CRegistrar cRegistrar) {
        this.cRegistrar = cRegistrar;
    }

    public void inicializar(){
        registrarFrame = new RegistrarFrame(cRegistrar);
        registrarFrame.inicializar();
        registrarFrame.setVisible(true);
    }

    public void tancar(){
        registrarFrame.dispose();
    }



}
