package com.mineSweeper.dataLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.mineSweeper.domainLayer.domainModel.Administrator;
import com.mineSweeper.domainLayer.domainModel.Casella;
import com.mineSweeper.domainLayer.domainModel.Jugador;
import com.mineSweeper.domainLayer.domainModel.Nivell;
import com.mineSweeper.domainLayer.domainModel.Partida;
import com.mineSweeper.domainLayer.domainModel.UsuariRegistrat;

public class datetest {
	
	private static AnnotationConfiguration config;
	private static SessionFactory factory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(UsuariRegistrat.class);
		config.addAnnotatedClass(Jugador.class);
		config.addAnnotatedClass(Administrator.class);
		config.addAnnotatedClass(Nivell.class);
		config.addAnnotatedClass(Casella.class);
		config.addAnnotatedClass(Partida.class);
		
	
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		
		//new SchemaExport(config).create(true, true);
		
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		
		
		Administrator a = new Administrator();
		a.setPwd("huhuhuhu");
		a.setUsername("huhuh");
		a.setTlfn("445454");
		String username= "123";
		Jugador j = (Jugador) session.createQuery("from Jugador where username = '"+username+"'").uniqueResult();
		
		UsuariRegistrat u = (UsuariRegistrat) session.createQuery("from UsuariRegistrat where username = '"+username+"'").uniqueResult();
	
		session.getTransaction().commit();	
	}

}
