package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CURegistrar;

/**
 * Created by qiaorui on 1/14/15.
 */
public class CRegistrar implements InterfaceRegistrar{

    private RegistrarView registrarView;
    private CURegistrar cuRegistrar;

    public CRegistrar(CURegistrar cuRegistrar) {
        this.cuRegistrar = cuRegistrar;
    }

    public void inicializar() {
        registrarView = new RegistrarView(this);
        registrarView.inicializar();
    }

    @Override
    public void prOkRegistrar(String username, String pwd, String nom, String cognom, String email) {
        cuRegistrar.registrarJugador(username,pwd,nom,cognom,email);
        registrarView.tancar();
    }

    @Override
    public void prCancel() {
        registrarView.tancar();
    }
}
