package com.mineSweeper.dataLayer;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;


import com.mineSweeper.AdministratorShell;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.dataInterface.CtrlNivell;

public class CtrlNivellBD implements CtrlNivell {
	
	
	
    public Nivell getNivell(String nom) {
    	ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
		
		//Nivell n = new Nivell( (NivellBD) session.createQuery("from NivelBD where nom = '"+nom+"'").uniqueResult());
		Nivell n = (Nivell) session.createQuery("from Nivell where nom = '"+nom+"'").uniqueResult();
		
		session.getTransaction().commit();
		
		return n;
    }

	public List getAll() {	
		ConnexionPgl.getInstance();
		Session session = ConnexionPgl.getFactory().getCurrentSession();
		session.beginTransaction();
    	List nivells = session.createQuery("from Nivell").list();
    	session.getTransaction().commit();
		return nivells;
    }
}
