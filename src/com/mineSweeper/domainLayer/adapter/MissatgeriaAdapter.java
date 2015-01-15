package com.mineSweeper.domainLayer.adapter;

import com.mineSweeper.domainLayer.service.SvEmail;
import com.mineSweeper.domainLayer.serviceLocator.ServeiLocator;

/**
 * Created by liya on 14/1/15.
 */
public class MissatgeriaAdapter implements InterfaceMissatgeriaAdapter{


    @Override
    public void enviarMissatge(String receiver, String missatge) {
        SvEmail svEmail = ServeiLocator.getInstance().obtenirServei("SvEmail");
        svEmail.setText(missatge);
        svEmail.setReceiver(receiver);
        svEmail.enviar();
    }
}
