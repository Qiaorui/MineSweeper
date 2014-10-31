package com.mineSweeper.domainLayer.domainModel;

/**
 * Created by qiaorui on 14-10-29.
 */
public class UsuariRegistrat {

    private String nom;
    private String cognom;
    private String username;
    private String pwd;

    public UsuariRegistrat() {

    }

    public boolean comprovaPwd(String pwd) {
        return this.pwd.equals(pwd);
    }
}
