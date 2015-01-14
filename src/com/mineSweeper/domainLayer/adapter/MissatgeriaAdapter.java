package com.mineSweeper.domainLayer.adapter;

import com.mineSweeper.domainLayer.service.SvEmail;

/**
 * Created by liya on 14/1/15.
 */
public class MissatgeriaAdapter implements InterfaceMissatgeriaAdapter{


    @Override
    public void enviarMissatge(String receiver, String missatge) {
        SvEmail svEmail = new SvEmail(receiver, missatge);
        svEmail.enviar();
    }
}
