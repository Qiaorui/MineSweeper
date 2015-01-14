package com.mineSweeper.dataLayer;

import org.hibernate.Session;

import com.mineSweeper.domainLayer.domainModel.UsuariRegistrat;


public class CtrlUsuariRegistratBD {

    public UsuariRegistrat getUsuariRegistrat (String username) {
    	
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		UsuariRegistrat u = (UsuariRegistrat) session.createQuery("from UsuariRegistrat where username = '"+username+"'").uniqueResult();
		
		session.getTransaction().commit();

		return u;
    }
}
