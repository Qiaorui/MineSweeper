package com.mineSweeper.presentationLayer;

/**
 * Created by qiaorui on 1/14/15.
 */
public class RegistrarView {
    private RegistrarFrame registrarFrame;
    private CRegistrar cRegistrar;

    /**
     * RegistrarView Creadora de la vista
     * @param cRegistrar
     */
    public RegistrarView(CRegistrar cRegistrar) {
        this.cRegistrar = cRegistrar;
    }

    /**
     * inicializar inicialitza la vista
     */
    public void inicializar(){
        registrarFrame = new RegistrarFrame(cRegistrar);
        registrarFrame.inicializar();
        registrarFrame.setVisible(true);
    }

    /**
     * tancar tanca la finestra
     */
    public void tancar(){
        registrarFrame.dispose();
    }



}
