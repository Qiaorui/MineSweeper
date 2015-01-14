package com.mineSweeper.dataLayer;

import org.hibernate.Session;

import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.dataInterface.CtrlUsuariRegistrat;
import com.mineSweeper.domainLayer.domainModel.UsuariRegistrat;


public class CtrlUsuariRegistratBD implements CtrlUsuariRegistrat {

    public UsuariRegistrat getUsuariRegistrat (String username) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		
		UsuariRegistrat u = (UsuariRegistrat) session.createQuery("from UsuariRegistrat where username = '"+username+"'").uniqueResult();
		
		session.getTransaction().commit();

		return u;
    }
}
