package com.mineSweeper.presentationLayer;

import com.mineSweeper.domainLayer.domainControllers.CURegistrar;

/**
 * Created by qiaorui on 1/14/15.
 */
public class CRegistrar implements InterfaceRegistrar{

    private RegistrarView registrarView;
    private CURegistrar cuRegistrar;

    /**
     * CRegistrar Creadora de la classe
     * @param cuRegistrar cas d'us Registrar
     */
    public CRegistrar(CURegistrar cuRegistrar) {
        this.cuRegistrar = cuRegistrar;
    }

    /**
     * inicializar inicialitza la pantalla
     */
    public void inicializar() {
        registrarView = new RegistrarView(this);
        registrarView.inicializar();
    }

    /**
     * prOkRegistrar Registra el nou jugador amb nom username, contrasenya pwd, nom i cognoms i email
     * @param username nom de l'usuari
     * @param pwd contrasenya de l'usuari
     * @param nom nom real de l'usuari
     * @param cognom cognom de l'usuari
     * @param email adreca de correu
     */
    @Override
    public void prOkRegistrar(String username, String pwd, String nom, String cognom, String email) {
        cuRegistrar.registrarJugador(username,pwd,nom,cognom,email);
        registrarView.tancar();
    }

    /**
     * prCancel tanca la finestra
     */
    @Override
    public void prCancel() {
        registrarView.tancar();
    }
}
