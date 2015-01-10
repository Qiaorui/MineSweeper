package com.mineSweeper.dataLayer;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;



import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.dataInterface.CtrlNivell;

public class CtrlNivellBD implements CtrlNivell {
	
	private static AnnotationConfiguration config;
	private static SessionFactory factory;
	
	CtrlNivellBD () {
		config = new AnnotationConfiguration();
		config.addAnnotatedClass(Nivell.class);
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		
	}
    public Nivell getNivell(String nom) {
    	Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Nivell n = (Nivell) session.createQuery("from Nivel where nom = '"+nom+"'").uniqueResult();
		
		session.getTransaction().commit();
		
		return n;
    }

    public List getAll() {
    	Session session = factory.getCurrentSession();
		session.beginTransaction();
		
    	List nivells = session.createCriteria(Nivell.class).list();
    	
    	session.getTransaction().commit();
		
		return nivells;
    }
}
