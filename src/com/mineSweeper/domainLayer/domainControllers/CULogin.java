package com.mineSweeper.domainLayer.domainControllers;

import com.mineSweeper.domainLayer.dataInterface.DataControllerFactory;
import com.mineSweeper.domainLayer.domainModel.UsuariRegistrat;

/**
 * Created by qiaorui on 14-10-28.
 */
public class CULogin {

    public CULogin() {

    }

    public boolean Login(String username, String password) {
        DataControllerFactory dataControllerFactory = DataControllerFactory.getInstance();
        UsuariRegistrat usuariRegistrat = dataControllerFactory.getCtrlUsuariRegistrat().getUsuariRegistrat(username);
        usuariRegistrat.comprovaPwd(password);
        return true;
    }
}
