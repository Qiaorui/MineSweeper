package com.mineSweeper.domainLayer.adapter;

import com.mineSweeper.domainLayer.service.SvEmail;
import com.mineSweeper.domainLayer.serviceLocator.ServeiLocator;

/**
 * Created by liya on 14/1/15.
 */
public class MissatgeriaAdapter implements InterfaceMissatgeriaAdapter{

    /**
     * enviarMissatge
     * Envia un mensaje a una direccion de correo electronico
     * @param receiver La direccion de email a la que queremos enviar el mensaje
     * @param missatge Texto del mensaje
     */
    @Override
    public void enviarMissatge(String receiver, String missatge) {
        SvEmail svEmail = ServeiLocator.getInstance().obtenirServei("SvEmail");
        svEmail.setText(missatge);
        svEmail.setReceiver(receiver);
        svEmail.enviar();
    }
}
